package usacoProblemsBronze;

/*
ID:johangma
LANG: JAVA
TASK: traffic
 */
import java.util.*;
import java.io.*;

public class traffic {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("traffic.in"));
	    
	    int[][] road = new int[in.nextInt()][3]; 
	    in.nextLine(); 
	    
	    for(int i = 0; i < road.length; i++) {
	    	String[] segment = in.nextLine().split(" "); 
	    	
	    	if(segment[0].equals("on")) road[i][0] = 1; 
	    	else if(segment[0].equals("none")) road[i][0] = 0; 
	    	else road[i][0] = -1; 
	    	
	    	road[i][1] = Integer.parseInt(segment[1]); 
	    	road[i][2] = Integer.parseInt(segment[2]);
	    }

	    in.close();
	
	    
	    int start = 0; 

	    while(road[start][0] != 0) start++; 
	
	    
	    int lower  = road[start][1]; 
	    int higher = road[start][2]; 
	    int origLower = 0; 
		int origHigher = 0;
	    boolean firstRamp = false; 
	    
	    for(int i = start; i < road.length; i++) {
	    	if(firstRamp == false && road[i][0] != 0) {
	    		origLower = lower; 
	    		origHigher = higher;
	    		for(int j = 0; j < start; j++) {
	    			if(road[j][0] == 1) {
		    	    	origLower -= road[j][2]; 
		    	    	origHigher -= road[j][1];
	    			}
	    			else {
	    				origLower += road[j][1]; 
		    	    	origHigher += road[j][2];
	    			}
	    	    }
	    		firstRamp = true;
	    		//continue; 
	    	}
	    	if(road[i][0] == 1) {
	    		lower += road[i][1]; 
    	    	higher += road[i][2];
    	    	continue; 
	    	}
	    	else if(road[i][0] == -1) {
	    		lower -= road[i][2]; 
    	    	higher -= road[i][1];
    	    	continue; 
	    	}
	    	if(road[i][1] > lower) lower = road[i][1]; 
	    	
	    	if(road[i][2] < higher) higher = road[i][2]; 
	    }
	    
	   
	    int afterLower = lower; 
	    int afterHigher = higher; 
	    
	    if(afterLower < 0 ) afterLower = 0; 
	    if(afterHigher < 0) afterHigher = 0; 
	    if(origLower < 0) origLower = 0; 
	    if(origHigher < 0) origHigher = 0; 
	  
	    PrintWriter out = new PrintWriter(new File("traffic.out")); 
	    
	    out.print(origLower + " ");
	    out.println(origHigher); 
	    out.print(afterLower + " ");
	    out.print(afterHigher);

	
	    out.close();
	}
}
