設問15

次のコードをコンパイル、実行したときの結果として正しいもの選べ（１つ）

```
package no_15;

public class No_15 {
	public class thread_start {

		public static void main(String[] args) throws InterruptedException {

			Thread t = new Thread(() -> {
				for (int i = 0; i < 3; i++) {
					System.out.println("a" + i);
				}
			});

			t.start();
			t.join();
			System.out.println("main");
		}

	}
}

```

A. finishが最初に表示される

B. スレッドの出力が完了した後にfinishが表示される


C. スレッドの出力が完了する前にfinishが表示される

D. コンパイルエラーになる

E. 実行時に例外がスローされる



#問題解いた時の所感(設問解き1回目）  
15.?ちんぷんかんぷん


#迷った部分(設問解き2回目）

B
※特に迷わず正答OK  


#選択肢を絞るために必要な前提知識（Java文法や仕様）

・mainスレッドとは？
**プログラム開始時に自動生成される**
*JVM が public static void main(String[] args) を呼び出すために作る。*  


・t.start()とは？  
**新しいスレッドが開始**  
**ラムダ式の Runnable が新しいスレッドで実行**  
⇒Ruunableインタフェースの抽象メソッド「void run()」を実行（上記クラスで、実装を書いているということ）

・t.join()とは？
**メインスレッドは t の終了を待機します。**  


・new Thread()のラムダ式の実装はどういう作りか、仕様か？
*Threadクラスは、Runnableインタフェース型を実装ている点を理解すること*  



#選択肢を絞るための試験観点の整理（判定ポイント）

*Thread コンストラクタに渡しているラムダ式は Runnable の run() の中身*  


`Thread t = new Thread(() -> {...})`  
◆ Runnable をラムダ式で実装している  
new Thread(() -> {...}) のラムダ式は Runnable の run() を実装した匿名クラスと同じ意味  

□内部的なクラス生成イメージ：  

```
class SyntheticRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("a" + i);
        }
    }
}
```

**Thread コンストラクタに渡されるのは、この匿名クラスのインスタンス**  
