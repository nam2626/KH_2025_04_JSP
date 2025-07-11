package mapper;

import java.util.List;
import java.util.Map;

import dto.BoardCommentDTO;
import dto.BoardDTO;
import dto.BoardFileDTO;

public interface BoardMapper {

	List<BoardDTO> selectAllBoard();
	List<BoardDTO> selectBoardList(Map<String, Object> map);
	int selectBoardTotalCount();
	int selectBoardNo();
	int insertBoard(BoardDTO board);
//	int insertBoardFile(List<BoardFileDTO> fList);
	int insertBoardFile(BoardFileDTO item);
	int updateBoardCount(int bno);
	BoardDTO selectBoard(int bno);
	List<BoardFileDTO> selectBoardFileList(int bno);
	BoardFileDTO selectBoardFile(int fno);
	List<BoardCommentDTO> selectBoardCommentList(Map<String, Object> map);
	int insertBoardComment(BoardCommentDTO comment);
	int insertBoardLike(Map<String, Object> map);
	Map<String, Object> selectBoardLikeHateCount(int bno);
	int deleteBoardLike(Map<String, Object> map);
	int insertBoardHate(Map<String, Object> map);
	int deleteBoardHate(Map<String, Object> map);


}



