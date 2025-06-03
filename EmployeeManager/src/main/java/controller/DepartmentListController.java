package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.DepartmentDTO;
import model.service.DepartmentService;
import view.ModelAndView;

public class DepartmentListController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<DepartmentDTO> deptList = DepartmentService.getInstance().getAllDepartments();
        request.setAttribute("deptList", deptList);
        return new ModelAndView("dept_list.jsp", false);
	}

}
