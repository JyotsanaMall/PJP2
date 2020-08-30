package com.sapient.calculator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DateTimeCalculatorServlet
 */
@WebServlet("/DateTimeCalculatorServlet")
public class DateTimeCalculatorServlet extends HttpServlet {
	private static final String OPERATION = "operation";
	private static final long serialVersionUID = 1L;

    public DateTimeCalculatorServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String choice = request.getParameter(OPERATION);
		String destination = OPERATION + choice + ".jsp";
		request.getRequestDispatcher(destination).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
