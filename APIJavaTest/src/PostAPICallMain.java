import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import org.json.JSONObject;

public class PostAPICallMain {
	public static String callAPI(String id, String passwd, 
									String userName, String nickName) {
		String responseBody = "";
//		1. URL 셋팅
		String apiURL = "http://localhost:8888/APIServer/members";

		HttpURLConnection conn = null;
		try {
			URL url = new URL(apiURL);
			//연결 객체 생성
			conn = (HttpURLConnection) url.openConnection();
//		2. 헤더에 인증 및 기타 정보 셋팅
			conn.setRequestMethod("POST");
			//데이터 전송을 위해서 output 설정
			conn.setDoOutput(true);
			
			//전달할 회원 정보 JSONObject 생성
			JSONObject json = new JSONObject();
			json.put("id", id);
			json.put("passwd", passwd);
			json.put("nickName", nickName);
			json.put("userName", userName);

			//서버로 데이터 전송
			conn.getOutputStream().write(json.toString().getBytes(StandardCharsets.UTF_8));
			
			InputStream is = null;
			//3. 요청
			//4. 요청이 정상적으로 처리가 되었는지 체크
			//getResponseCode()나 getInputStream() 이떄 실제 요청
			if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				is = conn.getInputStream();
			}else {
				is = conn.getErrorStream();
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			responseBody = br.lines().collect(
					Collectors.joining(System.lineSeparator()));

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(conn != null)
				conn.disconnect();
		}		
		
		return responseBody;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
