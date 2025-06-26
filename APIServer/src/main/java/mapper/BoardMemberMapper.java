package mapper;

import java.util.List;

import dto.BoardMemberDTO;

public interface BoardMemberMapper {

	List<BoardMemberDTO> selectAllMember();
	int deleteMember(String id);
	int insertMember(BoardMemberDTO dto);

}
