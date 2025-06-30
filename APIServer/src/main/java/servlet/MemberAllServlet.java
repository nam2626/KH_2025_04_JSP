package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;

import dto.BoardMemberDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardMemberService;

/**
 * Servlet implementation class MemberAllServlet
 */
@WebServlet("/members/*")
public class MemberAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberAllServlet() {    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//BoardMemberMapper 클래스에서 전체 회원정보를 받아오기
		List<BoardMemberDTO> list = BoardMemberService.getInstance().selectAllMember();
		
		//리스트나 배열을 json으로 변경
		JSONArray jsonArray;
		//모든 데이터를 json으로 변경, JSONObject로 데이터를 포장해서 전달
		JSONObject jsonObject = new JSONObject();
		//JSON에 데이터 추가
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		jsonObject.put("date", sdf.format(Calendar.getInstance().getTime()));
		jsonObject.put("list", list);
		jsonObject.put("count", list.size());
		System.out.println(jsonObject);
		
		response.getWriter().println(jsonObject.toString());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//기존 방법
//		String requestBody = new String();
//		String str = "";
//		while((str = req.getReader().readLine()) != null) {
//			requestBody += str;
//		}
		//1.8 이후 방법 : Stream API이용해서 한번 본문 내용 읽어오기
		String requestBody =
				req.getReader().lines().collect(
						Collectors.joining(System.lineSeparator()));
		System.out.println(requestBody);
		//JSON으로 파싱 후 회원정보를 등록
		JSONObject json = new JSONObject(requestBody);
		System.out.println(json.getString("id"));
		System.out.println(json.getString("passwd"));
		System.out.println(json.getString("userName"));
		System.out.println(json.getString("nickName"));
		String id = json.getString("id");
		String passwd = json.getString("passwd");
		String userName = json.getString("userName");
		String nickName = json.getString("nickName");
		//마이바티스로 데이터 추가하고 추가한 결과를 클라이언트에게 전달
		//sql 결과가 1 이면 메세지 : 회원정보 등록 완료
		//          0 이면 메세지 : 회원정보 등록 실패
		BoardMemberDTO dto = new BoardMemberDTO(id, passwd, userName, nickName);
		
		int count = BoardMemberService.getInstance().insertMember(dto);
		JSONObject result = new JSONObject();
		result.put("count", count);
		if(count == 1) {
			result.put("msg", "회원정보 등록 성공");
		}else {
			result.put("msg", "회원정보 등록 실패");
		}
		resp.getWriter().println(result);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//PathVariable 뽑는 방법
		System.out.println(req.getPathInfo().substring(1));
//		System.out.println(req.getPathInfo().replace("/", ""));
		String id = req.getPathInfo().substring(1);
		
		//데이터 삭제 처리
		
		//삭제 성공 했을 때, 해당 데이터 삭제를 완료했습니다.
		
		//삭제 실패 했을 때, 해당 데이터 삭제를 실패하였습니다.
		
	}
	
	
}





