設問49


次のコードをコンパイル、実行したときの結果として正しいものを選べ（１つ）

```
package stream_api;

import java.util.List;

public class Parael_stream {
	public static void main(String[] args) {
		List<String> data = List.of("a", "b", "c", "d");
		String result = data.parallelStream().map(String::toUpperCase).findFirst().orElse("NONE");
		System.out.println(result);
	}
}
```


A. Aが出力される

B. Cが出力される

C. A,B,C,Dのいずれかが出力される

D. NONEが出力される

E. コンパイルエラーが発生する

F. 実行時に例外がスローされる



#設問説いた時の所感


49.A？
わかりません。。。。


#選択肢を絞るために必要な知識

・parallelStream() → 並列処理になるが 順序は保持される（順序付きストリーム）


・Java の Stream は「順序付きストリーム」と「順序なしストリーム」があるという知識

    List → 順序付きストリーム  

    Set → 順序なしのことが多い  

    HashSet → 順序なし  

    TreeSet → 順序あり  


・「 orElse("NONE")」文法の意味について把握しているか

⇒ストリームが空なら "NONE" を返す