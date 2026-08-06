設問46


次のコードをコンパイル、実行したときの結果として正しいものを選べ（１つ）


```
package stream_api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class File_Groping {
	public static void main(String[] args) {
		try (Stream<String> data = Files.lines(Paths.get("sample.txt"))) {
			Map<String, Long> result = data.flatMap(line -> Arrays.stream(line.split("\\W+"))).filter(word -> !word.isEmpty()).collect(Collectors.groupingBy(word -> word, Collectors.counting()));
			result.forEach((word, count) -> System.out.println(word + ":" + count));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```


A. ファイルに含まれる単語の数の集計結果が表示される

B. ファイル内の全行が表示される

C. ファイル内の空白以外の行数の集計結果が出力される

D. コンパイルエラーが発生する



#設問解いたときの所見
46.C
？
よくわからない


#前提知識

・flatMapとは？  
*「要素を Stream に変換し、それらを 1 本にまとめる*  




・Streamインタフェースのcollectメソッド仕様  

*Stream インタフェースの collect メソッドは「ストリームの要素を 1 つの結果にまとめるための“汎用的な畳み込み処理”」*  




・Collectorsクラスの「groupingBy」メソッド、「counting」メソッド仕様  
🎯 まず結論（戻り値型）

✔ counting の戻り値型
`Collector<T, ?, Long>`  


✔ groupingBy の戻り値型（2引数版）  
`Collector<T, ?, Map<K, D>>`    
※ K はキー、D はダウンストリーム Collector の結果型  


