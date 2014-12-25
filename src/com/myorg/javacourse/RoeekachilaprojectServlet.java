package com.myorg.javacourse;
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class RoeekachilaprojectServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	
		resp.setContentType("text/html");
		
		//variable declaration
		int firstParamFirstTask, secondParamFirstTask, thirdParamFirstTask, responseFirstTask;
		int firstParamSecondTask,secondParamSecondTask,responseSecondTask;
		String htmlFirstTask, htmlSecondTask;
				
		//variable assignment		
		firstParamFirstTask = 4;
		secondParamFirstTask = 3;
		thirdParamFirstTask = 7;
		responseFirstTask = (firstParamFirstTask + secondParamFirstTask) * thirdParamFirstTask;
		
		firstParamSecondTask = 5;
		secondParamSecondTask = 2;
		responseSecondTask= firstParamSecondTask * secondParamSecondTask;
		
		// preparing HTML tags
		htmlFirstTask = new String("<h1> Result of (" +firstParamFirstTask +"+"+ secondParamFirstTask + ")*" + thirdParamFirstTask + "=" + responseFirstTask + "</h1>" );
		htmlSecondTask = new String("<h1> Result of " +firstParamSecondTask +"*"+ secondParamSecondTask + "=" + responseSecondTask + "</h1>" );

		// add to HTML
		resp.getWriter().println(htmlFirstTask);
		resp.getWriter().println(htmlSecondTask);

		
	}
}
