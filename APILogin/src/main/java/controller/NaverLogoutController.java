package controller;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import view.ModelAndView;

public class NaverLogoutController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		return new ModelAndView("/naver/loginView", true);
	}

}
