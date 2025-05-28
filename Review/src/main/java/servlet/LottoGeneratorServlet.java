package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

@WebServlet("/lottoGenerator")
public class LottoGeneratorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LottoGeneratorServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로또 세트 개수
		int set = Integer.parseInt(request.getParameter("setCount"));
		
		ArrayList<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>();
		Random r = new Random();
		
		for(int i=0;i<set;i++) {
			//로또번호 1셋트 생성
			HashSet<Integer> s = new HashSet<Integer>();
			while(s.size() < 6) {
				s.add(r.nextInt(45)+1);
			}
			list.add(s);
		}
		
		request.setAttribute("lottoNumbers", list);
		request.getRequestDispatcher("./displayLotto.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}






