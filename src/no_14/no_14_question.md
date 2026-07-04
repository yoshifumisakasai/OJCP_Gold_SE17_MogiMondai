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



#選択肢を絞るために必要な前提知識（Java文法や仕様）



#選択肢を絞るための試験観点の整理（判定ポイント）

