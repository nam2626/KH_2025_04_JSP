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

	public int insertBoardLike(int bno, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		map.put("id", id);
		return mapper.insertBoardLike(map);
	}

	public Map<String, Object> selectBoardLikeHateCount(int bno) {
		return mapper.selectBoardLikeHateCount(bno);
	}

	public int deleteBoardLike(int bno, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		map.put("id", id);
		return mapper.deleteBoardLike(map);		
	}
	
	public int insertBoardHate(int bno, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		map.put("id", id);
		return mapper.insertBoardHate(map);
	}
	public int deleteBoardHate(int bno, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		map.put("id", id);
		return mapper.deleteBoardHate(map);		
	}

	public int insertBoardCommentLike(int cno, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cno", cno);
		map.put("id", id);
		return mapper.insertBoardCommentLike(map);
	}
	public int deleteBoardCommentLike(int cno, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cno", cno);
		map.put("id", id);
		return mapper.deleteBoardCommentLike(map);
	}
	public Map<String, Object> selectBoardCommentLikeHateCount(int cno) {
		return mapper.selectBoardCommentLikeHateCount(cno);
	}

	public int insertBoardCommentHate(int cno, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cno", cno);
		map.put("id", id);
		return mapper.insertBoardCommentHate(map);	
	}
	public int deleteBoardCommentHate(int cno, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cno", cno);
		map.put("id", id);
		return mapper.deleteBoardCommentHate(map);		
	}
}



