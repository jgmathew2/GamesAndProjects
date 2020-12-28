package usacoProblemsBronze;

/*
ID:johangma
LANG: JAVA
TASK: sleepy
 */
import java.util.*;
import java.io.*;

public class sleepy {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("sleepy.in"));
	    int[] positions = new int[in.nextInt()]; 
	    
	    for(int i = 0; i < positions.length; i++) {
	    	positions[i] = in.nextInt(); 
	    }
	    in.close();
	    
	    int time = 0; 
	    
	    outer: for(int i = 0; i < positions.length; i++) {
	    	if(positions[i] > i + 1) {
	    		int[] inserted = new int[positions.length]; 
	    		System.arraycopy(positions, 0, inserted, 0, i - 1);
	    		System.arraycopy(positions, i + 1, inserted, i, positions[i] - 1);
	    		inserted[positions[i]] = positions[i]; 
	    		System.arraycopy(positions, positions[i + 1], inserted, positions[i + 1], positions.length);
	    	
	    	}
	    	time++;
	    	
	    	for(int j = 0; j < positions.length; j++) {
	    		if(positions[j] != j) {
	    			continue outer; 
	    		}
	    	}
	    	break; 
	    }
	
	    int result = time;
	    PrintWriter out = new PrintWriter(new File("sleepy.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
}
