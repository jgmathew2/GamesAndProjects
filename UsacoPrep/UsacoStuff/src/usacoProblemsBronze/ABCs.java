package usacoProblemsBronze;

/*
ID:johangma
LANG: JAVA
TASK: ABCs
 */
import java.util.*;
import java.io.*;

public class ABCs {
 	public static void main(String[] args) {
 		
 		//System.out.println("hello"); 
	    Scanner in = new Scanner(System.in);
	    
	    int[] values = new int[7]; 
	    
	    for(int i = 0; i < values.length; i++) {
	    	values[i] = in.nextInt(); 
	    }
	    
	    in.close(); 
	  
	    
	    Arrays.sort(values);
	    
	    int a = values[0]; 
	    int b = values[1]; 
	    
	    int c = 0; 
	    
	    if(values[2] == a + b) c = values[3];
	    else c = values[2]; 

	
	    System.out.print(a + " ");
	    System.out.print(b + " ");
	    System.out.print(c);
	   
	}
}
