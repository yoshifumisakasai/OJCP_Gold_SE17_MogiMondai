#実行時エラー  

```
Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:229)
	at java.base/java.util.stream.IntPipeline.noneMatch(IntPipeline.java:547)
	at stream_api.IntStream_x.main(IntStream_x.java:10)

```

🧭 出題者の意図（試験観点）  
この問題は以下を理解しているかを試す：  

**① Stream は「一度消費したら再利用できない」**  
allMatch は 終端操作（terminal operation）  
終端操作を呼ぶとストリームは 閉じられる（consumed）  

*そのストリームに対して 再度操作すると例外*  




#allMatchメソッドについて  
`boolean allMatch(Predicate<? super T> predicate)`  

□APIのノート:
このメソッドは、ストリームの要素に対する述語の全称量化(すべてのxについてP(x))を評価します。 ストリームが空の場合、量化は無意味に満たされると言い、(P(x)とは無関係に)常にtrueになります。  

□パラメータ:  
predicate - ストリームの要素に適用する非干渉でステートレスな述語  

□戻り値:  
ストリームのすべての要素が指定された述語に一致するかストリームが空の場合はtrue、それ以外の場合はfalse




#noneMatchメソッドについて  
`boolean noneMatch(Predicate<? super T> predicate)`  

※「none」は、１つも無いという英語  

**noneMatch は「ストリームの全要素が条件に一致しないことを確認する終端操作」**  
**Predicate.test が 1 回も true を返さなければ true を返すメソッド**  
`ストリームの要素に対して predicate.test(v) を順に評価し、1つでも true が出たら即座に false を返し、最後まで true が出なければ true を返す`  



□APIのノート:  
このメソッドは、ストリームの要素に対する述語の否定の全称量化(すべてのxについて~P(x))を評価します。 ストリームが空の場合、量化は無意味に満たされると言い、P(x)とは無関係に常にtrueになります。  

□パラメータ:  
predicate - ストリームの要素に適用する非干渉でステートレスな述語  

□戻り値:  
ストリームのどの要素も指定された述語に一致しないかストリームが空の場合はtrue、それ以外の場合はfalse  


〇理解ポイント  
**「Predicate の抽象メソッド boolean test(T t) を、ラムダ式が実装する」仕組み**  
**ラムダ式は Predicate の test を実装した“関数オブジェクト” **  

〇匿名クラス  
Javaが自動で「匿名クラス」を生成しているだけです。  

```
new Predicate<Integer>() {
    @Override
    public boolean test(Integer v) {
        return v < 0;
    }
}

```

#🧩 Predicate の Java仕様  
□抽象メソッドは test(T t) ただ 1 つ  

```
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}

```