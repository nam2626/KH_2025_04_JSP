import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.stream.Collectors;

import org.json.JSONObject;

public class NaverImgSearchMain {
	private static String clientID = "클라이언트 아이디";
	private static String clientSecret = "클라이언트 시크릿";
	
	public static String callNaverAPI(String searchText) {
		String responseBody = "";
//		1. URL 셋팅
		String apiURL = "https://openapi.naver.com/v1/search/image";
		try {
			searchText = URLEncoder.encode(searchText, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		apiURL += "?query=" + searchText;
		HttpURLConnection conn = null;
		try {
			URL url = new URL(apiURL);
			//연결 객체 생성
			conn = (HttpURLConnection) url.openConnection();
//		2. 헤더에 인증 및 기타 정보 셋팅
			conn.setRequestMethod("GET");
			conn.setRequestProperty("X-Naver-Client-Id", clientID);
			conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);

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
		String result = callNaverAPI("해수욕장");
		System.out.println(result);
		JSONObject json = new JSONObject(result);
		json.getJSONArray("items").forEach(item -> {
			JSONObject obj = (JSONObject) item;
			System.out.println(obj.getString("title"));
			System.out.println(obj.getString("link"));
		});
	}

}


