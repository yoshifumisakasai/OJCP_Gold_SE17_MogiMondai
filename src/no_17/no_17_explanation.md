#インタフェースConnection
すべてのスーパー・インタフェース:AutoCloseable, Wrapper  

`public interface Connection extends Wrapper, AutoCloseable`  
特定のデータベースとの接続(セッション)を表現します。 接続のコンテキスト内でSQL文が実行され結果が返されます。  


※


#CallableStatement を生成するJDBC メソッド

■「Connection」インタフェース型の"prepareCall"メソッド

`CallableStatement prepareCall(String sql) throws SQLException`   
*データベースのストアド・プロシージャを呼び出すためのCallableStatementオブジェクトを生成します。*  


■パラメータ:  
`sql - 1つ以上の「?」パラメータ・プレースホルダーを含めることができるSQL文。 通常この文は、JDBC呼出しのエスケープ構文を使用して指定される`  
■戻り値:  
`プリコンパイルされたSQL文を含む新しいデフォルトのCallableStatementオブジェクト`  


**✔ JDBC 仕様に存在する**  
**✔ CallableStatement を返す**  
*✔ ストアドプロシージャ呼び出し専用*  


#インタフェースCallableStatement  
すべてのスーパー・インタフェース:AutoCloseable, PreparedStatement, Statement, Wrapper
**CallableStatement は prepareCall() でしか作れません**  

`public interface CallableStatement extends PreparedStatement`  
SQLストアド・プロシージャを実行するのに使用されるインタフェースです。 JDBC APIは、ストアド・プロシージャSQLエスケープ構文を提供します。  
すべてのRDBMSに対し標準の方法でストアド・プロシージャを呼び出せます。 


**※ストアド・プロシージャ（Stored Procedure）**  
データベース内に“保存しておける一連の SQL 処理（＋制御構文）”のこと。  
アプリ側からは 名前を指定して呼び出すだけで実行できる「DB 内のプログラム」  




#PreparedStatementインタフェース型と、CallableStatementインタフェース型の違いについて 
●PreparedStatement	⇒prepareStatement()メソッド：  
*パラメータ化 SQL(SQL文実行のStatement)※ただのSQL文実行SELECT / INSERT / UPDATE / DELETEのみ*          

□コード例  

```
PreparedStatement ps = con.prepareStatement(
    "INSERT INTO users(id, name) VALUES (?, ?)"
```

戻り値型：  
**prepareStatement() → PreparedStatement**
  






●CallableStatement	⇒prepareCall()メソッド：  
*ストアドプロシージャ呼び出し(DB 内のプログラム（CALL）) *      
 
 □コード例  
 
 ````
 CallableStatement cs = con.prepareCall(
    "{call UPDATE_SAMPLE(?, ?)}"
);
```

戻り値型：
**prepareCall() → CallableStatement**  
