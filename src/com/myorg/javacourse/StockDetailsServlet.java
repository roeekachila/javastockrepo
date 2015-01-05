package com.myorg.javacourse;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class StockDetailsServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		
		String pageContent = "";
		Stock stock1;
		Stock stock2;
		Stock stock3;
		try {
			stock1 = new Stock("PIH", 13.1f, 12.4f, "15-11-2014");
			stock2 = new Stock("AAL", 5.78f, 5.5f, "15-11-2014");
			stock3 = new Stock("CAAS", 32.2f, 31.5f, "15-11-2014");
			
			resp.setContentType("text/html");
			pageContent = stock1.getHtmlDescription();
			pageContent += "<br>";
			pageContent += stock2.getHtmlDescription();
			pageContent += "<br>";
			pageContent += stock3.getHtmlDescription();
			pageContent += "<br>";
		
		}
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.getWriter().println(pageContent);		
	}
}
