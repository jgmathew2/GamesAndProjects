package usacoProblemsSilver;

/*
ID:johangma
LANG: JAVA
TASK: planting
 */
import java.util.*;


import java.io.*;


//  8 / 10 cases
public class planting {
 	public static void main(String[] args) throws Exception {
 		
	    Scanner in = new Scanner(new File("planting.in"));
	    
	    int N = in.nextInt(); 
	    Field[] fields = new Field[N]; 
	    
	    
	    
	    for(int i = 0; i < N; i++) {
	    	fields[i] = new Field(i); 
	    }
	    

	    for(int i = 0; i < N - 1; i++) {
	    	int field1 = in.nextInt() - 1; 
	    	int field2 = in.nextInt() - 1; 
	    	
	    	fields[field1].neighbors.add(field2); 
	    	fields[field2].neighbors.add(field1); 
	    }
	    
	    
	    in.close();
	    
	    HashSet<Field> beenTo = new HashSet<Field>(); 
	    Deque<Field> queue = new ArrayDeque<Field>(); 
	    
	    queue.add(fields[0]); 
	    fields[0].justPrevious.add(0); 
	    
	    while(!queue.isEmpty()) {
	    	Field current = queue.remove(); 
	    	
	    	
	    	if(beenTo.contains(current)) continue; 
	    	
	    	beenTo.add(current); 
	    	
	    	int i = 1; 
	    	while(true) {
	    		if(current.previous.contains(i)) i++; 
	    		else break; 
	    	}
	    	
	    	current.type = i; 
	    	
	    	
	    	for(int j : current.neighbors) {
	    		
	    		for(int k : fields[j].neighbors) {
	    			
	    			fields[k].previous.add(current.type); 
	    			
	    		}
	    		fields[j].justPrevious.add(current.type); 
	    		fields[j].previous.add(current.type); 
	    		
	    		fields[j].previous.addAll(current.justPrevious); 
	    		
	    		queue.add(fields[j]); 
	    	}
	    	
	    	
	    	
	    }
	    
	    int result = 0;
	    
	    for(int i = 0; i < fields.length; i++) {
	    	if(fields[i].type > result) result = fields[i].type; 
	    }
	
	   
	    PrintWriter out = new PrintWriter(new File("planting.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
 	
 	static class Field {
 		HashSet<Integer> neighbors; 
 		int type; 
 		HashSet<Integer> previous;
 		HashSet<Integer> justPrevious; 
 		int id; 
 	
 		
 		Field(int id) {
 			neighbors = new HashSet<Integer>(); 
 			previous = new HashSet<Integer>(); 
 			justPrevious = new HashSet<Integer>(); 
 			this.id = id; 
 		}
 		
 		
 	}
 	
}


