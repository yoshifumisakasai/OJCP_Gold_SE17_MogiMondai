設問36


JDBCを使ってデータベースに接続するためのコードとして正しいものを選べ（１つ）

A. DriverManager.onnect("localhost", 1527, "sample");


B. DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "test", "test");


C. DriverManager.createConnection("derby", "test", "test");
				
				
D. DriverManager.connect("jdbc:derby://localhost:1527/sample");
				
				
E. DriverManager.getConnection("test", "test", "jdbc:derby://localhost:1527/sample");




#説いた時の所感
36.B
⇒明確な選択肢の判定基準を理解して「B」としたわけではなく、何となく見た感じで正しいそうに見えた。




#試験観点
JDBC の仕様に基づいて “なぜ B が正しいか” を明確に理解できるように整理してください


#選択肢を絞るための前提知識

**JDBC で DB に接続するには DriverManager.getConnection() を使い、第1引数に JDBC URL を渡すのが絶対ルール。**



#選択肢切り分けポイント

●JDBC URL の判定基準（覚えるべきポイント）

`①JDBC URL の形式を満たしているか`
jdbc:<サブプロトコル>:<サブネーム>  


`②DriverManager.getConnection() を使っているか`    
JDBC 接続は必ずこのメソッド  


`③引数の順番が正しいか`  
getConnection(String url)  

getConnection(String url, String user, String pass)  

`④メソッド名が存在するか`  
connect() や createConnection() は存在しない
	