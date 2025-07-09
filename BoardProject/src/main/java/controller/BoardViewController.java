package controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import dto.BoardDTO;
import dto.BoardFileDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.BoardService;
import view.ModelAndView;

public class BoardViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//글번호 받아오기
		int bno = Integer.parseInt(request.getParameter("bno"));
		//글번호에 해당하는 게시글의 조회수를 증가
		//현재 방문한 적이 있으면 조회수 증가를 하지 않음.
		//방문한 적이 없는 글이면 조회수를 증가.
		HttpSession session = request.getSession();
		HashSet<Integer> history = (HashSet<Integer>) session.getAttribute("history");
		if(history == null) {
			history = new HashSet<Integer>();
			session.setAttribute("history", history);
		}
		if(history.add(bno))
			BoardService.getInstance().updateBoardCount(bno);
		
		//게시글 조회
		BoardDTO board = BoardService.getInstance().selectBoard(bno);
		//해당 게시글 댓글 목록 조회
		
		//해당 게시글 첨부파일 목록 조회
		List<BoardFileDTO> flist = BoardService.getInstance().selectBoardFileList(bno);
		
		request.setAttribute("board", board);
		request.setAttribute("flist", flist);
		return new ModelAndView("board_view.jsp", false);
	}

}





