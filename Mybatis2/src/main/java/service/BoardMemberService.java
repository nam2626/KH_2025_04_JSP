package service;

import config.DBManager;
import mapper.BoardMemberMapper;

public class BoardMemberService {
	private static BoardMemberService instance = new BoardMemberService();
	private BoardMemberMapper mapper;
	
	private BoardMemberService() {
		mapper = DBManager.getInstance().getSession().getMapper(BoardMemberMapper.class);
	}
	
	public static BoardMemberService getInstance() {
		if(instance == null)
			instance = new BoardMemberService();
		return instance;
	}
}
