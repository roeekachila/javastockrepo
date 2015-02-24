package com.myorg.javacourse.service;

import java.text.ParseException;

import com.myorg.javacourse.model.Portfolio;
import com.myorg.javacourse.model.Stock;

	public class PortfolioManager {
	
	private Portfolio portfolio;
	
	public PortfolioManager( ) { // zero-parameter c'tor
		portfolio = new Portfolio();		
		portfolio.setTitle("defaultName");	
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
	 
	 public void setBalance(float l_balance) {
			portfolio.setBalance(l_balance);
	    }
	
	 public Portfolio getPortfolio() {
	        return portfolio;
	    }
	 
	 public void sellStock( String symbolToSell, int quantity) {
		 portfolio.sellStock(symbolToSell,quantity);
	    }
	 
	 public void buyStock(String l_symbol,float l_ask,float l_bid, String l_date, int l_stockQuantity) {
			try {
				Stock stock = new Stock(l_symbol, l_ask, l_bid, l_date,l_stockQuantity);
				portfolio.buyStock(stock,l_stockQuantity);

			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	 
		public boolean removeStock( String symbolToRemove )  { 
			 return (portfolio.removeStock(symbolToRemove));
		}

}
