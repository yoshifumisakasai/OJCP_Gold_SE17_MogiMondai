設問33
次のコードをコンパイル、実行したときの結果として正しいものを選べ（１つ）


```
package java_clazz_function;

import java.util.ArrayList;
import java.util.List;

public class List_add {

	public static void main(String[] args) {
		List list_x = new ArrayList<Integer>();

		list_x.add(Integer.valueOf(1));
		list_x.add(Integer.valueOf(2));
		list_x.add(Integer.valueOf(3));
		
		list_x.forEach(n -> System.out.println(n.x()));
	}

}
```


A. 1,2,3の順に表示される

B. 実行時に、NoSuchMethodExceptionがスローされる

C. 実行時にClassCastExceptionがスローされる

D. コンパイルエラーが発生する




#説いた時の所感
33.D
   ジェネリクス型未指定なのでエラー
   
   
#試験観点
ただし「ジェネリクス型未指定だから」だけでは説明として不十分で、
本質的な理由は ラムダ式の型推論が raw 型によって Object になり、Object に x() が存在しないため です。



#覚えて億ポイントについて  

📌 コンパイルエラーの理由（公式な説明）  
**raw 型 List を使うと、ジェネリクス情報が消える**  

**forEach のラムダ式の型推論は Object になる**  

**Object に x() メソッドは存在しない**  
※元々Object型に規定されているメソッド以外は存在しない  

