package DS;
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

public class FinalPrint extends HttpServlet{
	private String message;
	
	public void init(){
		this.message = "Hello World";
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<h1>" + message + "<h1>");
//		out.println("<form action=\"/BMI\" method=\"GET\">");
//		out.println("Height: <input type=\"text\" name=\"Height\"><br>");
//		out.println("Weight: <input type=\"text\" name=\"Weight\"><br>");
		
		out.println("<form action=\"/BeatGoogle\" method=\"GET\">");
		out.println("Input Keyword: <input type=\"text\" name=\"Keyword\"><br>");
		
		
		out.println("</form>");
	}
}