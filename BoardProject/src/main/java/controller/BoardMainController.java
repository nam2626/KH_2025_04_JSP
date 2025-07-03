package controller;

import java.io.IOException;
import java.util.List;

import dto.BoardDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardService;
import view.ModelAndView;

public class BoardMainController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//게시글 리스트 받음
		List<BoardDTO> list = BoardService.getInstance().selectAllBoard();
		
		//request 영역에 게시글 목록 저장
		request.setAttribute("list", list);
		
		return new ModelAndView("main.jsp", false);
	}

}








