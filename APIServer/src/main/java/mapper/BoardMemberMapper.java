package mapper;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import dto.BoardMemberDTO;

public interface BoardMemberMapper {

	List<BoardMemberDTO> selectAllMember();
	int deleteMember(String id);
	int insertMember(BoardMemberDTO dto);
	int updateMember(BoardMemberDTO dto);
	int updateMember2(Map<String, Object> map);

}
