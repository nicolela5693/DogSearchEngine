package DS;

public class WebScore {
	public String title;
	public double score;
	public String URL;
	
	public WebScore(String title,double score, String URL){
		this.title = title;
		this.score = score;
		this.URL = URL;
	}
	
	@Override 
	public String toString(){
		return"[" + title + ","+ score + "," + URL + "]";
	}

}
