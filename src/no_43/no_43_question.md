設問43


次のコードをコンパイル、実行したときの結果として正しいものを選べ（１つ）

```
package stream_api;

import java.util.stream.Stream;


record Item(String name, int price) {
};

public class Main_reduce {
	record Item(String name, int price) {
	};

	public static void main(String[] args) {
		Stream<Item> stream = Stream.of(new Item("apple", 100), new Item("banana", 80), new Item("orange", 120));
		
		Integer result = stream.filter(item -> item.price() >= 100).map(item -> item.price()).reduce(0, Integer::sum);
		System.out.println(result);
	}

}
```


A. 0が出力される

B. 220が出力される

C. nullが出力される

D. 実行時に例外がスローされる




#コード読み解く前提知識

〇2つのラムダ式 と 1つのメソッド参照について 

`item -> item.price()（filter）`  

`item -> item.price()（map）`  

`Integer::sum（reduce の BinaryOperator）`  


**⇒すべて「関数型インタフェースの抽象メソッドを実装したインスタンス」 として扱われる**  


〇reduceとは？  

reduce は 2つのものを使ってストリームを 1 個の値にする  (Streamインタフェースのメソッド)  
ストリームを 1 個の値に変換するために、BinaryOperator の apply を繰り返し呼び出す  
