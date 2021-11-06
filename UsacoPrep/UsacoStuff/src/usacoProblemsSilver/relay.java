package usacoProblemsSilver;
/**
* @author Johan
 * @version Creation time: Oct 2, 2021 5:23:24 PM
 * Class Description
*/
import java.util.*;
import java.io.*;

//tested + completed fully
public class relay {
	public static void main(String[] args) throws Exception {
      
	    //input stuff
	    Scanner in = new Scanner(new File("relay.in"));
	    int[] messages = new int[in.nextInt()]; 
	    
	    int[] routes = new int[messages.length]; 
	    
	    for(int i = 0; i < routes.length; i++) {
	        routes[i] = in.nextInt() - 1; 
	    }
	    in.close();
	    
	    
	    //Actually gets path 
	    
	    for(int i = 0; i < messages.length; i++) {
	        if(messages[i] != 0) continue; 
	        
	        HashSet<Integer> route = new HashSet<Integer>(); 
	        
	        route.add(i); 
	        
	        int current = i; 
	        
	        while(true) {
	            int next = routes[current]; 
	            
	            if(next == -1 || messages[next] == 1) {
	                changeArray(messages, route, 1); 
	                break;
	            } 
	            
	            if(route.contains(next) || messages[next] == -1) {
	                changeArray(messages, route, -1); 
	                break; 
	            }
	            
	            route.add(next); 
	            current = next; 
	        }
	    }
	    
	    
	    
	    
	    //gets result based on paths
	    
	
	    int result = 0;
	    
	    for(int i = 0; i < messages.length; i++) {
	        if(messages[i] == 1) result++; 
	    }
	    
	    PrintWriter out = new PrintWriter(new File("relay.out"));
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
	
	static void changeArray(int[] array, HashSet<Integer> indices, int newInt) {
	    for(Integer i : indices) {
	        array[i] = newInt; 
	    }
	}
}


