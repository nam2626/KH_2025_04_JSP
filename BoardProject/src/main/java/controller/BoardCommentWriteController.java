package controller;

import java.io.IOException;

import dto.BoardCommentDTO;
import dto.BoardMemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardService;
import view.ModelAndView;

public class BoardCommentWriteController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//글 번호
		int bno = Integer.parseInt(request.getParameter("bno"));
		//댓글
		String content = request.getParameter("content");
		//작성자 ID
		BoardMemberDTO member = (BoardMemberDTO) request.getSession().getAttribute("user");
		String id = member.getId();
		
		System.out.println(bno + " " + content + " " + id);
		
		BoardCommentDTO comment = new BoardCommentDTO();
		comment.setBno(bno);
		comment.setContent(content);
		comment.setId(id);
		
		BoardService.getInstance().insertBoardComment(comment);		
		
		return new ModelAndView("/boardView.do?bno="+bno, true);
	}

}


