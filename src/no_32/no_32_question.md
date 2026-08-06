設問32：


通販サイトのスタートアップメッセージは、ベース名がmessagesのリソースバンドルからキー「hello」で取得します。
実行前にデフォルトロケールは「米国（Locale.US）」に設定しています。
用意されているプロパティファイルは、次の通りです。


・messages.properties(ルート)には、「hello=Hello, Java!」が定義

・messages_ja.propertiesには、「hello=こんにちは、Java!」が定義

・それ以外のプロパティファイルは存在しない


アプリは、次の順で言語を切り替え、メッセージを取得して標準出力に1行ずつ表示します。

・米国（US）
・日本語（ja）
・フランス語（fr）



このアプリを実行したときの結果として、正しいものを選べ（１つ）

A. Hello, Java!
   こんにちは、Java!
   Hello, Java!
   
B. Hello, Java!
   こんにちは、Java!
   Bonjour, Java!
   
C. Hello, Java!
   Hello, Java!
   Hello, Java!
   
D. こんにちは、Java!
   Hello, Java!
   Hello, Java!
   
E. 実行時に例外がスローされる



#設問見た時の所感について
32.?
何のことか全く分からない状態

   

#設問絞るための前提知識

(1)
**ResourceBundle のフォールバック仕様**  

(2)
ResourceBundle の探索順（プロパティファイルの検索の順序）についての理解：  

**1.[言語 + 国]形式のプロパティファイル → 2.[言語]単体形式のプロパティファイル → 3.ルート（messages.properties）**  
