設問9

次のコードをコンパイル、実行したときの結果として、正しいものを選べ（１つ）


□コード1

```
record Item(String name, int price){}

```



□コード2

```
import java.util.List;

public class Sample {

 public static void main(String[] args){
 
  List<Item> items = List.of(new Item("apple", 50),new Item("banana", 80),new Item("orange", 120),new Item("mango", 150),new Item("melon", 200));
  
  System.out.println(items.stream().filter(i -> i.price() <50 ).count()); 
 
 }

}


```

A. nullが表示される

B. 0が表示される

C. 実行時に例外がスローされる

D. コンパイルエラーが発生する


