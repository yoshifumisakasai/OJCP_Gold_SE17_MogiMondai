設問59

次のコードをコンパイル、実行したときの結果として正しいものを選べ（１つ）



```
package java_clazz_function;

import java.util.HashMap;
import java.util.Map;

public class HashMap_t {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "A");
		map.put(2, "B");
		map.put(1, "C");
		System.out.println(map);
	}

}
```


A. {1=A,2=B,3=C}が出力される

B. {1=A,2=B}が出力される

C.{1=C,2=B}が出力される

D.{1=A,3=C,2=B}が出力される




#設問を解いた時の所見は

59.C
   Mapはキー一意だった気が



#試験観点
 HashMap の put が “同じキーなら上書きする” という基本仕様を問う典型的な Silver 問題
 HashMap は「キーが一意」