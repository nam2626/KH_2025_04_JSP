package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mapper.BoardMemeberMapper;

import java.io.IOException;

import dto.BoardMemberDTO;

/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/register.do")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberInsertServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자가 전송한 데이터 받음
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String userName= request.getParameter("username");
		String nickName = request.getParameter("nickname");
		
		BoardMemberDTO dto = new BoardMemberDTO();
		dto.setId(id); dto.setNickName(nickName); 
		dto.setPasswd(passwd); dto.setUserName(userName);
		//Mapper로 회원정보 전달
		BoardMemeberMapper.getInstance().insertMember(dto);
		//all.do 서블릿 호출해서 새 회원정보가 등록되었는지 확인
		response.sendRedirect("./all.do");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}




