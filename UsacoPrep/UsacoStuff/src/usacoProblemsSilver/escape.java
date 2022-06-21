package usacoProblemsSilver;

/*
ID:johangma
LANG: JAVA
TASK: escape
 */
import java.util.*;
import java.io.*;

public class escape {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("escape.in"));
	   
	    int N = in.nextInt(); 
	    int[] values = new int[N]; 
	    
	    for(int i = 0; i < values.length; i++) {
	    	values[i] = in.nextInt(); 
	    }
	    
	    int result = 0;
	    
	    for(int i = 0; i < values.length; i++) {
	    	boolean[] available = new boolean[N]; 
	    	
	    	result = Math.max(result, loading(values, available, 0, i)); 
	    }
	    		
	    
	    in.close();
	
	   
	    PrintWriter out = new PrintWriter(new File("escape.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
 	static boolean test(int a, int b) {
 		
 		int count = 10; 
 		
 		while(b > 0 && a > 0) {
 			int aTest = count % 10; 
 			int bTest = count % 10; 
 			if(aTest + bTest >= 10) return false; 
 			a /= 10; 
 			b /= 10; 
 		
 		}
 		
 		return true; 
 	}
 	
 	static int loading(int[] values, boolean[] available, int currentLoad, int currValue) {
 		int count = 1; 
 		
 		int maximum = 0; 
 		available[currValue] = false; 
 		for(int i = 0; i < values.length; i++) {
 			if(!available[i]) continue; 
 			
 			if(test(currentLoad, values[i]) ) {
 				
 				Math.max(maximum, loading(values, available, currentLoad + values[i], i)); 
 			}
 			else {
 				available[i] = false; 
 			}
 		}
 		
 		return count + maximum; 
 	}
}	
 	

/*
 * 
 * 
*/
 

