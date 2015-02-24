package com.myorg.javacourse.servlet;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myorg.javacourse.model.Portfolio;
import com.myorg.javacourse.model.Stock;
import com.myorg.javacourse.service.PortfolioManager;

@SuppressWarnings("serial")
public class PortfolioServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {		
		PortfolioManager portfolioManager1 = new PortfolioManager();
		portfolioManager1.setTitle("Exercise 7 portfolio");
		portfolioManager1.setBalance(10000);		
		portfolioManager1.buyStock("PIH", 10.0f, 8.5f, "15-12-2014",20);
		portfolioManager1.buyStock("AAL", 30.0f, 25.5f, "15-12-2014",30);	
		portfolioManager1.buyStock("CAAS", 20.0f, 15.5f, "15-12-2014",40);	
		
		resp.getWriter().println(portfolioManager1.getPortfolio().getHtmlString());
		portfolioManager1.sellStock("AAL", -1);
		resp.getWriter().println(portfolioManager1.getPortfolio().getHtmlString());
		portfolioManager1.removeStock("CAAS");
		resp.getWriter().println(portfolioManager1.getPortfolio().getHtmlString());
	}
}

