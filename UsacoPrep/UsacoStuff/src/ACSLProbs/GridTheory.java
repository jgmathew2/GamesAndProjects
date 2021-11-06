package ACSLProbs;

import java.util.*; 
/**
* @author Johan
 * @version Creation time: May 8, 2021 10:08:29 PM
 * Class Description
*/
public class GridTheory {
	public static int sumPathsOfLengthN(int num, String edges) {
        ArrayDeque<Path> queue = new ArrayDeque<Path>(); 
        
        String[] stringRoads = edges.split(" ");
        
        int finalSum = 0; 
        
        boolean[][] roads = new boolean[10][10]; 
        
        for(int i = 0; i < stringRoads.length; i++) {
            int road = Integer.parseInt(stringRoads[i]); 
            
            roads[road / 10][road % 10] = true; 
        }
        
        for(int i = 0; i < 9; i++) {
            queue.add(new Path(i + 1, 0)); 
        }
        
        while(queue.isEmpty() == false) {
            Path path = queue.remove(); 
            
            int current = path.previous % 10; 
            int currLength = path.length; 
            int previous = path.previous; 
            
            if(currLength == num) {
            	finalSum += path.previous;
            	continue; 
            }
            	
            
            
            for(int i = 0; i < 10; i++) {
                if(roads[current][i]) {
                	if(roads[current][i]) {
                		if(isRepeat(previous, i) == true) continue; 
                        queue.add(new Path(path.addRoute(i), currLength + 1)); 
                    }
                }
            }
        }
        return finalSum; 
        
    }
	
	public static void main(String[] args) {
		System.out.println(isRepeat(47567, 8)); 
		System.out.println(sumPathsOfLengthN(3, "12 23 34 41 13 32")); 
	
	}
	
	static boolean isRepeat(int previous, int next) {
		if(next > previous) return false; 
		int start = 10; 
		
        while(start < previous) start *= 10; 
        start /= 10; 
        
        while(previous > 0) {
            if(previous / start == next)  return true; 
            else {
                previous %= start; 
                start /= 10; 
            }
        }
        
        return false; 
	}

}


class Path {
    int previous; 
    int length;
    
    Path(int start, int currLength) {
        previous = start; 
        this.length = currLength; 
    } 
    
    int addRoute(int dest) {
        
        return previous * 10 + dest; 
    }
}


