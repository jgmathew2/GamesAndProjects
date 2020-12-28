package usacoProblemsBronze;

/*
ID:johangma
LANG: JAVA
TASK: shell
 */
import java.util.*;
import java.io.*;

public class shell {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("shell.in"));
	    int[] swaps = new int[in.nextInt()]; 
	    int[] guesses = new int[swaps.length]; 
	    
	    for(int i = 0; i < swaps.length; i++) {
	    	swaps[i] = 10 * in.nextInt() + in.nextInt(); 
	    	guesses[i] = in.nextInt(); 
	    }
	    in.close();
	    
	    int highestScore = 0; 
	    
	    for(int i = 1; i < 4; i++) {
	    	int position = i; 
	    	int score = 0; 
	    	
	    	for(int j = 0; j < swaps.length; j++) {
	    		int shell1 = swaps[j] / 10; 
	    		int shell2 = swaps[j] % 10; 
	    		
	    		if(position == shell1) position = shell2; 
	    		else if(position == shell2) position = shell1; 
	    		
	    		if(guesses[j] == position) score++; 
	    	}
	    	
	    	if(score > highestScore) highestScore = score; 
	    }
	    
	    
	
	    int result = highestScore;
	    PrintWriter out = new PrintWriter(new File("shell.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
}
