package usacoProblemsBronze;

/*
ID:johangma
LANG: JAVA
TASK: measurement
 */
import java.util.*;
import java.io.*;

public class measurement {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("measurement.in"));
	    int[] milkPro = new int[3]; 
	    int[][] changes = new int[3][101]; 
	    for(int i = 0; i < 3; i++) {
	    	milkPro[i] = 7; 
	    }
	    int numOfChanges = in.nextInt(); 
		in.nextLine(); 
	    for(int i = 0; i < numOfChanges; i++) {
	    	
	    	String line = in.nextLine(); 
	    	
	    	String[] milking = line.split(" "); 
	    	
	    	int cow = 0; 
	    	
	    	if(milking[1].equals("Elsie")) cow = 1;  
	    	else if(milking[1].equals("Mildred")) cow = 2; 
	    	
	    	changes[cow][Integer.parseInt(milking[0])] = Integer.parseInt(milking[2]); 
	    }
	    
	    in.close();
	    
	    int current = 0;
	    int highest = 7; 
	    int screenChange = 0; 
	
	    for(int i = 0; i <= 100; i++) {
	    	for(int c = 0; c < 3; c++) {
	    		milkPro[c] += changes[c][i]; 
	    		if(milkPro[c] > highest) {
	    			highest = milkPro[c]; 
	    			current = c; 
	    			screenChange++; 
	    		}
	    	}
	    	
	    }
	    PrintWriter out = new PrintWriter(new File("measurement.out")); 
	    
	    int result = screenChange; 
	
	    System.out.println(result);
	    out.println(result + 1);
	    out.close();
	}
}
