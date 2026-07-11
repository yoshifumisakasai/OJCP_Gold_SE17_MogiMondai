#インタフェース

□BinaryOperator の抽象メソッド：
`T apply(T a, T b);`  


□Test の抽象メソッド（今回の設問のインタフェース）：  
`int execute(int a, int b);`
構造が完全一致



#選択肢判定

・まず正解：A が正しい理由
`Test t = (a, b) -> a + b;`  
int result = t.execute(2,3);  
(a, b) -> a + b は Test インタフェースの抽象メソッド execute(int,int) を実装したインスタンス  




・❌ C. int result = t.execute(2,3,a+b);  
理由：execute の引数は 2 個なのに 3 個渡している  
Test インタフェース：
`int execute(int a, int b);`  
引数は2個  
3個渡すと当然コンパイルエラー  



❌ D. int result = Test.execute(a,b);
理由：execute は「インスタンスメソッド」であり static ではない

Test インタフェースのメソッド：
`int execute(int a, int b);`  
*これは インスタンスメソッド*    
**static メソッドではないので、Test.execute(...) のように型名で呼び出すことはできない。**  

→ コンパイルエラー。



❌ E. int result = Test.execute(2,3);
理由：D と同じ。
`static メソッドではないTest インタフェースは 関数型インタフェースであり、抽象メソッド execute は インスタンスに対して呼び出すもの。`
※型名で呼び出すことはできない  
