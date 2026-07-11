package no_60;

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

			// 自動コミットを OFF にする（＝トランザクション開始）
			//「自動コミットを止めて、明示的に commit() / rollback() を自分で行う」ためのコード
			
			con.setAutoCommit(false); // トランザクション開始

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

			//④ commit() / rollback() は Connection に対して呼ぶ
			con.commit(); // すべて成功 → コミット
			System.out.println("コミットしました");

		} catch (Exception e) {
			e.printStackTrace();

			if (con != null) {
				try {
					//④ commit() / rollback() は Connection に対して呼ぶ
					con.rollback(); // 失敗 → ロールバック
					System.out.println("ロールバックしました");
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		} finally {
			if (con != null) {
				try {
					//JDBC の仕様で：Connection.close() は、未コミットの変更を 自動で commit する
					//rollback したい場合は close() される前に rollback を呼ぶ必要がある。
					con.close(); // 最後に必ず閉じる
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}

	}
}
