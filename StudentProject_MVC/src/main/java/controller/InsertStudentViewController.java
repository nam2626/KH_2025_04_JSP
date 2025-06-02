package controller;

import java.io.IOException;
import java.util.ArrayList;

import dto.MajorDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.StudentService;
import view.ModelAndView;

public class InsertStudentViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//모든 학과정보 request영역에 저장
		ArrayList<MajorDTO> list = StudentService.getInstance().selectAllMajor();
		request.setAttribute("majorList", list);
		
		return new ModelAndView("insert_student.jsp", false);
	}

}





