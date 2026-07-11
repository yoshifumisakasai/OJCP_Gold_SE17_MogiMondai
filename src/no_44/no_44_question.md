
設問44

次のコードをコンパイル、実行したときの結果として正しいものを選べ（１つ）

```
package java_clazz_function;

import java.util.List;

public class Immutalbe_list {

	public static void main(String[] args) {
		List<String> list = List.of("A", "B", "C");
		list.add(2, "D");
		list.stream().forEach(s -> System.out.println(s));
	}

}
```


A. A,B,Cが出力される

B. A,B,Dが出力される

C. コンパイルエラーが発生する

D. 実行時に例外がスローされる



#所見

選択肢は「B選んだ

しかし、正答は、Dのようでした


#観点  

正解は D（実行時に例外がスローされる）  
**理由は List.of(...) が返すリストは「完全不変（immutable）」であり、add が禁止されているため。**  

#前提知識は？
「List.of の仕様」を知っているかどうかを問う典型的な Java Gold の問題  


〇ポイント整理  
1. List.of / Set.of / Map.of は 不変コレクション  
2. 不変コレクションは 変更操作がすべて UnsupportedOperationException  
3. コンパイルは通るが、実行時例外になる  
4. Java 9 以降の新しいコレクション API の仕様理解  


#List.of()メソッド仕様  


例）

---------------------------------------------

`static <E> List<E>	of​()`	  
ゼロ要素を含む不変のリストを返します。  

`static <E> List<E>	of​(E e1)`  	
1つの要素を含む不変のリストを返します。  
---------------------------------------------


□今回の例  
`static <E> List<E>	of​(E... elements)`	  
任意の数の要素を含む不変のリストを返す。  

@SafeVarargs
static <E> List<E> of​(E... elements)

型パラメータ:E - List要素型  
パラメータ:elements - リストに含まれる要素  
戻り値:指定された要素を含むList  