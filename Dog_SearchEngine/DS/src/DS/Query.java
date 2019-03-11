package DS;
import java.io.IOException;

import java.util.HashMap;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;

public class Query {
	
	public String URL;
	public String name;
	public WordCounter counter;
	public double score;
	
	
	public String searchKeyword;
	public String url;
	
	
	public Query(String searchKeyword){
		this.searchKeyword = searchKeyword;
		//this.url = "http://www.google.com/search?q=" + searchKeyword + "&oe=utf8&num=10";
		this.url = "https://ipetgroup.com/Search?k=" + searchKeyword;
		
	}
	
	public HashMap<String, String> query() throws IOException{
		HashMap<String, String> retVal = new HashMap<String, String>();
		Document document = Jsoup.connect(this.url).get();
		
		//URLEncoder.encode(url,"UTF-8");

//		Elements div_rcs = document.select("div.rc");
//		
//		for(Element div_rc : div_rcs){
//			Element h3 = div_rc.select("h3.r").get(0);
//			String title = h3.text();
//			
//			Element cite = div_rc.select("cite").get(0);
//			
//			String citeUrl = cite.text();
//			
//			retVal.put(title, citeUrl);
		
		Elements div_rcs = document.select("div.articleContent");
		  
		  
		  
		  for(Element div_rc : div_rcs){
		   Element h3 = div_rc.select("a").get(0);
		   String title = h3.text();
		   
		   Element cite = div_rc.select("a").first();
		   String linkHref = "https://ipetgroup.com" + cite.attr("href");

		   
		   retVal.put(title, linkHref);
						
		}
		
		return retVal;
	}
	
	


}