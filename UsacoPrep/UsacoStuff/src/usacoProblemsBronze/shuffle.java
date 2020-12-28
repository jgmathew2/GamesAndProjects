package usacoProblemsBronze;

/*
ID:johangma
LANG: JAVA
TASK: shuffle
 */
import java.util.*;
import java.io.*;

public class shuffle {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("shuffle.in"));
	    int num = in.nextInt(); 
	    
	    
	    
	    int[] ids = new int[num];
	    int[] switches = new int[num];
	    
	    for(int i = 0; i < num; i++) {
	    	switches[i] = in.nextInt(); 
	    }
	    for(int i = 0; i < num; i++) {
	    	ids[i] = in.nextInt(); 
	    }
	    		
	    in.close();
	
	    for(int i = 0; i < 3; i++) {
	    	int[] newIds = new int[num]; 
	    	
	    	for(int j = 0; j < num; j++) {
	    		int target = 0; 
	    		for(int c = 0; c < num; c++) {
	    			if(switches[c] == j + 1) {
	    				target = c; 
	    			}
	    		}
	    		
	    		newIds[target] = ids[j]; 
	    	}
	    	
	    	ids = newIds; 
	    }
	    PrintWriter out = new PrintWriter(new File("shuffle.out")); 
	    
	    for(int i = 0; i < ids.length; i++) {
	    	out.println(ids[i]); 
	    	System.out.println(ids[i]); 
	    }
	
	    out.close();
	}
}
