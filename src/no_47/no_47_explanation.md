#なぜコンパイルエラーになるのか  

1. `var data = new ArrayList<Long>();`  
**data の型は ArrayList<Long> に確定**  
※以下と同じ状態  
`ArrayList<Long> data = new ArrayList<>();`vv



2. ArrayList<Long> の add メソッドは Long しか受け取れない  

```
boolean add(Long e);
void add(int index, Long e);
```

3. 
**data.add(1); の 1 は int → Integer にボクシングされる**  
**1 は int、オートボクシングすると Integer**   
しかし add(Long) が要求するのは Long   
Integer と Long は互換性なし（兄弟クラス）  

*→ Long に変換できないためコンパイルエラー*  



#AutoBoxingルールについて  

`Java のオートボクシングは “型一致するラッパー型にしか変換しない” というルールがある`  
※int → Long には変換してくれない   


#重要観点（Java仕様）  

`Java が勝手に int → Integer に変換するのは「コレクションがプリミティブ型を扱えない」という歴史的仕様のためで、Java 言語仕様に明確にそう書かれている`  

`Java は List や Map にプリミティブ型を入れられないため、プリミティブを渡すと自動でラッパークラスに変換する（オートボクシング）。`  
