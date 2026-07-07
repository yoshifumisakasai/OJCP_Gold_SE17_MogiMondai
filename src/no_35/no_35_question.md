設問35

次のコードをコンパイル、実行したときの正しいものを選べ（１つ）


・コード1  

```
record Item(String name, int price) {}
```



・コード2

```
public class Sample{

 public static void main(String[] args){
  Item item = new Item("apple",100);
  System.out.println(item);

 }
}
```

A. appleが表示される

B. Item[name=apple, price=100]が表示される

C. Item@3cb456baのような文字列が表示される

D. コンパイルエラーが発生する


#設問解いたときの状況
35.BかC
   どっちだったけ？
   ⇒１つに絞れなかった
   
   
   

#正答へのポイント整理（以下の知識不足）※選択肢を１つに絞れなかった原因は？  

①record は 自動で toString() を生成する  
フォーマットは 「RecordName[field=value, field=value]」 で固定 


②形式は Object のデフォルト toString()  
**クラス名@ハッシュコード**  



※Java Gold では record の自動生成メソッド（equals, hashCode, toString）が頻出  
