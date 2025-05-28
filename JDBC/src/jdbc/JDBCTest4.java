package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCTest4 {

	public static void main(String[] args) {
		// 학생 이름 일부를 입력 받아서
		// 해당 학생 정보를 조회해서 출력
		// 조회할 걸럼 : 학번, 이름, 학과명, 성별, 평점
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("검색할 이름 : ");
			String sname = sc.nextLine();
			try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##scott",
					"123456")) {
				String sql = "select s.sno, s.sname, s.score, s.gender, m.mname"
						+ " from student s inner join major m on s.mno = m.mno "
						+ "where s.sname like '%' || ? || '%'";
				try (PreparedStatement stmt = conn.prepareStatement(sql)) {
					stmt.setString(1, sname);
					
					try(ResultSet rs = stmt.executeQuery()){
						while(rs.next()) {
							System.out.println(rs.getString(1) + " " + 
						rs.getString(2) + " " + rs.getDouble(3) + " " + rs.getString(4)
						+ " " + rs.getString(5));
						}
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
