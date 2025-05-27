package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class TableGeneatorServlet
 */
@WebServlet("/generateTable")
public class TableGeneatorServlet extends HttpServlet {
    public TableGeneatorServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rows = Integer.parseInt(request.getParameter("rows"));
		int cols = Integer.parseInt(request.getParameter("cols"));
		
		request.setAttribute("rows", rows);
		request.setAttribute("cols", cols);
		
		request.getRequestDispatcher("./tableResult.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}





