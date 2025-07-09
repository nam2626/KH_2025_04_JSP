package controller;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.NaverCallClass;
import view.ModelAndView;

public class NaverProfileController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		String token = (String) session.getAttribute("accessToken");
		String header = "Bearer " + token; 
        String apiURL = "https://openapi.naver.com/v1/nid/me";
        
        String result = NaverCallClass.requestNaverServer(apiURL, header);
        request.setAttribute("userInfo",result);

        return new ModelAndView("naver_login_result.jsp", false);
	}

}
