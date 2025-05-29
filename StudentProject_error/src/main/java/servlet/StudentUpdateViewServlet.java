package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.StudentService;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.MajorDTO;
import dto.StudentDTO;

@WebServlet("/updateView.do")
public class StudentUpdateViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentUpdateViewServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 수정할 학생 정보 조회
		String sno = request.getParameter("sno");
		StudentDTO student = StudentService.getInstance().selectStudent(sno);
		//2. 전체 학과 정보 조회
		ArrayList<MajorDTO> majorList = StudentService.getInstance().selectAllMajor();
		//3. 1/2번 데이터를 request영역에 저장
		request.setAttribute("majorList", majorList);
		request.setAttribute("student", student);
		//4. 페이지 이동
		request.getRequestDispatcher("./student_update.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
