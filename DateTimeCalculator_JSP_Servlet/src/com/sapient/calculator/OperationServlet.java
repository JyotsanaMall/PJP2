package com.sapient.calculator;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OperationServlet
 */
@WebServlet("/OperationServlet")
public class OperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OperationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String choice = request.getParameter("choice");
		String ans = "";
		
		if(choice.equals("1")) {
			Calendar cal1 = DateTimeCalculatorUtils.stringToDate(request.getParameter("date1"));
			Calendar cal2 = DateTimeCalculatorUtils.stringToDate(request.getParameter("date2"));
			if(request.getParameter("operation").equals("+"))
				ans = DateTimeCalculatorUtils.addDates(cal1, cal2);
			else
				ans = DateTimeCalculatorUtils.subDates(cal1, cal2);
		}
		else if(choice.equals("2")) {
			Calendar cal = DateTimeCalculatorUtils.stringToDate(request.getParameter("date"));
			int days = Integer.parseInt((String) request.getParameter("days"));
			if(request.getParameter("operation").equals("-")) 
				days = - days;
			ans = DateTimeCalculatorUtils.addSubDays(cal, days);
		}
		else if(choice.equals("3")) {
			Calendar cal = DateTimeCalculatorUtils.stringToDate(request.getParameter("date"));
			int weeks = Integer.parseInt((String) request.getParameter("weeks"));
			if(request.getParameter("operation").equals("-"))
				weeks = -weeks;
			ans = DateTimeCalculatorUtils.addSubWeeks(cal, weeks);
		}
		else if(choice.equals("4")) {
			Calendar cal = DateTimeCalculatorUtils.stringToDate(request.getParameter("date"));
			int months = Integer.parseInt((String) request.getParameter("months"));
			if(request.getParameter("operation").equals("-"))
				months = -months;
			ans = DateTimeCalculatorUtils.addSubMonths(cal, months);
		}
		else if(choice.equals("5")) {
			Calendar cal = DateTimeCalculatorUtils.stringToDate(request.getParameter("date"));
			int years = Integer.parseInt((String) request.getParameter("years"));
			if(request.getParameter("operation").equals("-"))
				years = -years;
			ans = DateTimeCalculatorUtils.addSubYears(cal, years);
		}
		else if(choice.equals("6")) {
			Calendar cal = DateTimeCalculatorUtils.stringToDate(request.getParameter("date"));
			ans = DateTimeCalculatorUtils.getDay(cal);
		}
		else if(choice.equals("7")) {
			Calendar cal = DateTimeCalculatorUtils.stringToDate(request.getParameter("date"));
			ans = DateTimeCalculatorUtils.getWeekNo(cal);
		}
		else if(choice.equals("8"))
			ans = StringToDate.convert(request.getParameter("phrase"));
		
		request.setAttribute("choice", choice);
		request.setAttribute("ans", ans);
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
