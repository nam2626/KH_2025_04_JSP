package service;

import config.DBManager;
import mapper.BoardMapper;

public class BoardService {
	//싱글톤
	private static BoardService instance = new BoardService();
	private BoardMapper mapper;
	
	private BoardService() {	
		//mapper 생성
		mapper = DBManager.getInstance().getSession().getMapper(BoardMapper.class);
	}

	public static BoardService getInstance() {
		if(instance == null)
			instance = new BoardService();
		return instance;
	}
	
}



