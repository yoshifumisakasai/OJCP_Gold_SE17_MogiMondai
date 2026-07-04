#シリアライズ（Serialization）とは？  
**オブジェクトをバイト列（データ）に変換すること**  
※「Javaオブジェクト → ファイルやネットワークで送れるデータ」に変換する処理  

```
Personオブジェクト
    ↓ シリアライズ
-----------------------
010101001011010...
-----------------------
（バイト列）
```

□Javaオブジェクト  
`Person p = new Person("田中", 30);`

↓  
□ファイル  
`person.dat`  
というファイルへ保存  


●Javaコード（シリアライズ処理）  

```
ObjectOutputStream out =
    new ObjectOutputStream(
        new FileOutputStream("person.dat"));

out.writeObject(p);
```



#デシリアライズ（Deserialization）とは？  
**バイト列から元のオブジェクトへ戻すこと**  
※「ファイルのデータ → Javaオブジェクト」へ復元する処理  


```
-----------------------
010101001011010...
-----------------------
      ↓ デシリアライズ

Personオブジェクト
```

●Javaコード例（デシリアライズ処理）  

```

ObjectInputStream in =
    new ObjectInputStream(
        new FileInputStream("person.dat"));

Person p = (Person) in.readObject();
```


#全体流れの把握  

```
① オブジェクト作成  

Person p = new Person(...);  

        │  
        │  
        ▼  

② シリアライズ  

writeObject()  

        │  
        ▼  

person.dat（ファイル）  

        │  
        ▼  

③ デシリアライズ  

readObject()  

        │  
        ▼  

Personオブジェクト復元  

```

#試験観点  
■① ObjectInputStream.readObject() の戻り値は Object  

※JavaDoc仕様  
`public final Object readObject()`  

**戻り値は Object**  
**キャストが必要**  


■② Employee の readObject() は「private で void」  
**「readObject の戻り値が void である」という仕様**  

・in.readObject() が Employee を返すわけではない  

・Employee の private readObject() は 内部フィールドの復元処理をするだけ  

・Employee emp = in.readObject(); はコンパイルエラー。  


〇正しい復元方法は「Object を読み込んで Employee にキャスト」  
`Employee emp = (Employee) in.readObject();`  



**〇インタフェースSerializableについて**  
`public interface Serializable`  
クラスの直列化可能性は、java.io.Serializableインタフェースを実装するクラスによって有効になります。  


・直列化と直列化復元の際に特殊な扱いが必要なクラスでは、正確に次のようなシグネチャを持つ特殊なメソッドを実装する必要があります。  

 `private void writeObject(java.io.ObjectOutputStream out) throws IOException`  
 
 `private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException;`  
 
 `private void readObjectNoData() throws ObjectStreamException;`  
 
■writeObjectメソッド  
writeObjectメソッドは、その特定のクラスのオブジェクトの状態を書き込んで、対応するreadObjectメソッドがオブジェクトの状態を復元できるようにする役割を担います。 out.defaultWriteObjectを呼び出せば、オブジェクトのフィールドを保存するためのデフォルトのメカニズムを呼び出すことができます。  


■readObjectメソッド  
readObjectメソッドは、ストリームからの読み込みとクラス・フィールドの復元を行う役割を担います。 このメソッドは、in.defaultReadObjectメソッドを呼び出して、オブジェクトの非staticフィールドおよび非transientフィールドを復元するためのデフォルトのメカニズムを呼び出すことができます。   


#Serializableインタフェース仕様（間違いやすいポイント）  
**「Serializable インタフェース側の readObject/writeObject を呼んでいる」わけではありません。**  
**Serializable は メソッドを一切持たない marker interface（印だけのインタフェース）**

Employeeクラス：  
`private void writeObject(ObjectOutputStream out)`  
`private void readObject(ObjectInputStream in)`  

・Serializable が要求する“特別な名前のメソッド"  
・ObjectOutputStream / ObjectInputStream が「リフレクション」で自動的に呼び出す だけのもの  

`※JVM（正確には ObjectOutputStream / ObjectInputStream）がクラス内に “特別な名前の private メソッド” があるかを探す`  


#リフレクションについて  
**「リフレクションで自動的に呼び出す」とは、Java が “メソッド名だけを手がかりにして、private であっても強制的に呼び出す仕組み」 のこと**  
ObjectOutputStream / ObjectInputStream が内部で行う特別処理  

🎯 一言でまとめると
*Java のシリアライズは、クラスに “特別な名前の private メソッド” があると、リフレクションを使って強制的に呼び出す。*  
つまり、開発者のコードが呼ぶのではなく、JVM が勝手に呼ぶ。  

〇🔍 リフレクションとは何か（本質）  
リフレクションは Java の仕組みのひとつで、  
プログラムが実行中にクラスの構造（メソッド・フィールド）を調べたり、呼び出したりできる機能。  

*普通なら private メソッドは外部から呼べないが、リフレクションを使うと アクセス修飾子を無視して呼び出せる。*  
