package controller;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.DepartmentDTO;
import model.service.DepartmentService;
import view.ModelAndView;

public class DepartmentInsertController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 String deptNo = request.getParameter("deptNo");
	        String deptName = request.getParameter("deptName");

	        DepartmentDTO dto = new DepartmentDTO(deptNo, deptName);
	        boolean result = DepartmentService.getInstance().insertDepartment(dto);

	        if (result) {
	            // 등록 성공 시 전체 부서 리스트로 리다이렉트
	            return new ModelAndView("/deptList.do",true);
	        } else {
	            // 실패 시 다시 등록 폼으로
	        	response.setContentType("text/html;charset=utf-8");
	        	response.getWriter().println("<script>"
	        			+ "alert('부서 등록에 실패하였습니다.');"
	        			+ "history.back();"
	        			+ "</script>");
	        	return null;
	        }
	}

}
