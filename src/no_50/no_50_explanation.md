#takeWhile メソッドについて
パッケージ：java.util.stream

インタフェース：Stream<T>
メソッド種別：default メソッド
`→ Stream の実装クラス（ReferencePipeline など）が自動的に使えるようになっている`  

□シグネチャ（公式）
`default Stream<T> takeWhile(Predicate<? super T> predicate)`  
**引数：Predicate<? super T>**  
**戻り値：新しい Stream<T>**

※Predicate の抽象メソッド test(T t) を実装すPredicate の抽象メソッドは test(T t) のみ  
※takeWhile に渡すものは「test を実装した関数オブジェクト」であれば何でもよい   



■匿名クラス  
ラムダ式は 関数型インタフェースの抽象メソッドを実装した匿名クラスを生成する構文糖衣  

```
Predicate<Item> p = new Predicate<Item>() {
    @Override
    public boolean test(Item e) {
        return e.name().contains("e");
    }
};
```

□本設問用コード  

```
list.stream().takeWhile(new Predicate<Item>() {
    @Override
    public boolean test(Item e) {
        return e.name().contains("e");
    }
});
```

■メソッド参照の場合（test の実装を既存メソッドに委譲）  
**メソッド参照は 既存のメソッドを test に割り当てる書き方**  

例：
`list.stream().takeWhile(Item::hasE);`  


 Item にメソッドを準備：

```
record Item(String name, int price) {
    boolean hasE() {
        return name.contains("e");
    }
}
```

□Java の解釈  
**Item::hasE は「Item 型を受け取って boolean を返すメソッド」なので Predicate<Item> の test に一致する。**  


〇内部的にはこう展開されるイメージ：  

`Predicate<Item> p = item -> item.hasE();`    
さらに最適化されて invokedynamic でメソッドハンドルが使われる  


#メソッド参照は 関数型インタフェースの抽象メソッドとシグネチャが一致するメソッドを割り当てる仕組み  

`「シグネチャが一致する」とは、関数型インタフェースの抽象メソッドと “引数の数・型・戻り値の型” が一致すること`  

Predicate の test ：  
`boolean test(Item e)`  

Item::hasE ：  
`boolean hasE()`  

引数の型/数が不一致：
引数の扱いは Java が自動で合わせてくれるので、test(e) → e.hasE() に置き換えられる  
`（ただしインスタンスメソッドなので暗黙に this = Item を受け取る）`  