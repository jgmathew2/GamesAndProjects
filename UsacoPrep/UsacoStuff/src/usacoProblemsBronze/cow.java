package usacoProblemsBronze;

/*
ID:johangma
LANG: JAVA
TASK: cow
 */
import java.util.*;
import java.io.*;

public class cow {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("cow.in"));
	    in.nextLine(); 
	    String code = in.nextLine(); 
	    in.close();
	    
	    long cows = 0; 
	    
	    for(int i = 0; i < code.length(); i++) {
	    	if(code.charAt(i) == 'C') {
	    		for(int j = i + 1; j < code.length(); j++) {
	    			if(code.charAt(j) == 'O') {
	    				for(int k = j + 1; k < code.length(); k++) {
	    					if(code.charAt(k) == 'W') cows++; 
	    				}
	    			}
	    		}
	    	}
	    }
	
	    long result = cows;
	    PrintWriter out = new PrintWriter(new File("cow.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
}
