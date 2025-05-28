package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.StudentService;

import java.io.IOException;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete.do")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//삭제할 학번 받음
		String sno = request.getParameter("sno");
		//서비스 클래스로 삭제할 학번 전달
		StudentService.getInstance().deleteStudent(sno);		
		//삭제 후에 다시 전체 학생 목록을 조회 
		response.sendRedirect("./all.do");//redirect는 새로운 요청
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
