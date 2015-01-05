package com.myorg.javacourse;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class MyNewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		resp.setContentType("text/html");
		
		//variable declaration
		int circleRadius = 50;
		double circleArea = Math.PI * Math.pow(circleRadius,2);
		
		double triangleHypotenuse = 50; 
		double triangleAngle = 30;
		double triangleOpposite = Math.toRadians(triangleAngle) * triangleHypotenuse;
		
		int powBase = 20;
		int powExponent= 13;
		
				
		resp.getWriter().println("Area of circle with radius " + circleRadius + " is: " +  new DecimalFormat("#.##").format(circleArea) );
		resp.getWriter().println("<br>");
		resp.getWriter().println("Length of opposite where angle B is " + triangleAngle + " degrees and Hypotenuse length is " + triangleHypotenuse + " cm is: " + new DecimalFormat("#.##").format(triangleOpposite) +" cm");		
		resp.getWriter().println("<br>");
		resp.getWriter().println("Power of " + powBase +" with exp of " + powExponent + " is " + Math.pow(powBase,powExponent));


		
		
		
	}
}
