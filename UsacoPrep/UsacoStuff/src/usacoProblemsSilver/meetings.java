package usacoProblemsSilver;



/*
ID:johangma
LANG: JAVA
TASK: meetings
 */
import java.util.*;
import java.io.*;

public class meetings {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("meetings.in"));
	    MeetingCow[] cows = new MeetingCow[in.nextInt()]; 
	    
	    int dest = in.nextInt(); 
	    int totalWeight = 0; 
	    
	    for(int i = 0; i < cows.length; i++) {
	    	cows[i] = new MeetingCow(); 
	    	cows[i].weight = in.nextInt(); 
	    	cows[i].position = in.nextInt(); 
	    	cows[i].direction = in.nextInt(); 
	    	
	    	totalWeight += cows[i].weight; 
	    }
	    in.close();
	    
	    Arrays.sort(cows);
	
	    
	    int stoppedWeight = 0; 
	    
	    int meetings = 0; 
	    
	    while(stoppedWeight < totalWeight / 2) {
	    	for(int i = 0; i < cows.length; i++) {
	    		try {
	    			if(cows[i].position == cows[i + 1].position - 1 
	    					&& cows[i].direction == cows[i + 1].direction + 2) {
	    				cows[i].direction-=2; 
	    				cows[i + 1].direction+=2; 
	    				i++; 
	    				meetings++; 
	    				continue; 
	    			}
	    			else if(cows[i].position == cows[i + 1].position - 2 
	    					&& cows[i].direction == cows[i + 1].direction + 2) {
	    				cows[i].direction-=2; 
	    				cows[i + 1].direction+=2; 
	    				cows[i].position++; 
	    				cows[i + 1].position--; 
	    				meetings++; 
	    				i++; 
	    				continue; 
	    			}
	    			else if(cows[i].position == cows[i + 1].position) {
	    				cows[i].direction-=2; 
	    				cows[i + 1].direction+=2; 
	    				cows[i].position--; 
	    				cows[i + 1].position++; 
	    				meetings++; 
	    				i++; 
	    				continue; 
	    			}
	    		}
	    		catch(IndexOutOfBoundsException e) {}; 
	    		
	    		cows[i].position += cows[i].direction; 
	    		
	    		if(cows[i].direction != 0) {
	    			if(cows[i].position == 0 || cows[i].position == dest) {
	    				cows[i].direction = 0; 
	    				stoppedWeight+= cows[i].weight; 
	    			}
	    				
	    		}
	    		
	    		
	    		
	    	}
	    }
	    

	    int result = meetings; 	    
	    PrintWriter out = new PrintWriter(new File("meetings.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
}

class MeetingCow implements Comparable<MeetingCow> {
	int direction; 
	int position; 
	int weight; 
	
	
	public int compareTo(MeetingCow cow) {
		if(this.position > cow.position) {
			return 1; 
		}
		else if(this.position < cow.position) return -1; 
		else return 0; 
	}
}
