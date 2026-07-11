設問39

モジュールmodaを実行するためのカスタムランタイムイメージを次のコマンドで作成しました。
このモジュール・アプリケーションを実行するコマンドはどれですか？
（2つ選択）




コマンド：
jlink -p out --add-modules moda --output runtime
--launcher main=moda/app.moda.Main


A. ./out/bin/app.moda.Main

B. ./runtimme/bin/main

C. ./runtime/bin/java app.moda.Main

D. java runtime.Main

E. ./runtime/bin/java -m moda/app.moda.Main


#設問の所見
39.?
チンプンカンプン、どういうことか？というレベルで選択肢絞れない、そもそも選択肢それぞれのコマンドの意味もわかっていない

#試験の前提知識
jlinkとカスタムランタイムイメージを理解しているかを問う問題

（１）コマンドを読み取る
・コマンドの意味
**実行専用のJava環境(runtime)を作る**

・**jlink の -p オプション**  
「モジュールパス（module path）を指定するオプション」    
どこからモジュールを探すかを jlink に教えるためのもの。  


・**--add-modulesオプション**  
 「カスタムランタイムに含めるモジュールを指定するオプション」 
 ※今回のコマンドのケース：   
   jlink に対して、このモジュール（moda）と、その依存モジュールを全部集めてランタイムを作るよう指示する  


・**--outputオプション**  
「jlink が作るカスタムランタイムイメージの出力先ディレクトリを指定するオプション」    
 ここに “専用の JRE” を作るように jlink に命令するためのもの。  



・**--launcherオプションとは？**  
 「runtime/bin に “専用の起動コマンド” を作るオプション」   
jlink に対して、この名前（main）でアプリを起動できるコマンドを作るように指示  
そのコマンドが実行するモジュールとメインクラスはこれ（moda/app.moda.Main）と伝えているもの  


（２）選択肢判定



#試験解くポイント
Java Gold試験で覚えるポイント

1.jlink --output runtime で runtime フォルダが作成される。


2.--launcher main=moda/app.moda.Main を指定すると、runtime/bin/main という起動コマンドが作成される。


3.モジュールアプリは java -m モジュール名/メインクラス で起動する。



#試験対策のコツ

Java Goldでは、jlink コマンドのオプションをすべて暗記する必要はありません。頻出なのは次の対応だけです。

オプション	覚えること
--output runtime	runtime ディレクトリが作成される
--launcher 名前=モジュール/メインクラス	runtime/bin/名前 の起動コマンドが作られる
java -m モジュール/メインクラス	モジュールアプリの基本的な起動方法