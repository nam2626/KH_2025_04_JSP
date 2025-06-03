package controller;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import view.ModelAndView;

public class DepartmentInsertViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return new ModelAndView("dept_insert.jsp", false);
	}

}
