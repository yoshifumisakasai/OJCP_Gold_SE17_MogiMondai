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






#迷ったポイント「設問見たとき、解いたときの知識レベル、試験観点の把握レベルは？  

18.ちんぷんかんぷん。えどれも正しいようにしか見えない




#試験観点（この問題が何を測っているか）

・複数List型のまとめかた:  
複数の List を「ひとつの流れ」にまとめる方法は大きく 2 系統あり、試験ではこの違いを理解しているかを問われる。  
■方法1：List.of で “List<List<T>>” にまとめる  
■方法2：Stream.of で “Stream<List<T>>” を作る  


・flatMap の正しい使い方、役割は何か？  


List<List<T>> → Stream<T> の平坦化の理解  

average() の戻り値型（OptionalDouble）を知っているか  

Collectors.averagingDouble の戻り値型（Double）を知っているか  

Stream API のメソッド名の罠を見抜けるか  
