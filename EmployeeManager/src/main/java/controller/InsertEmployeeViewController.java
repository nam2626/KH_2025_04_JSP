package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.DepartmentDTO;
import model.dto.PositionDTO;
import model.service.DepartmentService;
import model.service.PositionService;
import view.ModelAndView;

public class InsertEmployeeViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<DepartmentDTO> deptList = DepartmentService.getInstance().getAllDepartments(); // 전체 부서
		List<PositionDTO> posList = PositionService.getInstance().getAllPositions(); // 전체 직급

		request.setAttribute("deptList", deptList);
		request.setAttribute("posList", posList);
		System.out.println(deptList);
		System.out.println(posList);
		return new ModelAndView("emp_insert.jsp",false);
	}

}
