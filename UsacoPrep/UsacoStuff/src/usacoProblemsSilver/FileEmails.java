package usacoProblemsSilver;


/*
ID:johangma
LANG: JAVA
TASK: FileEmails
 */
import java.util.*;
import java.io.*;

public class FileEmails {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(System.in);
	    

	    
	    int T = in.nextInt(); 
	    
	    OUTER: for(int i = 0 ; i < T; i++) {
	    	
		    LinkedHashSet<Integer> screen = new LinkedHashSet<Integer>(); 
		    
	    	int M = in.nextInt(); 
	    	int N = in.nextInt(); 
	    	int K = in.nextInt(); 
	    	
	    	int[] emails = new int[N]; 
	    	
	    	for(int j = 0; j < N; j++) {
	    		emails[j] = in.nextInt(); 
	    	}
	    	
	    	int currEnd = K; 
	    	int nextEmail = K;
	    
	    	
	    	for(int a = 0; a < nextEmail; a++) {
	    		if(emails[a] <= currEnd) nextEmail++; 
	    		else {
	    			screen.add(emails[a]); 
	    		}
	    	}
	    	boolean scrolled = false; 
	    	int scrolledEmail = 0; 
	    	INNER: while(nextEmail < N || !screen.isEmpty()) {
	    		
    			currEnd++; 
    			if(scrolled) {
					currEnd--; 
				}
    			if(nextEmail == N) {
    				if(screen.contains(currEnd)) {
    					screen.remove(currEnd) ;
    				}
    				continue INNER; 
    			}
    			if(screen.contains(currEnd)) {
    				
    				screen.remove(currEnd); 
    				
    				while(nextEmail < N && emails[nextEmail] <= currEnd) {
    					if(emails[nextEmail] < currEnd - K) {
    						System.out.println(false); 
    						continue OUTER; 
    					}
    					
    					if(scrolled) {
    						if(scrolledEmail <= currEnd) {
    							nextEmail++; 
    						}
    						else {
    							continue INNER; 
    						}
    					
    					}
    					else nextEmail++; 
    				}
    				
    				if(nextEmail < N)screen.add(emails[nextEmail]); 
    		
    			}
    			else {
    				if(scrolled) {
    					System.out.println(false); 
    					continue OUTER; 
    				}
    				
    				scrolled = true; 
    				scrolledEmail = screen.iterator().next(); 
    				screen.remove(scrolledEmail); 
    				
    				screen.add(emails[nextEmail]); 
    				nextEmail++; 
    				
    				
    				
    			}
	    		
	    	
	    		
	    	}
	    	
	    	System.out.println(true); 
	    	
	    	
	    	
	    	
	    }
	    
	    in.close();
	
	   
	}
}
