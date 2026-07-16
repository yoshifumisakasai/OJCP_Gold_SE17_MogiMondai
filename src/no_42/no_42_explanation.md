#module-source-pathとmodule-path違いについて

**module-source-path は「ソース(.java)を探す場所」**  
**module-path は「コンパイル済み(.class/.jar)を探す場所」**  



#🔍 1. module-source-path（ソースコードの住所録）  
探索対象：.java（ソース）  
使う場面：javac が複数モジュールをソースからコンパイルするとき  

役割：  
「ソースコードをどこから読むか」を javac に教える  

例
`javac --module-source-path src -d out -m app,util`  
javac は src/app、src/util をモジュールとして認識してコンパイルする。







#📦 2. module-path（完成品モジュールの倉庫）  
探索対象：.class / .jar（コンパイル済み）  

使う場面： 依存モジュールの参照（コンパイル・実行） 

・javac が 依存モジュールを参照するとき  
・java が 実行時にモジュールをロードするとき  
・jlink が モジュールをリンクするとき  

役割：
「依存するモジュールの完成品をどこから読むか」を javac/java に教える

例
`javac -p mods/util -d mods/app src/app/module-info.java src/app/Main.java`  
app をコンパイルするために、mods/util にある util モジュールの完成品を参照する。  




■モジュール構成  

```
prj/
 ├─ out/
 │    └─ moduleb/
 │         ├─ module-info.class
 │         └─ sample/Helper.class
 └─ src/
      └─ modulea/
           ├─ module-info.java
           └─ sample/Helper.java
```


〇上記の図から、読み取れる事項について


＜全体＞
・moduleb はすでにコンパイル済み（out/moduleb）  
・modulea は src/modulea にソースがある  
・modulea は moduleb に依存している（Helper.class があるので）  


＜moduleaをコンパイルするには＞
・modulea のソースを指定する  
・moduleb のコンパイル済みモジュールを module-path に指定する  



#選択肢の判定

A.
コード
javac -d out --source-path src -classpath ../out/modulea $(find modulea -name "*.java")
modulea のソースは指定している（source-path）

`moduleb を classpath に指定していない → 依存解決できない`  

`そもそも classpath を使う時点でモジュールとして扱われない`  

❌ 不正解


**-source-path は「javac が ソース(.java) を探しに行くディレクトリを指定するオプション **   
※Java 9 以降のモジュールシステム用の --module-source-path とは別物で、もっと単純な「ソース検索パス」  


B.
コード
javac -d out/modulea $(find src/modulea -name "src/modulea/*.java")
`module-path がない → moduleb を参照できない`  

`module-info.java があるのに classpath も module-path も指定していない`  

❌ 不正解




C.
コード
javac -d out --module-source-path src --module-path ../out --module modulea
module-source-path → src/modulea を自動認識

module-path → ../out に moduleb がある

--module modulea → modulea をコンパイル対象に指定

✔ 完全に正しい構成

これは modulea のソースを正しく見つけて、moduleb のコンパイル済みモジュールを module-path で参照する  
という “モジュールコンパイルの正しい形” を満たしている。




⭕ 正解候補

D.
コード
javac -d out/modulea -classpath out/moduleb $(find src/modulea -name "*.java")
`classpath を使っている → モジュールとして扱われない`  

`module-info.java があるのに classpath を使うとエラーになる`  

❌ 不正解

E.
コード
javac -d out --module-path src -classpath ../out/moduleb --module modulea
`module-path に src を指定している → ソースを module-path に置くのは誤り`  
`classpath に moduleb を置いている → モジュールとして扱われない`  

❌ 不正解


