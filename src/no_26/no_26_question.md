設問26


次のコードをコンパイル、実行した時の結果として正しいものを選べ（１つ）

```
package parallel_processing;

public class sa_run_start {

	public static void main(String[] args) {
		Thread a = new Thread(() -> System.out.println("A"));
		Thread b = new Thread(() -> System.out.println("B"));
		Thread c = new Thread(() -> System.out.println("C"));

		c.start();
		a.run();
		b.start();
		c.start();
	}

}
```

A. 1つのスレッドが実行される

B. 2つのスレッドが実行される

C. 3つのスレッドが実行される

D. 4つのスレッドが実行される

E. コンパイラーが発生する




#所感（設問解いたとき）  
26.BかE（コンパイルエラーにはならないから、B）
   たしか一度Startしたスレッド、再度Startさせることはできないはず

   
#設問解く上での前提知識  

・start()とrun()違いがわかっていない

#試験観点、ポイントは？  
この問題は 「start() と run() の違い」 を理解しているかを問う典型問題  


