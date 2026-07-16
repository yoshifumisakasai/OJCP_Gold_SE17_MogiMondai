#クラスExecutors  

〇本クラスに実装されているメソッド一覧:  

・シングルスレッド  
`public static ExecutorService newSingleThreadExecutor()`  
`public static ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory)`  

・キャッシュ処理スレッド(空きスレッド再利用/新スレッド動的作成)    
`public static ExecutorService newCachedThreadPool()`  
`public static ExecutorService newCachedThreadPool(ThreadFactory threadFactory)`  

・固定数スレッド  
`public static ExecutorService newFixedThreadPool(int nThreads)`  
`public static ExecutorService newFixedThreadPool(int nThreads, ThreadFactory threadFactory)`  

・CPUコア数で固定スレッド  
`public static ExecutorService newWorkStealingPool()`  
`public static ExecutorService newWorkStealingPool(int parallelism)`  


*すべての使用可能なプロセッサをターゲット並列性レベルとして使用して、work-stealingスレッド・プールを作成します。*  
※CPUプロセッサのこと  


**戻り値型：ExecutorServiceインタフェース型**  


#インタフェースExecutorService  
`public interface ExecutorService extends Executor`  

<仕様>  
すべてのスーパー・インタフェース:  
Executor  
既知のすべてのサブインタフェース:  
ScheduledExecutorService  
既知のすべての実装クラス:  
AbstractExecutorService、ForkJoinPool、ScheduledThreadPoolExecutor、ThreadPoolExecutor  


A.間違いの理由：  
A. newThreadPool()  
**❌ 存在しないメソッド**      
Java にこのメソッドはないので即 NG。  


B.間違い  
B. newWorkStealingPool()  
❌ ForkJoinPool ベース  
`スレッド数は CPUコア数で固定`  
`必要に応じてスレッドを増やす仕組みではない`  
「ワークスティーリング（仕事の奪い合い）」が目的の特殊プール  


C.間違い  
C. newSingleThreadExecutor()
`❌ 常に 1 スレッド`  

`必要に応じて増えない`  

**1 本のスレッドで順番に処理するだけ**  


D.間違い  
D. newFixedThreadPool(3)  
❌ スレッド数は常に 3  

**必要に応じて増えない**  

タスクが増えるとキューに溜まるだけ  




E.正しい選択肢：   
E. newCachedThreadPool()  
⭕ 必要に応じてスレッドを増やす唯一の選択肢  

内部動作：  
タスクが来る  
**→ 空きスレッドがあれば使う**  
**→ なければ 新しいスレッドを生成する**  

スレッドは 60 秒間アイドルなら破棄

スレッド数は 0〜無限に伸び縮み


#クラスExecutorsと、ExecutorServiceインタフェースの関係性について  
**Executors と ExecutorService の関係は「実装関係」ではなく「インスタンス生成のためのユーティリティ関係」**  


**Executors はユーティリティクラス（工場＝Factory）**  

**Executors は ExecutorService を実装したクラスのインスタンスを返すだけ**    



Executors 自身は ExecutorService を 実装していない  

ExecutorService はインタフェース（契約）  


```
ExecutorService (インタフェース)  
        ↑  
        │ implements  
ThreadPoolExecutor / ScheduledThreadPoolExecutor など  ※実装クラス（実体）   
        ↑  
        │ インスタンスを作る  
Executors（ユーティリティクラス）  
```

■例：固定スレッドプールを作る場合  

`ExecutorService service = Executors.newFixedThreadPool(3);`  
内部処理の動き:　　
*Executors.newFixedThreadPool(3) がThreadPoolExecutorのインスタンスをnewして返している*  
*Executors はただの static メソッド集*  







#設計について（Java の設計思想）

**1. 実装クラスを隠すため**  
*ユーザは ThreadPoolExecutorを直接newする必要がない*  

`new ThreadPoolExecutor(...)  // パラメータが多くて複雑`  
*これを隠して、簡単な API を提供するために Executors がある*  




**2. 柔軟な実装差し替えのため**
ExecutorService 型（インタフェース型）で受けておけば、

```
ExecutorService s = Executors.newCachedThreadPool();
ExecutorService s = Executors.newSingleThreadExecutor();
ExecutorService s = Executors.newScheduledThreadPool(2);
```
どの実装でも同じように扱える。

⇒左辺のインタフェース型に、実装クラス型を代入可能（Java仕様）  
※両者間に、実装関係があることが条件  
