#anyMatch のシグネチャ
Streamインタフェース型の抽象メソッド  
`boolean anyMatch(Predicate<? super T> predicate)`  
**※戻り値は必ず boolean**    


#インタフェースStream<T>仕様  
□型パラメータ:
T - ストリーム要素の型
すべてのスーパー・インタフェース:AutoCloseable, BaseStream<T,Stream<T>>

`public interface Stream<T> extends BaseStream<T,Stream<T>>`  
