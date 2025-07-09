package servlet;

import java.io.IOException;

import controller.Controller;
import controller.KaKaoHandlerMapping;
import controller.NaverHandlerMapping;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import view.ModelAndView;

@WebServlet(urlPatterns = {"/naver/*","/kakao/*"})
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String rootPath = "/WEB-INF/views/";
	public DispatcherServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 사용자가 요청한 경로
		int n = request.getRequestURI().lastIndexOf("/");
		String command = request.getRequestURI().substring(n + 1);
//		System.out.println("command : " + command);
//		System.out.println(request.getContextPath());
		// 작업을 진행
		Controller controller = null;
		
		if(request.getRequestURI().indexOf("naver") >= 0)
			controller = NaverHandlerMapping.getInstance().createController(command);
		else
			controller = KaKaoHandlerMapping.getInstance().createController(command);
		
		ModelAndView view = null;

		if (controller != null)
			view = controller.execute(request, response);

		// 페이지 이동처리
		if (view != null) {
			if (view.isRedirect()) {
				//	  http://localhost:8888/StudentProject_MVC/main.do
				response.sendRedirect(request.getContextPath() + view.getPath());
			} else {
				//    /WEB-INF/views/student_list.jsp --> 이동할 경로
				request.getRequestDispatcher(rootPath+view.getPath()).forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
