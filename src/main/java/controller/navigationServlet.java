package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.VideoGame;

/**
 * Servlet implementation class navigationServlet
 */
@WebServlet("/navigationServlet")
public class navigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public navigationServlet() {
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
		String act = request.getParameter("doThisToGame");
		
		String path = "/viewAllGamesServlet";
		
		VideoGameHelper dao = new VideoGameHelper();
		
		if(act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				VideoGame gameToDelete = dao.searchForGameById(tempId);
				dao.deleteGame(gameToDelete);
			}catch(NumberFormatException e) {
				System.out.println("Forgot to select a game.");
			}
			
		}else if(act.equals("edit")){
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				VideoGame gameToEdit = dao.searchForGameById(tempId);
				request.setAttribute("gameToEdit", gameToEdit);
				path="/edit-game.jsp";
			}catch(NumberFormatException e) {
				System.out.println("Forgot to select a game.");
			}
		}else if(act.equals("add")) {
			path="/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}
}
