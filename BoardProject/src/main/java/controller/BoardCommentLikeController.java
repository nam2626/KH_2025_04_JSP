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

public class BoardCommentLikeController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		JSONObject json = new JSONObject();
		// 로그인 체크
		if (session.getAttribute("user") == null) {
			json.put("resultCode", 0);
			json.put("msg", "로그인 하셔야 이용하실 수 있습니다.");
			response.getWriter().println(json);
			return null;			
		}
		int cno = Integer.parseInt(request.getParameter("cno"));
		String id = ((BoardMemberDTO) session.getAttribute("user")).getId();
		
		try {
			BoardService.getInstance().insertBoardCommentLike(cno, id);
			json.put("resultCode", 1);
			json.put("msg", "해당 댓글에 좋아요 하셨습니다.");
		}catch (Exception e) {
			// 좋아요 취소
			BoardService.getInstance().deleteBoardCommentLike(cno, id);
			json.put("resultCode", 1);
			json.put("msg", "해당 댓글에 좋아요를 취소하셨습니다.");
		}finally {
			Map<String, Object> map = 
					BoardService.getInstance().selectBoardCommentLikeHateCount(cno);
			json.put("count", new JSONObject(map));
		}
		response.getWriter().println(json);
		return null;
	}

}
