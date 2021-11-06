package usacoProblemsSilver;

/*
ID:johangma
LANG: JAVA
TASK: helpcross
 */
import java.util.*;
import java.io.*;

public class helpcross {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("helpcross.in"));
	    int numChickens = in.nextInt(); 
	    int numCows = in.nextInt(); 
	    
	    Chicken[] chickens = new Chicken[numChickens]; 
	    Cow[] cows = new Cow[numCows]; 
	    
	    HashMap<Integer, Integer> chickens2 = new HashMap<Integer, Integer>(); 
	    for(int i = 0; i < numChickens; i++) {
	    	chickens[i] = new Chicken(in.nextInt()); 
	    }
	    
	    for(int i = 0; i < numCows; i++) {
	    	cows[i] = new Cow( in.nextInt(), in.nextInt()); 
	    }
	    
	    in.close();
	    
	    Arrays.sort(chickens);
	    Arrays.sort(cows);
	    
	    int currCowDone= 0; 
	    int currChickDone = 0; 
	    int numPairs = 0; 
	    
	    while(currCowDone < numCows && currChickDone < numChickens) {
	    	Cow currCow = cows[currCowDone]; 
	    	int chickTime = chickens[currChickDone].time; 
	    	
	    	if(chickTime < currCow.A) {
	    		currChickDone++; 
	    		continue; 
	    	}
	    	
	    	if(chickTime > currCow.B) {
	    		currCowDone++; 
	    		continue; 
	    	}
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    }
	    int result = 0;
	    PrintWriter out = new PrintWriter(new File("helpcross.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
}


class Chicken implements Comparable<Chicken> {
	int time; 
	
	public int compareTo(Chicken chicken) { return this.time - chicken.time; }
	
	Chicken(int time) {this.time = time; }
	
	
	
	
}

class Cow implements Comparable<Cow> {
	int A; 
	int B; 
	
	public int compareTo(Cow cow) {
		
		int diff  = B - A; 
		int othDiff = cow.B - cow.A; 
		
		return diff - othDiff; 
	}
	
	Cow(int A, int B) { this.A = A; this.B = B;} 
}