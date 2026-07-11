#Predicateの仕様レベル
`Predicate<String> k = t -> t.length() < 5;`  
*test(T t) を実装するラムダ式*


■次の匿名クラスと同等：

```
Predicate<String> k = new Predicate<String>() {
    @Override
    public boolean test(String t) {
        return t.length() < 5;
    }
};
```

⇒ラムダ式は Predicate の test() の実装  



#ラムダ式はどこに実装されるのか？  
**ラムダ式は「関数型インタフェースの抽象メソッドを実装するオブジェクト」**  
**Predicate → 抽象メソッドは test(T t) だけ**  

※ラムダ式 → test の実装を提供する  

□test(String t) の実装  
`t -> t.length() < 5`  



