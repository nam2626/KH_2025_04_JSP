package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest1 {

	public static void main(String[] args) {
		try {
			//1. JDBC 드라이버 클래스 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 완료");
			//2. 데이터베이스 접속
//			Connection conn = 
//					DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
//							"c##scott","123456");
			Connection conn = 
					DriverManager.getConnection("jdbc:oracle:thin:c##scott/123456@localhost:1521:xe");
			System.out.println("데이터 베이스 접속 완료");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		//3. SQL문 작성
		
		//4. SQL문 실행
		
		//5. 결과 출력
	}

}
