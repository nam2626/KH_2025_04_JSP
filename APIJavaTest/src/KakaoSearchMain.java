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

import org.json.JSONArray;
import org.json.JSONObject;

public class KakaoSearchMain {
	private static String REST_API_KEY = "REST API KEY";
	
	public static String callKakaoAPI(String searchText) {
		String responseBody = "";
//		1. URL 셋팅
		String apiURL = "https://dapi.kakao.com/v2/search/web";
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
			conn.setRequestProperty("Authorization", "KakaoAK d77c810e173c3afbf300da53d245b731");

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
		String result = callKakaoAPI("해수욕장");
//		5. 화면에 받아온 데이터를 출력
		System.out.println(result);
		
		JSONObject json = new JSONObject(result);
		JSONArray arr = json.getJSONArray("documents");
		arr.forEach(item -> {
			JSONObject obj = (JSONObject) item;
			System.out.println(obj.getString("title"));
			System.out.println(obj.getString("datetime"));
			System.out.println(obj.getString("contents"));
			System.out.println(obj.getString("url"));
			System.out.println("-------------------------------");
		});
	}
}





