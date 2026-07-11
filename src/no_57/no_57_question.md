設問57

次のコードをコンパイル、実行したときの結果として正しいものを選べ（１つ）


```
package java_clazz_function;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Path_get {

	public static void main(String[] args) {
		Path a = Paths.get("/a");
		Path b = Paths.get("b/c");
		
		System.out.println(a.resolve(b));
	}
}
```


A. /a/b/cが出力される

B. b/cが出力される

C. /ab/cが出力される

D. コンパイルエラーが発生する

E. 実行時に例外がスローされる




#設問解いたときの所見

57.A
   aとbを、くっつけるだけではないのか？
   
   
   
#選択肢を限定するための知識は？
・Path.resolve の仕様  
  ⇒右側が相対パスか絶対パスかにより違いが生じる点   