
設問48


次のコードをコンパイルエラーを修正する方法として、正しいものを選べ（１つ）


■コード  

```
package java_clazz_function;

public class A_sat {

	public static void main(String[] args) {
		new A().new B().say();//A
	}

}
```


■コード2

```
package java_clazz_function;

public class A {
	private String msg = "hello";  //B
	class B{
		void say() {
			System.out.println(this.msg);//C
		}
	}
}
```

A. CをSystem.out.println(A.this.msg);に修正する

B. Bをprotected String msg="hello";に修正する

C. Bをpublic String msg = "hello";に修正する

D. Aをnew A.B().say();に修正する



#設問解いたときの所見

48.A
   Aのような気がするが、他の選択肢がNGの理由が見つからない

   
#設問絞るための知識


・「this」は、どのインスタンスを指すか

・「非 static の内部クラス」に関する知識
