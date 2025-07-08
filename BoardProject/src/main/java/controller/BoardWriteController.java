package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dto.BoardDTO;
import dto.BoardFileDTO;
import dto.BoardMemberDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardService;
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
		File root = new File("c:\\fileupload");
		if(!root.exists()) {
			System.out.println("파일 업로드할 폴더 생성");
			root.mkdirs();
		}		
		//업로할 파일 리스트
		List<BoardFileDTO> fList = new ArrayList<BoardFileDTO>();
		try {
			//업로드할 파일 정보를 읽어옴
			request.getParts().forEach(part -> {
//				파일쓰기
//				System.out.println(part.getName());
//				System.out.println(part.getSize());
//				System.out.println(part.getSubmittedFileName());
				if(part.getSubmittedFileName().isEmpty() || part.getSize() == 0) return;
				//파일 쓰기하는 메서드, 저장할 파일 전체경로
				try {
					String path = root.getAbsolutePath() + "\\" + part.getSubmittedFileName();
					part.write(path);
//					BoardFileDTO 생성 후 리스트로 관리
					fList.add(new BoardFileDTO(0, 0, path));
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			});
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
		//게시글 등록 처리(첨부파일까지 DB에 저장 처리)
		//1. 글번호 뽑음
		int bno = BoardService.getInstance().selectBoardNo();
		//2. 게시판 테이블에 등록 작업
		BoardDTO board = new BoardDTO();
		board.setBno(bno);
		board.setTitle(title);
		board.setContent(content);
		board.setId(id);
		BoardService.getInstance().insertBoard(board);
		//3. 게시판 파일 테이블에 등록 작업 
		BoardService.getInstance().insertBoardFile(fList);		
		//작성 글 확인하는 페이지로 이동(임시로 전체 조회하는 페이지로 이동)
		return new ModelAndView("/boardMain.do", true);
	}

	
	
	
	
	
	
}
