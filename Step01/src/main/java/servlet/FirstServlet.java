package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//아래 설정한 경로로 URL로 요청이 들어오면
//해당 서블릿 클래스가 동작하게끔 처리하는 어노테이션
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
       
    public FirstServlet() {
        super();
    }

    //GET 방식으로 요청했을때 처리하는 메서드
    //웹 브라우저에서 주소창을 직접 입력하거나, 링크를 클릭했을때 주로 사용.
    //URL 경로를 통해 호출되었을때 처리됨
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	//POST 방식으로 요청했을때 처리하는 메서드
	//폼 데이터를 전송할 때(method를 POST로 설정한 경우)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
