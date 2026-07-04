□Stream　　
`インタフェースStream<T>`  



□Collectorsクラス
`要素をコレクションに蓄積したり、さまざまな条件に従って要素を要約するなど、有用な各種リダクション操作を実装したCollector実装。`  


□Collectorインタフェース
`インタフェースCollector<T,A,R>`  
T - リダクション操作の入力要素の型
A - リダクション操作の可変蓄積の型(通常は実装詳細として隠蔽される)
R - リダクション操作の結果の型


#collectメソッド

Collector<T, ?, R>  
「返却値 R を作る Collector」。    
collect は「Collector が作る最終結果を返すだけ」  

`Collector<T, A, R> の 3 つ：`  

T：ストリームの要素型  

A：中間蓄積（Accumulator）の型（外に出ない）  

```
X -> (downstream 用の空の蓄積 A)
Y -> (downstream 用の空の蓄積 A)
Z -> (downstream 用の空の蓄積 A)

```
*A は mapping の中間蓄積（StringBuilder 的なもの）*  


**R：最終結果の型（collect() が返す型）**  
*collect が返すのは R だけ。*  

`<R,A> R collect(Collector<? super T,A,R> collector)`

`<R> R collect(Supplier<R> supplier,BiConsumer<R,? super T> accumulator, BiConsumer<R,R> combiner)`  

              
#groupingByメソッド  
groupingBy → Map<K, R> を作る  
「K]をグループキーとして、Rを複数あればまとめる  
`public static <T,K> Collector<T,?,Map<K,List<T>>> groupingBy(Function<? super T,? extends K> classifier)`  

`public static <T,K,A,D> Collector<T,?,Map<K,D>> groupingBy(Function<? super T,? extends K> classifier, Collector<? super T,A,D> downstream)`  


`public static <T,K,D,A,M extends Map<K,D>> Collector<T,?,M> groupingBy(Function<? super T,? extends K> classifier, Supplier<M> mapFactory, Collector<? super T,A,D> downstream)`  


□groupingBy の戻り値  
インタフェースCollector<T,A,R>  
`戻り値：Collector<T, ?, Map<K, D>>`
 *groupingBy は Map を作る Collector を返す。*  
 
※groupingBy は「値部分 R を作る Collector」を受け取る  
groupingBy の型：  
`Collector<T, ?, Map<K, R>>`   
groupingBy の R は “下流 Collector（downstream）” が作る型  

つまり groupingBy はこういう Collector を要求する：  
**downstream: Collector<T, ?, R>**  
mapping はまさにこれに該当  



```
downstream = groupingBy の “値の作り方” を担当する Collector

groupingBy は Map<K, R> を作る

しかし groupingBy 自体は R の作り方を知らない

※groupingBy は R を作る Collector（＝downstream） を受け取る
```

■Java文法仕様  

```
Collector<T, ?, Map<K, D>> groupingBy(
    Function<? super T, ? extends K> classifier,
    Collector<? super T, ?, D> downstream
)

```

**D が groupingBy の値部分の型**  
**downstream が D を作る Collector**  

つまり：  
**groupingBy は Map<K, D> を作る**  
**D の作り方は downstream Collector が決める**  


設問コード:  
**groupingBy(Products::category) によって、内部的には次のような Map が作られる：**  

X -> [Products("A","X"), Products("B","X")]  
Y -> [Products("C","Y"), Products("D","Y")]  
Z -> [Products("E","Z"), Products("F","Z")]  



#mappingメソッドについて  
mapping → R を作る（今回なら String）  
`public static <T,U,A,R> Collector<T,?,R> mapping(Function<? super T,? extends U> mapper, Collector<? super U,A,R> downstream)`  


`戻り値：Collector<T, ?, R>`  
便宜的に、**Collector<T, A, R>**でもよい  
T = Products  
A = joining が内部で使う StringBuilder 的な中間蓄積（外に出ない）  
R = String（joining の結果）  
※Products を受け取って、最終的に String を作る Collector  

**mapping は Map を作るのではなく、Map の “値部分” を作る Collector **  
※Mapオブジェクトは作りません!  

✔ mapping は「Products → name だけに変換する  
mapping(Products::name, ...) は 中間操作の map と同じ  

**オブジェクトから name だけを取り出す変換を行う。**
Products("A","X") → "A"  
Products("B","X") → "B"  

groupingBy の中身(上記処理後）  
X -> ["A", "B"]  
Y -> ["C", "D"]  
Z -> ["E", "F"]  


D:間違い  
選択肢 D のような
X:A X:B
になるためには、
**mapping が name ではなく category + name を返す必要がある。**  

mapping が以下のようなコードでないと D にはならない：  
`mapping(p -> p.category() + ":" + p.name(), joining(" "))`  

実際のコードは：  
`mapping(Products::name, joining(" "))`  
⇒name しか取り出していない。  


#joiningについて  
joiningの戻り値型：  
**Collector<CharSequence,?,String>**  

`public static Collector<CharSequence,?,String> joining(CharSequence delimiter)`  

`public static Collector<CharSequence,?,String> joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix)`    


□確認ポイント  
joining() の戻り値は Collector<CharSequence, ?, String>  
「String を作るための Collector（レシピ）」 を返している  
実際に String を返すのは collect(...) の役割  

*Collectors.joining() → Collector<CharSequence, ?, String>*  

*collect(...) → R（= String）を返す*  



#疑問点  
正答AとDが迷って、判断できない。
**・ストリームが分かれて３本走るようになるのか？**  
⇒`X 用のストリーム、Y 用のストリーム、Z 用のストリームが内部的に走る。`  


**・forEach(k,v)のkは何か、vは何か？**  
collect(...) の結果は Map<String, String> になる。  

つまり：  
k = category（X, Y, Z）  

v = "A B" のように joining された文字列  

生成されるMap型：  
X:A B  `k:X、v:A B`    
Y:C D  `k:Y、v:C D`  
Z:E F  `k:Z、v:E F`  

こういうMap型ではありません:  

"A", "X"  k:A、v:X
"B", "X"  k:B、v:X  
"C", "Y"  k:C、v:Y  
"D", "Y"  k:D、v:Y  
"E", "Z"  k:E、v:Z  
"F", "Z"  k:F、v:Z  
**forEach(k, v) の k は category、v は joining された文字列**  


**・mappingの戻り値は**    
・Collector<T,?,R>  
・Collector<T,?,Map<K,D>>  
・Collector<T,?,M>   
**のようでmap型ではない。どういうことか？**  

**mapping の戻り値は Collector だが、最終的には Map<K, R> の R に変換される**  

#全体流れ  

□全体流れ  

```
Products Stream
   |
   | groupingBy(category)
□詳細   
X -> (downstream 用の空の蓄積 A)
Y -> (downstream 用の空の蓄積 A)
Z -> (downstream 用の空の蓄積 A)
**<① groupingBy がカテゴリごとの箱を作る>**  
**<A は mapping の中間蓄積（StringBuilder 的なもの）。>**    
X -> [Products("A","X"), Products("B","X")]
Y -> [Products("C","Y"), Products("D",>"Y")]
Z -> [Products("E","Z"), Products("F","Z")]
   
   
   v
Map<String, List<Products>>
   |
   | mapping(name, joining(" "))
   <③ mapping が「Products → name」へ変換し、joining が蓄積する>
   （例）  
   Products("A","X") → "A"
   Products("B","X") → "B"
   
   joining(" ") が蓄積：
   X -> "A B"
   Y -> "C D"
   Z -> "E F"
   v
Map<String, String>
<④ groupingBy が「K → R」の Map を完成させる>
□詳細  
Map<String, String> {
    X = "A B",
    Y = "C D",
    Z = "E F"
}

```


#まとめ  

**mapping → Collector<T, ?, R>**  

**groupingBy → Collector<T, ?, Map<K, D>>**  

**joining → Collector<CharSequence, ?, String>**  

`どれも Collectorインタフェース型 を返すだけであり、最終結果を返すのは collect(...)`  

