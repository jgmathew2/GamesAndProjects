package usacoProblemsSilver;
import java.util.*; 


public class Frisbee {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		
		int N = in.nextInt(); 
		int[] cows = new int[N]; 
		
		for(int i = 0; i < cows.length; i++) {
			cows[i] = in.nextInt(); 
		}
		in.close(); 
		
		int start = 0; 
		int totalDistance = 0; 
		
		OUTER: while(start < N - 1) {
			int end = start + 1; 
		
			
			int currStart = cows[start]; 
			int currEnd = cows[end]; 
			int between = 0; 
			while(currStart > currEnd) {
				if(currEnd > between) {
					between = currEnd; 
					totalDistance += (end - start + 1); 
				}
				end++; 
			
				
				if(end < N) {
					currEnd = cows[end];
				}
				else { 
					start++; 
					continue OUTER; 
				
				}
			}
			totalDistance += end - start + 1; 
			start++; 
		
		}
		
		System.out.println(totalDistance); 
	}


}
