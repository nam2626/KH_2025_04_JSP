package controller;

import java.io.IOException;

import dto.BoardMemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import view.ModelAndView;

public class BoardWriteController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//title, content 파라미터롤 읽어옴
		String title = request.getParameter("title");
		String content= request.getParameter("content");
				
		//작성자 ID --> 세션에 있는 BoardMemberDTO 값으로 읽어옴
		BoardMemberDTO member = (BoardMemberDTO) request.getSession().getAttribute("user");
		String id = member.getId();
		
		System.out.println(title + "\n" + content + "\n" + id);
		
		//파일 업로드 처리
		
		//파일 업로드할 경로가 있는지 체크, 없으면 해당 경로를 생성
		
		//업로드할 파일 정보를 읽어옴
		
		//	파일쓰기
		
		//	BoardFileDTO 생성 후 리스트로 관리
		
		//게시글 등록 처리(첨부파일까지 DB에 저장 처리)
		
		//작성 글 확인하는 페이지로 이동(임시로 전체 조회하는 페이지로 이동)
		
		return null;
	}

	
	
	
	
	
	
}
