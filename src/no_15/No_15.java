package no_15;

public class No_15 {
	public class thread_start {

		//mainスレッド
		public static void main(String[] args) throws InterruptedException {

			//mainスレッドの中で新しいThread型変数が作られ、新しいスレッドで実行する内容としてラムダ式を代入
			Thread t = new Thread(() -> {
				for (int i = 0; i < 3; i++) {
					System.out.println("a" + i);
				}
			});

			t.start();
			//あるスレッドが終了を待機するメソッド
			//対象のスレッドがすべて終わるまで待機する
			t.join();
			//スレッド「t」が完了後、以下処理実行
			System.out.println("main");
		}

	}
}
