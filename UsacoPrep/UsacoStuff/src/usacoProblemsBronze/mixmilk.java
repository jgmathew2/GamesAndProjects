package usacoProblemsBronze;
/*
ID:johangma
LANG: JAVA
TASK: mixmilk
*/
import java.util.*;
import java.io.*;

public class mixmilk {
	public static void main(String[] args) throws Exception {
	
	    Scanner in = new Scanner(new File("mixmilk.in"));
	   
	    int[][] buckets = new int[3][2]; 
	    
	    
	    for(int i = 0; i < 3; i++) {
	    	buckets[i][0] = in.nextInt(); 
	    	buckets[i][1] = in.nextInt(); 
	    }
	    in.close();
	    
	    int currB = 0;
	    int nextB = 1; 
	    
	    for(int i = 0; i < 100; i++) {
	    	int cap1 = buckets[currB][0];
	    	int cap2 = buckets[nextB][0]; 
	    	
	    	int leftOver = buckets[currB][1] - (cap2 - buckets[nextB][1]);
	    	
	    	if(leftOver <= 0) {
	    		buckets[nextB][1] += buckets[currB][1]; 
	    		buckets[currB][1] = 0; 
	    	}
	    	else {
	    		buckets[nextB][1] = cap2; 
	    		buckets[currB][1] = leftOver; 
	    	}
	    	
	    	currB++; 
	    	nextB++; 
	    	
	    	if(currB == 3) currB = 0; 
	    	if(nextB == 3) nextB = 0; 
	    }
	

	    PrintWriter out = new PrintWriter(new File("mixmilk.out")); 
	
	    for(int i = 0; i < 3; i++) {
	    	out.println(buckets[i][1]); 
	    	//System.out.println(buckets[i][1]); 
	    }
	    
	    out.close();
	}
}