package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.StudentService;

import java.io.IOException;
import java.util.ArrayList;

import dto.MajorDTO;

/**
 * Servlet implementation class InsertViewServlet
 */
@WebServlet("/insertView.do")
public class InsertViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertViewServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전체 학과 정보를 조회
		ArrayList<MajorDTO> list = StudentService.getInstance().selectAllMajor();
		//request영역에 셋팅
		request.setAttribute("majorList", list);
		request.getRequestDispatcher("insert_student.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}




