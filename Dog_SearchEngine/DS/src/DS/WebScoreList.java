package DS;


import java.util.ArrayList;

public class WebScoreList {
	
	private ArrayList<WebScore> list;
	
	public WebScoreList(){
		this.list = new ArrayList<WebScore>();
	}
	
	public void add(WebScore k){
		list.add(k);
		
	}
	
	public void sort(){
		this.list = quickSort(this.list);
		
	}
	
	private ArrayList<WebScore>quickSort(ArrayList<WebScore> list){
		if(list.size() < 2) return list;
		ArrayList<WebScore> result = new ArrayList<WebScore>();
		
		int pivotIndex = list.size()/2;
		WebScore pivotKeyword = list.get(pivotIndex);
		
		ArrayList<WebScore> lessList = new ArrayList<WebScore>();
		ArrayList<WebScore> equalList = new ArrayList<WebScore>();
		ArrayList<WebScore> greaterList = new ArrayList<WebScore>();
		
		for(int i = 0; i < list.size(); i++){
			WebScore webScore = list.get(i);
			if(webScore.score > pivotKeyword.score){
				greaterList.add(webScore);
			}
			else if(webScore.score < pivotKeyword.score){
				lessList.add(webScore);
			}
			else{
				equalList.add(webScore);
			}
		}
		
		result.addAll(quickSort(greaterList));
		result.addAll(equalList);
		result.addAll(quickSort(lessList));
		
		return result;		
		
 	}
	
	public void output(){
		StringBuilder sBuilder = new StringBuilder();
		
		for(int i = 0; i < list.size(); i++){
			WebScore webScore = list.get(i);
			if(i > 0) sBuilder.append(" \n");
			sBuilder.append(webScore.toString());
		}
		System.out.println(sBuilder);
	}
	
	

}
