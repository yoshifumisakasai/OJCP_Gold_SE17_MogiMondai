#reduceとは？
reducing のラムダは「複数の値を1つにまとめる」

**グループ内の値を 1 つにまとめる Collector**  



#(k, v) とは?
**groupingBy の結果 Map の キーと値**  

```
k = Category_X  

v = Optional<Item>  
```

🎯 groupingBy の戻り値は何か  
`Collectors.groupingBy(classifier, downstream)`  
この Collector の型は：

**Collector<T, ?, Map<K, R>>**  
collect の戻り値は Map<K, R>  
`R は “下流 Collector（downstream）” によって変わる`  

K = グループ化キー（カテゴリなど）  

R = グループの最終結果（List、Set、Optional、Long など）  


#Stream の collect メソッドの戻り値型
「Collector が生成する R 型」  

`<R, A> R collect(Collector<? super T, A, R> collector)`  
**collect の戻り値は R**

R = 最終的な結果の型  

A = 中間バッファ（途中経過の入れ物）  

T = Stream の要素型  