package main;

import java.util.List;

import dto.BoardMemberDTO;
import mapper.BoardMemeberMapper;

public class TestMain {

	public static void main(String[] args) {
		BoardMemeberMapper mapper = BoardMemeberMapper.getInstance();
		List<BoardMemberDTO> list = mapper.selectAllMember();
		list.forEach((obj) -> {
			System.out.println(obj);
		});
	}

}
