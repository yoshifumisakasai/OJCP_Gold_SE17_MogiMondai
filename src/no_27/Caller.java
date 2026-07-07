package no_27;

public class Caller {
	public static void main(String[] args) {
		//Value は「金額を持つオブジェクト」
		Value a = new Value(3000);
		Value b = new Value(7000);

		//Caller では 2つのスレッドが同時に送金を行う
		//Thread のコンストラクタに直接ラムダ式を渡す： 
		
		//【スレッド1】b → a に 2000 移動
		new Thread(() -> Value.swap(b, a, 2000)).start();

		//【スレッド2】a → b に 1500 移動
		new Thread(() -> Value.swap(a, b, 1500)).start();
		//		スレッドは並行に動くので、どちらが先に実行されるか分からない。
		//		スレッド1 は b をロック → a をロック
		//		スレッド2 は a をロック → b をロック
		//		この順番が逆なので、本来は デッドロックが起きる危険がある。
		
		System.out.println("a:" + a.getAmount());
		System.out.println("b:" + b.getAmount());
		//スレッド終了を待っていない（join していない）ため、送金前の値が表示されることもある。
		//Caller はスレッド終了を待っていないので結果が不定
	}

}
