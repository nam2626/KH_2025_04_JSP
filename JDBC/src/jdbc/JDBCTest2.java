package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest2 {

	public static void main(String[] args) {
		try(Connection conn = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
						"c##scott","123456")){
//			conn.setAutoCommit(false); //자동 커밋 해제
			//학생 데이터 하나 추가하는 SQL문 작성
			String sql = "insert into student values('22221111','테스트',3.2,'M','M02')";
			try(Statement stmt = conn.createStatement()){
				int count = stmt.executeUpdate(sql);
				System.out.println(count + "건 적용되었습니다.");
				//conn.commit(); // 커밋
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}






