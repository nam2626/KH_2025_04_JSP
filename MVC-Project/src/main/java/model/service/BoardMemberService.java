package model.service;

import model.dao.BoardMemberDAO;
import model.dto.BoardMemberDTO;

public class BoardMemberService {
	private static BoardMemberService instance = new BoardMemberService();
	private BoardMemberDAO dao;
	private BoardMemberService() {
		dao = BoardMemberDAO.getInstance();
	}

	public static BoardMemberService getInstance() {
		if(instance == null)
			instance = new BoardMemberService();
		return instance;
	}

	public BoardMemberDTO login(String id, String passwd) {
		if(id.length() == 0 || passwd.length() == 0) {
			System.out.println("아이디나 비밀번호가 입력되지 않았습니다.");
			return null;
		}
		return dao.login(id,passwd);
	}

	
	
}
