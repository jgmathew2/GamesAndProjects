package usacoProblemsSilver;

/*
ID:johangma
LANG: JAVA
TASK: skidesign
 */
import java.util.*;
import java.io.*;

public class skidesign {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("skidesign.in"));
	    
	    int cost = Integer.MAX_VALUE; 
	    
	    int[] hills = new int[in.nextInt()]; 
	    
	    for(int i = 0; i < hills.length; i++) {
	    	hills[i] = in.nextInt(); 
	    }
	    in.close();
	    
	    for(int i = 1; i < 84; i++) {
	    	int currentCost = 0; 
	    	
	    	
	    	for(int j = 0; j < hills.length; j++) {
	    		if(hills[j] - i > 17) {
	    			currentCost += Math.pow(hills[j] - i - 17, 2); 
	    		}
	    		else if(hills[j] < i) {
	    			currentCost+= Math.pow(Math.abs(hills[j] - i), 2); 
	    		}
	    	}
	    	
	    	if(currentCost < cost) cost = currentCost; 
	    	
	    }
	
	    int result = cost;
	    PrintWriter out = new PrintWriter(new File("skidesign.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
}
