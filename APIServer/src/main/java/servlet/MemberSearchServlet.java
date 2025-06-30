package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardMemberService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.BoardMemberDTO;

/**
 * Servlet implementation class MemberSearchServlet
 */
@WebServlet("/search")
public class MemberSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberSearchServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String kind = request.getParameter("kind");
		String search = request.getParameter("search");
		System.out.println(kind + " / " + search);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("kind", kind);
		map.put("search", search);
		List<BoardMemberDTO> list = BoardMemberService.getInstance().searchMember(map);
		
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
