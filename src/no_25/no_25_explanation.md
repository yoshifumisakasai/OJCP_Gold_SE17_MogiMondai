#Ruunableインタフェースについて  
唯一の抽象メソッド run() を持ち、Thread に渡すことで別スレッドで処理を実行できます。

```

@FunctionalInterface
public interface Runnable
```

※Runnable は Supplier型、Consumer 型でも Function 型でも Predicate 型でもない。Runnable は「独立したカテゴリの関数型インタフェース」  
（Consumer型に近い）  

#🧩 Runnable の本質（最重要ポイント）  
Runnable =「結果を返さない処理(run)を表すオブジェクト」  

**抽象メソッドは void run() の 1 つだけ**  

**Thread に渡すと、run() が別スレッドで実行される**  

`Thread を継承せずに並行処理を実現できる（設計が柔軟になる）`    

関数型インタフェースなので ラムダ式で書ける  








#🧠 Runnable の公式仕様（Java SE）  
✔ 役割  
「アクティブな間にコードを実行したいオブジェクトの共通プロトコル」  

**Thread クラス自身も Runnable を実装している**   

**Runnable を実装したクラスは Thread に渡すことで、Thread を継承せずに動作できる**  

✔ 抽象メソッド  
`void run();`  
run() は「どんな処理でもよい」と仕様に書かれている  




#🧪 Runnable の基本的な使い方（Thread と組み合わせ）

```
class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread is running");
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(new MyTask());
        t.start();  // 別スレッドで run() が実行される
    }
}
```



#🧩 Runnable は関数型インタフェース → ラムダ式が使える  
`Runnable r = () -> System.out.println("Thread running using lambda");`  
`new Thread(r).start();`  

**ラムダ式は「run() の中身だけを提供する関数オブジェクト」を生成するため、Runnable を実装した“インスタンス”を作るが、クラスを作るわけではない  という点が重要。**  





#正誤判定


A.  
`Ruunable r = (s, t ) -> ...`  
Runnable は 引数なしなので (s, t) もアウト  
→ 不正解  



B.  
`Runnable r = a -> ...`  
Runnable は 引数なし  

a -> ... は 引数1つのラムダ式  
→ 不正解  



C.   
`Runnable r = System.out::println(Thread.currentThread());`  
（不正解の理由）  
*メソッド参照の書き方が完全に誤り*
*System.out::println は 引数1つを受け取る Consumer 的な形*  
*println(Thread.currentThread()) をその場で呼び出しているだけで、Runnable にならない*  
→ 不正解



D.
`Runnable r = () -> System.out.println(Thread.currentThread());`  

Runnable の形に完全一致  
引数なし → ()  
戻り値なし → void run() に対応  
正しい Runnable のラムダ式  
→ 正解  


E. 
`Runnable r = Runnable::new;`  
Runnable は インタフェース  
（不正解の理由）  
**Runnable::new はコンストラクタ参照だが、Runnable にコンストラクタは存在しない**  
→ 不正解

Runnable の抽象メソッド：  
`void run();`  
✔ 引数なし  
✔ 戻り値なし  
コンストラクタ参照 X::new は 必ず「X のインスタンスを返す」   
つまり戻り値が X 型になる。  
*Runnable の抽象メソッドは 戻り値 void*  

**❌ 戻り値が一致しない**  
**❌ Runnable はインタフェースなのでコンストラクタが存在しない**  
よって：
`Runnable r = Runnable::new;`  
⇒言語仕様上不可能  



〇Java Silver試験レベル：  
`Java のインタフェースにはコンストラクタは存在しない`  
`Java のインタフェースはインスタンス化できないため、初期化処理の必要がない`  



#Java のメソッド参照には 4 種類ある：

〇静的メソッド参照  
ClassName::staticMethod  

〇インスタンスメソッド参照  
instance::method  

〇任意オブジェクトのインスタンスメソッド参照  
ClassName::method  

〇コンストラクタ参照（constructor reference）  
ClassName::new ←  
`クラスのコンストラクタを関数オブジェクトとして扱うための記法`

`Supplier<List<String>> s = ArrayList::new;`

↑  
同じ  
↓  
`Supplier<List<String>> s = () -> new ArrayList<>();`  



#補足1
コンストラクタ参照は 関数型インタフェースの抽象メソッドのシグネチャと一致する必要がある。

例：  
Supplier<T> の抽象メソッド  
`T get();`    
() -> T  

これに一致するコンストラクタは：
`new ArrayList<>();` 
() -> ArrayList   
そのため、 ArrayList::new が Supplier に代入可能となる  
→ 引数の数・型が一致   
→ 戻り値の型も一致（T = ArrayList）  



#補足2
Runnable の場合はどうなる？  
**Runnable の抽象メソッド：**  
`void run();`
形は：
引数：0  
戻り値：void  

↑  
  
↓  

✔ コンストラクタ参照は必ず「インスタンスを返す」  
Runnable::new の形：

`() -> new Runnable()`  
**しかし Runnable はインタフェースなのでコンストラクタがない。**  
仮にクラスだったとしても：

戻り値：Runnable のインスタンス  
(runnableインタフェース型の)抽象メソッドの戻り値：void  

❌ 戻り値が一致しない
❌ Runnable はコンストラクタを持たない