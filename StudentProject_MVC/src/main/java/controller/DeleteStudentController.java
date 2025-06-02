package controller;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.StudentService;
import view.ModelAndView;

public class DeleteStudentController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 삭제할 학번 받음
		String sno = request.getParameter("sno");
		// 서비스 클래스로 삭제할 학번 전달
		StudentService.getInstance().deleteStudent(sno);
		// 삭제 후에 다시 전체 학생 목록을 조회
		return new ModelAndView("/main.do", true);
	}

}
