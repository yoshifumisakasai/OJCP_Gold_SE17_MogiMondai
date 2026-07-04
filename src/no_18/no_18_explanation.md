#複数List型のまとめかた:  

複数の List を「ひとつの流れ」にまとめる方法は大きく 2 系統あり、試験ではこの違いを理解しているかを問われる。  

■方法1：List.of で “List<List<T>>” にまとめる  
`List<List<Integer>> lists = List.of(a, b);`  
その後 stream → flatMap で平坦化する。  


■方法2：Stream.of で “Stream<List<T>>” を作る  
`Stream<List<Integer>> stream = Stream.of(a, b);`  
その後 flatMap で平坦化する。  




#flatMap の正しい使い方  
**Stream#flatMapメソッドで、複数のリストの要素をすべて取り出し、1つのストリームに並べなおす**


① flatMapの文法  
〇「flatMap」で最終的に Stream<T> にする  
`Stream<Integer> s = Stream.of(a, b).flatMap(List::stream);`  
`Stream<Integer> s = List.of(a, b).stream().flatMap(List::stream);`  


② flatMap の役割  
List<List<T>> → Stream<T>  
Stream<List<T>> → Stream<T>  



#Streamインタフェースの「flatMap()メソッド」仕様
**インタフェースStream<T>**  
型パラメータ:  
T - ストリーム要素の型  
すべてのスーパー・インタフェース:AutoCloseable, BaseStream<T,Stream<T>>

`public interface Stream<T> extends BaseStream<T,Stream<T>>`  




□メソッド  
`<R> Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper)`   
R - 新しいストリームの要素の型  
パラメータ:  
mapper - 新しい値のストリームを生成するために各要素に適用する、非干渉でステートレスな関数  
戻り値:新しいストリーム  


＞ラムダ式
`stream.flatMap(x -> x.stream())`  


＞メソッド参照  
`stream.flatMap(List::stream)`  

**flatMap の引数 Function<? super T, ? extends Stream<? extends R>> は「Function インターフェース」に該当**   
**他の候補（Consumer / Predicate / Supplier / BiFunction / UnaryOperator）はすべて不適合**  


※関数型インタフェース（参考）  
Functionインターフェース

**Function<T, R>**は、1つの引数を受け取り、結果を返す関数を表します。

```
import java.util.function.Function;
Function<Integer, String> intToString = num -> "Number: " + num;
System.out.println(intToString.apply(5)); // 出力: Number: 5
```


Consumerインターフェース

**Consumer**は、1つの引数を受け取り、結果を返さない操作を表します。

```
import java.util.function.Consumer;
Consumer<String> greet = name -> System.out.println("Hello, " + name + "!");
greet.accept("Alice"); // 出力: Hello, Alice!
```



Predicateインターフェース

**Predicate**は、1つの引数を受け取り、trueまたはfalseを返す述語を表します。

```
import java.util.function.Predicate;
Predicate<String> isNameAlice = name -> name.equals("Alice");
System.out.println(isNameAlice.test("Alice")); // 出力: true
```



Supplierインターフェース

**Supplier**は、引数を受け取らず、結果を供給する操作を表します。

```
import java.util.function.Supplier;
Supplier<String> provideName = () -> "Alice";
System.out.println(provideName.get()); // 出力: Alice
```



BiFunctionインターフェース

**BiFunction<T, U, R>**は、2つの引数を受け取り、結果を返す関数を表します。

```
import java.util.function.BiFunction;
BiFunction<Integer, Integer, String> sumToString = (a, b) -> "Sum: " + (a + b);
System.out.println(sumToString.apply(3, 4)); // 出力: Sum: 7

```


UnaryOperatorインターフェース

**UnaryOperator**は、1つの引数を受け取り、同じ型の結果を返す操作を表します。

```
import java.util.function.UnaryOperator;
UnaryOperator<String> toUpperCase = str -> str.toUpperCase();
System.out.println(toUpperCase.apply("Alice")); // 出力: ALICE
```
