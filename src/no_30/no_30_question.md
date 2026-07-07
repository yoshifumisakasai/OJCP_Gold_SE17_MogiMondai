
設問30


次のコードをコンパイル、実行したときの結果として正しいものを選べ（１つ）


```
package java_clazz_function;

import java.util.Random;
import java.util.function.Supplier;

public class Supplier_t {

	public static void main(String[] args) {
		Supplier<Integer> s = () -> new Random().nextInt(10);
		System.out.println(s.get());
	}

}
```

A. 0から9までの整数がランダムに表示される

B. 10が表示される

C. コンパイラーが発生する


D.実行時に例外がスローされる



#試験観点

・Random#nextInt(int bound) の仕様：

・Supplier は「引数なしで値を返す」関数型インタフェースであること
