設問34

次のコードをコンパイル、実行した時の結果として正しいものを選べ（１つ）


```
package parallel_processing;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class Publisher_Main {
	public static void main(String[] args) throws InterruptedException {

		SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();

		publisher.subscribe(new Flow.Subscriber<>() {
			private Flow.Subscription subscription;

			
			@Override
			public void onSubscribe(Flow.Subscription subscription) {
				this.subscription = subscription;
				subscription.request(0);
				
			}

			@Override
			public void onNext(Integer item) {
				System.out.println("Received:"+item);
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("Error:"+t);
			}

			@Override
			public void onComplete() {
				System.out.println("Done");
			}

		});
		
		publisher.submit(1);
		publisher.close();
		
		Thread.sleep(500);
	}
}
```



A. Received:1
   Done
   
B. Done


C. 実行時にIlleagalArgumentExceptionがスローされる

D. 何も表示されない




#設問見た時の所感

34.D
   publisher側は1でSubmitしているが、受けてのsubscribeのrequestが0で、受付禁止なので


#設問のポイント

onSubscribe で subscription.request(0) を呼んでいるため、
Subscriber が 1 件も要求しない（＝需要ゼロ）ので、Publisher は onNext を送らない からです。



#設問回答へ概要把握のための前提知識  
*■Publisher：データを発行する*  
*■Subscriber はデータを受け取る*  
*■Subscription は Publisher と Subscriber の橋渡し*  
*→ request(n) で「何件欲しいか」を指定する（バックプレッシャー）*  

〇順番  
`①データほしい側がrequestする（何件欲しい）`    
↓  
`②データを発行してもらう`  
