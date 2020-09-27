package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beansList;

/**
 * Servlet implementation class addBeansServlet
 */
@WebServlet("/addBeansServlet")
public class addBeansServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addBeansServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String origin = request.getParameter("origin");
		String roast = request.getParameter("roast");
		beansList li = new beansList(origin, roast);
		ListBeanHelper dao = new ListBeanHelper();
		dao.insertBean(li);
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
