package controller;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.PositionDTO;
import model.service.PositionService;
import view.ModelAndView;

public class PositionInsertController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		   String posNo = request.getParameter("posNo");
	        String posName = request.getParameter("posName");

	        PositionDTO dto = new PositionDTO(posNo, posName);
	        boolean result = PositionService.getInstance().insertPosition(dto);

	        if (result) {
	            // 등록 성공 시 전체 직급 리스트로 리다이렉트
	            return new ModelAndView("/posList.do",true);
	        } else {
	        	response.setContentType("text/html;charset=utf-8");
	        	response.getWriter().println("<script>"
	        			+ "alert('직급 등록에 실패하였습니다.');"
	        			+ "history.back();"
	        			+ "</script>");
	        	return null;
	        }
	}

}
