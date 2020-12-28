package usacoProblemsSilver;

/*
ID:johangma
LANG: JAVA
TASK: CLASS_NAME
 */
import java.util.*;
import java.io.*;

public class rectpasture {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(System.in);
	    //Scanner in = new Scanner(new File("rectpasture.in"));
	    int[][] cows = new int[in.nextInt()][2]; 
	    
	    for(int i = 0 ; i < cows.length; i++) {
	    	cows[i][0] = in.nextInt(); 
	    	cows[i][1] = in.nextInt(); 
	    }
	    in.close();
	 
	    long result = (long) Math.pow(2, cows.length);
	    
	    for(int i = 0; i < cows.length; i++) {
	    	for(int j = i + 1; j < cows.length; j++) {
	    		for(int k = i + 1; k < cows.length; k++) {
	    			if(cows[i][0] < cows[k][0] && cows[k][0] < cows[j][0] && cows[k][1] < cows[j][1]
	    					&& cows[k][1] > cows[i][1]) {
	    				result -= (cows.length - 2 - i);
	    				
	    			}
	    		}
	    	}
	    }
	    
	    
	    System.out.println(result); 
	    
	}
}
