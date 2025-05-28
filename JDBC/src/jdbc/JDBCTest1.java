package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest1 {

	public static void main(String[] args) {
		try {
			//1. JDBC 드라이버 클래스 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 완료");
			//2. 데이터베이스 접속
//			Connection conn = 
//					DriverManager.getConnection("jdbc:oracle:thin:c##scott/123456@localhost:1521:xe");

			Connection conn = 
					DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
							"c##scott","123456");
			System.out.println("데이터 베이스 접속 완료");
			//3. SQL문 작성
			String sql = "select * from student";
			//4. Statement 생성(SQL문을 데이터베이스 전송하고 실행하는 객체)
			Statement stmt = conn.createStatement();
			//5. SQL문 실행
			ResultSet rs = stmt.executeQuery(sql);
			//6. 결과 출력
			while(rs.next()) {
				System.out.println(
						rs.getString(1) + " " + rs.getString("sname") +
						" " + rs.getDouble("score") + " " + rs.getString("gender")
						+ " " + rs.getString("mno"));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		//4. SQL문 실행
		
		//5. 결과 출력
	}

}
