設問31

次のコードを確認してください


```
package stream_api;

import java.util.List;
import java.util.stream.Collectors;

public class Double_test {

	public static void main(String[] args) {
		List<Integer> values = List.of(10, 20, 30, 40, 50);

		
	}

}
```


このコードから平均値を求めるためのコードとして正しいものを選べ（１つ）  



A.
double result = values.stream().mapToDouble(d -> d).collect(Collectors.averagingDouble(d -> d));  

		

B.
double result_b = values.stream().mapToInt(x -> x).average().getAsDouble();  

		
C.
double result_c = values.stream().average();  



D.
double result_d = values.stream().collect(Collectors.averagingDouble(i -> i)).orElseThrow();  
		
		
E.
double result_e = values.stream().map(i->i).average().orElse();  
		

		
		
#設問見た時の所感
31.チンプンカンプンどれも正しようにしか見えない


#試験観点は何か？  


Java Gold の本質 )  

・Stream の型変換（map → mapToInt → mapToDouble）と Optional の仕様を理解していれば迷わない。


・“ラムダ式・Stream の型変換・Optional の仕様”の観点が不足  




〇知識で覚えておく  
❌ Stream<Integer> に average() は存在しない  
average() は IntStream / LongStream / DoubleStream のメソッド  

注意点：  
stream()には、averageメソッドはないが、mapToIntメソッドは存在していて、その戻り値型が、「IntStreamインタフェース」
そのため、そのインタフェースには、「average()メソッド」あるので問題なし
※メソッドチェーンになっているものは注意してください   
`values.stream().mapToInt(x -> x).average().getAsDouble();`  
※stream()とaverage()の間に1つあるので、それを無しと判断して、stream()にはaverage()なしだからNG選択肢とはならないこと
※中間に「mapToInt()」あるので、その戻り値型に対して、「average()」を呼んでいる  

参考）  
mapToIntの戻り値は、IntStreamインタフェース型
mapToDouble戻り値は、DoubleStreamインタフェース型
mapToLongの戻り値は、LongStreamインタフェース型  




❌ averagingDouble の戻り値は Doubleで、Optional ではないため、Optional判定でのみ使用できるorElseThrow() は存在しない
❌Optional型を戻さないシチュエーションでは、Optional判定用の orElse() も存在しないため、コンパイルエラー  


・collect()は、 ⇒Streamインタフェースのメソッドであること  

・Collectorsは「クラス」です    

・averagingDouble**  
⇒Collectorsクラスのメソッドで、戻り値型は、インタフェースCollector<T,?,Double>であること  

