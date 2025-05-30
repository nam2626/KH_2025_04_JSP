package controller;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dto.BoardMemberDTO;
import model.service.BoardMemberService;
import view.ModelAndView;

public class LoginController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView view = null;
		//1. 사용자로부터 데이터를 받음
		String id = request.getParameter("id");
		String passwd = request.getParameter("pass");
		System.out.println(id);
		System.out.println(passwd);
		
		//2. 작업 처리
		//2-1. Service 클래스로 아이디와 비밀번호 보내서, 로그인 결과는 BoardMemberDTO 받음
		//2-2. BoardMemberDTO 결과가 있으면 로그인 성공
		//2-3. BoardMemberDTO 결과가 없으면 로그인 실패
		BoardMemberDTO member = BoardMemberService.getInstance().login(id,passwd);
		System.out.println(member);
		//3. ModelAndView 생성해서 이동할 페이지 설정
		if(member == null) {
			view = new ModelAndView("./loginView.do", true);
		}else {
			view = new ModelAndView("./", true);
			HttpSession session = request.getSession();
			session.setAttribute("user", member);
		}
		
		return view;
	}

}
