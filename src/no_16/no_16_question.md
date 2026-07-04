設問16


次のコードの「insert code here」に入るものとして、正しいものを1つ選べ

```
package no_16;

import java.io.Console;

public class No_16 {
	public static void main(String[] args) {
		Console console = System.console();
		var value = console.readLine();
		//insert code here
	}
}
```









A. console.print("value = " + value);

B. console.println("value = " + value);

C. console.printf("value = %s", value);

D. console.println("value = %s", value);

E. console.printf("value = %d", value);




#この設問を説いたときの所感（設問見たとき、解いたときの知識レベル、試験観点の把握レベルは？）    
16.？ちんぷんかんぶん


#選択肢を絞るために必要な前提知識（Java文法や仕様）

・Consoleクラスとは？


・System.console()とは？


・console.readLine()とは？


・print, println, printfの違いについて把握していない
 **print / println / printf の違いは「改行の有無」と「フォーマット指定の可否」 **
 

・「%s」、「%d」とは？
**「%s」は文字列を埋め込むためのフォーマット指定子**      
**「%d」は整数を埋め込むためのフォーマット指定子**  

・printfのフォーマット、書式の理解  



#選択肢を絞るための試験観点の整理（判定ポイント）  

「Console クラス」で使える出力メソッド（Console には以下のメソッドがある：）  

`✔ print は存在しない`  
→ A は 存在しないメソッドなので不正解。  

`✔ println は存在しない`  
→ B と D は 存在しないメソッドなので不正解。  

`✔ printf は存在する`  
→ C と E は候補になる。  