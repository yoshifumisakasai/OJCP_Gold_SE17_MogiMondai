設問25

次のコードのうち、正しいものを選べ（１つ）


A. Ruunable r = (s, t ) -> System.out.println(t.currentThread());


B. Runnable r = a -> System.out.println(Thread.currentThread());


C. Runnable r = System.out::println(Thread.currentThread());


D. Runnable r =() -> System.out.println(Thread.currentThread());


E. Runnable r = Runnable::new;




#試験観点について

`・Runnable は 「引数なし」・「戻り値なし」の関数型インタフェース`     
※ラムダ式の形は () -> { … } でなければならないこと(引数を渡していないこと）  


・コンストラクタ参照の仕様、文法についての理解
・代入先の関数型インタフェースの抽象メソッドの形と一致しないと代入できない

