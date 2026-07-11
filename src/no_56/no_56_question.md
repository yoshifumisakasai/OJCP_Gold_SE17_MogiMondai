設問56

次のコードをコンパイル、実行したときの結果として正しいものを選べ（１つ）


```
package no_56;

import java.util.stream.Stream;

public class Stream_gen {

	public static void main(String[] args) {
		Stream a = Stream.of(1, 2, 3);
		Stream<Integer> b = a.map(n -> n + 1);
		b.forEach(n -> System.out.println(n));
	}

}
```

A. 1,2,3の順に表示される

B. 2,3,4の順に表示される

C. コンパイルエラーが発生する

D. 実行時に例外がスローされる




#設問を説いたときの所感

56.C
   Streamにジェネリクス型未指定だから？

   
   
#観点追加
1. Streamにジェネリクス型未指定
2. なぜコンパイルエラーになるのかを “Java の型推論の内部仕様” まで踏み込んで整理すること
   → a.map(...) の戻り値も raw 型扱いになる点  
   → raw 型の map は Function も raw 型になる点  
