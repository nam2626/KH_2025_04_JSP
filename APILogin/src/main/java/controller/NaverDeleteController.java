package controller;

import java.io.IOException;

import config.APIConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.NaverCallClass;
import view.ModelAndView;

public class NaverDeleteController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();

		String apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=delete" + "&client_id="
				+ APIConfig.NAVER_CLIENT_ID + "&client_secret=" + APIConfig.NAVER_CLIENT_SECRET_ID + "&access_token="
				+ session.getAttribute("accessToken");

		String res = NaverCallClass.requestNaverServer(apiURL, null);
		session.invalidate();
		System.out.println("res : " + res);
		return new ModelAndView("/naver/loginView", true);
	}

}
