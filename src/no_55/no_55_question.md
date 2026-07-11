設問55

次のコードをコンパイル、実行したときの結果として正しいものを選べ（１つ）


```
package stream_api;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream_compare {

	record Item(String name, int price) {

	}

	public static void main(String[] args) {
		List<Item> items = List.of(
				new Item("mango", 150),
				new Item("banana", 80),
				new Item("orange", 120),
				new Item("apple", 100),
				new Item("melon", 1000));
		String result = items.stream().sorted(Comparator.comparing(Item::price).reversed()).map(Item::name)
				.collect(Collectors.joining(",", "[", "]"));
		System.out.println(result);
	}

}
```


A. [melon, mango,orange,apple,banana]が出力される

B. []melon,[]mango,[]orange,[]apple,[]banana,が出力される

C. []melon,mango,orange,apple,banana[]が出力される

D. [melon],[mango],[orange],[apple],[banana]が出力される

E. コンパイルエラーが発生する

F. 実行時に例外がスローされる


#設問を解いたときの所見

55.DかAか、どっちか？



#知識不足ポイント

・map(Item::name)の出力の形式について  
・Collectorsクラスのjoiningメソッド仕様（引数3つ、戻り値型：Collectorインタフェース）
・joining()はオーバーロードを持つこと（その内の1種類を使用していること）