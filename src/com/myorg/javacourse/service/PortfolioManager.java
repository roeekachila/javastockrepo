package com.myorg.javacourse.service;

import java.text.ParseException;

import com.myorg.javacourse.model.Portfolio;
import com.myorg.javacourse.model.Stock;

	public class PortfolioManager {
	
	private Portfolio portfolio;
	
	public PortfolioManager( ) { // zero-parameter c'tor
		portfolio = new Portfolio();		
		portfolio.setTitle("Roee portfolio");
		try {
			Stock stock1 = new Stock("PIH", 13.1f, 12.4f, "15-11-2014");
			Stock stock2 = new Stock("AAL", 5.78f, 5.5f, "15-11-2014");
			Stock stock3 = new Stock("CAAS", 32.2f, 31.5f, "15-11-2014");
			portfolio.addStock(stock1);
			portfolio.addStock(stock2);
			portfolio.addStock(stock3);			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public PortfolioManager( PortfolioManager portfolioManager) throws ParseException { // copy c'tor
		portfolio = new Portfolio(portfolioManager.getPortfolio());
	}
	
	public void deleteStockByIndex(int index) throws ParseException
	{
		portfolio.deleteStockByIndex(index);
	}
	
	public void setBid(float l_bid) throws ParseException
	{
		portfolio.setBid(l_bid);
	}
	
		
	 public void setTitle(String l_title) {
		 portfolio.setTitle(l_title);
	    }
	
	 public Portfolio getPortfolio() {
	        return portfolio;
	    }

}
