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
 * Servlet implementation class StudentUpdateServlet
 */
@WebServlet("/updateStudent.do")
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String sno = request.getParameter("sno");
    	String sname = request.getParameter("sname");
    	String mno = request.getParameter("mno");
    	String gender = request.getParameter("gender");
    	double score = Double.parseDouble(request.getParameter("score"));

    	StudentService.getInstance().updateStudent(
    			new StudentDTO(sno, sname, score, gender, mno, null));

    	response.sendRedirect("./all.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
