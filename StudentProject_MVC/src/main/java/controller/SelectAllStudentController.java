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
		ArrayList<StudentDTO> list = null;
		System.out.println(request.getParameter("search"));
		String search = request.getParameter("search");
		if(search != null || search.length() != 0) {
			//1. 검색어가 있는 경우
			list = StudentService.getInstance().selectStudentList(search);
		}else {
			//2. 검색어가 없는 경우
			list = StudentService.getInstance().selectAllStudent();
		}
		//-------------------------------------------
		request.setAttribute("list", list);
		return new ModelAndView("student_list.jsp", false);
	}

}




