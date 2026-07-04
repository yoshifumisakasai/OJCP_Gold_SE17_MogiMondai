
  設問：
  次のコードをコンパイル、実行したときの結果として正しいもの１つ選べ


□コード1  

```
package parallel_processing;

public class Sample {

	public static void main(String[] args) {
		Singleton a = Singleton.getInstance();
		Singleton b = Singleton.getInstance();
		
		System.out.println(a == b);
	}

}
```


□コード2  

```
package parallel_processing;

public class Singleton {
	private static volatile Singleton instance;

	private Singleton() {

	}
	public static Singleton getInstance() {

		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}

}
```




A. trueが表示される  

B. falseが表示される  

C.コンパイルエラーが発生する  

D. 実行時に例外がスローされる  



#迷った点  
6.A
  Singletonって何だっけ？
  newしていないし、同じインスタンスを返しているからtrue

#試験観点  
*試験では「なぜ true になるのか」を Java の仕様レベルで説明できるかが問われる。*  
