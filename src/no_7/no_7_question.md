次のコードの「/insert code here」に入るコードとして正しいものを１つ選べ


□コード1:  

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




□コード2:  

```
package File_I_O;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee implements Serializable {
	private String name;
	private String telephone;

	public Employee(String name, String telephone) {
		super();
		this.name = name;
		this.telephone = telephone;
	}

	public String getName() {
		return name;
	}

	public String getTelephone() {
		return telephone;
	}

	@Override
	public String toString() {
		return "Employee[name=" + name + ",telephone=" + telephone + "]";
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		System.out.println("write");
		out.writeObject(name);
		out.writeObject(telephone);
	}

	private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
		System.out.println("read");
		this.name = (String) in.readObject();
		this.telephone = (String) in.readObject();
	}
}
```


#試験で判断できなかった部分  
Java GoldSE17模擬問題で出ましたが、チンプンカンプンでわかりません。  
Eclipseではコーディングして仕様理解はしたのですが、Eclipseなしで紙の試験、机上ではまったくわからずでした。
試験解答のポイントは何か？

