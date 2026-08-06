設問12

次のコードをコンパイル、実行したときの結果として正しいものを1つ選べ

```
package stream_api;

import java.util.stream.Stream;

public class X_12 {
	public static void main(String[] args) {
		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5).filter(i -> {
			System.out.println("A");
			return i % 2 == 0;
		});
		System.out.println("B");
		stream.forEach(System.out::println);
	}
}
```

A. AAAAAB24の順に表示される

B. BAAAAA24の順に表示される

C. ABA2AA4Aの順に表示される

D. BAA2AA4Aの順に表示される

E. コンパイルエラーが発生する

F. 実行時に例外がスローされる



#試験で迷ったポイント  
12.1,2,3,4,5をそれぞれ2で割って余り0なのは、2と4なので、Aが2回でると思うのだが、それが選択肢にない



#知識

□考え方のポイント1
**System.out.println("A"); は「filter 条件の外」ではなく、filter の“条件式の一部として必ず実行される処理”です。**  
**ただし、戻り値（true/false）には関係しない副作用の処理です。**  
**各要素の値自体は、filter の Predicate<T> の test判定で、 true の要素だけを次のステージに渡され、forEachで結果出力される**  
`  

□考え方のポイント2 
*「Streamラインの外にあるもの」は、普通の処理される点*    
**ストリーム定義ラインの構築の外にあるもの（1回だけ処理される）**    
`System.out.println("B");`  
