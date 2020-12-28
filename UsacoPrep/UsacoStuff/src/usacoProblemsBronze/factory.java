package usacoProblemsBronze;

/*
ID:johangma
LANG: JAVA
TASK: factory
 */
import java.util.*;
import java.io.*;

public class factory {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("factory.in"));
	    int numStations = in.nextInt(); 
	    boolean[][] connectors = new boolean[numStations][numStations];
	    
	    while(in.hasNextInt()) {
	    	int station1 = in.nextInt(); 
	    	int station2 = in.nextInt();
	 
	    	connectors[station2 - 1][station1 - 1] = true;
	    
	    }
	    in.close();
	    
	    int result = -1;
	    
	  
	    
	    outer: for(int i = 0; i < connectors.length; i++) {
	    	for(int j = 0; j < connectors.length; j++) {
	    		if(connectors[i][j] == false && i != j) {
	    			for(int k = 0; k < connectors.length; k++) {
	    				if(connectors[k][j] == true && connectors[i][k] == true) continue;
	    				
	    			}
	    			continue outer; 
	    			
	    		}
	    	}
	    	
	    	result = i + 1; 
	    	break outer; 
	    }
	
	   
	    PrintWriter out = new PrintWriter(new File("factory.out")); 
	
	
	    out.println(result);
	    System.out.println(result); 
	    out.close();
	}
}
