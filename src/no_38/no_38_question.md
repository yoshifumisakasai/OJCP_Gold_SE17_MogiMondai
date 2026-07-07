
設問38

次のコードをコンパイル、実行した時の結果として正しいものを選べ（１つ）



```
package java_clazz_function;

import java.util.function.Predicate;

public class Predicate_t {

	public static void main(String[] args) {
		Predicate<String> k = t -> t.length() < 5;
		String s = "abcde";
		if (k.test(s)) {
			System.out.println("A");
		} else {
			System.out.println("B");
		}
	}

}

```


A. Aと表示される

B. Bと表示される

C. コンパイルエラーが発生する


D. 実行時の例外がスローされる




#設問回答時の所感について  
38.B
   5文字分あるので、5より小さいでは4以下でfalseなのでB表示の条件式に合致



#ラムダ式実装の理解観点不足