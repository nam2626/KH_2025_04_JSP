package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.EmployeeDTO;
import model.service.EmployeeService;
import view.ModelAndView;

public class MainController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//전체 사원 정보 가져오기
		ArrayList<EmployeeDTO> empList = EmployeeService.getInstance().selectAll();
		//request영역에 저장
		request.setAttribute("empList", empList);
		return new ModelAndView("emp_list.jsp", false);
	}

}








