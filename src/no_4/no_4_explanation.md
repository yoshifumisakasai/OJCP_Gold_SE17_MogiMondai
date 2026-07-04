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