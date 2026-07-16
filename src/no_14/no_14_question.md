設問14;  
次のコードを実行したとき、ABCDの順に表示したい。insert code hereに入るコードとして正しいものを選べ（2つ選択）  

```
import java.util.List;

public class No_14 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("C", "B", "A", "D");
		//insert code here;
		list.forEach(e -> System.out.printf("%s", e));
	}

```

A. list.stream().sorted();

B. Collections.sort(list, (a,b) -> b.compareTo(a));

C.list.sort((a,b) -> a.compareTo(b));

D.Collections.sort(list);

E.list.sort(Collections.reverseOrder());



#迷った部分，解いたときの所感

14.？
   昇順ソートするだけど、それはそうだけどA～E正しい適切なコードは分からない




#選択肢を絞るために必要な前提知識（Java文法や仕様）  

・sort（）メソッド」に２種類あること（オーバーロード）  





#選択肢を絞るための試験観点の整理（判定ポイント）  　

・ポイント１
**list.stream().sorted();**  
ソートされるが、元の list は変わらない点
sorted() は 新しい Stream を返すだけで、list 自体は変更されない点を理解していること  
→ 副作用なし  


・ポイント２
**list.sort / Collections.sort は リストを直接並び替える**
→ 副作用あり  


・ポイント３
compareTo の向きで昇順・降順が決まるという点  
a.compareTo(b) → 昇順  
b.compareTo(a) → 降順  
reverseOrder() → 降順  
