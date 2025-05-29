package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.StudentService;

import java.io.IOException;
import java.util.ArrayList;

import dto.StudentDTO;

@WebServlet("/all.do")
public class SelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectAllServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 서비스 클래스에게 전체 학생 정보를 요청
		ArrayList<StudentDTO> list = StudentService.getInstance().selectAllStudent();
		//2. request 영역에 서비스 클래스로 부터 받은 전체 학생 정보를 저장
		request.setAttribute("list", list);
		//3. student_list.jsp로 이동해서 학생정보 전체 출력
		request.getRequestDispatcher("./student_list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
