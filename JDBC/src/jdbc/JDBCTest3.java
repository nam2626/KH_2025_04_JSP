package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest3 {

	public static void main(String[] args) {
		//student 데이터 한건을 사용자로 부터 입력 받아서
		try(Scanner sc = new Scanner(System.in)){
			System.out.print("학번 : ");
			String sno = sc.nextLine();
			System.out.print("이름 : ");
			String sname = sc.nextLine();
			System.out.print("평점 : ");
			double score = sc.nextDouble();
			sc.nextLine();
			System.out.print("성별 : ");
			String gender = sc.nextLine();
			System.out.print("학과 번호 : ");
			String mno = sc.nextLine();
			//student 테이블에 추가
			try(Connection conn = 
					DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
							"c##scott","123456")){
				String sql = "insert into student values(?,?,?,?,?)";
				try(PreparedStatement stmt = conn.prepareStatement(sql)){
					stmt.setString(1, sno);
					stmt.setString(2, sname);
					stmt.setDouble(3, score);
					stmt.setString(4, gender);
					stmt.setString(5, mno);
					int count = stmt.executeUpdate();
					System.out.println(count + "건 적용되었습니다.");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

}
