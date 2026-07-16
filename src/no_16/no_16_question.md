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




#この設問を説いたときの所感(1回目)    
16.？ちんぷんかんぶん


#この設問を説いたときの所感(2回目)

Consoleクラスには、printfしかないことを意識できていない  
println/printは、System.outにあること  


#選択肢を絞るために必要な前提知識（Java文法や仕様）

・Consoleクラスとは？
`Console = OS のコンソールと直結した I/O 専用クラス`  
**Console は java.io.Console に属するクラスで、JVM が「実行環境にコンソールが存在するか」をチェックして、存在する場合だけ Console インスタンスを返す**  

※Console は “標準入力” ではなく “OS のコンソールデバイス” に直接つながる I/O API  


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

■Console の主なメソッド  
✔ readLine()  
1 行の文字列を読み取る（Enter までブロック）  

✔ readPassword()  
入力を画面に表示せずに読み取る  

✔ printf() / format()  
**フォーマット付き出力**  
**（println は存在しない点が試験で狙われる）**  



`✔ print は存在しない`  
→ A は 存在しないメソッドなので不正解。  

`✔ println は存在しない`  
→ B と D は 存在しないメソッドなので不正解。  

`✔ printf は存在する`  
→ C と E は候補になる。  