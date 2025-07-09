package controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import dto.BoardFileDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardService;
import view.ModelAndView;

public class BoardFileDownController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//다운받을 파일 번호를 받아옴
		int fno = Integer.parseInt(request.getParameter("fno"));
		//board_file 테이블에서 전송할 파일 경로를 받아옴
		BoardFileDTO fileDTO = BoardService.getInstance().selectBoardFile(fno);
		response.setHeader("Content-Disposition", 
				"attachement;fileName="+fileDTO.getFileName());
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setContentLength((int) new File(fileDTO.getFpath()).length());
		
		//스트림을 이용해서 파일을 읽은 후, 클라이언트에게 전송
		try(FileInputStream fis = new FileInputStream(fileDTO.getFpath());
			BufferedOutputStream bos = 
					new BufferedOutputStream(response.getOutputStream())){
			byte[] buffer = new byte[1024 * 1024];
			while(true) {
				int size = fis.read(buffer);
				if(size == -1) break;
				bos.write(buffer,0,size);
				bos.flush();
			}
		}
		return null;
	}

}







