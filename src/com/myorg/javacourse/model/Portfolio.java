package com.myorg.javacourse.model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * Represents a Portfolio object.
 * Portfolio may contain stocks and other important data  
 * Portfolio object is used from PortfolioManager object
*/

public class Portfolio {
	// Class Member
	private String title;
	private final int MAX_PORTFOLIO_SIZE = 5;
	private Stock stocks[] = new Stock[MAX_PORTFOLIO_SIZE];
	private int portfolioSize = 0;
	
	private float bid;
	private java.util.Date date;
	SimpleDateFormat dateFormat;
	
	public Portfolio() { // zero-parameter c'tor
		title = "anonymous Portfolio";
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
	}
	
	public Portfolio(String l_title) { // parameter c'tor
		this();
		this.setTitle(l_title);
	}
	
	public Portfolio(Portfolio portfolio) throws ParseException { // copy c'tor	
		this(portfolio.getTitle());	
		for (int i=0; i<portfolio.getPortfolioSize(); i++)
		{
			this.addStock(portfolio.getStocks()[i]);			
		}		
	}
	
	public void setTitle(String myTitle) {
		title = myTitle;
	}
	
	public String getTitle() {
		return(title);
	}
	
	public Stock[] getStocks() {
		return(stocks);
	}
	
	public void deleteStockByIndex(int index) throws ParseException
	{
		Stock tempStocks[] = new Stock[MAX_PORTFOLIO_SIZE];	
		int tempStocksLength = 0;
		for (int i=0; i<portfolioSize; i++)
		{			
			if(i != index)
			{
				tempStocks[tempStocksLength++] = new Stock(stocks[i]);
			}
		}
		stocks = tempStocks;
		portfolioSize--;	
	}
	
	public int getPortfolioSize() {
		return(portfolioSize);
	}
	
	public boolean addStock( Stock newStock ) throws ParseException { // zero-parameter c'tor
		if (portfolioSize < MAX_PORTFOLIO_SIZE)
		{
			stocks[portfolioSize] = new Stock(newStock);			
			portfolioSize++;
			return true;
		}
		return false;
	}
	
	 public Stock[] getArray() {
	        return Arrays.copyOf(stocks, stocks.length);
	    }
	 
	 public String getHtmlString() {
		 	String portfolioHtml;
		 	try {
				portfolioHtml = new String("<h1>" + title + "</h1>");

				for (int i=0; i<portfolioSize; i++)
				{
					portfolioHtml += stocks[i].getHtmlDescription();
					portfolioHtml += "<br>";
				}
				
		        return (portfolioHtml);
		 	} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return ("");

	    }
	 
	 public void setBid(float l_bid) throws ParseException
		{
		 stocks[2].setBid(l_bid);
		}
	

	
	
	
}
