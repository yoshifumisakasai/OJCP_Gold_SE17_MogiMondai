設問37

データベースに接続するプログラムを開発している。データベースとの接続するためのコードとして、正しいものを選べ（１つ）


A. Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "sample","sample");


B. Connection con = DriverManager.getConnection("sample", "sample", "jdbc:derby://localhost:1527/sample");


C. Connection con = DriverManager.connect("localhost", "1527", "sample");


D. Connection con = DriverManager.connect("jdbc:derby://localhost:1527/sample");


E. Connection con = DriverManager.createConnection("localhost", "1527", "sample");