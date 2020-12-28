package usacoProblemsBronze;

/*
ID:johangma
LANG: JAVA
TASK: revegetate
 */
import java.util.*;
import java.io.*;

public class revegetate {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("revegetate.in"));
	    int numPastures = in.nextInt(); 
	    int numCows = in.nextInt(); 
	    
	    int[][] pastures = new int[numPastures][numPastures];
	    
	    for(int i = 0; i < numCows; i++) {
	    	int fav1 = in.nextInt(); 
	    	int fav2 = in.nextInt(); 
	    	
	    	pastures[fav1 - 1][fav2 - 1] = 1; 
	    	pastures[fav2 - 1][fav1 - 1] = 1; 
	    }
	    in.close();
	    PrintWriter out = new PrintWriter(new File("revegetate.out")); 
	    
	    pastures[0][0] = 1; 
	    try {
		    if(pastures[1][0] == 1) pastures[1][1] = 2; 
		    else pastures[1][1] = 1; 
		}
	    catch(Exception e) {}; 
	    
	    outer: for(int i = 2; i < pastures.length; i++) {
	    	boolean[] possible = new boolean[4]; 
	    	for(int j = 0; j < i; j++) {
	    		if(pastures[i][j] == 1) {
	    			possible[pastures[j][j] - 1] = true; 
	    		}
	    	}
	    	
	    	for(int k = 0; k < possible.length; k++) {
	    		if(possible[k] == false) {
	    			pastures[i][i] = k + 1; 
	    			continue outer; 
	    		}
	    		
	    	}
	    }
	    
	    for(int i = 0; i < pastures.length; i++) {
	    	out.print(pastures[i][i]);
	    }
	    out.close();
	}
}
