package controller;

import java.io.IOException;
import java.net.URLEncoder;

import org.json.JSONObject;

import config.APIConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.NaverCallClass;
import view.ModelAndView;

public class NaverLoginController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String redirectURI = URLEncoder.encode("http://localhost:8888/APILogin/naver/callback", "UTF-8");
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		String apiURL;
		apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
		apiURL += "client_id=" + APIConfig.NAVER_CLIENT_ID;
		apiURL += "&client_secret=" + APIConfig.NAVER_CLIENT_SECRET_ID;
		apiURL += "&redirect_uri=" + redirectURI;
		apiURL += "&code=" + code;
		apiURL += "&state=" + state;
		
		HttpSession session = request.getSession();
		
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
