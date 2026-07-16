#設問4  

必要に応じてスレッドを生成するスレッドプールを生成するには、選択肢のどのコードを使うべきか（１つ選べ）  
  
  A.ExecutorService service = Executors.newThreadPool();  
  
  B.ExecutorService service = Executors.newWorkStealingPool();  
  
  C.ExecutorService service = Executors.newSingleThreadExecutor();  
  
  D.ExecutorService service = Executors.newFixedThreadPool(3);  
   
  E.ExecutorService service = Executors.newCachedThreadPool();  

  
  
#判断に迷った部分(設問解き1回目）
4.E（かＡ）迷って回答できなかった  
  キャッシュからプール生成  
  newSingleは１つだけなのでNg  
  newFixed(3)は、3つ固定で変動できないからNG  
  newThreadPoolも正しいように見える、  

  
  
#判断に迷った部分(設問解き2回目）
newWorkStealingPoolって何だっけ？

あと、Executorsって何？、ExecutorServiceって何、クラスだっけ？