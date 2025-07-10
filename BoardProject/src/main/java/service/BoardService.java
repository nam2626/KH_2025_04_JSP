package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import config.DBManager;
import dto.BoardCommentDTO;
import dto.BoardDTO;
import dto.BoardFileDTO;
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

	public List<BoardDTO> selectBoardList(int pageNo, int pageContentEa) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageNo", pageNo);
		map.put("pageContentEa", pageContentEa);
		return mapper.selectBoardList(map);
	}

	public int selectBoardTotalCount() {
		return mapper.selectBoardTotalCount();
	}

	public int selectBoardNo() {
		return mapper.selectBoardNo();
	}

	public int insertBoard(BoardDTO board) {
		return mapper.insertBoard(board);
	}

	public void insertBoardFile(List<BoardFileDTO> fList) {
		fList.forEach(item -> mapper.insertBoardFile(item));
	}

	public int updateBoardCount(int bno) {
		return mapper.updateBoardCount(bno);
	}

	public BoardDTO selectBoard(int bno) {
		return mapper.selectBoard(bno);
	}

	public List<BoardFileDTO> selectBoardFileList(int bno) {
		return mapper.selectBoardFileList(bno);
	}

	public BoardFileDTO selectBoardFile(int fno) {
		return mapper.selectBoardFile(fno);
	}

	public List<BoardCommentDTO> selectBoardCommentList(int bno, int i) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		map.put("page", i);
		return mapper.selectBoardCommentList(map);
	}

	public int insertBoardComment(BoardCommentDTO comment) {
		return mapper.insertBoardComment(comment);
	}
	
}



