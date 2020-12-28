package usacoProblemsBronze;

/*
ID:johangma
LANG: JAVA
TASK: gymnastics
 */
import java.util.*;
import java.io.*;

public class gymnastics {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("gymnastics.in")); 
	    int sessions = in.nextInt(); 
	    int[][] rankings = new int[in.nextInt()][sessions]; 
	    int pairs = 0; 
	    
	    for(int i = 0; i < sessions; i++) {
	    	for(int j = 0; j < rankings.length; j++) {
	    		int cow = in.nextInt(); 
	    		rankings[cow - 1][i] = j;  
	    	}
	    }
	    in.close();
	    
	    for(int i = 0; i < rankings.length; i++) {
	    	cycle: for(int j = 0; j < rankings.length; j++) {
	    		if(i == j) continue; 
	    		int compare = 0; 
	    		if(rankings[i][0] > rankings[j][0]) compare = 1;
	    		else compare = -1; 
	    		
	    		for(int k = 1; k < rankings[i].length; k++) {
	    			if(rankings[i][k] > rankings[j][k] && compare == -1) continue cycle;
	    			else if(rankings[i][k] < rankings[j][k] && compare == 1) continue cycle; 
	    		}
	    		
	    		pairs++; 
	    	}
	    }
	
	    int result = pairs / 2;
	    PrintWriter out = new PrintWriter(new File("gymnastics.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
}
