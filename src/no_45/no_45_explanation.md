#java.util.function（関数型インタフェース） のどれと一致するか


■Function<T, R>
`R apply(T t)`  
引数：T（今回なら String）  
戻り値：R（今回なら Integer）  

→ 完全一致  

ただし戻り値が int なので、実際には Function<String, Integer> に置き換える。  

Java のプリミティブ専用 Function には「ToIntFunction<T>」もあるが、選択肢にないので Function が正解。  


■A. Supplier  
`T get()`

引数なし

戻り値あり
→ 引数がないので不一致  





■B. BinaryOperator  
`T apply(T t1, T t2)`  
引数2つ

戻り値あり
→ 引数が2つなので不一致



■C. Consumer  
 
`void accept(T t)`    
引数あり  

戻り値なし（void）  
→ 戻り値がないので不一致  




■D. Predicate  
`boolean test(T t)`  
引数あり  

戻り値は boolean  
→ 戻り値の型が違うので不一致  