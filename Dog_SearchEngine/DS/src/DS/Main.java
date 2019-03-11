package DS;
	
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws IOException{
		
		WebScoreList list = new WebScoreList();
		
		Scanner scanner = new Scanner(System.in);
		String keyword = scanner.nextLine();
		
		ArrayList<Keyword> keywords = new ArrayList<Keyword>();					
		keywords.add(new Keyword(keyword, 10));
		keywords.add(new Keyword("dog", 10));
		keywords.add(new Keyword("ª¯", 10));
		keywords.add(new Keyword("¶Q»«", 2));
		keywords.add(new Keyword("¤ü", 10));
		keywords.add(new Keyword("puppy", 5));
														
		GoogleQuery gQuery = new GoogleQuery(keyword);	
		Query gQuerySecond = new Query(keyword);
		
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
		
	
		list.sort();
		list.output();
					
		scanner.close();
		
		}
}
		
