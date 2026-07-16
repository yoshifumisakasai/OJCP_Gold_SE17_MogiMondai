設問28


ファイルへの書き込みをしたい。
「/insert code here」に入るコードとして、正しいものを選べ（１つ）


```
package File_I_O;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Sample_x {

	public static void main(String[] args) throws IOException {

	
		try(FileOutputStream fos = new FileOutputStream("sample.jpg")){
		/insert code here
		}
		
	}

}
```


選択肢：

A. fos.write("Hello");

B. fos.write("Hello".getBytes());

C. fos.output("Hello".toCharArray());

D. fos.append("Hello");

E. fos.write("Hello".chars());




#試験観点は？  
この問題は FileOutputStream が扱えるのは「バイト列だけ」という仕様を理解しているかを問う典型問題


#設問解くために、前提知識
**書けるのは「バイト」か「バイト配列」だけということ**  
`FileOutputStream が “生の 8bit データ（byte）しか書けない” という意味であり、文字列やオブジェクトなどをそのまま書けるわけではない、ということ。`  
`FileOutputStream は OS のファイルに対して “バイト単位で書き込む” ための最も低レベルの出力ストリーム。扱えるのは byte の配列（byte[]）だけ。`  
