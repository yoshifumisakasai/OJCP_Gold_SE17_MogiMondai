package no_27;

public class Value {
	//フィールド
	private int amount;

	//コンストラクタ
	public Value(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return this.amount;
	}

	//	スレッドが同時に実行しても 金額が壊れないように synchronized でロックしている
	//execute() は synchronized を使って送金処理を排他制御しているが、スレッド1とスレッド2で、ロック順序が逆なのでデッドロックの危険がある
	private void execute(Value to, int amount) {
		//呼び出し元のクラス全体をロック（this（送金元）をロック）
		// 呼び出し元の Value をロック
		synchronized (this) {

			synchronized (to) {
				//相手側のValueインスタンスをロック（ to（送金先）をロック）
				//相手側の Value をロック
				if (amount > this.amount) {
					throw new IllegalArgumentException();
				}
				to.amount += amount;
				this.amount -= amount;
			}
		}
	}

	//swap()（静的メソッド）
	//execute() は「from → to に amount を移動する処理」
	public static void swap(Value from, Value to, int amount) {
		from.execute(to, amount);
	}
}
