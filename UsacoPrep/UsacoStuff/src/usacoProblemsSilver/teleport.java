package usacoProblemsSilver; 

/*
ID:johangma
LANG: JAVA
TASK: teleport
 */
import java.util.*;
import java.io.*;

public class teleport {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("teleport.in"));
	    
	    ArrayList<Poop> all = new ArrayList<Poop>(); 
	    ArrayList<Integer> testing = new ArrayList<Integer>(); 
	    
	    int N = in.nextInt(); 
	    
	    for(int i = 0; i < N; i++) {
	    	int start = in.nextInt(); 
	    	int end = in.nextInt(); 
	    	
	    	int distance = Math.abs(end - start); 
	    	
	    	int distance2 = Math.abs(end); 
	    	int distance3 = Math.abs(start); 
	    	
	    	all.add(new Poop(start, end)); 
	    	
	    	if(distance2 < distance || distance3 < distance) {
	    		testing.add(start); 
	    		testing.add(end); 
	    	}
	    }
	    
	    Collections.sort(testing);
	    
	    int min = 0; 
	    int max = testing.size(); 
	    
	    int minD = Integer.MAX_VALUE; 
	    
	    
	    for(int i = 0; i < testing.size(); i++) {
	    	int D = findD(all, testing.get(i));
	    	
	    	minD = Math.min(D, minD); 
	    	
	    	
	    }
	     /*
	    while(min < max) {
	    	int test = (min + max) / 2; 
	    	int test2 = (min + max) / 2 + 1; 
	    }
	    
	    */
	    
	    
	    
	    in.close();
	
	    int result = minD;
	    PrintWriter out = new PrintWriter(new File("teleport.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
 	
 	static class Poop implements Comparable<Poop> {
 		int start; 
 		int end; 
 		
 		public int compareTo(Poop poop) {
 			return (this.end - this.start) - (poop.end - poop.start); 
 		}
 		
 		Poop(int start, int end) {
 			this.start = start; 
 			this.end = end; 
 		}
 		
 	}
 	
 	static int findD(ArrayList<Poop> poop, int teleport) {
 		int D = 0; 
 		
 		for(Poop curr : poop) {
 			int start = curr.start; 
 			int end = curr.end; 
 			
 			int path1 = Math.abs(end - start); 
 			int path2 = Math.abs(teleport - start) + Math.abs(end); 
 			int path3 = Math.abs(start) + Math.abs(teleport - end); 
 			
 			int min1 = Math.min(path1, path2); 
 			int min2 = Math.min(min1, path3); 
 			
 			D += min2; 
 		}
 		
 		return D; 
 		
 		
 	}
}
