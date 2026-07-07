#実行時の流れ  

1. Publisher 作成
`SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();`  

2. Subscriber 登録
`publisher.subscribe(new Flow.Subscriber<>()`  



3. onSubscribe が呼ばれる
`subscription.request(0);`  
ここが 致命的ポイント。

**Reactive Streams（Flow API）は「要求された数だけデータを送る」という 背圧（Backpressure）モデル**  

*request(0) → 1件も要求していない*
*Publisher は 1件も送ってはいけない*


4. submit(1) を呼ぶ  
`publisher.submit(1);`  
**Publisher は内部キューに入れるが、Subscriber が要求していないので onNext を呼ばない**  


5. close() を呼ぶ  
publisher.close();
**Publisher が完了通知を送るが、onComplete も「要求がない場合は送られない」仕様**  



#Flow API の仕様（重要）  
onNext は request(n) が呼ばれた分だけ送られる

onComplete は demand が 0 の場合は呼ばれないことがある

つまりこのコードは 何も出力しない。