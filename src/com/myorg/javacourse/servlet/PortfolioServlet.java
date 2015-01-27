package com.myorg.javacourse.servlet;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myorg.javacourse.model.Stock;
import com.myorg.javacourse.service.PortfolioManager;

@SuppressWarnings("serial")
public class PortfolioServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {		
		try {
			PortfolioManager portfolioManager1 = new PortfolioManager();
			portfolioManager1.setTitle("portfolio1");
			PortfolioManager portfolioManager2 = new PortfolioManager(portfolioManager1);
			portfolioManager2.setTitle("portfolio2");
			
			resp.getWriter().println(portfolioManager1.getPortfolio().getHtmlString());	
			resp.getWriter().println(portfolioManager2.getPortfolio().getHtmlString());	
			
			portfolioManager1.deleteStockByIndex(0);
			
			resp.getWriter().println(portfolioManager1.getPortfolio().getHtmlString());	
			resp.getWriter().println(portfolioManager2.getPortfolio().getHtmlString());	
		
			portfolioManager2.setBid(55.55f);
			
			resp.getWriter().println(portfolioManager1.getPortfolio().getHtmlString());	
			resp.getWriter().println(portfolioManager2.getPortfolio().getHtmlString());	

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}

