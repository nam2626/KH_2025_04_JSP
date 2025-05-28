package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class JDBCTest5 {

	public static void main(String[] args) {
		try{
			OracleDataSource ods = new OracleDataSource();
		    ods.setURL("jdbc:oracle:thin:c##scott/123456@localhost:1521:xe");
		    String sql = "select * from student";
		    try(Connection conn = ods.getConnection();
		    	PreparedStatement pstmt = conn.prepareStatement(sql)){
		    	try(ResultSet rs = pstmt.executeQuery()){
		    		while(rs.next()) {
						System.out.println(
								rs.getString(1) + " " + rs.getString("sname") +
								" " + rs.getDouble("score") + " " + rs.getString("gender")
								+ " " + rs.getString("mno"));
					}
		    	}
		    }
		    
		}catch (SQLException e) {
			e.printStackTrace();
		}
	    

	}

}
