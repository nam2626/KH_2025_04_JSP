package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.stream.Collectors;

/**
 * Servlet implementation class NaverSearchServlet
 */
@WebServlet("/book")
public class NaverBookServlet extends HttpServlet {
	private final String clientID="클라이언트 아이디";
	private final String clientSecret="클라이언트 시크릿";
	
    public NaverBookServlet() {    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txt = request.getParameter("text");
		//callNaver 결과를 클라이언트에게 전송
		String result = callNaver(txt);
		System.out.println(txt);
		System.out.println(result);
		response.getWriter().println(result);
	}

	//파라미터 받은 문자열로 네이버 웹문서 검색 수행하는 API를 호출하는 메서드를 하나 작성
	public String callNaver(String search) {
		try {
			//검색어 인코딩
			search = URLEncoder.encode(search, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String apiURL = "https://openapi.naver.com/v1/search/book.json";
		apiURL += "?query="+search;
		HttpURLConnection conn = null;
		String responsebody = "";
		try {
			URL url = new URL(apiURL);
			
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("X-Naver-Client-Id", clientID);
			conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			
			int responseCode = conn.getResponseCode();
			
			BufferedReader br = null;
			
			if(responseCode == HttpURLConnection.HTTP_OK) {
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			}else {
				br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			
			responsebody = br.lines().collect(
					Collectors.joining(System.lineSeparator()));
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responsebody;
	}
}







