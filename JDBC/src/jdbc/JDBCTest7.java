package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest7 {

	public static void main(String[] args) {
		try {
			Connection conn = 
					DriverManager.getConnection("jdbc:mysql://localhost/scott?" +
                            "user=scott&password=123456");
			String sql = "select * from student";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(
						rs.getString(1) + " " + rs.getString("sname") +
						" " + rs.getDouble("score") + " " + rs.getString("gender")
						+ " " + rs.getString("mno"));
			}
			
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
