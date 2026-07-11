#基本
ラムダ式は 匿名クラスの簡易記法ではない。  
**「動作上は匿名クラスと同じく、インタフェースの抽象メソッドを実装したインスタンスになる」**  


#filter のラムダ式

`item -> item.price() >= 100`



*Predicate<Item> の抽象メソッド boolean test(Item t) を実装している*  

コンパイラは概念的に次のようなコードを生成する：  

↓↓  

```
Predicate<Item> pred = new Predicate<Item>() {
    @Override
    public boolean test(Item item) {
        return item.price() >= 100;
    }
};
```


#map のラムダ式  




`item -> item.price()`  


*Function<Item, Integer> の抽象メソッド apply を実装している*  

内部的には次のようなものが生成される：  


↓↓  

```

Function<Item, Integer> func = new Function<Item, Integer>() {
    @Override
    public Integer apply(Item item) {
        return item.price();
    }
};

```


#メソッド参照の観点（Integer::sum）

`Integer::sum`  

*BinaryOperator<Integer> の抽象メソッド apply(T t1, T t2) を実装している*  

```
BinaryOperator<Integer> op = new BinaryOperator<Integer>() {
    @Override
    public Integer apply(Integer a, Integer b) {
        return Integer.sum(a, b);
    }
};
```

**メソッド参照は「既存メソッドをラムダ式として使うための糖衣構文」**  



#reduceとは？

・reduce は 2つのものを使ってストリームを 1 個の値にする  
・ストリームを 1 個の値に変換するために、BinaryOperator の apply を繰り返し呼び出す。  

■基本シグネチャ
`T reduce(T identity, BinaryOperator<T> accumulator)`    

〇パラメータ:
**identity - 蓄積関数に対する単位元の値（いわゆる「初期値」）**  
**accumulator - 2つの値を結合するための結合的、非干渉、およびステートレスな関数**
                （（合成関数） ← ラムダ式 or メソッド参照）  



～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～  
□その他（オーバーロード）  

`Optional<T> reduce(BinaryOperator<T> accumulator)`  


`<U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)`    
～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～  


■ポイント  
**reduce は BinaryOperator<T> の apply を繰り返し呼び出す処理**  

`BinaryOperator は Function のサブタイプで、抽象メソッドは：`  
`T apply(T a, T b)`   



■reduce の動作：「匿名クラス」コード

```
Integer result = stream.reduce(0, new BinaryOperator<Integer>() {
    @Override
    public Integer apply(Integer a, Integer b) {
        return Integer.sum(a, b);
    }
});



```