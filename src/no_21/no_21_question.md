
設問21
次のコードをコンパイル、実行したときの結果として正しいものを１つ選べ 

```
package parallel_processing;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
	public static void main(String[] args) {
		AtomicInteger counter = new AtomicInteger(0);
		
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				counter.incrementAndGet();
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				counter.incrementAndGet();
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.err.println("スレッドが割り込まれました: " + e.getMessage());
		}

		System.out.println("最終カウント: " + counter.get());
	}
}
```


A. 10が表示される

B. 20が表示される

C. 毎回異なる結果が表示される

D. コンパイルエラーが発生する

E. 実行時に例外がスローされる







#解いたときの所感、迷ったところ   
21.AかBかわからない




#試験観点としては？  
AtomicInteger の“原子的操作”が何を保証しているかがまだ曖昧
*→ 複数スレッドが同時に実行しても値が壊れない*  


間違い:  
❌ C. 毎回異なる結果
**→ AtomicInteger を使っているので 必ず同じ結果**  


③ join() により 両スレッドの終了を待ってから get() を呼ぶ
→ 中途半端な値にならない  



#観点２  
③ join() により 両スレッドの終了を待ってから get() を呼ぶ処理がなくても、AtomicIntegerなら、毎回異なる結果にならず、必ず２０ですか？

↓↓  
`結論から言うと いいえ。join() を外した場合、AtomicInteger でも “必ず 20（正しくは 2000）” にはなりません。  AtomicInteger は 値が壊れない（原子的） ことを保証しますが、「すべての加算が終わるまで待つ」ことは保証しません。`  

ここが AtomicInteger の保証範囲と join() の役割の違いで、
試験でもよく問われるポイント。

