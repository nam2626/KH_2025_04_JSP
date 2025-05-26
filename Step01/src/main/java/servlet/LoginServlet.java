package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 로그인한 아이디값이 admin이면 request 영역에 '관리자로 로그인하셨습니다.'
		//   admin이 아니면 '일반회원으로 로그인하셨습니다.' 메세지를 저장
		String id = request.getParameter("id");
		String msg = "";
		if(id.equals("admin")) {
			msg = "관리자로 로그인하셨습니다.";
		}else {
			msg = "일반회원으로 로그인하셨습니다.";
		}
		request.setAttribute("msg", msg);
		//2. login_result.jsp로 이동하게끔 처리
		request.getRequestDispatcher("./login_result.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}





