package com.myorg.javacourse.model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import com.myorg.javacourse.model.Stock.stockState;

/**
 * Represents a Portfolio object.
 * Portfolio may contain stocks and other important data  
 * Portfolio object is used from PortfolioManager object
*/

public class Portfolio {
	
	// Class Member
	private stockState ALGO_RECOMMENDATION;
	private String title;
	private final int MAX_PORTFOLIO_SIZE = 5;
	private Stock stocks[] = new Stock[MAX_PORTFOLIO_SIZE];
	private int portfolioSize = 0;
	private float balance = 0;

	
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
	
	public int getStockIndex(String symbol) {
		boolean alreadyExists = false;
		int stockIndex = -1;
		for (int i=0; (i<portfolioSize) && (!alreadyExists); i++)
		{
			if ( stocks[i].getSymbol().equals(symbol) ) 
			{
				alreadyExists = true;
				stockIndex = i;
			}
		}
		return (stockIndex);		
	}
	
	public boolean addStock( Stock newStock ) throws ParseException { 
		if (portfolioSize < MAX_PORTFOLIO_SIZE)
		{
			int stockIndex = getStockIndex(newStock.getSymbol());
			if (stockIndex == -1)
			{
				stocks[portfolioSize] = new Stock(newStock);			
				portfolioSize++;
				return true;
			}	
		}
		return false;
	}
	
	public boolean removeStock( String symbolToRemove )  { 
		int stockIndex = getStockIndex(symbolToRemove);
		if (stockIndex != -1)
		{
			boolean soldStock = sellStock(symbolToRemove,-1);
			
			if (!soldStock)
			{
				return false;
			}
			
			if ( stockIndex != (portfolioSize-1) )
			{
				stocks[stockIndex] = stocks[portfolioSize-1];
				stocks[portfolioSize-1] = null;
			}
			else
			{
				stocks[stockIndex] = null;
			}
			portfolioSize--;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean sellStock( String symbolToSell, int quantity)  {
		
		if ((quantity < -1))
		{
			System.out.print("sellStock - negative quantity is forbidden");
			return (false);
		}
		
		int stockIndex = getStockIndex(symbolToSell);
		if (stockIndex == -1)
		{
			System.out.print("sellStock - stock doesn't exists");
			return (false);
		}
			
		int ourStockAmount = stocks[stockIndex].getStockQuantity();
		if (ourStockAmount < quantity)
		{
			System.out.print("sellStock - Not enough stocks to sell");
			return (false);
		}
		
		if (quantity == -1)
		{
			quantity = ourStockAmount;
		}
		
		balance += quantity * stocks[stockIndex].getBid();
		stocks[stockIndex].setStockQuantity(ourStockAmount-quantity);
		return (true);
	}
	
	
	public boolean buyStock( Stock stock, int quantity)  {

		if ((quantity < -1))
		{
			System.out.print("buyStock - negative quantity is forbidden");
			return (false);
		}
		int stockIndex = getStockIndex(stock.getSymbol());
		if (stockIndex == -1) 
		{
			if ( (MAX_PORTFOLIO_SIZE) == portfolioSize ) 
			{
				System.out.print("buyStock - already have max number of stocks");
				return (false);
			}
		}
			
		if (quantity == -1)
		{
			quantity = (int)(balance/stock.getAsk());
		}
		
		if ((quantity * stock.getAsk()) > balance )
		{
			System.out.print("buyStock - not enough money");
			return (false);
		}	
		
		if (stockIndex == -1) 
		{
			stocks[portfolioSize] = stock;
			portfolioSize++;
		}
		else
		{		
			int currentAmount = stocks[stockIndex].getStockQuantity();
			stocks[stockIndex].setStockQuantity(currentAmount + quantity);
		}
		
		balance -= quantity * stock.getAsk();		
		return (true);		 
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
				portfolioHtml += "<br>";
//				portfolioHtml += "Total Portfolio Value: " + getTotalValue() + "$<br>";
//				portfolioHtml += "Total Total Stocks: " + getStocksValue() + "$<br>";
				portfolioHtml += "Total Balance Value: " + getBalance() + "$<br>";
			
		        return (portfolioHtml);
		 	} catch (ParseException e) {
				e.printStackTrace();
			 	return("");
			}
	    }
	 
	 public void setBid(float l_bid) throws ParseException
		{
		 stocks[2].setBid(l_bid);
		}
	 
	 public boolean updateBalance(float amount) 
	{
		 if ( (balance+amount)<0 )
		 {
			 return false;
		 }
		 else
		 {
			 balance += amount;
			 return true;
		 }
	}
	 
	 public float getBalance() {
	        return balance;
	 }
	 
	 public void setBalance(float newValueBalance) {
	         balance = newValueBalance;
	 }
	 
	 public float getStocksValue() {
		 	float totalValue = 0;
			for (int i=0; i<portfolioSize; i++)
			{
				totalValue += stocks[i].getBid() * stocks[i].getStockQuantity();
			}			 	
	        return totalValue;
	 }
	 
	 public float getTotalValue() {		 		 	
	        return (getBalance() + getStocksValue());
	 }
	
	 
	
	
	
}
