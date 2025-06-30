package service;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import config.DBManager;
import dto.BoardMemberDTO;
import mapper.BoardMemberMapper;

public class BoardMemberService {
	private static BoardMemberService instance = new BoardMemberService();
	private BoardMemberMapper mapper;
	
	private BoardMemberService() {
		mapper = DBManager.getInstance().getSession().getMapper(BoardMemberMapper.class);
	}
	
	public static BoardMemberService getInstance() {
		if(instance == null)
			instance = new BoardMemberService();
		return instance;
	}

	public List<BoardMemberDTO> selectAllMember() {
		return mapper.selectAllMember();
	}

	public int deleteMember(String id) {
		return mapper.deleteMember(id);
	}

	public int insertMember(BoardMemberDTO dto) {
		return mapper.insertMember(dto);
	}

	public int updateMember(BoardMemberDTO dto) {
		return mapper.updateMember(dto);
	}

	public int updateMember(Map<String, Object> map) {
		System.out.println(map.toString());
		return mapper.updateMember2(map);
	}

	public List<BoardMemberDTO> searchMember(Map<String, Object> map) {
//		return mapper.searchMember(map);
		return mapper.searchMember2(map);
	}
}




