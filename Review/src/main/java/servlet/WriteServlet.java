package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({ "/WriteServlet", "/writePost" })
public class WriteServlet extends HttpServlet {
    public WriteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println(title + " " + content);
		request.setAttribute("postTitle", title);
		request.setAttribute("postContent", content);
		
		request.getRequestDispatcher("./writeResult.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");//한글이 깨질때 인코딩 처리
		doGet(request, response);
	}

}
