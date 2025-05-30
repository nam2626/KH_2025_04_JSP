package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DispatcherServlet 호출");
		System.out.println(request.getRequestURI());
		System.out.println(request.getRequestURL());
		//경로 끝에 위치한 *.do만 뽑아서 출력
		int n = request.getRequestURI().lastIndexOf("/");
		System.out.println(request.getRequestURI().substring(n+1));
		String[] path = request.getRequestURI().split("/");
		System.out.println(path[path.length-1]);
		System.out.println(request.getRequestURI().substring(n+1).replace(".do", ""));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
