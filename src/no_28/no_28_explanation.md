#🎯 FileOutputStream の write() が受け取れる型
□FileOutputStream の write メソッドは以下の 3 種類：

```
void write(int b)
void write(byte[] b)
void write(byte[] b, int off, int len)
```

**書けるのは「バイト」か「バイト配列」だけということ**  
`FileOutputStream が “生の 8bit データ（byte）しか書けない” という意味であり、文字列やオブジェクトなどをそのまま書けるわけではない、ということ。`  
`FileOutputStream は OS のファイルに対して “バイト単位で書き込む” ための最も低レベルの出力ストリーム。扱えるのは byte の配列（byte[]）だけ。`  


#クラスFileOutputStream  
すべての実装されたインタフェース:Closeable、Flushable、AutoCloseable  

`public class FileOutputStream extends OutputStream`    
 
 
 
 
#🧩 各選択肢の正誤判定  

A.   
`fos.write("Hello");`  
"Hello" は String  

**write(int) にも write(byte[]) にも一致しない**  
→ コンパイルエラー  
→ 不正解  


B.   
`fos.write("Hello".getBytes());`  
"Hello".getBytes() は byte[]  
**write(byte[]) に完全一致**  
→ 正しい    
→ 正解  



C.   
`fos.output("Hello".toCharArray());`    
*FileOutputStream に output() メソッドは存在しない*    
→ コンパイルエラー  
→ 不正解  

D.   
`fos.append("Hello");`    
*FileOutputStream に append() メソッドは存在しない*    
→ コンパイルエラー   
→ 不正解  

E.   
`fos.write("Hello".chars());`  
"Hello".chars() は IntStream  

*write() は IntStream を受け取れない*  
→ コンパイルエラー  
→ 不正解


#参考  
□🧩 なぜ「バイト列だけ」なのかについて（Java の I/O の階層構造）  
Java の I/O は階層構造：  

```
OutputStream（抽象クラス）
   └── FileOutputStream（ファイルへバイトを書き込む）
```

`public class FileOutputStream extends OutputStream`  

`public abstract class OutputStream extends Object implements Closeable, Flushable`  


*OutputStream が提供する write メソッドはすべて「byte（8bit）」を扱うもの*  

*FileOutputStream はこの OutputStream を継承しているので、FileOutputStream が扱えるのは byte（または byte[]）だけという仕様になる。*  

```
public abstract class OutputStream {
    public abstract void write(int b);
    public void write(byte[] b);
    public void write(byte[] b, int off, int len);
}

```

