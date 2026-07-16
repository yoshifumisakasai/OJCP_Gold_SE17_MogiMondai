#設問18

次のコードの「insert code here」に入るコードとして正しいものを選べ（１つ）

```
package no_18;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class No_18 {

	public static void main(String[] args) {
		List<Integer> a = List.of(50, 60, 70, 80);
		List<Integer> b = List.of(40, 50, 60, 70);
		//Insert code here
      System.out.println(avg);
  } 
}
```




選択肢：  


A. dobule avg = Stream.flatMap(a.stream(), b.stream()).mapToInt(i -> i).average().agetAsDouble;` 

		

B. double avg = Stream.of(a, b).flatMap(List::stream).collect(Collectors.averagingDouble(d -> d));



C. double avg = List.of(a, b).stream().flatMap(s -> s.stream()).map(d -> d).average().orElse(0.0);

	
		
D. double avg = Stream.of(a, b).flatMap(s -> s.stream()).mapToInt(i -> i).average();

		
		
E. double avg = Stream.concat(a, b).strem().collect(Collectors.averagingDouble(Integer::doubleValue));






#迷ったポイント「設問見たとき、解いたときの知識レベル、試験観点の把握レベルは？(1回目)  

18.ちんぷんかんぷん。えどれも正しいようにしか見えない


#迷ったポイント(2回目)
わからない、flatMapはたしか、複数のストリームを１つにするだっけ？のレベル




#試験観点（この問題が何を測っているか）1回目

・複数List型のまとめかた:  
複数の List を「ひとつの流れ」にまとめる方法は大きく 2 系統あり、試験ではこの違いを理解しているかを問われる。  
■方法1：List.of で “List<List<T>>” にまとめる  
■方法2：Stream.of で “Stream<List<T>>” を作る  


・flatMap の正しい使い方、役割は何か？  


List<List<T>> → Stream<T> の平坦化の理解  

average() の戻り値型（OptionalDouble）を知っているか  

Collectors.averagingDouble の戻り値型（Double）を知っているか  

Stream API のメソッド名の罠を見抜けるか  



#試験観点（この問題が何を測っているか）2回目


〇まず2点覚えておく


（１）複数のListのまとめ方
flatMapは、以下の2つの方法しかないこと（分かっていれば、選択肢5⇒3つに絞れる）

■方法1：Stream.of  

```
List<Integer> a = List.of(50, 60, 70, 80);  
List<Integer> b = List.of(40, 50, 60, 70);  
Stream.of(a, b).flatMap  
```
		
■方法2：List.of  

```
List<Integer> a = List.of(50, 60, 70, 80);  
List<Integer> b = List.of(40, 50, 60, 70);  
List.of(a, b).stream().flatMap  
```

（２）flatMapの処理のところ
`flatMap(List::stream)`  
**List を stream に変換して 平坦化（flatten）**    
→ Stream<Integer> になる  
→ [50,60,70,80,40,50,60,70]  

※以下どちらでも同じ処理  
・ラムダ式での記述  
`.flatMap(s -> s.stream())`

・メソッド参照での記述  
`.flatMap(List::stream)`   