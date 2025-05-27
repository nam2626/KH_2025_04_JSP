package servlet;

import java.io.IOException;
import java.util.ArrayList;

import dto.BoardMemberDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class JSTLServlet
 */
@WebServlet("/jstl.do")
public class JSTLServlet extends HttpServlet {
    public JSTLServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//BoardMemberDTO 하나 생성
		BoardMemberDTO dto = new BoardMemberDTO("A0001", "홍길동", "123456", "HongKD");
		
		//session 생성
		HttpSession sessions = request.getSession();
		sessions.setAttribute("dto", dto);
		sessions.setAttribute("msg", "세션 메세지 내용");
		
		//ArrayList<BoardMemberDTO> 생성해서 데이터를 3건을 저장
		ArrayList<BoardMemberDTO> list = new ArrayList<BoardMemberDTO>();
		list.add(new BoardMemberDTO("A0002", "김철수", "123456", "Kim"));
		list.add(new BoardMemberDTO("A0003", "이영수", "123456", "Lee"));
		list.add(new BoardMemberDTO("A0004", "박영희", "123456", "Park"));
		
		request.setAttribute("list", list);
		request.setAttribute("age", 44);
//		request.setAttribute("msg", "request 메세지 내용");
		
		request.getRequestDispatcher("./jstl_el.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}






