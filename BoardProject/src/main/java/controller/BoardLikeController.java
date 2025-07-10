package controller;

import java.io.IOException;
import java.util.Map;

import org.json.JSONObject;

import dto.BoardMemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.BoardService;
import view.ModelAndView;

public class BoardLikeController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		HttpSession session = request.getSession();
		BoardMemberDTO member = (BoardMemberDTO) session.getAttribute("user");
		JSONObject json = new JSONObject();
		//로그인 체크
		if(member == null) {
			json.put("resultCode", 0);
			json.put("msg", "로그인 하셔야 이용하실 수 있습니다.");
			response.getWriter().println(json);
			return null;
		}
		
		BoardService.getInstance().insertBoardLike(bno, member.getId());
		
		Map<String, Object> map = BoardService.getInstance().selectBoardLikeHateCount(bno);
		System.out.println(map);
		json.put("count", new JSONObject(map));
		json.put("resultCode", 1);
		json.put("msg", "해당 게시글에 좋아요 하셨습니다.");
		response.getWriter().println(json);
		return null;
	}

}




