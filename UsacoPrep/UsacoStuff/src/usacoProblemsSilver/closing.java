package usacoProblemsSilver; 

/*
ID:johangma
LANG: JAVA
TASK: closing
 */
import java.util.*;
import java.io.*;

public class closing {
	

	
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("closing.in"));
	    
	    ArrayList<HashSet<Barn>> regions  = new ArrayList<HashSet<Barn>>();
	    
	    int N = in.nextInt(); 
	    int M = in.nextInt(); 
	    
		Barn[] barns  = new Barn[N]; 
	    
	    for(int i = 0; i < N; i++) barns[i] = new Barn(i); 
	    
	    for(int i = 0; i < M; i++) {
	    	int barn1 = in.nextInt() - 1; 
	    	int barn2 = in.nextInt() - 1; 
	    	
	    	barns[barn1].neighbors.add(barn2); 
	    	barns[barn2].neighbors.add(barn1); 
	    	
	    }
	    PrintWriter out = new PrintWriter(new File("closing.out"));
	    
	    HashSet<Barn> beenTo = new HashSet<Barn>(); 
	    
	    //finds starting regions
	    int regionNum = 0; 
	    for(int i = 0; i < N; i++) {
	    	if(beenTo.contains(barns[i])) continue;
	    	
	    	regions.add(findRegion(i, regionNum, beenTo, barns));
	    	
	    	regionNum++; 
	    	
	    	
	    }
	    
	    if(regions.size() > 1)  { 
	    	System.out.println("NO"); 
	    
	    }
	    else System.out.println("YES"); 
	    
	    //Now go through removals
	    
	    int placeholder = 0; 

	    for(int i = 0; i < N - 1; i++) {
		    beenTo.clear(); 
		    
		    int removedId = in.nextInt() - 1; 
	    	Barn removed = barns[removedId]; 
	    	
	    	int regionSplit = removed.region + placeholder; 
	    	
	    	HashSet<Integer> neighbors = removed.neighbors; 
	    	
	    	
	    	remove(removedId, barns); 
	    	placeholder--; 
	    	regions.remove(regionSplit); 
	    	for(int j : neighbors) {
	    		if(beenTo.contains(barns[j])) continue;
		    	
		    	regions.add(findRegion(j, regionNum, beenTo, barns));
		    	regionNum++; 
	    	}
	    	
	    	
	    	if(regions.size() > 1) System.out.println("NO"); 
	    	else System.out.println("YES"); 
	    	
	    }

	    
	    in.close();

	    
	     
	
	    out.close();
	}
 	
 	static class Barn {
 		int id; 
 		int region; 
 		HashSet<Integer> neighbors = new HashSet<Integer>(); 
 		
 		Barn(int id) {
 			this.id = id; 
 		}
 	}
 	
 	static void remove(int index, Barn[] barns) {
 		Barn removed = barns[index]; 
 		
 		Set<Integer> connections = removed.neighbors; 
 		
 		for(int barn : connections) {
 			barns[barn].neighbors.remove(index); 
 		}
 		
 		barns[index] = null; 
 	}
 	
 	static HashSet<Barn> findRegion(int start, int regionNum, HashSet<Barn> beenTo, Barn[] barns) {
 		HashSet<Barn> region = new HashSet<Barn>(); 
 		Deque<Barn> queue = new ArrayDeque<Barn>();
 		
 		region.add(barns[start]); 

 		queue.add(barns[start]); 
 		
 		while(!queue.isEmpty()) {
 			Barn barn = queue.remove(); 
 			
 			if(beenTo.contains(barn)) continue;
 			
 			beenTo.add(barn); 
 			region.add(barn); 
 			
 			barn.region = regionNum; 
 			
 			Set<Integer> connections = barn.neighbors;
 			
 			for(int i : connections) {
 				queue.add(barns[i]); 
 			}
 			
 			
 			
 		}
 		
 		return region; 
 	}
 			
}
