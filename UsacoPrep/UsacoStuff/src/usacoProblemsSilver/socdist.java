
package usacoProblemsSilver;

/*
ID:johangma
LANG: JAVA
TASK: socdist
 */
import java.util.*;
import java.io.*;

public class socdist {
 	public static void main(String[] args) throws Exception {
 		
 		//finished problem
	    Scanner in = new Scanner(new File("socdist.in"));
	    int numCows = in.nextInt(); 
	    
	    Grass[] grazeSpots = new Grass[in.nextInt()]; 
	    
	    for(int i = 0; i < grazeSpots.length; i++) {
	    	
	    	grazeSpots[i] = new Grass(); 
	    	grazeSpots[i].start = in.nextInt(); 
	    	grazeSpots[i].end = in.nextInt(); 
	    }
	    in.close();
	    
	    Arrays.sort(grazeSpots);
	    
	    int min = 1; 
	    int max = (grazeSpots[grazeSpots.length - 1].end - grazeSpots[0].start) / numCows * 2 + 1; 
	    
	    while(max - min > 1) {
	    	int test = (min + max) / 2; 
	    	
	    	if(testDist(test, numCows, grazeSpots)) min = test; 
	    	else max = test; 
	    }
	    
	    int result = min; 
	    PrintWriter out = new PrintWriter(new File("socdist.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
 	
 	static boolean testDist(int distance, int numCows, Grass[] grazeSpots) {
 		numCows--; 
 		int prevMax = grazeSpots[0].start; 
 		for(int i = 0; i < grazeSpots.length; i++) {
 
 			int currMax = grazeSpots[i].end;
 			
 			
 			
 			while(true) {
 				if(prevMax + distance <= currMax) {
 					if(prevMax + distance < grazeSpots[i].start) prevMax = grazeSpots[i].start;
 					else prevMax += distance; 
 					numCows --; 
 				}
 				else break; 
 			}
 			
			if(numCows <= 0) return true; 
 			
 		}
 		
 		return false; 
 	}
 	
 	static class Grass implements Comparable<Grass> {
 		int start; 
 		int end; 
 		
 		public int compareTo(Grass grass) {
 			return this.start - grass.start; 
 		}
 	}
}
