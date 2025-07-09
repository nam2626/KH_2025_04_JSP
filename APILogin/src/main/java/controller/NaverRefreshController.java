package controller;

import java.io.IOException;

import org.json.JSONObject;

import config.APIConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.NaverCallClass;
import view.ModelAndView;

public class NaverRefreshController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		
		String apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=refresh_token"
				+ "&client_id=" + APIConfig.NAVER_CLIENT_ID
				+ "&client_secret=" + APIConfig.NAVER_CLIENT_SECRET_ID
				+ "&refresh_token=" + session.getAttribute("refreshToken");

		String res = NaverCallClass.requestNaverServer(apiURL, null);
		
		if(res != null && !res.equals("")) {
			JSONObject json = new JSONObject(res);
			session.setAttribute("user", res);
			session.setAttribute("accessToken", json.get("access_token"));
			session.setAttribute("refreshToken", json.get("refresh_token"));
		}else {
			request.setAttribute("res", "로그인 실패");
		}
		return new ModelAndView("naver_login_result.jsp", false);
	}

}
