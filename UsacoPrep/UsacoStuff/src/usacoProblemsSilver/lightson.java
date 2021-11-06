package usacoProblemsSilver;
/**
* @author Johan
 * @version Creation time: Feb 15, 2021 5:31:22 PM
 * Class Description
*/

import java.util.*;
import java.io.*;

public class lightson {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("lightson.in"));
	    int N = in.nextInt();
	    int M = in.nextInt(); 
	    
	    Switch[][][] switches = new Switch[N][N][M + 1];
	    
	    for(int i = 0; i < switches.length; i++) {
	    	for(int j = 0; j < switches[0].length; j++) {
	    		switches[i][j][0] = new Switch(0, 0); 
	    	}
	    	
	    }
	    
	    
	    for(int i = 0; i < M; i++) {
	    	int a = in.nextInt(); 
	    	int b = in.nextInt(); 
	    	int curr = switches[a][b][0].i; 
	    	switches[a][b][curr] = new Switch(in.nextInt(), in.nextInt()); 
	    	switches[a][b][0].i++; 
	    	
	    }
	    
	    boolean[][] light = new boolean[N][N]; 
	    boolean[][] beenTo = new boolean[N][N]; 
	    
	    light[0][0] = true; 
	    beenTo[0][0] = true; 
	    
	    Deque<Room> queue = new ArrayDeque<Room>(); 
	    
	    queue.add(new Room(0, 0, 1)); 	   
	    
	    
	    while(!queue.isEmpty()) {
	    	Room current = queue.remove(); 
	    	
	    	
	    }
	    
	    

	    
	    in.close();
	
	    int result = 0;
	    PrintWriter out = new PrintWriter(new File("lightson.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
 	
 	static class Switch {
 		int i; 
 		int j; 
 		
 		Switch(int i, int j) {
 			this.i = i; 
 			this.j = j; 
 		}
 	}
 	
 	static class Room {
 		int i; 
 		int j; 
 		int on; 
 		
 		Room(int i, int j, int on) {
 			this.i = i; 
 			this.j = j; 
 			this.on = on; 
 		}
 		
 	}
}

