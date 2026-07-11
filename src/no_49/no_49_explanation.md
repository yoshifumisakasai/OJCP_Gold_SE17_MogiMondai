
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
