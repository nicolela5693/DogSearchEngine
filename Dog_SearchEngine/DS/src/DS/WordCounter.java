package DS;



import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class WordCounter {
	
	private String urlStr;
	private String content;
	
	
	public WordCounter(String urlStr){
		this.urlStr = urlStr;
			
	}
	
	
	
	private String fetchContent() throws IOException{
		
//		URL url = new URL(this.urlStr);
//				
//		//HttpURLConnection connection = (java.net.HttpURLConnection)url.openConnection();
//		URLConnection connection = url.openConnection();
//		connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
//		InputStream input = connection.getInputStream();
//		BufferedReader br = new BufferedReader(new InputStreamReader(input));
//		
//		String retVal = "";
//		String line = null;
//		
//		while((line = br.readLine()) != null){
//			retVal = retVal + line + "\n";
//
//		}
//		
//		return retVal;
		Document doc = Jsoup.connect(this.urlStr).get();
		
		return doc.toString();
			
	}
	
	public int countKeyword(String keyword) throws IOException{
		if(content == null) content = fetchContent();
		
		content = content.toUpperCase();
		keyword = keyword.toUpperCase();
		
		int retVal = 0;
		int fromIdx = 0;
		int found = -1;
		
		while((found = content.indexOf(keyword, fromIdx)) != -1){
			retVal++;
			fromIdx = found + keyword.length();
		}
		
		return retVal;
	}

}

