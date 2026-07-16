#解説（コード）    

**List インタフェースのデフォルトメソッド：**
`default void sort(Comparator<? super E> c)`  
*Comparator を受け取って並び替えるメソッド*  

Comparator を受け取って並び替えるメソッド。  

✔ (a, b) -> a.compareTo(b) の意味  
ラムダ式で Comparator を作っている。  

`a.compareTo(b) が負 → a が前`  

`a.compareTo(b) が正 → b が前`  

`0 → 同値`  



**Stringクラス は Comparable<String> を実装している**  
compareTo を持っている  
Comparator のラムダ式 (a, b) の中で a.compareTo(b) を呼んでいる  
※（Comparatorインタフェース の compare メソッドの実装）  

その Comparator を sort() が使う
→ 結果として compareTo が呼ばれる




選択肢C.

**Listインタフェースに定義されているsortメソッドを使った標準的な並び替え方法**    

```
		コード1)
		list.sort((a, b) -> a.compareTo(b));
		list.forEach(e -> System.out.printf("%s", e));
```
*compareToは、自然順（昇順）で並び替えをするため、アルファベット順に並び替え*  

`インタフェースComparable<T>`  
□型パラメータ:  
T - このオブジェクトが比較されるオブジェクトの型  

/抽象メソッド   
`int compareTo(T o)`  
このオブジェクトと指定されたオブジェクトの順序を比較します。 このオブジェクトが指定されたオブジェクトより小さい場合は負の整数、等しい場合はゼロ、大きい場合は正の整数を返します。  


`Comparator のラムダ式 (a, b) の中で a.compareTo(b) を呼んでいる`  
`その Comparator を sort() が使う→ 結果として compareTo が呼ばれる`  

↓↓  

`(a, b) -> a.compareTo(b)`  
**これは Comparator の compare メソッドの実装**  

■匿名クラス  

```
new Comparator<String>() {
    @Override
    public int compare(String a, String b) {
        return a.compareTo(b);
    }
}

```

**sort()	並び替えたいが、比較方法は知らない**  
**Comparatorインタフェース	比較方法を提供する（compare メソッド）**  
**compareTo	実際の大小比較（String の辞書順）**  


#インタフェースComparator<T>  

オブジェクトのコレクションで全体順序付けを行う比較関数  


```
@FunctionalInterface
public interface Comparator<T>
```

□型パラメータ:  
T - このコンパレータにより比較されるオブジェクトの型  

□関数型インタフェース:  
これは関数型インタフェースなので、ラムダ式またはメソッド参照の代入先として使用できます。  


選択肢D.

```
		コード2)
		Collections.sort(list);;
		list.forEach(e -> System.out.printf("%s", e));
```





#Collectionクラスの「sort（）メソッド」
2種類  
（オーバーロード）  


`static <T extends Comparable<? super T>> void	sort(List<T> list)`  
指定されたリストを、その要素の自然順序付けに従って昇順にソート  

`static <T> void	sort(List<T> list, Comparator<? super T> c)	`  
指定されたコンパレータが示す順序に従って、指定されたリストをソート  
