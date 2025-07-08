package mapper;

import java.util.List;
import java.util.Map;

import dto.BoardMemberDTO;

public interface BoardMemberMapper {

	List<BoardMemberDTO> selectAllMember();
	int deleteMember(String id);
	int insertMember(BoardMemberDTO dto);
	BoardMemberDTO login(Map<String, Object> map);

}
