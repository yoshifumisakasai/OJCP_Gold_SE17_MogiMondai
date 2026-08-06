設問8


次のプログラムをコンパイル、実行したときの結果として、正しいものを選べ（１つ）


```
import java.util.ArrayList;

public class Sample {

 public static void main(String[] args){
 
  var list = new ArrayList<String>();
  
  list.add("A");
  list.add("B");
  list.add("C");
 
 list.set(3,null);
 for(String str : list){
 
  System.out.print(str);
 }
 }




}


```


A. 3番目の要素の後ろに要素nullが挿入される

B. 3番目の要素がnullに置き換わる


C. NullPointerExceptionがスローされる

D. IndexOutOfBoundsExceptionがスローされる

E. コンパイルエラーが発生する

