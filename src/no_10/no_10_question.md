設問10

次のコードをコンパイル、実行したときの結果として正しいものを選べ（１つ）


```
package java_clazz_function;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.io.IOException;

public class Sample {

	public static void main(String[] args) thorws IOException {
		Path a = Paths.get("source.txt");
		Path b = Paths.get("target.txt");
		
		Files.copy(a, b,StandardCopyOption.REPLACE_EXISTING);
	}
}
```


A. target.txtが存在しない場合にのみ、コピーができる

B. target.txtが存在する場合は、元のファイル名が変更される

C. target.txtが存在する場合は、元のファイルがそのまま保持される

D. target.txtが存在する場合は、ファイルが上書きされる

E. コンパイルエラーが発生する
