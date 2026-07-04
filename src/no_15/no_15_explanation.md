#mainスレッド  
**Java の mainスレッド とは、Java プログラムを起動したときに 最初に自動的に作られる実行スレッド のことです。**  
**Java 仮想マシン（JVM）は、main メソッドを呼び出すために 1 本の 非デーモン・スレッド を作成し、それを mainスレッド と呼びます**  


■1. mainスレッドの特徴  
**プログラム開始時に自動生成される**
*JVM が public static void main(String[] args) を呼び出すために作る。*  
**名前は "main"**
Thread.currentThread().getName() で確認できる。  

〇非デーモン・スレッド  
他の非デーモン・スレッドが残っている限り JVM は終了しない。  
優先度は通常 Thread.NORM_PRIORITY (5)  
`mainスレッドから他のスレッドを起動できる`    
`new Thread(...).start() で並行処理を開始できる。`  

■2. mainスレッドの動作イメージ  

JVM起動  
   ↓  
mainスレッド作成（名前 "main"）  
   ↓  
mainメソッド実行  
   ↓  
必要に応じて他のスレッドを生成・開始  
   ↓  
mainメソッド終了後も、他の非デーモン・スレッドが動いていればJVMは継続  



#クラスThread  
java.lang.Object  
java.lang.Thread  
**すべての実装されたインタフェース:Runnable**  

**直系の既知のサブクラス:ForkJoinWorkerThread**  

`public class Thread extends Object implements Runnable`  
スレッドとは、プログラム内での実行スレッドのことです。  
Java仮想マシンでは、アプリケーションは並列に実行される複数のスレッドを使用することができます。  



#t.start
`新しい OS スレッドを作り、そのスレッドで Runnable の run() を実行させる命令。`  
`Java の Thread は「OS のスレッドをラップしたオブジェクト」なので、t.start() を呼ぶと JVM が OS に対して「新しいスレッドを作ってくれ」と依頼する。`  


**void run()**
オブジェクトが実装するインタフェースRunnableを使ってスレッドを作成し、そのスレッドを開始すると、独立して実行されるスレッド内で、オブジェクトのrunメソッドが呼び出されます。  
*(新しいスレッドを作成して、この Thread に紐づく Runnable の run() を実行)*  


■Thread オブジェクトの生成  
**t.startしない限り、スレッドはまだ存在しない**  
**ただの「Thread を表すオブジェクト」ができただけの状態であることに注意すること**

〇Runnableインタフェース型の実装を代入  
`Thread t = new Thread(runnable);`  

↑
  
↓  

```
	Thread t = new Thread(() -> {
				for (int i = 0; i < 3; i++) {
					System.out.println("a" + i);
				}
			});
```

#Runnable は「抽象メソッドが1つだけ」の関数型インタフェース  

〇抽象メソッドは run() 1つだけ  
→ 関数型インタフェース  
→ ラムダ式で実装できる  

```
@FunctionalInterface
public interface Runnable {
    void run();
}
```


□匿名クラス（以下のようなコード）とほぼ同じものが生成  

```
class SomeSyntheticClass implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("a" + i);
        }
    }
}

```
※new Thread() に渡されるのは、この匿名クラスのインスタンス  
 