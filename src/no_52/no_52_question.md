
設問52


次のコードの「insert code here」に入るコードとして正しいものを選べ（１つ）


```
package java_clazz_function;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		int c = 0;
		StringBuilder sb = new StringBuilder();
		try (FileReader reader = new FileReader("book.txt")) {
			/* insert code here*/
		}
	}
}
```



A.	while ((c = reader.read()) == 0) {
	sb.append(c);
	}
	
	
	
	
B.	while ((c = reader.read()) != -1) {
	sb.append((char) c);
	}
	
	
	
C.	while ((c = reader.read()) == -1) {
	sb.append((char[]) c);
	}
	
	
	
D.	while ((c = reader.read()) != 0) {
	sb.append((String) c);
	}
	
	
E.	while ((c = reader.read()) != -1) {
	sb.append((String) c);
	}
	
	
#設問といたきの状況、所見
52.チンプンカンプン？
	
	
	
	
#選択肢を選ぶポイント

（１）　　
**FileReader.read() の戻り値は、ファイル終端（EOF）に達したら -1を戻す**  


	
（２）
キャスト可否について判断できるか？


（３）
read() の戻り値は、読み込んだ 1文字の Unicode コードポイント（0〜65535）であること