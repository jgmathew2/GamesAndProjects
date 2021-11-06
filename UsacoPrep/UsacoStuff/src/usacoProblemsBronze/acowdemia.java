package usacoProblemsBronze;
import java.util.Scanner;

/**
* @author Johan
 * @version Creation time: Apr 4, 2021 6:20:10 PM
 * Class Description
*/
public class acowdemia {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		
		int N = in.nextInt(); 
		
		int surveys = in.nextInt(); 
		
		int pageLimit = in.nextInt(); 
		
		int[] papers = new int[N]; 
		
		for(int i = 0; i < papers.length; i++) {
			papers[i] = in.nextInt(); 
		}
		
		for(int h = 1; h < N; h++) {
			int numAchieved = 0; 
			
			for(int i = 0; i < N; i++) {
				if(papers[i] >= h) numAchieved++; 
			}
			
			//if(numAchieved )
		}
		
		
	}

}
