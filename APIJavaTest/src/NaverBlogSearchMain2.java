import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class NaverBlogSearchMain2 {
    public static void main(String[] args) {
        String clientId = "클라이언트 아이디"; //애플리케이션 클라이언트 아이디
        String clientSecret = "클라이언트 시크릿"; //애플리케이션 클라이언트 시크릿
        String searchText = "8월 연휴";

        try {
            // 통합된 API 호출 메서드 호출
            String responseBody = callNaverBlogSearchApi(clientId, clientSecret, searchText);
            System.out.println(responseBody);

            // JSON 결과 파싱 및 출력
            JSONObject json = new JSONObject(responseBody);
            json.getJSONArray("items").forEach(t -> {
                JSONObject j = (JSONObject) t;
                System.out.println(j.getString("title"));
                System.out.println(j.getString("link"));
                System.out.println(j.getString("bloggername"));
                System.out.println("---------------");
            });
        } catch (RuntimeException e) {
            System.err.println("API 호출 또는 처리 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 네이버 블로그 검색 API를 호출하고 응답 본문을 문자열로 반환합니다.
     * 이 메서드는 검색어 인코딩, URL 구성, 헤더 설정, HTTP 요청 수행, 응답 읽기 등
     * 전체 프로세스를 캡슐화합니다.
     *
     * @param clientId 네이버 API 클라이언트 ID.
     * @param clientSecret 네이버 API 클라이언트 시크릿.
     * @param searchText 검색할 텍스트.
     * @return API로부터 받은 응답 본문을 문자열로 반환합니다.
     * @throws RuntimeException 인코딩, URL 구성, 연결 또는 응답 읽기 중 오류가 발생하면 발생합니다.
     */
    public static String callNaverBlogSearchApi(String clientId, String clientSecret, String searchText) {
        String encodedText;
        try {
            encodedText = URLEncoder.encode(searchText, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패: " + searchText, e);
        }

        String apiURL = "https://openapi.naver.com/v1/search/blog?query=" + encodedText;

        HttpURLConnection con = null;
        try {
            URL url = new URL(apiURL);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            Map<String, String> requestHeaders = new HashMap<>();
            requestHeaders.put("X-Naver-Client-Id", clientId);
            requestHeaders.put("X-Naver-Client-Secret", clientSecret);

            for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            int responseCode = con.getResponseCode();
            InputStream responseStream;

            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                responseStream = con.getInputStream();
            } else { // 오류 발생
                responseStream = con.getErrorStream();
            }

            // 응답 본문 읽기
            try (BufferedReader lineReader = new BufferedReader(new InputStreamReader(responseStream))) {
                StringBuilder responseBody = new StringBuilder();
                String line;
                while ((line = lineReader.readLine()) != null) {
                    responseBody.append(line);
                }
                return responseBody.toString();
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다: " + apiURL, e);
        } catch (IOException e) {
            throw new RuntimeException("URL에 대한 API 요청 및 응답 실패: " + apiURL, e);
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
    }
}