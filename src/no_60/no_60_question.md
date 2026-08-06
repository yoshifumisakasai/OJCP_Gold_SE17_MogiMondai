設問60

次のコードをコンパイル、実行したときの結果として正しいものを選べ（１つ）

```
package jdbc_verification;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Jdbc_commit {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = null;

		try {
			con = DriverManager.getConnection(
					"jdbc:derby:C:/pleiades/2026-03/workspace/OJCP_Gold_SE17_Exam/derbyDB/Sample");
			
			con.setAutoCommit(false);

			// 1つ目の SQL
			try (PreparedStatement ps = con.prepareStatement(
					"INSERT INTO test (id, name) VALUES (?, ?)")) {
				ps.setInt(1, 100);
				ps.setString(2, "AAA");
				ps.executeUpdate();
			}

			// 2つ目の SQL
			try (PreparedStatement ps = con.prepareStatement(
					"INSERT INTO test (id, name) VALUES (?, ?)")) {
				ps.setInt(1, 101);
				ps.setString(2, "BBB");
				ps.executeUpdate();
			}

			con.commit();
			System.out.println("コミットしました");

		} catch (Exception e) {
			e.printStackTrace();

			if (con != null) {
				try {
					con.rollback(); 
					System.out.println("ロールバックしました");
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}

	}
}
```

A. テーブルに2行追加される

B. テーブルに1行追加され、2行目の追加時にSQL Exceptionがスローされる

C. SQL Exceptionがスローされ、1行も追加されない

D. テーブルに1行追加され、2行目の追加時にNullPointerExceptionがスローされる

E. コンパイルエラーが発生する



#設問解いたときの所見
60.A

