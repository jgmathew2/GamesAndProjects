package usacoProblemsSilver;

/*
ID:johangma
LANG: JAVA
TASK: pairup
 */
import java.util.*;
import java.io.*;


//completed 
public class pairup {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("pairup.in"));
 		//Scanner in = new Scanner(System.in); 
 		ArrayList<Cow> cows = new ArrayList<Cow>(); 
	    int N = in.nextInt(); 
	    for(int i = 0; i < N; i++) {
	    	cows.add(new Cow(in.nextInt(), in.nextInt())); 
	    }
	    
	    Collections.sort(cows);
	    
	    
	    int minCow = 0; 
	    int maxCow = cows.size() - 1; 
	    
	    int maxTime = Integer.MIN_VALUE; 
	    
	    while(minCow != maxCow) {
	    	Cow earlyCow = cows.get(minCow); 
	    	Cow lateCow = cows.get(maxCow); 
	    	
	    	if(earlyCow.number > lateCow.number) {
	    		earlyCow.number -= lateCow.number; 
	    		maxCow--; 
	    		maxTime = Math.max(earlyCow.production + lateCow.production, maxTime); 
	    	}
	    	else if(earlyCow.number < lateCow.number) {
	    		lateCow.number -= earlyCow.number; 
	    		minCow++; 
	    		maxTime = Math.max(earlyCow.production + lateCow.production, maxTime); 
	    	}
	    	else {
	    		maxCow--; 
	    		minCow++; 
	    		maxTime = Math.max(earlyCow.production + lateCow.production, maxTime); 
	    	}
	    }
	    
	    maxTime = Math.max(minCow + maxCow, maxTime); 
	    in.close();
	
	    int result = maxTime;
	    PrintWriter out = new PrintWriter(new File("pairup.out")); 
	
	    System.out.println(result);
	    out.println(result);
	 
	    out.close();
	}
 	
 	static class Cow implements Comparable<Cow> {
 		int number; 
 		int production; 
 		
 		public int compareTo(Cow other) {
 			return this.production - other.production; 
 		}
 		
 		Cow(int number, int production) {
 			this.number = number; 
 			this.production = production;
 		}
 	}
}

