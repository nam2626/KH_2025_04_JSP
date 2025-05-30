package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import view.ModelAndView;

import java.io.IOException;

import controller.Controller;
import controller.HandlerMapping;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자가 요청한 경로
		int n = request.getRequestURI().lastIndexOf("/");
		String command = request.getRequestURI().substring(n+1).replace(".do", "");
		
		//작업을 진행
		Controller controller = HandlerMapping.getInstance().createController(command);
		ModelAndView view = null;
		
		if(controller != null)
			view = controller.execute(request, response);
		
		//페이지 이동처리
		if(view != null) {
			if(view.isRedirect()) {
				response.sendRedirect(view.getPath());
			}else {
				request.getRequestDispatcher(view.getPath()).forward(request, response);
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
