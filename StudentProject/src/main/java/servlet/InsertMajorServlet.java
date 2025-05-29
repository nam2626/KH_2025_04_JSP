package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.StudentService;

import java.io.IOException;

import dto.StudentDTO;

/**
 * Servlet implementation class InsertMajorServlet
 */
@WebServlet("/insertMajor.do")
public class InsertMajorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertMajorServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//1. insert_major.jsp에서 보낸 파라미터 받음
    	String sno = request.getParameter("sno");
    	String sname = request.getParameter("sname");
    	String mno = request.getParameter("mno");
    	String gender = request.getParameter("gender");
    	double score = Double.parseDouble(request.getParameter("score"));
    	//2. 서비스 클래스로 학생 데이터 보냄
    	StudentService.getInstance().insertStudent(
    			new StudentDTO(sno, sname, score, gender, mno, null));
    	//3. 추가 후 전체 학생 목록 조회는 서블릿 호출
//    	request.getRequestDispatcher("./all.do").forward(request, response);
    	response.sendRedirect("./all.do");
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}




