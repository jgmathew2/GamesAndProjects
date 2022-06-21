package usacoProblemsSilver; 

/*
ID:johangma
LANG: JAVA
TASK: convention2
 */
import java.util.*;
import java.io.*;


//completed
public class convention2 {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("convention2.in"));
	    
	   // Scanner in = new Scanner(System.in); 
	    
	    Cow[] cows = new Cow[in.nextInt()]; 
	    
	    for(int i = 0; i < cows.length; i++) {
	    	cows[i] = new Cow(in.nextInt(), in.nextInt(), i); 
	    }
	    in.close();
	    
	    Arrays.sort(cows, new ArrivalCompare());
	    
	    int longestWaiting = 0; 
	    
	    int currTime = cows[0].arrival; 
	    int nextCow = 1; 
	    PriorityQueue<Cow> queue = new PriorityQueue<Cow>(new SeniorCompare()); 
	
	    queue.add(cows[0]); 
	    
	    while(!queue.isEmpty() || nextCow < cows.length) {
	    	if(queue.isEmpty()) {
	    		currTime = cows[nextCow].arrival; 
	    		queue.add(cows[nextCow]); 
	    		nextCow++; 
	    		continue; 
	    	}
	    	Cow currCow = queue.remove(); 
	    	longestWaiting = Math.max(longestWaiting, currTime - currCow.arrival); 
	    	
	    	currTime += currCow.eating; 
	    	
	    	for(int i = nextCow; i < cows.length; i++) {
	    		if(cows[i].arrival < currTime) {
	    			queue.add(cows[i]); 
	    			nextCow++; 
	    		}
	    		else break; 
	    		
	    	}
	    	
	    	
	    	
	    	
	    }
	   
	
	    int result = longestWaiting;
	    PrintWriter out = new PrintWriter(new File("convention2.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
 	

 	static class Cow {
 		int arrival; 
 		int eating; 
 		int seniority; 
 		
 		
 		Cow(int arrival, int eating, int seniority) {
 			this.arrival = arrival; 
 			this.eating = eating; 
 			this.seniority = seniority; 
 		}
	
 	}
 	
 	static class ArrivalCompare implements Comparator<Cow> {

		public int compare(Cow arg0, Cow arg1) {
			// TODO Auto-generated method stub
			return arg0.arrival - arg1.arrival; 
		}
 		
 	}
 	static class SeniorCompare implements Comparator<Cow> {

		public int compare(Cow arg0, Cow arg1) {
			// TODO Auto-generated method stub
			return arg0.seniority - arg1.seniority; 
		}
 		
 	}

}
