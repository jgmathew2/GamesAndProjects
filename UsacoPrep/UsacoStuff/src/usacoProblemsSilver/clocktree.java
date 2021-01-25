package usacoProblemsSilver; 

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*; 


public class clocktree {
	static int[][] corridors; 
	public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("clocktree.in"));
        
        int N = in.nextInt();
        
        Room[] rooms = new Room[N];
        for (int i = 0; i < N; i++) {
            rooms[i] = new Room(in.nextInt());
            
        }
        corridors = new int[N - 1][2];
        for (int i = 0; i < N-1; i++) { // coridoors
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            
            corridors[i][0] = a; 
            corridors[i][1] = b; 
            
            rooms[a].addRoom(rooms[b]);
            rooms[b].addRoom(rooms[a]);
        }
        
        in.close(); 
        
        
   
        int solutions = 0; 
        
 
        
        outer: for(int i = 0; i < rooms.length; i++) {
        	Deque<Room> test = new ArrayDeque<Room>();  
        	
        	Room[] copy = clone(rooms); 
        	
        	test.add(copy[i]);
        	
        	boolean started = false; 
        	
        	while(!test.isEmpty()) {
        		Room current = test.pop();
        		
        		
        		
        		if(started) current.clock++; 
        		else {
        			started = true; 
        		}
        		
        		if(current.clock > 12) current.clock -= 12;  
        		
        		if(current.connectedRooms.isEmpty()) {
                	if(current.clock == 12 || current.clock == 1) {
                		solutions++; 
                		 
                	}
                	continue outer;
        		}
        		//boolean continuing = false;
        		
        		if(current.connectedRooms.size() == 1) {
        			Room next = current.connectedRooms.get(0); 
        			
        			next.clock += (12 - current.clock); 
        			
        			test.push(next);
        			next.removeRoom(current);
        			
        			     			
        		}
        		
        		else {
        			ArrayList<Room> connected = current.connectedRooms; 
        			
        			Random random = new Random(); 
        			
        			int index = random.nextInt(connected.size()); 
        			
        			Room next = connected.get(index); 
        			test.push(next);

        		}
        		
        		//if(continuing) test.push(current); 
        	}
        	
        	
        	
        }
        PrintWriter out = new PrintWriter(new File("clocktree.out")); 
        
        out.println(solutions); 
        
        out.close(); 
    }
    
    static Room[] clone(Room[] array) {
    	Room[] copy = new Room[array.length];
    	
    	for(int i = 0; i < copy.length; i++) {
    		copy[i] = new Room(array[i].clock); 
    	}
    	
    	for(int i = 0; i < corridors.length; i++) {
    		int a = corridors[i][0];
    		int b = corridors[i][1]; 
    		copy[a].addRoom(copy[b]);
            copy[b].addRoom(copy[a]);
    	}
    	
    	return copy; 
    	
    	
    }
    static class Room {
        int clock;
        ArrayList<Room> connectedRooms;
        
        Room(int clock) {
            this.clock = clock;
            this.connectedRooms = new ArrayList<>();
        }
        
        void addRoom(Room r) {
            this.connectedRooms.add(r);
        }
        void removeRoom(Room r) {
        	this.connectedRooms.remove(r); 
        }
    }
}
