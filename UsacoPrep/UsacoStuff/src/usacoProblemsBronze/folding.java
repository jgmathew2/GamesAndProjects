package usacoProblemsBronze;

import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
* @author Johan
 * @version Creation time: Sep 16, 2021 12:45:22 PM
 * Class Description
*/
 public class folding {
	 	public static void main(String[] args) throws Exception {
		    Scanner in = new Scanner(new File("folding.in"));
		  
		    int[] knots = new int[in.nextInt()]; 
		    int length = in.nextInt(); 
		    
		    for(int i = 0; i < knots.length; i++) {
		    	knots[i] = in.nextInt(); 
		    }
		    in.close();
		    
		    Arrays.sort(knots);
		    
		    int[] distances = new int[knots.length - 1]; 
		    int foldpoints;  
		    if(distances.length > 1) foldpoints = 2; 
		    else foldpoints = 1; 
		  
		    
		    for(int i = 0; i < distances.length; i++) {
		    	distances[i] = knots[i + 1] - knots[i]; 
		    }
		    
		    
		    
		    outer: for(int i = 2; i < distances.length + knots.length - 2; i++) {
		    	if(i % 2 == 0) {
		    		int b = i/2; 
		    		int a = b - 1; 
		    		
		    		while(b < distances.length && a >= 0) {
		    			if(distances[a] != distances[b]) continue outer; 
		    			b++; 
		    			a--; 
		    		}
		    	}
		    	else {
		    		int a = i/2 - 1; 
		    		int b = i/2 + 1; 
		    		
		    		while(b < distances.length && a >= 0) {
		    			if(distances[a] != distances[b]) continue outer; 
		    			b++; 
		    			a--; 
		    		}
		    	}
		    	
		    	foldpoints++; 
		    }
		
		    
		    PrintWriter out = new PrintWriter(new File("folding.out")); 
		
		    System.out.println(foldpoints);
		    out.println(foldpoints);
		    out.close();
		}
	}
