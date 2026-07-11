
#Listインタフェース型
`public interface List<E>  extends Collection<E>`  
型パラメータ:E - このリスト内に存在する要素の型  

すべてのスーパー・インタフェース:Collection<E>, Iterable<E>  

既知のすべての実装クラス:AbstractList, AbstractSequentialList, ArrayList, AttributeList,CopyOnWriteArrayList, LinkedList, RoleList, RoleUnresolvedList, Stack, Vector  



#parallelStream()メソッド
*java.util.Collection インタフェースのデフォルトメソッド*
*実際の戻り値は java.util.stream.Stream（具体的には ParallelStreamSupport が生成する並列ストリーム）*  

```
public interface Collection<E> {
    default Stream<E> parallelStream() {
        return StreamSupport.parallelStream(spliterator(), false);
    }
}

```

**□Collection型インタフェース を実装するすべてのクラスが parallelStream() を使用可能**  



#順序付きストリーム  
→ 元の順序（a→b→c→d）を保持する
→ findFirst() は必ず a を返す
→ forEach() は a→b→c→d の順で実行される（並列でも）



#順序なしストリーム  
→ 順序を保持しない
→ findFirst() は意味を持たない（どれが来てもよい）
→ forEach() の実行順序は保証されない