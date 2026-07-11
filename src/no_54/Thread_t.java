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
		//Java の java.util.concurrent パッケージにある スレッドセーフな List の実装。
		List<Integer> data = new CopyOnWriteArrayList<Integer>();
		// 「2つのスレッドを使うスレッドプールを作成している
		ExecutorService s = Executors.newFixedThreadPool(2);
		//3つのスレッドが await() に到達するまで待つ
		CyclicBarrier b = new CyclicBarrier(3, () -> System.out.println(data));

		IntStream.rangeClosed(0, 6).parallel().forEach(n -> s.execute(() -> {
			try {
				data.add(n);
				//wait()は3秒
				b.await(3, TimeUnit.SECONDS);
			} catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
				System.out.println(e);
			}
		}));
	}
}
