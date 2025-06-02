package controller;

import java.io.IOException;
import java.util.ArrayList;

import dto.MajorDTO;
import dto.StudentDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.StudentService;
import view.ModelAndView;

public class UpdateStudentViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. 수정할 학생 정보 조회
		String sno = request.getParameter("sno");
		StudentDTO student = StudentService.getInstance().selectStudent(sno);
		// 2. 전체 학과 정보 조회
		ArrayList<MajorDTO> majorList = StudentService.getInstance().selectAllMajor();
		// 3. 1/2번 데이터를 request영역에 저장
		request.setAttribute("majorList", majorList);
		request.setAttribute("student", student);
		// 4. 페이지 이동
		return new ModelAndView("student_update.jsp", false);
	}

}
