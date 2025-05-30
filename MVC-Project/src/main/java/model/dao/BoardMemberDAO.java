package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.DBManager;
import model.dto.BoardMemberDTO;

public class BoardMemberDAO {
	private static BoardMemberDAO instance = new BoardMemberDAO();
	private DBManager manager;
	
	private BoardMemberDAO() {
		manager = DBManager.getInstance();
	}

	public static BoardMemberDAO getInstance() {
		if(instance == null)
			instance = new BoardMemberDAO();
		return instance;
	}

	public BoardMemberDTO login(String id, String passwd) {
		//로그인 SQL문을 이용해서 board_member 테이블에서 데이터 조회 결과를 리턴
		String sql = "select * from board_member \n"
				+ "where id like ? and passwd like standard_hash(?,'SHA512')";
		
		BoardMemberDTO dto = null;
		
		try(PreparedStatement pstmt = 
				manager.getInstance().getConnection().prepareStatement(sql)){
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					String name = rs.getString("username");
					String nick = rs.getString("nickname");
					
					dto = new BoardMemberDTO(id, null, name, nick);					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dto;
	}

	
	
}











