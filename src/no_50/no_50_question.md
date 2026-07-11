
設問50

次のコードをコンパイル、実行したときの結果として正しいものを選べ（１つ）

```
package stream_api;

import java.util.List;

public class Takewhile {
	record Item(String name, int price) {
	};

	public static void main(String[] args) {
		List<Item> list = List.of(new Item("apple", 100),
				new Item("banana", 80),
				new Item("orange", 120));
		list.stream().takeWhile(e -> e.name().contains("e")).forEach(System.out::print);
	}
}
```

A. Item[name=apple, price=100]が表示される

B. Item[name=orange,price=120]が表示される

C. Item[name=apple,price=100] Item[name=orange,price=120]が表示される

D. 何も出力されない

E. コンパイルエラーが発生する

F. 実行時に例外がスローされる



#設問解いたときの所見

50.takewhileって何？
チンプンカンプン
でも、"e"含まれる文字をフィルタりしてるようなので、appleとorangeだから、Cと思うけど


#選択肢判定のための前提知識

①
*takeWhile は filter と違って “途中で false が出たら即終了*
**"e"含まれる文字をフィルタして、ヒットしたものをすべて取り出しではない点注意**


②takeWhile メソッドについて
takeWhile メソッドは java.util.stream.Stream インタフェースのメソッド
`default Stream<T> takeWhile(Predicate<? super T> predicate)`  
※Predicate の抽象メソッド test(T t) を実装する  
