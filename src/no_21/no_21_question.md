
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



#🎯 試験観点：AtomicInteger が保証する「値が壊れない」とは何か？

**「値が壊れない」という表現は試験では “競合しても論理的に正しい値が得られること” を指す**  
**具体的に言うと 「複数スレッドが同時に increment しても、加算回数が欠けたり重複したりしない」 という保証**  


〇✔ 1. 加算が欠けない（lost update が起きない）  
普通の int++ は 3つの操作に分解される：

読む

足す

書く

複数スレッドが同時に実行すると：

スレッドAが読む（値10）

スレッドBが読む（値10）

スレッドAが書く（11）

スレッドBが書く（11） ← Aの更新が消える

本来 12 になるべきなのに 11 になってしまう  
これが lost update（更新の消失）＝値が壊れる。

AtomicInteger は CAS によりこれを防ぐ。



〇✔ 2. 加算が重複しない（不正な上書きが起きない）
普通の int++ は途中で割り込まれるので：

A が 10 を読み、11 を書く

B が 11 を読み、12 を書く

C が 10 を読み、11 を書く ← 古い値を使ってしまう

結果が 11 に戻ることすらある。

AtomicInteger は 古い値を使った更新を拒否する（CAS が失敗する）  
→ 重複や巻き戻りが起きない
→ 値が壊れない




〇✔ 3. 操作が不可分（atomic）である
AtomicInteger の increment は：

読む

比較する

書く

**ひとまとまりの1操作として実行する、途中で他スレッドが割り込めない**  
※これが「値が壊れない」の本質
**両スレッドが並行的に動作しても、スレッド単体での処理が保証される点**  

```
int counter = 0;

Thread t1 = new Thread(() -> {
    for (int i = 0; i < 1000; i++) {
        counter++; // ← これが壊れる
    }
});

Thread t2 = new Thread(() -> {
    for (int i = 0; i < 1000; i++) {
        counter++; // ← これが壊れる
    }
});

```


■シーケンス図  

```
t1                         AtomicInteger(counter)                         t2
 |                                 |                                       |
 |---- incrementAndGet() --------->|                                       |
 |                                 |                                       |
 |                                 |<------ incrementAndGet() -------------|
 |                                 |                                       |
 |  CAS(旧値→新値) 成功             |   CAS(旧値→新値) 成功                 |
 |                                 |                                       |
 |---- incrementAndGet() --------->|                                       |
 |                                 |<------ incrementAndGet() -------------|
 |                                 |                                       |
 |  CAS(旧値→新値) 成功             |   CAS(旧値→新値) 成功                 |
 |                                 |                                       |
 ...（1000回ずつ繰り返し）...
```
