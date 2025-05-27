package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/session.do")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = request.getParameter("msg");
		
		//세션 정보를 읽어옴
		HttpSession session = request.getSession();
		//세션에 데이터 저장
		session.setAttribute("msg", msg);
		//세션 유효시간 - 초단위
//		session.setMaxInactiveInterval(1800);
		
		System.out.println(session.getId());
		//페이지 이동 session_result.jsp
		request.getRequestDispatcher("session_result.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
