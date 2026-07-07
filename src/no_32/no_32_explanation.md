#🌍 アプリの言語切り替え順と実際の探索結果  

① Locale.US（米国）
探索順：

messages_en_US.properties（存在しない）

messages_en.properties（存在しない）

☆
**messages.properties（ルート） ← ここでヒット**




② Locale.JAPAN（日本語）
探索順：

☆
**messages_ja.properties ← ここでヒット**  

messages.properties（ルート）




③ Locale.FRANCE（フランス語）
探索順：

messages_fr_FR.properties（存在しない）

messages_fr.properties（存在しない）

☆
**messages.properties（ルート） ← ここでヒット** 





#探索階層

**「言語＋国」＝ Locale の言語コード＋国コード（例：en_US, ja_JP）**  
**「言語」＝ Locale の言語コードだけ（例：en, ja）**  

※ResourceBundle がプロパティファイルを探すときの「階層」のことを指している  



■Locale は次の 3 つの情報を持つ：

`言語（language）：例 → en, ja, fr`    

`国（country）：例 → US, JP, FR`  

`バリアント（variant）：今回は使わない`  


■探索順
Java は次の順番で「プロパティファイル」を探す。  


`① 「言語＋国（language + country）」パターンのプロパティファイル`    
例：Locale.US → messages_en_US.properties  

言語：en  
 
国：US  
→ messages_en_US.properties  


`② 言語（language）単体パターンのプロパティファイル`    
例：Locale.US → messages_en.properties  

言語：en  
→ messages_en.properties  


`③ ルート（base name）プロパティファイル`  
例：messages.properties  