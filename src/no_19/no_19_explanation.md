#ストリームの流れ  


🔬 1 要素ずつ流れる様子（これが試験の狙い）
`※Listの「a,b,c」を全部一気に通過するわけではなく、ライン投入口に、まず１つ目の要素「a」を投入、パイプラインを流れ最後まで到達`  
`次に２要素目.....`  


● 要素「a」
peek → a を表示

filter → "a".contains("b") → false

→ 後続の peek に進まない

→ forEach にも進まない

出力：a


● 要素「b」
peek → b を表示

filter → "b".contains("b") → true

次の peek → B を表示

forEach → b を表示


● 要素「c」
peek → c を表示

filter → "c".contains("b") → false

→ 後続の peek に進まない

→ forEach にも進まない

出力：c




#副作用とは？

🎯 副作用とは何か（最重要）
副作用とは：
関数の戻り値以外の形で外部に影響を与えること。

具体例：

コンソールに出力する（System.out.println）

ファイルに書き込む

DB に書き込む

グローバル変数を変更する

フィールドを書き換える

つまり 「値を返す以外の行為」 が全部副作用。



■🧩 peek がやっていることは「副作用の実行」
peek の役割は：

ストリームの流れの途中で副作用を実行する（観察する）だけ。
`値を変換しない。ストリームの内容にも影響しない。`  

例：
.peek(v -> System.out.println(v))
これは 値を返さない（void） ので、ストリームの流れには何も影響しない。
ただし コンソールに出力するという副作用だけが起きる。


`Stream<T> peek(Consumer<? super T> action)`  

Consumer の定義：  
`void accept(T t)`  
**値を返さない（void）**  
**外部（ストリームライン外ということ！）への影響（副作用）だけを起こす**  
だから peek は 副作用専用の中間操作  

**Consumer インタフェースの抽象メソッド accept(T t) を、peek に渡すラムダ式が“実装している**  

■Consumer インタフェースの定義  
```
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
```


#参考
*🔥 map と peek の違い（副作用の観点）*  

〇✔ map（純粋関数）
`.map(v -> v.toUpperCase())`  
**値を変換する**  
**副作用を持たない**

〇✔ peek（副作用）
`.peek(v -> System.out.println(v))`  

**値を変換しない**  
**副作用だけを実行する**  


※匿名クラスによる記述：  

```
new Consumer<String>() {
    @Override
    public void accept(String v) {
        System.out.println(v);
    }
}

```