package usacoProblemsSilver;

/*
ID:johangma
LANG: JAVA
TASK: maxcross
 */
import java.util.*;
import java.io.*;


//completed
public class maxcross {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("maxcross.in"));
	    
	    //Scanner in = new Scanner(System.in); 
	    
	    HashSet<Signal> neighbors = new HashSet<Signal>(); 
	    
	    int N = in.nextInt(); 
	    
	    int K = in.nextInt(); 
	    
	    int broken = in.nextInt(); 
	    
	    int[] locations = new int[broken + 2]; 
	    
	    for(int i = 0; i < broken; i++) {
	    	locations[i + 1] = in.nextInt(); 
	    }
	    
	    locations[0] = 0; 
	    locations[locations.length - 1] = N + 1; 

	    in.close();
	    
	    Arrays.sort(locations);
	    
	    int count = 1; 
	    int space = locations[1] - 1; 
	    int numUsed = 0; 
	    int result = Integer.MAX_VALUE;
	    for (int i = 1; i< locations.length; i++) {
	 
	    	while(space < K && count < broken + 1) {
	    		space += locations[count + 1] - locations[count]; 
	    		count++; 
	    		numUsed++; 
	    
	    	}
	    	
	    	if(space >= K) result = Math.min(result,  numUsed); 
	    	

	    	numUsed--; 
	    	
	    	if(i != broken - 1) space -= locations[i] - locations[i - 1]; 
	    
	    	
	    }
	    
	    /*
	    Signal[] signals = new Signal[broken]; 
	    
	    for(int i = 0; i < signals.length; i++) {
	    	signals[i] = new Signal(); 
	    }
	    
	    Signal previous = signals[0]; 
	    
	    previous.reach = locations[1]; 
	    
	    for(int i = 1; i < broken - 1; i++) {
	    	Signal next = signals[i]; 
	    	previous.neighbors.add(next); 
	    	next.neighbors.add(previous); 
	    	
	    	next.reach = locations[i + 1] - locations[i - 1] - 1; 
	    	
	    	previous = next; 
	    }
	    
	    signals[broken - 1].neighbors.add(previous); 
	    signals[broken - 1].reach = N - locations[broken - 2]; 
	    
	    Arrays.sort(signals);
	    int total = 0; 
	    int numUsed = 0; 
	    for(int i = broken - 1; i >= 0; i--) {
	    	if(neighbors.contains(signals[i])) continue; 
	    	if(total >= K) break; 
	    	
	    	total += signals[i].reach; 
	    	
	    	numUsed++; 
	    	neighbors.addAll(signals[i].neighbors); 
	    }
	    
	    if(total < K) numUsed += K - total; 
	    */
	
	    
	    PrintWriter out = new PrintWriter(new File("maxcross.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
 	
 	static class Signal implements Comparable<Signal> {
 		int reach; 
 		
 		HashSet<Signal> neighbors = new HashSet<Signal>(); 
 		
 		public int compareTo(Signal other) {
 			return this.reach - other.reach; 
 		}
 	}
}
