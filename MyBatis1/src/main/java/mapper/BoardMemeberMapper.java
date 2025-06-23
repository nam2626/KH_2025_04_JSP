package mapper;

import java.util.List;

import config.DBManager;
import dto.BoardMemberDTO;

public class BoardMemeberMapper {
	private static BoardMemeberMapper instance = new BoardMemeberMapper();
	private DBManager manager;
	
	private BoardMemeberMapper() {
		manager = DBManager.getInstance();
	}
	
	public static BoardMemeberMapper getInstance() {
		if(instance == null)
			instance = new BoardMemeberMapper();
		return instance;
	}
	
	public List<BoardMemberDTO> selectAllMember(){
		return manager.getSession().selectList("selectAllMember");
	}
	
}






