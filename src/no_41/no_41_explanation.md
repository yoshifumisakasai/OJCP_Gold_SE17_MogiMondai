#replaceAll の動作


**インタフェースList<E>**  
型パラメータ:  
E - このリスト内に存在する要素の型  

□すべてのスーパー・インタフェース:  
Collection<E>, Iterable<E>, SequencedCollection<E>  


□既知のすべての実装クラス:  
AbstractList, AbstractSequentialList, ArrayList, AttributeList, CopyOnWriteArrayList, LinkedList, RoleList, RoleUnresolvedList, Stack, Vector

`public interface List<E> extends SequencedCollection<E>`  


*replaceAll()メソッド仕様**  
`default void replaceAll(UnaryOperator<E> operator)`  
List インタフェースの “default メソッド  
`※default メソッド（実装を持つ）`  
`※抽象メソッド（実装を持たない）`  


*default が付いている*  
*インタフェース内に実装が書かれている*  
*抽象メソッドではない（abstract が付かない）*  

（□経緯）  
 既存の List 実装クラス（ArrayList, LinkedList）を全部修正するのは非現実的  
・インタフェース側に実装を持たせる  
・既存のクラスはそのままでも新機能が使える  


・戻り値型  
`replaceAll は UnaryOperator<String> を受け取り、リストの各要素を置換するだけ`


`names.replaceAll(n -> n.toUpperCase());`  







#List インタフェースの default メソッド内部仕様  

**ループ処理は List が持っている**  
**要素をどう変換するかは operator.apply(...) に委譲している**  


```
default void replaceAll(UnaryOperator<E> operator) {
    Objects.requireNonNull(operator);
    final ListIterator<E> li = this.listIterator();
    while (li.hasNext()) {
        li.set(operator.apply(li.next()));
    }
}
```

replaceAll は List が持つ処理の枠組み（default メソッド）であり、ラムダ式は その枠組みに渡す「変換ロジック」だけを表現する。実装があるのにラムダを書くという構造になる  




#インタフェースUnaryOperator<String>  
**UnaryOperator<String> は「String を受け取って String を返す“1引数の自己変換関数”」**    
**Function<String, String> の特化版で、「入力と出力の型が同じ」場合に使うための関数型インタフェース**  


□定義  

```
@FunctionalInterface
public interface UnaryOperator<T> extends Function<T, T> {
    static <T> UnaryOperator<T> identity() {
        return t -> t;
    }
}
```

●整理

------------  

UnaryOperator<T> = Function<T, T> の別名（特化型）  
Function<T, T> を継承しており、引数も戻り値も同じ型 Tで、「自己変換」を表す関数型インタフェース

------------  