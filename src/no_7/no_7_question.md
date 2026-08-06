設問7
次のコードの「/insert code here」に入るコードとして正しいものを１つ選べ

□コード1:

```
import java.io.Serializable;

record Item(String name, int price) implements Serializable{}

```


□コード2:  

```
package File_I_O;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Custom_caller {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("emp.ser"));
		try (out) {
			Employee emp = new Employee("sample", "0312345689");
			out.writeObject(emp);
		}

		ObjectInputStream in = new ObjectInputStream(new FileInputStream("emp.ser"));
		try (in) {
			Employee emp = //Insert Code here
			System.out.println(emp);
		}

	}

}


```




□コード3:  

```
package File_I_O;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee implements Serializable {
 private EmployeeRecord record;

    public Employee(String name, String telephone) {
        this.record = new EmployeeRecord(name, telephone);
    }

    public String getName() {
        return record.name();
    }

    public String getTelephone() {
        return record.telephone();
    }

    @Override
    public String toString() {
        return "Employee[name=" + getName() + ",telephone=" + getTelephone() + "]";
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        System.out.println("write");
        out.writeObject(record.name());
        out.writeObject(record.telephone());
    }

    private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
        System.out.println("read");
        String name = (String) in.readObject();
        String telephone = (String) in.readObject();
        this.record = new EmployeeRecord(name, telephone);
    }
}
```

A. ois.readObject()

B. (Item)ois.reader()

C. (Item)ois.readObject()

D. new Item(ois)

E. ois.readBytes()



#試験で判断できなかった部分(設問解き1回目）  
Java GoldSE17模擬問題で出ましたが、チンプンカンプンでわかりません。  
Eclipseではコーディングして仕様理解はしたのですが、Eclipseなしで紙の試験、机上ではまったくわからずでした。
試験解答のポイントは何か？



#前提知識は？


**シリアライズ ** 
オブジェクトをバイト列（データ）に変換すること  
※「Javaオブジェクト → ファイルやネットワークで送れるデータ」に変換する処理  
`writeObject()`  


**デシリアライズ** 
バイト列から元のオブジェクトへ戻すこと  
※「ファイルのデータ → Javaオブジェクト」へ復元する処理   
`readObject()  `  


#試験観点  

**ObjectInputStream.readObject() の戻り値は Object**  
`public final Object readObject()`   
readObject() は Object を返すため、キャストが必須  
※Object → Employee の暗黙キャストは不可  




#試験で判断できなかった部分(設問解き2回目）  
・シリアライズ化：writeObject()  
・デシリアライズ化：readObject()   
・readObject() の戻り値は Objectなのでキャスト必要な点  

