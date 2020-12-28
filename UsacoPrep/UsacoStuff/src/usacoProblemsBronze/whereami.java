package usacoProblemsBronze;

/*
ID:johangma
LANG: JAVA
TASK: whereami
 */
import java.util.*;
import java.io.*;

public class whereami {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("whereami.in"));
	    int houses = in.nextInt();
	    in.nextLine(); 
	    String colors = in.nextLine(); 
	    in.close();
	    
	    int result = 0; 
	    
	    outer: for(int k = 2; k < houses / 2 + 1; k++) {
	    	String pattern = colors.substring(0, k); 
	    	
	    	for(int i = k; i < houses; i++) {
	    		String repeat = colors.substring(i, i + k); 
	    		
	    		if(repeat.equals(pattern)) continue outer; 
	    	}
	    	
	    	result = k; 
	    	break; 
	    	
	    	
	    }
	    
	    if(result == 0) result = houses / 2 + 1; 
	    
	    
	    
	    
	
	   
	    PrintWriter out = new PrintWriter(new File("whereami.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
}
