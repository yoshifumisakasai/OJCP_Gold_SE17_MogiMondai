設問45


SampleInterfaceインタフェースを、java.uti.functionパッケージで提供されるインタフェースに置き換えたい。
置き換え可能なインタフェースとして、正しいものを選べ（１つ）


```
@FunctionalInterface
interface SampleInterface{
  int convertInt(String str);
}
```

A. Supplier

B. BinaryOperator

C. Consumer

D. Predicate

E. Function


#設問解いたときの所見
45.わからない。Function関数型は、引数と戻り値あり
  @FunctionalInterfaceだから？関数型Interfaceなら全部つける。

  
  
#選択肢の絞り方  

・「引数あり・戻り値あり」という **Function の抽象メソッド構造と完全一致するかどうか？
・ 関数型インタフェースの抽象メソッドのシグネチャが一致するかどうか が判断基準  




※設問のサンプルコードにおける抽象メソッドのシグネチャ：

引数：String 1つ  

戻り値：int  

「String → int に変換する関数」  


** 関数型インタフェースFunction<T, R>と判断**  
