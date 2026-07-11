#🧩 なぜ List.of は add できないのか？（内部仕様レベルで解説）

List.of(...) が返すリストは java.util.ImmutableCollections.ListN
**Java 9 以降、List.of は 不変コレクション（ImmutableCollections） を返す**



内部的には：
「java.util.ImmutableCollections$ListN」というクラスのインスタンスになる  



`ImmutableCollections$ListN は Java 9 以降で導入されたjava.util.ImmutableCollections の内部クラスのひとつで、List.of(...) などで作られる 固定長・変更不可の List 実装 です`


※このクラスは add / remove / set などの変更操作をすべて UnsupportedOperationException をスローする  



#🧩 実際の add の中身（内部コードイメージ）

ImmutableCollections.ListN の add はこういう実装になっている：

```
public void add(int index, E element) {
    throw new UnsupportedOperationException();
}
```


*コンパイルは通るが、実行時に必ず例外が出る*  


#🎯 なぜコンパイルは通るのに例外が出るのか？  
理由は List.of が返す型は「List」という仕様のためです  

Java の型システムでは：  
`List<String> list = List.of(...);`  
この list は List インタフェースとして扱われる。  

List インタフェースには add があるので コンパイルは通る。  


**しかし実体は ImmutableCollections.ListN なので 実行時に例外**  
