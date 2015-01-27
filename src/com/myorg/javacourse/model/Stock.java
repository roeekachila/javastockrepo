package com.myorg.javacourse.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * Represents a stock object.
 * stock object contains many information about its state
 * stock object is stored in a portfolio
*/

public class Stock {
	
	public enum stockState
	{
		BUY,SELL,REMOVE,HOLD
	}
	
	// Class Member
	private String symbol;
	private float ask;
	private float bid;
	private String dateAsString;
	private java.util.Date date;
	SimpleDateFormat dateFormat;
	int recommendation;
	int stockQuantity;
	
	public Stock( ) { // zero-parameter c'tor
	}
	
	public Stock(String l_symbol,float l_ask,float l_bid, String l_date) throws ParseException { // one-parameter c'tor
		symbol = l_symbol;
		ask = l_ask;
	    bid = l_bid;     
	    dateAsString = l_date;
	    
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		date = sdf.parse(l_date);	
	}
	
	public Stock(Stock stock) throws ParseException { // copy c'tor	
		this(stock.getSymbol(),stock.getAsk(),stock.getBid(),stock.getDateAsString());	
//		this("CAAS", 32.2f, 31.5f, "15-11-2014");
	}
	
	
	//Getters and Setters
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public float getAsk() {
		return ask;
	}
	public void setAsk(float ask) {
		this.ask = ask;
	}
	public float getBid() {
		return bid;
	}
	public void setBid(float bid) {
		this.bid = bid;
	}	
	public java.util.Date getDate() {
		return date;
	}

	public String getDateAsString() {
		return dateAsString;
	}
	
	public void setDate(java.util.Date date) {
		this.date = date;
	}

	// Class Method
	public String getHtmlDescription() throws ParseException {		
		return "<b> Stock symbol: </b>" + symbol + ", <b> ask: </b> " +
						ask + ", <b> bid: </b> " + bid + ", <b> date: </b> " +
															dateFormat.format(date) ;	
	}

	
	
}
