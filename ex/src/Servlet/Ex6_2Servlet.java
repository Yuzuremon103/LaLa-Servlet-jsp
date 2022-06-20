package Servlet;


import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ex62")
public class Ex6_2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int randomNum = new Random().nextInt(10);
//		int randomNum = (int)(Math.random() * 10);
		System.out.println(randomNum);
		
		if (randomNum % 2 == 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/forwarded.jsp");
			dispatcher.forward(request, response);
//			response.sendRedirect("/ex/forwarded.jsp");
//			return;
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/redirected.jsp");
			dispatcher.forward(request, response);
		}
	}


}
