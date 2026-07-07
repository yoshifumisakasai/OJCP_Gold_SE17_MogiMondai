設問27

次のコードをコンパイル、実行したときの結果として正しいものを選べ（）１つ）


□スレッド処理側  

```
package no_27;

public class Value {
	private int amount;

	public Value(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return this.amount;
	}

	private void execute(Value to, int amount) {
		synchronized (this) {

			synchronized (to) {
				if (amount > this.amount) {
					throw new IllegalArgumentException();
				}
				to.amount += amount;
				this.amount -= amount;
			}
		}
	}

	public static void swap(Value from, Value to, int amount) {
		from.execute(to, amount);
	}
}
```



□呼び出し側  

```

package no_27;

public class Caller {
	public static void main(String[] args) {
		Value a = new Value(3000);
		Value b = new Value(7000);

		
		new Thread(() -> Value.swap(b, a, 2000)).start();

		new Thread(() -> Value.swap(a, b, 1500)).start();
	
		System.out.println("a:" + a.getAmount());
		System.out.println("b:" + b.getAmount());
	}

}
```


A. デッドロックの可能性がある

B. スタベーションの可能性がある

C. ライブブロックの可能性がある

D. コンパイルエラーが発生する

E. 実行時に例外がスローされる



#初見で説いたときの理解度は？

27.A＿？



#設問解く上での前提知識

「デッドロック」

「スタベーション」

「ライブブロック」
の意味が分かっていない


