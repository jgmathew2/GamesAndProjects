package usacoProblemsSilver;

/*
ID:johangma
LANG: JAVA
TASK: cowcode
 */

//9/10 test cases 


import java.util.*;
import java.io.*;

public class cowcode {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("cowcode.in"));
	    
	    String[] input = in.nextLine().split(" "); 
	    
	    String code = input[0]; 
	    
	    long letter = Long.parseLong(input[1]) - 1; 
	    
	    
	    in.close();
	    
	    long length = code.length();
	   
	    
	    while(length < letter) {
	    	length *= 2; 
	    }
	    
	    length /= 2; 
	    
	    while(letter >= code.length()) {
	    	while(letter <= length) {
	    		length /= 2; 
	    	}
	    	
	    	letter = letter - length - 1; 
	    }
	    
	    
	    if(letter < 0) letter += code.length(); 
	    
	    

		
		
	
	   
	    PrintWriter out = new PrintWriter(new File("cowcode.out")); 
	
	    
	    char result = code.charAt((int)letter); 
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
}
