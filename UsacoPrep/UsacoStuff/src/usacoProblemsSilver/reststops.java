package usacoProblemsSilver;
/**
* @author Johan
 * @version Creation time: Feb 21, 2021 11:43:56 AM
 * Class Description
*/

import java.util.*;
import java.io.*;

public class reststops {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("reststops.in"));
	    
	    long totalD = in.nextInt(); 
	    int N = in.nextInt(); 
	    long fJSpeed = in.nextInt(); 
	    long bSpeed = in.nextInt(); 
	    
	    RestStop[] stops = new RestStop[N]; 
	    
	    for(int i = 0; i < N; i++) {
	    	stops[i] = new RestStop(in.nextInt(), in.nextInt()); 
	    }
	    
	    Arrays.sort(stops);
	    
	    long currDistance = 0; 
	    
	    long tastyValue = 0; 
	    
	    for(int i = 0; i < stops.length; i++) {
	    	long location = stops[i].location; 
	    	
	    	if(location < currDistance) continue; 
	    	
	    	long time = (fJSpeed - bSpeed) * (location - currDistance); 
	    	
	    	tastyValue += (time * stops[i].value); 
	    	
	    	currDistance = location; 
	    	
	    }
	    
	    in.close();
	
	    long result = tastyValue;
	    PrintWriter out = new PrintWriter(new File("reststops.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
 	
 	static class RestStop implements Comparable<RestStop> {
 		long location; 
 		long value; 
 		
 		RestStop(long location, long value) {
 			this.location = location; 
 			this.value = value; 
 		}
 		
 		public int compareTo(RestStop r) {
 			return (int)(r.value - this.value); 
 		}
 	}
}
