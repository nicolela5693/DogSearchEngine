package DS;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BeatGoogle extends HttpServlet{
	
	public void init(){
		
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
//		int height = Integer.parseInt(request.getParameter("Height"));
//		int weight = Integer.parseInt(request.getParameter("Weight"));
		
		String keyword = request.getParameter("Keyword");
		
		
		out.println("</form>");
	}
	
//	public double getBMI(int height,int weight){
//		return weight/Math.pow((float)height/100.0, 2);
//	}
	
	public void getWeb(String keyword) throws IOException{
		WebScoreList list = new WebScoreList();
			
		
		ArrayList<Keyword> keywords = new ArrayList<Keyword>();					
		keywords.add(new Keyword(keyword, 10));
		keywords.add(new Keyword("dog", 10));
		keywords.add(new Keyword("ª¯", 10));
		keywords.add(new Keyword("¶Q»«", 2));
		keywords.add(new Keyword("¤ü", 10));
		keywords.add(new Keyword("puppy", 5));
														
		GoogleQuery gQuery = new GoogleQuery(keyword);	
		Query gQuerySecond = new Query(keyword);
//		GoogleQuerySecond gQuerySecond = new GoogleQuerySecond(keyword);
		
		ArrayList<WebPage> webPages = new ArrayList<WebPage>();				
		ArrayList<WebTree> webTrees = new ArrayList<WebTree>();	
		for(Object key : gQuery.query().keySet()){		
			String link = gQuery.query().get(key);
			
		
			WebPage rootPage = new WebPage(link,"" + key);
			webPages.add(rootPage);
			WebTree tree = new WebTree(rootPage);
			try{
			webTrees.add(tree);
			tree.setPostOrderScore(keywords);
			//tree.eularPrintTree();
			}
			catch(java.net.MalformedURLException e){
				
			}
			
			catch(java.io.IOException e){
				
			}
			catch(Exception e){
				
			}	
			
			list.add(new WebScore(rootPage.title,rootPage.score,rootPage.URL));
			
			
		}
		
		for(Object key : gQuerySecond.query().keySet()){		
			String link = gQuerySecond.query().get(key);
			
		
			WebPage rootPage = new WebPage(link,"" + key);
			webPages.add(rootPage);
			WebTree tree = new WebTree(rootPage);
			try{
			webTrees.add(tree);
			tree.setPostOrderScore(keywords);
			//tree.eularPrintTree();
			}
			catch(java.net.MalformedURLException e){
				
			}
			
			catch(java.io.IOException e){
				
			}
			catch(Exception e){
				
			}	
			
			list.add(new WebScore(rootPage.title,rootPage.score,rootPage.URL));
		}
		
//		for(Object key : gQuerySecond.query().keySet()){		
//			String link = gQuerySecond.query().get(key);
//			
//		
//			WebPage rootPage = new WebPage(link,"" + key);
//			webPages.add(rootPage);
//			WebTree tree = new WebTree(rootPage);
//			webTrees.add(tree);
//			tree.setPostOrderScore(keywords);
//			//tree.eularPrintTree();
//			
//			list.add(new WebScore(rootPage.title,rootPage.score));
//			
//			
//		}
		
		list.sort();
		list.output();
	}
	
	
				
	
	
}
