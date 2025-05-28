package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.DBManager;
import oracle.jdbc.pool.OracleDataSource;

public class JDBCTest6 {

	public static void main(String[] args) {
		try{
			String sql = "select * from student";
		    try(Connection conn = DBManager.getInstance().getConnection();
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
