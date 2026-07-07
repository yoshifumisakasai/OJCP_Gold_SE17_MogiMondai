# 他の選択肢が間違いな理由  
A. implements api.impl.SampleImpl;  
モジュール宣言に implements は存在しない  
Java の文法として不正


B. opens api.impl.SampleImpl to api.Sample;  
**opens はリフレクション用のアクセス許可**  

（サービス提供とは無関係  ）  



C. services api.imple.SampleImpl for api.Sample
そもそも構文が存在しない
services というキーワードは JPMS にない



E. uses api.Sample;
**これは サービス利用側（consumer）が書くもの**

今回は「実装を提供する側」なので不正