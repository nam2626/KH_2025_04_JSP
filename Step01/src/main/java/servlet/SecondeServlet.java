package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class SecondeServlet
 */
@WebServlet("/SecondeServlet")
public class SecondeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SecondeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 사용자가 보낸 데이터 받아옴.
		String num = request.getParameter("num");
		int n = Integer.parseInt(num);
		
		//2. 데이터 처리
		int result = n * n;
		
		//3. 응답할 데이터 셋팅
		request.setAttribute("result", result);
		
		//4. 이동할 페이지 셋팅 후 페이지 이동
		request.getRequestDispatcher("./seconde_result.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}





