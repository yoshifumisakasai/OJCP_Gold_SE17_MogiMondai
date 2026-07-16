設問13

次のインタフェースを利用したコードについて、正しいものを1つ選べ。  

```
public interface Sample{

    int test(int a, int b);
}

```

A. Sample s = a+ b;

B. Sample s = (int a, b) -> { return a + b };

C. Sample s = (int a, int b) -> a + b;

D. var s = (a, b ) -> a+ b;

E. Sample s = (a, b) -> { a + b};




#選択肢を絞るための前提知識

・ブロック { ... } を使う場合は return が必須  


・var は ローカル変数の型推論では、ターゲット型（左辺の型）が必要  


・パラメータの型指定は 両方書くか、両方書かないか のどちらか  