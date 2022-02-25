package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GameLibrary;
import model.VideoGame;

/**
 * Servlet implementation class CreateNewLibraryServlet
 */
@WebServlet("/createNewLibraryServlet")
public class CreateNewLibraryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewLibraryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		VideoGameHelper vgh = new VideoGameHelper();
		String name = request.getParameter("name");
		System.out.println("Name: " + name);
		
		String[] selectedGames = request.getParameterValues("allGamesToAdd");
		List<VideoGame> selectedGamesInList = new ArrayList<VideoGame>();
		
		if(selectedGames != null && selectedGames.length > 0) {
			for(int i = 0; i<selectedGames.length; i++) {
				System.out.println(selectedGames[i]);
				VideoGame g = vgh.searchForGameById(Integer.parseInt(selectedGames[i]));
				selectedGamesInList.add(g);
			}
		}
		
		GameLibrary gl = new GameLibrary(name, selectedGamesInList);
		
		GameLibraryHelper glh = new GameLibraryHelper();
		glh.insertNewGameLibrary(gl);
		
		System.out.println("Success!");
		System.out.println(gl.toString());
		
		getServletContext().getRequestDispatcher("/viewAllLibraries").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
