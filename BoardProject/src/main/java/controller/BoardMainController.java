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
		//사용자가 클릭한 페이지 번호를 받아서 조회, 단 페이지 번호가 없으면 1로 지정
		//페이지 번호 파라미터 명 : page
		String page = request.getParameter("page");
		String contentEa = request.getParameter("contentEa");
		int pageNo = 1;
		int pageContentEa = 30;
		
		try {
			if(page != null && !page.isEmpty())
				pageNo= Integer.parseInt(page);
			if(contentEa != null && !contentEa.isEmpty())
				pageContentEa = Integer.parseInt(contentEa);
		}catch (NumberFormatException e) {
			System.out.println("페이지 번호 및 게시글 개수가 숫자가 아닙니다.");
		}
		
		//게시글 리스트 받음
//		List<BoardDTO> list = BoardService.getInstance().selectAllBoard();
		List<BoardDTO> list = BoardService.getInstance()
				.selectBoardList(pageNo, pageContentEa);
		//PaggingVO 생성
		
		
		//request 영역에 게시글 목록 저장
		request.setAttribute("list", list);
		
		return new ModelAndView("main.jsp", false);
	}

}








