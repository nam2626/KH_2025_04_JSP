package controller;

import java.io.IOException;

import dto.StudentDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.StudentService;
import view.ModelAndView;

public class InsertStudentController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	String sno = request.getParameter("sno");
    	String sname = request.getParameter("sname");
    	String mno = request.getParameter("mno");
    	String gender = request.getParameter("gender");
    	double score = Double.parseDouble(request.getParameter("score"));

    	StudentService.getInstance().insertStudent(
    			new StudentDTO(sno, sname, score, gender, mno, null));

    	return new ModelAndView("/main.do", true);
	}

}
