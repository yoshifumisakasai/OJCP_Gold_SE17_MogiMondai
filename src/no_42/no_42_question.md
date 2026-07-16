設問42

次のモジュールmoduleaを正しくコンパイルできるコマンドはどれか
prjディレクトリをカレントディレクトリとする（1つ選択）


prj

---------------out
                |
                ----------moduleb
                             |
                             ----------module-info.class
                             ----------sample
                                         |
                                         --------Helper.class
                               
---------------out
                |
                ----------modulea
                ----------module-info.java
                ----------sample
                             |
                             ----------Helper.java


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



A. javac -d out --source-path src -classpath ../out/modulea $(find modulea -name #*.java")


B. javac -d out/modulea $(find src/modulea -name "src/modulea/*.java")


C. javac -d out --module-source-path src --module-path ../out --module modulea


D. javac -d out/modulea -classpath out/moduleb $(find src/modulea -name "*.java")


E.  javac -d out --module-path src -classpath ../out/moduleb --module modulea



#設問解いた初見

42.？ まったく分からない。選択肢絞れない、その以前の問題
そもそも、コマンドの意味がわかっていない

   module-source-pathとmodule-path違いなんでしたっけ？


   
#観点、ポイント （選択肢を一瞬で絞るための4つのポイント）  

module-source-path → ソースを探す場所  (同義：-source-path )  

module-path → コンパイル済みモジュールを探す場所  

module-info.java があるなら classpath を使うとモジュール扱いされない  

依存モジュール（moduleb）は module-path に置く必要がある  
