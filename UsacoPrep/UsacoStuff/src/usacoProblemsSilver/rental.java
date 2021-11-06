package usacoProblemsSilver;

import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
* @author Johan
 * @version Creation time: Apr 1, 2021 9:36:12 PM
 * Class Description
*/

public class rental {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("rental.in"));
	    
	    int N = in.nextInt(); 
	    int M = in.nextInt(); 
	    int R = in.nextInt(); 
	    
	    
	    int[] cows = new int[N]; 
	    int[][] prices = new int[M][2]; 
	    int[] rentals = new int[R]; 
	    
	    for(int i = 0; i < cows.length; i++) {
	    	cows[i] = in.nextInt(); 
	    }
	    
	    for(int i = 0; i < M; i++) {
	    	prices[i][0] = in.nextInt(); 
	    	prices[i][1] = in.nextInt(); 
	    }
	    
	    for(int i = 0; i < R; i++) {
	    	rentals[i] = in.nextInt(); 
	    }
	    
	    Arrays.sort(cows); 
	    Arrays.sort(rentals); 
	    
	    
	    in.close();
	
	    int result = 0;
	    PrintWriter out = new PrintWriter(new File("rental.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
}
