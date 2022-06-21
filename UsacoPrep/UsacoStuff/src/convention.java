
/*
ID:johangma
LANG: JAVA
TASK: convention
 */
import java.util.*;
import java.io.*;

public class convention {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("convention.in"));
	    
	    int numCows = in.nextInt(); 
	    int numBuses = in.nextInt(); 
	    int capacity = in.nextInt();
	    Cow[] cows = new Cow[numCows]; 
	    for(int i = 0; i < numCows; i++) {
	    	cows[i] = new Cow(in.nextInt()); 
	    }
	    
	    Arrays.sort(cows);
	    
	    
	    in.close();
	    
	    
	    
	    
	    
	
	    int result = 0;
	    PrintWriter out = new PrintWriter(new File("convention.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
 	
 	static class Cow implements Comparable<Cow> {
 		int arrival;
 		
 		Cow(int arrival) {
 			this.arrival = arrival; 
 		}
 		
 		public int compareTo(Cow other) {
 			return this.arrival - other.arrival; 
 		}
 	}
}
