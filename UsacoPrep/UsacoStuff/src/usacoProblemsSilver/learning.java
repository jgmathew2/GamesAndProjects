package usacoProblemsSilver;



/*
ID:johangma
LANG: JAVA
TASK: learning
 */
import java.util.*;
import java.io.*;

public class learning {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("learning.in"));
	    
	    int numCows = in.nextInt(); 
	    int minWeight = in.nextInt(); 
	    int maxWeight = in.nextInt(); 
	    
	    Cow[] cows = new Cow[numCows]; 
	    in.nextLine(); 
	    for(int i = 0; i < numCows; i++) {
	    	char[] input = in.nextLine().toCharArray(); 
	    	
	    	Cow cow = new Cow(in.nextInt()); 
	    	
	    	if(input[0] == 'S') cow.spotted = true; 
	    	else cow.spotted = false; 
	    	
	    	cows[i] = cow; 
	    }
	    
	    Arrays.sort(cows);
	   
	    in.close();
	
	    int result = 0;
	    
	    boolean current = cows[0].spotted; 
	    
	    if(current) result += cows[0].weight - minWeight; 
	    
	    for(int i = 0; i < cows.length - 1; i++) {
	    	int middle = cows[i].weight + cows[i+1].weight; 
	    	
	    	boolean next = cows[i+1].spotted; 
	    	
	    	if(current && !next) result += middle - cows[i].weight + 1; 
	    	
	    	else if(current && next) result += cows[i + 1].weight - cows[i].weight; 
	    	
	    	else if(!current && next) {
	    		result += cows[i + 1].weight - middle; 
	    	}
	    	
	    	current = next; 
	    	
	    }
	    
	   
	    PrintWriter out = new PrintWriter(new File("learning.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
 	
 	static class Cow implements Comparable<Cow>{
 		boolean spotted; 
 		
 		int weight; 
 		
 		public int compareTo(Cow other) {
 			return this.weight - other.weight; 
 		}
 		
 		Cow(int position) {
 			this.weight = position; 
 		}
 	}
}
