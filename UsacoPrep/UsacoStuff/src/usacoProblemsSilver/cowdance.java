package usacoProblemsSilver;

/*
ID:johangma
LANG: JAVA
TASK: cowdance
 */
import java.util.*;
import java.io.*;


//    8/10 test cases 
public class cowdance {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("cowdance.in"));
 		
 		//Scanner in = new Scanner(System.in); 
 		
	    Cow[] routines = new Cow[in.nextInt()]; 
	    
	    int maxTime = in.nextInt(); 
	    
	    for(int i = 0; i < routines.length; i++) {
	    	routines[i] = new Cow(in.nextInt()); 
	    }
	    in.close();
	    
	    int min = 1; 
	    int max = routines.length; 
	    
	    while(min + 1 < max) {
	    	int average = (min + max) / 2; 
	    	
	    	if(isPossible(routines, maxTime, average)) {
	    		max = average; 
	    	}
	    	else min = average; 
	    }
	  
	
	    int result = max;
	    PrintWriter out = new PrintWriter(new File("cowdance.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
 	
 	static boolean isPossible(Cow[] routines, int maxTime, int stageSize) {
 		HashSet<Cow> stage = new HashSet<Cow>(); 
 		
 		int i = 0; 
 		int totalTime = 0; 
 		for(int j = 0; i < stageSize; i++) {
 			routines[i].startTime = 0; 
 			
 			stage.add(routines[i]); 
 		}
 		
 		boolean finished = false; 
 		while(!stage.isEmpty()) {
 			int nextCowFinished = Integer.MAX_VALUE; 
 			HashSet<Cow> removal = new HashSet<Cow>(); 
 			int lastCowFinished = Integer.MIN_VALUE; 
 			
 			for(Cow curr : stage) {
 				int willFinish = curr.routine - (totalTime - curr.startTime); 
 				lastCowFinished = Math.max(willFinish, lastCowFinished); 
 				if(willFinish < nextCowFinished) { 
 					nextCowFinished = willFinish; 
 					
 					removal.clear(); 
 					removal.add(curr); 
 						
 				}
 				else if(willFinish == nextCowFinished) removal.add(curr); 
 					
 				
 				
 			}
 			
 			
 			if(!finished) {
 				totalTime += nextCowFinished; 
 				if(totalTime > maxTime) return false; 
 			}
 			else {
 				totalTime += lastCowFinished; 
 				if(totalTime > maxTime) return false; 
 				break; 
 			}
 			
 			
 			int numRemoved = removal.size(); 
 			stage.removeAll(removal);
 		
 			
 			for(int a = 0; a < numRemoved; a++) {
 				try {
	 			
	 				routines[i].startTime = totalTime; 
	 				stage.add(routines[i]); 
	 				i++; 
 				}
 				catch(Exception e) { 
 					finished = true; 
 					continue; 
 				} 
 			}
 			
 			
 			
 		
 			
 			
 		}
 			
 			
 		
 		
 		return true; 
 			
 	}
 	
 	static class Cow {
 		int routine; 
 		int startTime; 
 		
 		Cow(int routine) {
 			this.routine = routine; 
 		}
 	}
 
 	
 	
}
