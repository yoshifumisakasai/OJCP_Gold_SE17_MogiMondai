#補足 TreeSet は “自然順序（natural order）” で並ぶ  

**java.util.TreeSet は内部的に Red-Black Tree（赤黒木） を使っていて、要素を挿入するたびに compareTo() の結果 に基づいて並び替える。**  

↓↓↓
`String → Comparable<String> を実装している`  

**compareTo() によって辞書順（昇順）で並ぶ**

※重複は無視される（Set の性質）




#compareTo() メソッド
“Comparable インタフェース”の持ち物。
実際に compareTo を実装しているのは Comparable を実装した各クラス（String、Integer、LocalDate など）


**compareTo() は Comparable<T> インタフェースの抽象メソッド**  

```

public interface Comparable<T> {
    int compareTo(T o);
}
```


**Comparable が持っているメソッドを、実装クラスが override して使う**  




# compareTo() を持っている “クラス” は？
*Comparable を実装しているクラスは compareTo() を持つ。*  

代表例：

String

Integer

Long

Double

Character

BigDecimal

LocalDate

LocalDateTime

Enum（すべての列挙型）

これらはすべて Comparable を実装しているので compareTo() を持つ。



例：String の compareTo()

```
public final class String implements Comparable<String> {
    public int compareTo(String anotherString) { ... }
}
```