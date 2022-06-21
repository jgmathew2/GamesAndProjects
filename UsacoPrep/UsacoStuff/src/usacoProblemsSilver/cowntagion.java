package usacoProblemsSilver;

/*
ID:johangma
LANG: JAVA
TASK: CLASS_NAME
 */
import java.util.*;
import java.io.*;

public class cowntagion {
    
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(System.in);
	    //Scanner in = new Scanner(new File("cowntagion.in"));
	    
	    Farm[] farms = new Farm[in.nextInt()]; 
	    
	    for(int i = 0; i < farms.length; i++) {
	    	farms[i] = new Farm(); 
	    }
	    
	    for(int i = 0; i < farms.length - 1; i++) {
	    	int a = in.nextInt() - 1; 
	    	int b = in.nextInt() - 1; 
	    	
	    	farms[a].neighbors.add(farms[b]); 
	    	farms[b].neighbors.add(farms[a]); 
	    
	    }
	    
	    farms[0].infected++; 
	    
	    
	    ArrayDeque<Farm> queue = new ArrayDeque<Farm>(); 
	    
	    queue.add(farms[0]); 
	    
	    HashSet<Farm> beenTo = new HashSet<Farm>(); 
	    int days = 0; 
	    
	    while(!queue.isEmpty()) {
	    	Farm current = queue.remove(); 
	    	Iterator<Farm> iter = current.neighbors.iterator(); 
	    	if(beenTo.contains(current)) continue; 
	    	
	    	beenTo.add(current); 
	    	while(iter.hasNext()) {
	    		if(iter.next().infected > 0) iter.remove(); 
	    	}
	    	int needed = current.neighbors.size(); 
	    	int infected = 1; 
	    
	    	while(infected <= needed) {
	    		infected *= 2; 
	    		days++; 
	    	}
	    	
	    	for(Farm neighbor : current.neighbors) {
	    		neighbor.neighbors.remove(current); 
	    		neighbor.infected++; 
	    		queue.add(neighbor); 
	    		
	    		days++; 
	    	}
	    	
	    	
	    }
	    
	    System.out.println(days); 
	    
	
 	}
 	
 	static class Farm {
 		int infected = 0; 
 		
 		HashSet<Farm> neighbors = new HashSet<Farm>(); 
 	}
	    
	    
}

