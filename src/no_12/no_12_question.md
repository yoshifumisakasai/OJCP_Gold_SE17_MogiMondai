
次のコードをコンパイル、実行したときの結果として正しいものを1つ選べ

```
package stream_api;

import java.util.stream.Stream;

public class X_12 {
	public static void main(String[] args) {
		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5).filter(i -> {
			System.out.println("A");
			return i % 2 == 0;
		});
		System.out.println("B");
		stream.forEach(System.out::println);
	}
}
```

A. AAAAAB24の順に表示される

B. BAAAAA24の順に表示される

C. ABA2AA4Aの順に表示される

D. BAA2AA4Aの順に表示される

E. コンパイルエラーが発生する

F. 実行時に例外がスローされる



#試験で迷ったポイント  
12.1,2,3,4,5をそれぞれ2で割って余り0なのは、2と4なので、Aが2回でると思うのだが、それが選択肢にない
