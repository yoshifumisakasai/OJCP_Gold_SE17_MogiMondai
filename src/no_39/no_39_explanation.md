#コマンド：
`jlink -p out --add-modules moda --output runtime  --launcher main=moda/app.moda.Main`  


・何をしているのか?  
**実行専用のJava環境(runtime)を作る**

・作成されるフォルダ：
runtime/

・中身  
runtime  
 ├─bin  
 │   ├─java  
 │   └─main  
 ├─lib  
 └─・・・  
 
 
※普通のJDKではなく、「runtime/bin/java」：というJava実行ファイルが生成



・launcherとは？

**--launcher main=moda/app.moda.Main**  

「main」という名前の実行コマンドを作成するという意味  
※「runtime/bin/main」という実行ファイルが生成される  

「java -m moda/app.moda.Main」が自動で実行される  
☆「runtime/bin/main」は、"runtime/bin/java -m moda/app.moda.Main"のショートカットみたいなもの  



#実行方法は2種類  

方法①  
`./runtime/bin/main`  

(これがlauncher)  



方法②  

(launcherを使わず)  

`./runtime/bin/java -m moda/app.moda.Main`  

でも実行可



■jlink図

```
        コンパイル済みモジュール
                 │
                 ▼
             out/
                 │
        jlinkで実行環境作成
                 │
                 ▼
            runtime/
             │
      ┌──────┴──────┐
      │             │
 runtime/bin/java   runtime/bin/main
      │             │
      └──────┬──────┘
             ▼
        moda/app.moda.Main
```

#選択肢判定

A
./out/bin/app.moda.Main

×

outは、モジュールをコンパイルした場所

※Javaクラスはありますが「bin/app.moda.Main」実行ファイルはありません。




B
./runtime/bin/main
○
launcherで作った実行ファイルです。

これが正解。



C.
./runtime/bin/java app.moda.Main

×

**これはクラス名だけを書いています。モジュールアプリは「-m」が必要です。**

正しくは
java -m moda/app.moda.Main
です。



D
java runtime.Main

×

意味不明です。

runtime.Mainというクラスは存在しません。



E
./runtime/bin/java -m moda/app.moda.Main

○

これはlauncherを使わず

java -m

で直接起動しています。

正解です。



#なぜ -m が必要なのかについて？

モジュールでは「モジュール名」と「Mainクラス」両方必要です。  

書き方：
`java -m モジュール名/メインクラス`    

java -m moda/app.moda.Main  
