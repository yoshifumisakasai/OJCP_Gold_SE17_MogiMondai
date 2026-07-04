設問17
データベースに登録されているプロシージャ「UPDATE_SAMPLE」を実行するためのコードとして正しいものを1つ選べ

A. CallableStatement stmt = con.callable("UPDATE_SAMPLE(?,?)");

B. CallableStatement stmt = con.callStatement("UPDATE_SAMPLE(?,?)");

C. CallableStatement stmt = con.prepareCallable("UPDATE_SAMPLE(?,?)");

D. CallableStatement stmt = con.prepareStatement("UPDATE_SAMPLE(?,?)");

E. CallableStatement stmt = con.prepareCall("UPDATE_SAMPLE(?,?)");



#迷ったポイント「設問見たとき、解いたときの知識レベル、試験観点の把握レベルは？  
   CallableStatemetnってなんだっけ？


#正答  
A. con.callable(...)  
そんなメソッドは JDBC に存在しない。

B. con.callStatement(...)  
これも JDBC には存在しない。

C. con.prepareCallable(...)  
これも存在しない。名前は似ているが罠。

D. con.prepareStatement(...)  
PreparedStatement を返す。
プロシージャ呼び出しには使えない。

`E. con.prepareCall("UPDATE_SAMPLE(?,?)") `   
**✔ JDBC 仕様に存在する**  
**✔ CallableStatement を返す**  
*✔ ストアドプロシージャ呼び出し専用*


#試験観点①
PreparedStatement と CallableStatement の違いを問う  
それぞれのインタフェース型が生成メソッドの知識  


#試験観点②  
戻り値型「CallableStatement」 は prepareCall() でしか作れない  

