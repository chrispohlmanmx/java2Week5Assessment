package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GameLibrary;

/**
 * Servlet implementation class LibraryNavigationServlet
 */
@WebServlet("/librarynavigationservlet")
public class LibraryNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibraryNavigationServlet() {
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
		GameLibraryHelper glh = new GameLibraryHelper();
		String act = request.getParameter("doThisToList");
		
		if(act == null) {
			getServletContext().getRequestDispatcher("/viewAllLibraries").forward(request, response);
		}else if(act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				GameLibrary toDelete = glh.searchForGameLibraryById(tempId);
				glh.deleteLibrary(toDelete);
			}catch(NumberFormatException e) {
				System.out.println("Forgot to make a selection");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllLibraries").forward(request, response);
			}
		}else if(act.equals("add")) {
			getServletContext().getRequestDispatcher("/addLibraryServlet").forward(request, response);
		}
	}

}
