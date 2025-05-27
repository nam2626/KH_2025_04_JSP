package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/cookie.do")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txt = request.getParameter("text");//쿠키에 저장할 데이터
		
		//쿠키 셋팅
		Cookie cookie = new Cookie("keyword", txt);
		Cookie ageCookie = new Cookie("age", "30");
		
		//쿠키 유효시간 설정(초단위)
		cookie.setMaxAge(180);//3분
		response.addCookie(cookie);//response 객체에 쿠키 추가
		
		ageCookie.setMaxAge(180);
		response.addCookie(ageCookie);
		
		//페이지 이동 - cookie_result.jsp
		request.getRequestDispatcher("./cookie_result.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
