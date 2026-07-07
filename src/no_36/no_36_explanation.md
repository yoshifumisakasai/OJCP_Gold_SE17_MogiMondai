■JDBC URL の形式：  


`jdbc:<サブプロトコル>:<サブネーム>`  



■Derby Network Server の場合：  


`jdbc:derby://<host>:<port>/<dbName>`  



正解)
B. 
`DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "test", "test");`  
getConnection() → JDBC 正規のメソッド  

第1引数が正しい JDBC URL  

第2・第3引数がユーザ名・パスワード  



不正解
E. 
DriverManager.getConnection("test", "test", "jdbc:derby://localhost:1527/sample");  

引数の順番が間違い  

JDBC URL が第3引数になっている → アウト  