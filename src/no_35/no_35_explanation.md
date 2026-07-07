#recordは、toString()を生成するとは？

`「コンパイラが自動で中身を文字列化するメソッドを作る`  
*record は 自動で toString() を生成*

※出力フォーマットは 「RecordName[field=value, field=value]」 で固定  


■（Item@xxxx の形式）について  
この形式は Object のデフォルト toString()。
クラス名@ハッシュコード
**record は Object の toString() を使わず、コンパイラが自動生成した toString() を使う**  



〇元コード
`record Item(String name, int price) {}`  


↓↓↓  
〇内部で生成されるコードイメージ：  
**toString() を開発者が書いていないが、コンパイラが自動生成**  


```
public final class Item {
    private final String name;
    private final int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String name() { return name; }
    public int price() { return price; }

    @Override
    public String toString() {
        return "Item[name=" + name + ", price=" + price + "]";
    }

    @Override
    public boolean equals(Object o) { ... }

    @Override
    public int hashCode() { ... }
}

```