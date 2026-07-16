
#デッドロック・スタベーション・ライブロックの違い


`🧱 ① デッドロック（Deadlock）`
✔ 状態：完全停止
✔ 原因：互いが相手のロックを待ち続ける

Thread1: A をロック → B を待つ
Thread2: B をロック → A を待つ
→ 永遠に待ち続けて進まない

例（銀行送金の典型例）
synchronized(accountA) {
    synchronized(accountB) {
        // ...
    }
}
逆順でロックするとデッドロック。




`🍙 ② スタベーション（Starvation / 飢餓）`  
✔ 状態：あるスレッドだけ永遠に実行されない
✔ 原因：リソースが偏って強いスレッドに奪われ続ける
例：優先度の高いスレッドが常に CPU を奪う

Thread1（優先度高）: CPUをずっと使う
Thread2（優先度低）: 実行の機会が永遠に来ない
→ Thread2 が 飢餓状態（starvation）になる。

他の例
synchronized の待ち行列で後ろのスレッドが永遠に入れない

ExecutorService でキューが偏って特定タスクが永遠に実行されない



`🔄 ③ ライブロック（Livelock）`  
✔ 状態：動いてはいるが進捗ゼロ（空回り）
✔ 原因：互いが譲り合い続けて前に進まない

Thread1: A をロック → B を取れない → A を解放 → 再試行
Thread2: B をロック → A を取れない → B を解放 → 再試行
→ お互いが譲り続けて永遠に進まない

例：2人が狭い廊下で譲り合って永遠に進めない
A: あ、どうぞ
B: あ、どうぞ
A: あ、どうぞ
B: あ、どうぞ
→ 動いてるけど進んでない
→ ライブロック



#設問回答へのアプローチについて  

✔ スレッド1
`Value.swap(b, a, 2000)`  
execute() 内では：

this = b
to = a

ロック順序：
`synchronized(b)`  
`synchronized(a)`  




✔ スレッド2
`Value.swap(a, b, 1500)`  
execute() 内では：

this = a
to = b

ロック順序：
`synchronized(a)`  
`synchronized(b)`  


Thread1: b をロック → a を待つ  
Thread2: a をロック → b を待つ  
**→ 互いが相手を待ち続ける → デッドロック**  



□synchronized(this)   
`this は「その execute() メソッドを呼び出した Value インスタンス」を指す`  
`送金元（from） の Value オブジェクト`  


■他の選択肢がなぜ不正解かについてのポイント  
B. スタベーション
*→ 優先度やキューの偏りが原因*  
→ このコードにはその要素がない
→ 不正解

C. ライブロック
*→ 譲り合いで進まない状態*  
*→ synchronized は譲り合いをしない*  
→ 不正解
