package src.main.java;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JavaWebServlet
 */
@WebServlet("/JavaWebServlet")
public class JavaWebServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JavaWebServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("doGet");
		 request.getRequestDispatcher("Calculator.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num1 = request.getParameter("firstNum");
		String num2 = request.getParameter("secondNum");
		float sum = Float.parseFloat(num1) + Float.parseFloat(num2);
		request.setAttribute("response", true);
		request.setAttribute("sum", sum);
		request.getRequestDispatcher("Calculator.jsp").forward(request, response);
		System.out.println("doPost");
	}

}
