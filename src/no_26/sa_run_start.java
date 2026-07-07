package no_26;

public class sa_run_start {

	public static void main(String[] args) {
		Thread a = new Thread(() -> System.out.println("A"));
		Thread b = new Thread(() -> System.out.println("B"));
		Thread c = new Thread(() -> System.out.println("C"));

		c.start();
		a.run();
		b.start();
		//同一のThreadインスタンスに対するstartは1回しか許容されないため、「IllegalThreadStateException」実行エラー
		//		A
		//		C
		//		B
		//		Exception in thread "main" java.lang.IllegalThreadStateException
		//			at java.base/java.lang.Thread.start(Thread.java:1525)
		//			at parallel_processing.sa_run_start.main(sa_run_start.java:14)

		c.start();
	}

}
