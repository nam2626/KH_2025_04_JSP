package controller;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.EmployeeDTO;
import model.service.EmployeeService;
import view.ModelAndView;

public class InsertEmployeeController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 // 1. 파라미터 추출
        String empNo = request.getParameter("empNo");
        String empName = request.getParameter("name");
        String deptNo = request.getParameter("department");
        String posNo = request.getParameter("position");
        String salaryStr = request.getParameter("salary");
        String hireDate = request.getParameter("hireDate");
        int salary = 0;
        try {
            salary = Integer.parseInt(salaryStr);
        } catch(Exception e) {
            // 예외 발생시 0(혹은 에러 처리)
        }

        // 2. DTO 생성
        EmployeeDTO dto = new EmployeeDTO(empNo, empName, deptNo, posNo, salary, hireDate);

        // 3. 서비스로 등록 요청
        boolean success = EmployeeService.getInstance().insertEmployee(dto);

        // 4. 등록 후 메인 리스트로 리다이렉트 또는 등록 결과 페이지
        if(success) {
            // 등록 성공시 메인(사원 목록)으로 이동
            return new ModelAndView("/main.do",true);
        } else {
            // 실패시 에러 메시지와 함께 등록 폼으로 다시
        	response.setContentType("text/html;charset=utf-8");
        	response.getWriter().println("<script>"
        			+ "alert('사원정보 등록에 실패하였습니다.');"
        			+ "history.back();"
        			+ "</script>");
        	return null;
        }
	}

}
