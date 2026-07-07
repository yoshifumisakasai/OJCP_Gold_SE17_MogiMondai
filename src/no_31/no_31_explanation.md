# A  NG理由  


`values.stream().mapToDouble(d -> d).collect(Collectors.averagingDouble(d -> d));`  


❌ mapToDouble と averagingDouble の二重変換  
mapToDouble(d -> d) で double に変換済み  

なのに averagingDouble(d -> d) で 再度 double に変換しようとしている  

❌ collect(averagingDouble) の戻り値は Double
→ Optional ではない
→ これは平均値を返す Collector だが、mapToDouble と組み合わせる意味がない（冗長）


■🧩 averagingDouble が Optional を返さない理由  
Collectors.averagingDouble(...) の型：  

`Collector<T, ?, Double>`  
**最終結果（R）は Double**  
** Optional のような「値があるかどうかの判定」は不要**  


`collect`  
⇒Streamインタフェースのメソッドであること  
 `<R,A> R collect(Collector<? super T,A,R> collector)`  
〇型パラメータ:  
R - 結果の型  
A - Collectorの中間蓄積の型  
パラメータ:collector - リダクションを記述するCollector  

 
例）  
*.collect(Collectors.averagingDouble(d -> d));*  


**averagingDouble**  
Collectorsクラスのメソッドであること
`public static <T> Collector<T,?,Double> averagingDouble(ToDoubleFunction<? super T> mapper)`

`クラスCollectors`
`public final class Collectors extends Object`  



■Optional判定について  
`Optional 判定をする＝「値が入っているかどうか（存在するかどうか）をチェックすること」`  
**Optional の isPresent() や orElse() や orElseThrow() を使って、値があるか／ないか” を分岐する処理のこと**  




例1)値があるかどうかを判定する  

```
OptionalDouble opt = stream.average();

if (opt.isPresent()) {
    double v = opt.getAsDouble();
}

```

例2)値がなければデフォルト値を返す  
`double v = opt.orElse(0.0);`  



例3)値がなければ例外を投げる  
`double v = opt.orElseThrow();`  



# B :正解  
`mapToInt(x -> x).average().getAsDouble();`  

Stream<Integer> → IntStream

average() → OptionalDouble

getAsDouble() で取り出す

教科書通りの正解


〇注意  
**stream()には、averageメソッドはないが、mapToIntメソッドは存在していて、その戻り値型が、「IntStreamインタフェース」**  
**そのため、そのインタフェースには、「average()メソッド」あるので問題なし**  
`IntStream mapToInt(ToIntFunction<? super T> mapper)`

(その他参考）  
`DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper)`  
`LongStream mapToLong(ToLongFunction<? super T> mapper)`  


#C NG理由  
`values.stream().average();`  
**❌ Stream<Integer> に average() は存在しない**  
**average() は IntStream / LongStream / DoubleStream のメソッド**  

✔ 結論  
コンパイルエラー。


■インタフェースIntStream  
すべてのスーパー・インタフェース:AutoCloseable, BaseStream<Integer,IntStream>  
`public interface IntStream extends BaseStream<Integer,IntStream>`  

■インタフェースLongStream  
すべてのスーパー・インタフェース:AutoCloseable, BaseStream<Long,LongStream>  
`public interface LongStream　extends BaseStream<Long,LongStream>`  

■インタフェースDoubleStream  
すべてのスーパー・インタフェース:AutoCloseable, BaseStream<Double,DoubleStream>  
`public interface DoubleStream extends BaseStream<Double,DoubleStream>`  



# D NG理由  

```
values.stream()
      .collect(Collectors.averagingDouble(i -> i))
      .orElseThrow();
```
      
❌ averagingDouble の戻り値は Doubleで、Optional ではない  
かつ orElseThrow() は存在しない→ コンパイルエラー  



#✔ E NG理由  
`values.stream().map(i -> i).average().orElse();`  
❌ map(i -> i) は Stream<Integer> のまま
→ average() が存在しない（C と同じ理由）

❌ orElse() も存在しない
→ コンパイルエラー








#Streamの「collect」メソッドについて  


・オーバーロード  

① Collector を使う collect  
`<R,A> R collect(Collector<? super T,A,R> collector)`  
✔ Collector が「最終結果の型 R」を決める  
averagingDouble() の場合  → R = Double   


✔ Optional ではない理由
Collector は「空ストリームでも 0.0 を返す」仕様   
→ Optional を使う必要がない  
→ だから Double が返る  



□インタフェースCollector<T,A,R>  
`public interface Collector<T,A,R>`  

〇型パラメータ:  
T - リダクション操作の入力要素の型  
A - リダクション操作の可変蓄積の型(通常は実装詳細として隠蔽される)  
R - リダクション操作の結果の型  


② 3 つの関数を渡す collect  
`<R> R collect(Supplier<R> supplier,BiConsumer<R,? super T> accumulator,BiConsumer<R,R> combiner)`  

✔ これは「自作 Collector」  

・supplier：結果の入れ物を作る  

・accumulator：要素を入れ物に追加する  

・combiner：並列処理時に入れ物を結合する  

✔ 戻り値は R（自分で決める）
※Optional でも Double でも List でも Map でも何でも作れる。  





#補足（Optional を戻すパターン）  

**Optional を戻すパターンとは「結果が あるかもしれないし、ないかもしれない」状況で、その“値の有無”を安全に扱うために Optional を返すメソッドのこと**  
`※Java では「値が存在しない可能性がある」メソッドは 必ず Optional 系を返すように設計されている`  


〇🎯 Optional を戻す典型パターン（Java 標準 API）  

1. Stream の平均値（average）
`OptionalDouble avg = IntStream.empty().average();`  
空ストリーム → 平均値なし → OptionalDouble.empty  

値あり → OptionalDouble.of(値)



2. Stream の最小値・最大値
`OptionalInt min = IntStream.empty().min();`  
`OptionalInt max = IntStream.empty().max();`  


3. Stream の find 系

`Optional<Integer> v = values.stream().findFirst();`  
`Optional<Integer> v2 = values.stream().findAny();`  
*要素がない可能性があるため Optional*    



4. Map の get（キーが存在しない可能性）  
`Optional<String> name = Optional.ofNullable(map.get("key"));`  



5. Optional.ofNullable（null の可能性）  

`Optional<String> opt = Optional.ofNullable(maybeNullValue);`  


6. 正規表現の Matcher#find

```
Optional<String> result = pattern.matcher(text)
                                 .results()
                                 .map(MatchResult::group)
                                 .findFirst();
```

7. Optional を返す自作メソッド（null を返したくない場合）  

```
Optional<User> findUserById(int id) {
    return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst();
}

```


#🧩 Optional を返すべき状況  
**（値が「存在しない可能性」がある）**  

・空の Stream  

・Map にキーがない  

・DB にレコードがない  

・計算結果が出ない  

・null が返る可能性がある  


✔ null を返したくない（NullPointerException を避けたい）
✔ 呼び出し側に「値があるかどうか」を判定させたい