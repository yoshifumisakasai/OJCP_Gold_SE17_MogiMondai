設問19


次のコードをコンパイル、実行したときの結果として正しいものを選べ（１つ）


```
package stream_api;

import java.util.List;

public class Sample_stream {

	public static void main(String[] args) {
		var values = List.of("a", "b", "c");
		values.stream().peek(v -> System.out.println(v)).filter(v -> v.contains("b"))
				.peek(v -> System.out.println(v.toUpperCase())).forEach(System.out::println);
		;
	}

}
```

A. abbBcが表示される

B. abBbcが表示される

C. aAbBbcCが表示される

D. abBcbが表示される

E. aAbBcCが表示される




#設問見た時の所感

19.？
   abcと表示されて、次abB
   自分の予想している回答がない

   
#ポイント
🧭 出題者の意図（試験観点）
この問題は以下を理解しているかを試す。

① peek は中間操作（副作用を観察するだけ）
**→ 終端操作（forEach）が呼ばれるまで実行されない。**  


**② Stream は「1 要素ずつ」流れる（ループのように）** vv
`→ map や filter のように「全体を処理してから次へ」ではない。`  


`peek(v -> System.out.println(v))`
を見た瞬間に、リストのa,b,cが出力されると勘違いしていまう点


③ filter を通過した要素だけが後続の peek に到達する
→ “b” だけが 2 回目の peek に到達する。

④ forEach は終端操作であり、ここで初めてストリームが流れ始める
→ peek の出力順序は forEach の実行順序と一致する。 