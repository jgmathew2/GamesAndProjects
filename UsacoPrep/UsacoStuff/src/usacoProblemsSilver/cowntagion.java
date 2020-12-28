package usacoProblemsSilver;

/*
ID:johangma
LANG: JAVA
TASK: CLASS_NAME
 */
import java.util.*;
import java.io.*;

public class cowntagion {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(System.in);
	    //Scanner in = new Scanner(new File("cowntagion.in"));
	    
	    int numCows = in.nextInt(); 
	    int[] fastestRoutes = new int[numCows + 1]; 
	    
	    for(int i = 2; i < fastestRoutes.length; i++) {
	    	fastestRoutes[i] = -1; 
	    }
;	    
	    int[][] bridges = new int[numCows][2];
	    
	    for(int i = 0; i < bridges.length - 1; i++) {
	    	bridges[i][0] = in.nextInt(); 
	    	bridges[i][1] = in.nextInt(); 
	    }
	    
	    int time = 0; 
	    int k = 0; 
	    
	    while(Math.pow(2, k) < numCows) k++; 
	    time = k; 
	    
	    time += numCows - 1; 
	    
	    /*
	    int beenTo = 1; 
	    int dist = 1; 
	    while(beenTo < numCows) {
	    	for(int i = 0; i < bridges.length; i++) {
	    		if(fastestRoutes[bridges[i][0]] != -1 && fastestRoutes[bridges[i][1]] == -1) {
	    			fastestRoutes[bridges[i][1]] = dist; 
	    			beenTo++; 
	    		}
	    	}
	    	
	    	dist++; 
	    }
	    
	    for(int i = 0; i < fastestRoutes.length; i++) {
	    	time += fastestRoutes[i]; 
	    }
	     
	    */
	    
	    
	    in.close();
	
	    int result = time;
	
	    System.out.println(result);
	  
	}
}

