**A.間違い**  
Test の抽象メソッドは：
String toString(Item employee);
`つまりラムダの引数は Item でなければならない。`  
`→ String を受け取るラムダでは、型が一致しないのでコンパイルエラー`  

**B.間違い**  
間違い理由：出力が問題文と一致しない
e.toString() は record のデフォルト toString なので：
Item[name=Apple, price=100]となる。
問題文の要求は：Apple is 100 yen.
→ 出力が違うので不正解。

C.間違い
`間違い理由：record に getter は存在しない`  
record のコンポーネントは：
String name
int price
`getter は getName() / getPrice() によるアクセサメソッド方式：NG`  
`getter/setter式で書いているが、こうは書けない」と判断`  
name()  
price()  
`C は JavaBeans の getter を呼んでいるので コンパイルエラー。`  
`「getter式で書いているが、こうは書けない」と判断してください`  

**Dについて**  
`record のフィールドは 暗黙に final で private`  
`コンポーネント名（name, price）で直接アクセスできる(アクセサ：public)`  

Test インタフェース:
String toString(Item employee);
ラムダは Item → String の関数であればよい
str -> str.name + "is" + str.price + "yen."
Item のフィールドに直接アクセスして文字列を返している
仕様的にOK


**Eについて**  
`record のフィールドは：暗黙に private final`  
`コンポーネント名で accessor が生成される`  
`同名のフィールドにも直接アクセスできる(アクセサ：public)`  
str.name → OK
str.price → OK


#JavaのRecordの内部仕様について  

`record Item(String name, int price) {}`  


↓
展開  
↓

```
final class Item {

    private final String name;
    private final int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String name() {
        return name;
    }

    public int price() {
        return price;
    }
}

```
**JavaBeans：**  

employee.getName();  
employee.getPrice();  


**record**  

employee.name();  
employee.price();  

`⇒Record仕様では、getterのようなアクセサが自動生成されます。`  
name  

というコンポーネント名と  

name()  

というアクセサ名が同じなので混乱しやすい  


#選択肢DとEの違い  


  D. Test t = str -> str.name+"is"+str.price+"yen.";    
  
  E. Test t =(Item e)->{return e.name()+"is"+e.price()+"yen.";};  
  
  
・選択肢D:直接フィールド（コンポーネント名）アクセス：NG  
フィールド name	private final（外部アクセス不可）  
フィールド price	private final（外部アクセス不可）  

・選択肢E:アクセサメソッド：OK    
name()	publicアクセサ  
price()	publicアクセサ  

`recordのコンポーネントは外部から直接アクセスできません。アクセスする場合は必ずアクセサメソッドを呼び出します`  
