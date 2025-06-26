package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

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
@WebServlet("/all.do")
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


}





