package no_17;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class No_17 {

    public static void main(String[] args) {

        String url = "jdbc:derby:C:/pleiades/2026-03/workspace/OJCP_Gold_SE17_Exam/derbyDB/Sample;create=true";

        try (Connection con = DriverManager.getConnection(url)) {

            // プロシージャ呼び出し
            try (CallableStatement cs = con.prepareCall("{call GREET(?)}")) {
                cs.setString(1, "Yoshifumi");
                cs.execute();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
