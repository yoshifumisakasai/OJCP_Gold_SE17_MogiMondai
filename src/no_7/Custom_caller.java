package no_7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Custom_caller {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		//シリアライズ実行
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("emp.ser"));
		//		コンストラクタ仕様書
		//		ObjectOutputStream()
		//		ObjectOutputStream(OutputStream out)	

		// 【確認ポイント】
		//	ObjectOutputStreamクラスのコンストラクタには、OutputStreamクラスを引数に取ります。
		//	しかし、コードでは、FileOutputStreamクラスのオブジェクトをセットしている。
		//	コンパイルエラーにはならない、問題ないですか？

		//  ↓（技術的回答）
		//Java の継承ルールとして“正しい書き方”  
		//FileOutputStream が OutputStream を継承しているため、OutputStream 型の引数に渡せる
		//FileOutputStream は OutputStream のサブクラスなので、OutputStream を受け取るコンストラクタに渡せる

		//OutputStream（親[基底]クラス）
		//   ↑
		//FileOutputStream（子[派生]クラス）

		try (out) {
			Employee emp = new Employee("sample", "0312345689");
			//[writeObjectメソッド]：シリアライズ時に自動的に呼び出されるメソッド
			out.writeObject(emp);
		}

		//デシリアライズ実行
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("emp.ser"));
		try (in) {
			//[readObjectメソッド]：デシリアライズ時に自動的に呼び出されるメソッド
			Employee emp = (Employee) in.readObject();
			System.out.println(emp);
		}

	}

}
