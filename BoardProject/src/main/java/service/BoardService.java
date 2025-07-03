package service;

import java.util.List;

import config.DBManager;
import dto.BoardDTO;
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

	public List<BoardDTO> selectAllBoard() {
		return mapper.selectAllBoard();
	}
	
}



