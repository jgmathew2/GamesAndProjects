package ACSLProbs;
/**
* @author Johan
 * @version Creation time: May 29, 2021 12:32:22 PM
 * Class Description
*/

import java.util.*; 

public class ACSLFinalProb2 {
	
	public static void main(String[] args) {
		System.out.println(find_max_weight("XA 5 AG 1 GX 6 AM 9 MA 6 MG 4 ZM 3 GZ 2")); 
		
	}
	public static int find_max_weight(String graph) {
        int[][] paths = new int[26][26]; 
        
        String[] array = graph.split(" "); 
        
        ArrayList<ArrayList<Integer>> cycles = new ArrayList<ArrayList<Integer>>(); 
        
        Deque<Path> queue = new ArrayDeque<Path>();
        
        
        for(int i = 0; i < array.length; i+= 2) {
            char[] vertice = array[i].toCharArray(); 
            
            paths[vertice[0] - 'A'][vertice[1]-'A'] = Integer.parseInt(array[i+1]); 
            
        }
        
        for(int i = 0; i < paths.length; i++) {
            queue.push(new Path(i)); 
        }
        
        while(queue.size() != 0) {
            Path path = queue.remove();
            
            int current = path.route.get(path.route.size() - 1);  
            
            for(int i = 0; i < paths.length; i++) {
                if(paths[current][i] != 0) {
                    
                	Path next = path.add(i); 
                        
                	if(next == null) {
                		continue; 
                	}
                	
                    if(next.cycle) cycles.add(path.route); 
                        
                    else queue.push(next);  
                    
                    
                }
            }
        }        
        int highestWeight = 0; 
        for(int i = 0; i < cycles.size(); i++) {
            int weight = 0; 
            ArrayList<Integer> cycle = cycles.get(i); 
            for(int j = 0; j < cycle.size() - 1; j++) {
                weight += paths[cycle.get(j)][cycle.get(j + 1)]; 
            }
            
            if(weight > highestWeight) highestWeight = weight; 
        }
        return highestWeight; 
    }
	
	static class Path {
	    ArrayList<Integer> route; 
	    ArrayList<Integer> copy; 
	    boolean cycle; 
	    static int start; 
	    
	    Path(int start, boolean cycle, boolean repeated, ArrayList<Integer> route) {
	        this.start = start; 
	        this.cycle = cycle; 
	        this.route = route;  
	        
	        copy = route; 
	 
	    }
	    
	    Path(int start) {
	        route = new ArrayList<Integer>(); 
	        route.add(start); 
	        
	        cycle = false; 
	      
	        this.start = start; 
	        
	        copy = route; 
	    }
	    
	    Path add(int next) {
	        if(next == route.get(0)) {
	           ArrayList<Integer> copy2 = new ArrayList<Integer>(); 
	           
	           for(int i = 0; i < route.size(); i++) {
	               copy2.add(route.get(i)); 
	           }
	           
	           copy2.add(next); 
	           
	           return new Path(start, true, false, copy2); 
	        } 
	        for(int i = 0; i < route.size(); i++) {
	            if(next == route.get(i)) {
	                return null; 
	            }
	            
	        }
	        
	        ArrayList<Integer> copy = new ArrayList<Integer>(); 
	           
	        for(int i = 0; i < route.size(); i++) {
	            copy.add(route.get(i)); 
	        }
	           
	        copy.add(next); 
	           
	        return new Path(start, false, false, copy); 
	        
	         
	        
	        
	    } 
	}

}

