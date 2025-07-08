package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import dto.BoardMemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.BoardMemberService;
import view.ModelAndView;

public class LoginController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView view = null;
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("pass");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("passwd", passwd);
		BoardMemberDTO member = BoardMemberService.getInstance().login(map);
		System.out.println(member);

		if(member == null) {
			view = new ModelAndView("/loginView.do", true);
		}else {
			view = new ModelAndView("/boardMain.do", true);
			HttpSession session = request.getSession();
			session.setAttribute("user", member);
		}
		
		return view;
	}

}
