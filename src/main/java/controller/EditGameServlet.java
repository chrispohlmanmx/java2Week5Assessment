package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.VideoGame;

/**
 * Servlet implementation class EditGameServlet
 */
@WebServlet("/editGameServlet")
public class EditGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditGameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		VideoGameHelper dao = new VideoGameHelper();
		
		String title = request.getParameter("title");
		String system = request.getParameter("system");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		VideoGame gameToUpdate = dao.searchForGameById(tempId);
		
		gameToUpdate.setTitle(title);
		gameToUpdate.setSystem(system);
		
		dao.updateGame(gameToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllGamesServlet").forward(request, response);
		
	}

}
