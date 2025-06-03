package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.PositionDTO;
import model.service.PositionService;
import view.ModelAndView;

public class PositionListController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<PositionDTO> posList = PositionService.getInstance().getAllPositions();
        request.setAttribute("posList", posList);
        return new ModelAndView("pos_list.jsp",false);
	}

}
