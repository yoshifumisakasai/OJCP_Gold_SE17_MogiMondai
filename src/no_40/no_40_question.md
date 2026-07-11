
設問40

次のコードをコンパイル、実行したときの結果として正しいものを選べ（１つ）

```
package stream_api;

import java.util.List;

public class AnyMatch {
	public static void main(String[] args) {
		List<Integer> list = List.of(10, 20, 30, 40, 50);
		var result = list.stream().anyMatch(i -> i > 30);
		System.out.println(result);
	}
}
```

A. trueが表示される

B. falseが表示される

C. 40, 50のいずれかが表示される

D. 40が表示される

E. コンパイルエラーが発生する


#設問解いた解き状況、所見  
40.Cかｄ判別つかない、
   30より大きいという判定なので、40か50しかない

   
#前提知識
・anyMatch仕様  
anyMatch の戻り値は boolean なので数値は出ません。
