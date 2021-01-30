package usacoProblemsSilver;

import java.util.*;

import usacoProblemsSilver.DanceMooves.Cow; 


public class DanceMooves2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    //Scanner in = new Scanner(new File("dancemooves.in"));
	    
	    Cow[] cows = new Cow[in.nextInt()]; 
	    
	    int K = in.nextInt(); 
	    
	    for(int i = 0; i < cows.length; i++) {
	       	cows[i] = new Cow(i); 
	    	cows[i].visited.add(i); 
	    
	    }
	    
	    for(int i = 0; i < K; i++) {
	    	int cow1 = in.nextInt();
	    	int cow2 = in.nextInt(); 
	    	
	    	cows[cow1].addDest(cows[cow2]); 
	    	cows[cow2].addDest(cows[cow1]); 
	    }
	    
	}
	
	int connections(Cow[] cows, int start) {
		Cow target = cows[start]; 
		
		Deque<Cow> queue = new ArrayDeque<Cow>(); 
		
		for(int i = 0; i < target.dests.length; i++) {
			queue.add(target.dests[i]); 
		}
		
		while(!queue.isEmpty()) {
			Cow curr = queue.getLast(); 
		}
		
		return target.visited.size(); 
	}
	
	static class Cow {
		Cow[] dests; 
		int index; 
		private int curr = 0;
		HashSet<Integer> visited = new HashSet<Integer>(); 
		
		void addDest(Cow cow) {
			dests[curr] = cow; 
			curr++; 
		}

		Cow(int index) {
			this.index = index; 
		}
	}

    
    
    
}

