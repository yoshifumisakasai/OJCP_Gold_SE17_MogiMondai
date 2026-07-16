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




#設問見た時の所感（1回目）

19.？
   abcと表示されて、次abB
   自分の予想している回答がない


#設問見た時の所感（2回目）

副作用でまずa出力される
filterで「a」通さない、後続進まず

次、b、まず出力される
filterでb通す、大文字で出力
forEachで、大文字ではない小文字のb出力
↓
cが副作用で出力

なので正答はBかと


#ポイント(1回目）
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



#ポイント(2回目）
 ・「出力順序の正確な理解” がまだズレている  
 ・peek の副作用がいつ実行されるか」「filter に落ちた要素の後続 peek が実行されない」部分の整理が不足  
 
 ※再チェックポイント（１）：  
`ストリームは 1 要素ずつパイプラインを流す（ループのように）< ★「要素」単位の逐次処理 >`  
`→ つまり「a の全処理 → b の全処理 → c の全処理」という順番で進む`  



※再チェックポイント（２）：  
`filter に落ちた（条件に該当した場合）要素は後続の peek や forEach に進まない`  




※再チェックポイント（３）：
`peek()とは、 「ストリームの途中で“副作用だけ”を実行する中間操作」であり、ストリームの値を変換しない・流れに影響しない`  



※再チェックポイント（４）：  
※**副作用**とは？  
⇒外部（ストリームライン外ということ！）への影響（副作用）  


