package usacoProblemsSilver;

import java.io.File;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.*; 

/**
* @author Johan
 * @version Creation time: Apr 2, 2021 4:00:29 PM
 * Class Description
*/

public class lemonade {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("lemonade.in"));
	    int[] cows = new int[in.nextInt()]; 
 		
 		//int[] cows = new int[] {7, 1, 400, 2, 2}; 
	    
 		
	    for(int i = 0; i < cows.length; i++) {
	    	cows[i] = in.nextInt(); 
	    }
	    in.close();
	    
	    
	    
	    Arrays.sort(cows); 
	    
	    int inLine = 0; 
	    
	    for(int i = cows.length - 1; i >= 0; i--) {
	    	if(cows[i] < inLine) {
	    		break; 
	    	}
	    	else inLine++; 
	    }
	
	    int result = inLine;
	    PrintWriter out = new PrintWriter(new File("lemonade.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
}
