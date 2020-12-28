package usacoProblemsBronze;

/*
ID:johangma
LANG: JAVA
TASK: buckets
 */
import java.util.*;
import java.io.*;

public class buckets {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("buckets.in"));
	    char[][] layout = new char[10][10]; 
	    ArrayDeque<BucketsCow> qeue = new ArrayDeque<BucketsCow>(); 
	    for(int i = 0; i < layout.length; i++) {
	    	layout[i] = in.nextLine().toCharArray(); 
	    }
	    
	    int destX = 0;
	    int destY = 0; 
	    BucketsCow solution = new BucketsCow(); ; 
	    
	    for(int i = 0; i < 10; i++) {
	    	for(int j = 0; j < 10; j++) {
	    		if(layout[i][j] == 'B') qeue.add(new BucketsCow(i, j, 0)); 
	    		
	    		if(layout[i][j] == 'L') {
	    			destX = i; 
	    			destY = j; 
	    		}
	    	}
	    }
	    in.close();
	    
	    
	    while(qeue.isEmpty() == false) {
	    	
	    	BucketsCow current = qeue.remove();
	    	if(current.x == destX && current.y == destY) {
	    		solution = current; 
	    		break; 
	    	}
	    	int distance = current.distance + 1; 
	    	ArrayList<BucketsCow> path = new ArrayList<BucketsCow>(); 
	    	
	    	for(int i = 0; i < current.path.size(); i++) {
	    		path.add(current.path.get(i));
	    		
	    	}
	    	
	    	path.add(current); 
	    	try {
		    	if(layout[current.x + 1][current.y] != 'R') {
		    		qeue.add(new BucketsCow(current.x + 1, current.y, distance, path)); 
		    	}
	    	}
	    	catch(Exception e) {}; 
	    	try {
		    	if(layout[current.x - 1][current.y] != 'R') {
		    		qeue.add(new BucketsCow(current.x - 1, current.y, distance, path)); 
		    	}
	    	}
	    	catch(Exception e) {}; 
	    	try {
		    	if(layout[current.x][current.y + 1] != 'R') {
		    		qeue.add(new BucketsCow(current.x, current.y + 1, distance, path)); 
		    	}
	    	}
	    	catch(Exception e) {}; 
	    	try {
		    	if(layout[current.x][current.y - 1] != 'R') {
		    		qeue.add(new BucketsCow(current.x, current.y - 1, distance, path)); 
		    	}
	    	}
	    	catch(Exception e) {}; 
	    	
	    	
	    	
	    }
	
	    int result = solution.distance - 1;
	    PrintWriter out = new PrintWriter(new File("buckets.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
}

class BucketsCow {
	int x;
	int y; 
	int distance = 0; 
	ArrayList<BucketsCow> path = new ArrayList<BucketsCow>(); 
	
	BucketsCow() {}; 
	
	BucketsCow(int x, int y, int distance) {
		this.x = x;
		this.y = y; 
		this.distance = distance; 
	}
	BucketsCow(int x, int y, int distance, ArrayList<BucketsCow> path) {
		this.x = x;
		this.y = y; 
		this.distance = distance; 
		this.path = path; 
	}
}

