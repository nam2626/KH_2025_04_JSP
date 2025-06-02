package controller;

import java.io.IOException;
import java.util.ArrayList;

import dto.StudentDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.StudentService;
import view.ModelAndView;

public class SelectAllStudentController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. 서비스 클래스에게 전체 학생 정보를 요청
		ArrayList<StudentDTO> list = StudentService.getInstance().selectAllStudent();
		// 2. request 영역에 서비스 클래스로 부터 받은 전체 학생 정보를 저장
		request.setAttribute("list", list);
		// 3. student_list.jsp로 이동해서 학생정보 전체 출력
		return new ModelAndView("student_list.jsp", false);
	}

}




