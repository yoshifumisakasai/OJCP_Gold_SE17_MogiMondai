
#🧩 ① Stream.of(…) の時点では何も起きない
Stream.of(10, 20, 30, 40, 50)    
**→ ただのストリーム(ライン）の「配置構成」、「設計図」を作成しただけで、実際の処理はまだ始まっていない（ラインに流していない）。**  


#🧩 ② filter の中身は「遅延評価」  
 *「filter」は遅延評価のため、A は出力されない。*  
filter は 中間操作であり、ストリームは「終端操作」が呼ばれるまで実行されないため。  
①`※「filter」は中間操作であり、実際にはこの時点で何も処理はされません。`
②`ストリームは遅延評価であり、中間操作はあくまでも「処理の流れの定義」として構築されるだけで、終端操作が実行されるまでデータは流れない`



 
```
.filter(i -> {
    System.out.println("A");
    return i % 2 == 0;
})
```

#🧩 ③ B はすぐ出力される
これは普通の処理「Streamラインの外にあるもの」なので、即出力  
※ストリーム定義の構築のあと、コンソールに「B]が出る  
`System.out.println("B");`  



#🧩 ④ forEach が呼ばれた瞬間にストリームが流れ始める
終端操作「forEach」実行により、ストリーム定義に従い、5つの要素が1つずつ評価を開始する  


#試験観点の説明  


・要素 1  
filter のラムダ実行 → A

*1 % 2 == 0 → false*  
`→ forEach に渡らない`  
**filter の条件が false の場合、その要素は終端操作側には一切流れません。**  
**ストリームのパイプラインから“除外される”ので、forEach には届きません。**  
`filter は Predicate<T> の test が true の要素だけを次のステージに渡す。`  
`boolean test(T value)`



● 要素 2  
A  
true → forEach が 2 を出力  
`→ forEach 終端操作側にデータが流れる` 


● 要素 3  
A  
false  
`→ forEach に渡らない`  
**filter の条件が false の場合、その要素は終端操作側には一切流れません。**  
**ストリームのパイプラインから“除外される”ので、forEach には届きません。**  
`filter は Predicate<T> の test が true の要素だけを次のステージに渡す。`  
`boolean test(T value)`



● 要素 4  
A  
true → 4 を出力  
`→ forEach 終端操作側にデータが流れる` 



● 要素 5  
A  
false  
`→ forEach に渡らない`  
**filter の条件が false の場合、その要素は終端操作側には一切流れません。**  
**ストリームのパイプラインから“除外される”ので、forEach には届きません。**  
`filter は Predicate<T> の test が true の要素だけを次のステージに渡す。`  
`boolean test(T value)`


□考え方のポイント  
**System.out.println("A"); は「filter 条件の外」ではなく、filter の“条件式の一部として必ず実行される処理”です。**  
**ただし、戻り値（true/false）には関係しない副作用の処理です。**  


・filter のラムダが呼ばれたら必ず実行される  

`true/false の判定には関与しない`  

`判定結果が false の場合は 後続のストリームには流れない`  

