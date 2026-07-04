設問22


次のコードをコンパイル、実行したときの結果として正しいものを選べ（１つ）


```

package stream_api;

import java.util.stream.IntStream;

public class IntStream_x {

	public static void main(String[] args) {
		IntStream values = IntStream.range(1, 5);
		var p = values.allMatch(v -> v > 0);
		var n = values.noneMatch(v -> v < 0);
		System.out.println(p + ":" + n);
	}

}
```


A. true:true

B. true:false

C. false:true

D. false:false

E. コンパイルエラーが発生する

F. 実行時に例外がスローされる



#迷ったポイント  

22.B
   1～5の範囲、0より大きいものはすべてマッチでtrue
   1～5の範囲、0より小さいものはないのでfalse




#観点
 *IntStream は「消費されたら再利用できない」ため、2 回目の allMatch / noneMatch 呼び出しで IllegalStateException が発生する。*  

ここで迷ったのは、まさに Java Gold SE17 が狙っているところで、
**「ストリームは一度使ったら再利用できない」という本質部分。**  
