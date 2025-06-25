package servlet;

import java.io.IOException;
import java.util.List;

import dto.BoardMemberDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardMemberService;

/**
 * Servlet implementation class MemberAllServlet
 */
@WebServlet("/all.do")
public class MemberAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberAllServlet() {    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//BoardMemberMapper 클래스에서 전체 회원정보를 받아오기
		List<BoardMemberDTO> list = BoardMemberService.getInstance().selectAllMember();
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("./member_list.jsp").forward(request, response);
	}


}





