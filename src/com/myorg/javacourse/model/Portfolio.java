package com.myorg.javacourse.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import com.myorg.javacourse.Stock;

public class Portfolio {
	// Class Member
	private String title;
	private final int MAX_PORTFOLIO_SIZE = 5;
	private Stock stocks[] = new Stock[MAX_PORTFOLIO_SIZE];
	private int portfolioSize = 0;
	
	private float bid;
	private java.util.Date date;
	SimpleDateFormat dateFormat;
	
	public Portfolio( String myTitle) { // zero-parameter c'tor
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
		title = myTitle;
	}
	
	public boolean addStock( Stock newStock ) { // zero-parameter c'tor
		if (portfolioSize < MAX_PORTFOLIO_SIZE)
		{
			stocks[portfolioSize] = newStock;
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
	

	
	
	
}
