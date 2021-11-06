package usacoProblemsSilver;
/**
* @author Johan
 * @version Creation time: Feb 28, 2021 3:15:19 PM
 * Class Description
*/

import java.io.File;
import java.util.*; 
public class TimeTravel {
	
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in); 
		
		//Scanner in = new Scanner(new File("timetravel.in"));
		
		ArrayList<Long> ancestors = new ArrayList<Long>(); 
		
		long N = in.nextInt(); 
		
		long K = in.nextInt();
		long yrs = 0; 
		
		ArrayList<Long> gaps = new ArrayList<Long>(); 

		
		for(int i = 0; i < N; i++) {
			ancestors.add((long)(2021 - in.nextInt())); 
		}
		
		Collections.sort(ancestors);
		
		long currYr = ancestors.get(0); 
		
		if(currYr % 12 > 5) {
			currYr -= (currYr % 12 - 5); 
		}
		else {
			currYr -= (12 - (5 - currYr % 12)); 
		}
		
		K--; 
		
		while(!ancestors.isEmpty()) {
			
			
			
			yrs += 12;
			currYr += 12; 
			
			for(int i = 0; i < ancestors.size(); i++) {
				if(ancestors.get(i) < currYr) {
					ancestors.remove(i);
					i--; 
				}
				else break; 
			}
			
			try {
				if(ancestors.get(0) - ancestors.get(0) % 12 - currYr >= 12) gaps.add(ancestors.get(0) - ancestors.get(0) % 12 - currYr); 
				
				currYr = ancestors.get(0); 
				
				if(currYr % 12 > 5) {
					currYr -= (currYr % 12 - 5); 
				}
				else {
					currYr -= (12 - (5 - currYr % 12)); 
				}
			
			}
			catch(Exception e) {
				//if(2021 - currYr >= 12)	gaps.add(2021 - currYr); 
		
			}
		}
		
		Collections.sort(gaps);
		
		for(int i = 0; i < gaps.size() - K - 1; i++) {
			yrs += gaps.get(i); 
		}
		
		System.out.println(yrs); 
		
		
	}

}
