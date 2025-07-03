package mapper;

import java.util.List;
import java.util.Map;

import dto.BoardDTO;

public interface BoardMapper {

	List<BoardDTO> selectAllBoard();
	List<BoardDTO> selectBoardList(Map<String, Object> map);

}
