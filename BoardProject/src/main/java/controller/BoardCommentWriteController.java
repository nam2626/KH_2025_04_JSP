package controller;

import java.io.IOException;

import dto.BoardMemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
		
		
		return new ModelAndView("/boardView.do?bno="+bno, true);
	}

}


