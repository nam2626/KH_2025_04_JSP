package mapper;

import java.util.List;
import java.util.Map;

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

}
