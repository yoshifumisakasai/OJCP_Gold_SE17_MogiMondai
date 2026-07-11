設問47

次のコードをコンパイル、実行したときの結果として正しいものを選べ（１つ）

```
package java_clazz_function;

import java.util.ArrayList;

public class Boxing {
	public static void main(String[] args) {
		var data = new ArrayList<Long>();
		data.add(1);
		data.add(2);
		data.add(3);

		long total = 0;
		for (Long n : data) {
			total += n;
		}

	}
}
```

A. 0が表示される

B. 6が表示される

C. コンパイルエラーが発生する

D. 実行時に例外がスローされる




#設問といたときの所見

47.B
？普通はそうだが、分からない


#設問の正当
data.add(1); の 1 は int → Integer にオートボクシングされる。  
**しかし ArrayList<Long> が受け取れるのは Long 型だけなので、Integer は Long に変換できず コンパイルエラーになる**  



#設問解く上で必要な観点（知識）

・AutoBoxingルール（同一系の型同士のみ）

・List型/Map型における制限（プリミティブ：NG、参照型のみ：OK）  

