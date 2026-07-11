
設問54


次のコードを実行したときに発生する例外についての説明として正しいものを選べ（１つ）

```
package no_54;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

public class Thread_t {
	public static void main(String[] args) {
		List<Integer> data = new CopyOnWriteArrayList<Integer>();
		ExecutorService s = Executors.newFixedThreadPool(2);
		CyclicBarrier b = new CyclicBarrier(3, () -> System.out.println(data));

		IntStream.rangeClosed(0, 6).parallel().forEach(n -> s.execute(() -> {
			try {
				data.add(n);
				b.await(3, TimeUnit.SECONDS);
			} catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
				System.out.println(e);
			}
		}));
	}
}

```

A. ConcurrentModificationExceptionがスローされる

B. BrokenBarrierExceptionがスローされる

C. TimeoutExceptionがスローされる

D. TimeoutExceptionとBrokenBarrierExceptionがスローされる



#設問といきたときの所見
54.わからない



#コードから最低限読み取れる情報は？

①　CyclicBarrier の待ち人数：3  


②  スレッドプール：2 スレッド  


↓↓↓
**parallel() で 7 回タスクを投げるが、実行できるのは常に2つだけ**

**3 人揃うことが絶対にない**

*各 await(3秒) は必ず タイムアウトする(TimeoutException)*  



③ バリアが壊れ、以降の await が BrokenBarrierException  
※CyclicBarrier は誰かが await で例外を出した瞬間に 壊れた状態（broken） になる  


#前提知識


・スレッドプール数の指定しているコード
`ExecutorService s = Executors.newFixedThreadPool(2);`


・Barrierアクションの[スレッド待ち数]を記述するコード
`CyclicBarrier b = new CyclicBarrier(3, () -> System.out.println(data));`  


・「barrierAction」の仕様をある程度理解していること
⇒**スレッドの待ち合わせ処理をする仕組み**  

