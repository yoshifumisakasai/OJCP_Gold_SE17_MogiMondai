#設問3  

次のコードをコンパイル、実行したときの結果として正しいものを選びなさい。（1つ選べ）

□コード1

```
package stream_api;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream_compare {

	public static void main(String[] args) {
		List<Products> products = List.of(
				new Products("A", "X"),
				new Products("B", "X"),
				new Products("C", "Y"),
				new Products("D", "Y"),
				new Products("E", "Z"),
				new Products("F", "Z"));
		products.stream().collect(Collectors.groupingBy(Products::category,
		Collectors.mapping(Products::name,
		Collectors.joining(" "))))
		.forEach(k,v)->System.out.println(k+":"+v));
	}

}
```




□コード2
`record Products(String name, String category) {}`  




A.次のように出力される
X:A B
Y:C D
Z:E F

B.次のように出力される
X:[A,B]
Y:[C,D]
Z:[E,F]

C.次のように出力される
X
Y
Z

D.次のように出力される
X:A X:B
Y:C Y:D
Z:E Z:F


E.実行時に例外がスローされる


#判断に迷った部分  
  ストリームは、Categoryで分ける  
  Xのストリーム   
  Yのストリーム  
  Zのストリーム  
  mappingの説明ができない  
