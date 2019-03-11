package DS;

import java.io.IOException;
import java.util.ArrayList;


public class WebPage {
	
	public String URL;
	public String title;
	public WordCounter counter;
	public double score;
	
	public WebPage(String URL, String title ){
		this.URL = URL;
		this.title = title;
		this.counter = new WordCounter(URL);
	}
//	public WebPage(String URL){
//		this.URL = URL;
//		this.counter = new WordCounter(URL);
//	}
	
	
	public void setScore(ArrayList<Keyword> keywords) throws IOException{
	score = 0;
	for(Keyword k : keywords){
		score += counter.countKeyword(k.name) * k.weight;
	}
	
		
	}
		//ArrayList<Keyword>keywords = new ArrayList<Keyword>();
		
}
