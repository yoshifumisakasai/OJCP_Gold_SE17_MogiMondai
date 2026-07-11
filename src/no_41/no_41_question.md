設問41


次のコードをコンパイル、実行したときの結果として正しいものを選べ（１つ）


```
package no_41;

import java.util.ArrayList;
import java.util.List;

public class No_41 {
	record Item (String name, int price);
	
	public static void main(String[] args) {
		List<Item> items = List.of(
				new Item("apple",100),
				new Item("banana",80),
				new Item("orange",120)
				);
		List<String> names = new ArrayList<String>();
		for(Item item:items) {
			names.add(item.name());
		}
		
		names.replaceAll(n->n.toUpperCase());
		System.out.println(names);
	}
}

```

A. [name=APPLE, name=BANANA, name=ORANGE]が表示される

B. [APPLE, BANANA,ORANGE]が表示される

C. [apple, banana,orange]が表示される

D. [name=apple, name=banana, name=orange]が表示される

E. コンパイルエラーが発生する






#設問の所見  
41.AヵB
   大文字にするのだからそうなのだけど、どう出力されれるか想像できない




#観点（事前知識）

(１）
`List<String> names = new ArrayList<String>();`  
※names に入れているのは Item ではなく String（name）

(２）
**replaceAll()メソッド仕様**  
・戻り値型、
・List インタフェースの “default メソッド


(３）
*UnaryOperator<String> についての理解不足*  
Function<String, String> の特化版で、
「入力と出力の型が同じ」場合に使うための関数型インタフェース**  
