package algorithmTemplates;

import java.util.*;

/**
* @author Johan
 * @version Creation time: Feb 7, 2021 1:32:15 PM
 * Class Description
*/
public class PracticeProblem {
	
	
	static ArrayList<Integer> findIt(String input, String[] answers, int s, int N) {
			
		HashMap<String, Boolean> answersMap = new HashMap<String, Boolean>(); 
		
		for(int i = 0; i < answers.length; i++) {
			answersMap.put(answers[i], true);
		}
		
		for(int i = 0; i < answers.length - s * N; i++) {
			if(answersMap.get(input.substring(i, i + s))) {
				int j = i + s; 
				while(j < answers.length) {
					if(!answersMap.get(input.substring(j, j + s))) break; 
				}
				
				j += s; 
				
				
			}
		}
		
		return new ArrayList<Integer>(); 
		
		
		
	}

}
