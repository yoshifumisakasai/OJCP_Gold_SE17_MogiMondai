設問51

次のコードの「insert code here」に入るコードとして正しいものを選べ（１つ）



```
package java_clazz_function;

public class Func_inter {

	public static void main(String[] args) {
		Test t = (a, b) -> a + b;
		//insert code here
		System.out.println(result);
	}

}

@FunctionalInterface
interface Test {
	int execute(int a, int b);
}
```

A. int result = t.execute(2,3);


B. int result = t(2,3);


C.int result = t.execute(2,3,a+b);


D. int result = Test.execute(a,b);


E int result = Test.execute(2,3);


#設問解いたときの所見

51.Aのような気がする
   でも他のものがダメが理由が見つからない




#選択肢絞るための基本知識

・本インタフェース：「BinaryOperator<T>	T apply(T a, T b)」と同じ形式であること  
・「インスタンスメソッド（static修飾なし）は型名で呼び出せない」 というのは、まさに Java Silver（SE11/SE8）レベルの基本事項。