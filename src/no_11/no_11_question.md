設問11


次のコードをコンパイル、実行したとき以下のような結果が出力されるように、コードのinsert code hereに入るコードとして正しいものを選べ（１つ）


VEGITABLE: Item[name=tomato, price=150, category=VEGITABLE]
FRUITS: Item[name=apple, price=100, category=FRUITS]

□コード1

```
package no_11;

//列挙型
enum Category_X {
	FRUITS, VEGITABLE

}

```

■コード2

```
	record Item(String name, int price, Category_X category) {
	}
```
	

■コード3

```
package no_11;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Collect_group {



	public static void main(String[] args) {

		//4つのItem作成
		Item a = new Item("apple", 100, Category_X.FRUITS);
		Item b = new Item("banana", 80, Category_X.FRUITS);
		Item c = new Item("cucanva", 120, Category_X.VEGITABLE);
		Item d = new Item("tomato", 150, Category_X.VEGITABLE);

		List<Item> items = List.of(a, b, c, d);

		Map<Object, Optional<Item>> maxPriceItemByCategory = items.stream().collect(Collectors
				.groupingBy(i -> i.category(), Collectors.reducing((i1, i2) -> i1.price() > i2.price() ? i1 : i2)));
		maxPriceItemByCategory.forEach((k, v) -> System.out.println(k + ": " + v.orElse(null)));

	}

}
```

A. (k,v) -> System.out.println(k+": "+v::or(null))

B. (k,v) -> System.out.println(k+": "+v.orElse(null))


C. (k,v) -> System.out.println(k+": "+v::toString)

D. (k,v) -> System.out.println(k+": "+v)

E. (k,v) -> System.out.println(k+": "+ v.toString())

#設問を説いたときの所見

11.?
   reducingの説明ができない
   (k,v)ってなんだっけ？
   orElse、orとかの説明ができない、こんなコード必要か？と思ってしまっている

   
   
#前提知識

・Stream の collect メソッドの戻り値型は？  
・reduceはストリームの要素を1個の値に畳み込む（fold する）処理
・reducing は Optional を返す点  
・Optional から値を取り出すには orElse が必要であること 
・groupingBy戻り値は何？  「Map の キーと値」
  k = Category_X  
  v = Optional<Item>   