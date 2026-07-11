#🎯 まずコードの処理内容を正しく分解する

`Files.lines(Paths.get("sample.txt"))`  
→ ファイルを 1行ずつ読み込む Stream<String>  



`flatMap(line → Arrays.stream(line.split("\\W+")))`  






#Streamインタフェースのcollectメソッド仕様  


Stream インタフェースの collect メソッドは「ストリームの要素を 1 つの結果にまとめるための“汎用的な畳み込み処理”」。
reduce が「値を畳み込む」のに対し、collect は 「オブジェクト（List, Map, String…）を構築するための仕組み」。

`<R, A> R collect(Collector<? super T, A, R> collector)`  



#Collectorsクラスの「groupingBy」メソッド、「counting」メソッド仕様  


🎯 まず結論（戻り値型）

✔ counting の戻り値型
`Collector<T, ?, Long>`  


✔ groupingBy の戻り値型（2引数版）  
`Collector<T, ?, Map<K, D>>`    
※ K はキー、D はダウンストリーム Collector の結果型  






#🧩 1. counting() の戻り値型を正確に分解  
counting のシグネチャ

`public static <T> Collector<T, ?, Long> counting()`  
つまり counting は：  

T：ストリームの要素型  

A：中間バッファ（内部で long を数えるための型 → 隠蔽されているので ?）  

R：最終結果 → Long  

最終的に Long を返す Collector を作る。  





#🧩 2. groupingBy の戻り値型を正確に分解
groupingBy のシグネチャ（2引数版）  
`public static <T, K, D> Collector<T, ?, Map<K, D>> groupingBy(Function<? super T, ? extends K> classifier,Collector<? super T, ?, D> downstream)`  
つまり groupingBy は：  

T：ストリームの要素型  

K：グループ化のキー  

D：ダウンストリーム Collector の結果型  

R：最終結果 → Map<K, D>  




#🎯 具体例で理解

```
stream.collect(Collectors.groupingBy(
    item -> item.category(),
    Collectors.counting()
));
```

〇counting の戻り値型
`Collector<Item, ?, Long>`  

〇groupingBy の戻り値型
`Collector<Item, ?, Map<String, Long>>`  

※最終結果は：
Map<String, Long>





#🧩 3. なぜ groupingBy の戻り値は Map ではなく Collector なのか？  
**groupingBy/counting は Map を返すのではなく、Map を作るための Collector を返す**  

**※groupingBy は「レシピ」であり、collect(...) がそのレシピを使って Map を生成する**  
