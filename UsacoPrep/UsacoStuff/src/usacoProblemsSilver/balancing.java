package usacoProblemsSilver;

/*
ID:johangma
LANG: JAVA
TASK: balancing
 */
import java.util.*;
import java.io.*;

public class balancing {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("balancing.in"));
	    
	    int N = in.nextInt(); 
	    XObject[] array1 = new XObject[N]; 
	    YObject[] array2 = new YObject[N]; 
	    
	    for(int i = 0; i < N; i++) {
	    	int x = in.nextInt(); 
	    	int y = in.nextInt(); 
	    	
	    	array1[i] = new XObject(x, y); 
	    	array2[i] = new YObject(x, y); 
	    }
	    
	    Arrays.sort(array1);
	    Arrays.sort(array2);
	   
	    in.close();
	    int a; 
	    int b; 
	    
	    
	   
	    
	    boolean xConflict = false;  
	    boolean yConflict = false; 
	    
	    if(N % 2 == 0) {
	    	a = (array1[N / 2].x + array1[N/2 - 1].x) / 2; 
	    	
	    	if(a == array1[N/2].x) xConflict = true; 
	    	
	    	
	    	b = (array2[N / 2].y + array2[N/2 - 1].y) / 2; 
	    	
	    	if(b == array2[N/2].y) yConflict = true; 
	    
	    }
	    
	    else {
	    	a = array1[N/2].x; 
	    	b = array2[N/2].y; 
	    	
	    	xConflict = true; 
	    	yConflict = true; 
	    }
	    
	    int max = Integer.MAX_VALUE; 
	    
	    if(xConflict && yConflict) {
	    	int[] poss = new int[4]; 
	    	
	    	poss[0] = gridcount(array1, a - 1, b - 1); 
	    	poss[1] = gridcount(array1, a - 1, b + 1); 
	    	poss[2] = gridcount(array1, a + 1, b - 1); 
	    	poss[3] = gridcount(array1, a + 1, b + 1); 
	    	
	    	for(int i = 0; i < poss.length; i++) {
	    		if(poss[i] < max) max = poss[i]; 
	    		
	    	}
	    }
	    
	    else if(xConflict) {
	    	max = gridcount(array1, a-1, b); 
	    	
	    	int value2 = gridcount(array1, a + 1, b); 
	    	
	    	if(max < value2) max = value2; 
	    }
	    else if(yConflict) {
	    	max = gridcount(array1, a, b + 1); 
	    	
	    	int value2 = gridcount(array1, a, b - 1); 
	    	
	    	if(value2 < max) max = value2; 
	    }
	    else {
	    	max = gridcount(array1, a, b); 
	    }
	    
	    while(gridcount(array1, a - 2, b) < gridcount(array1, a, b)) {
	    	a -=2; 
	    }
	    
	    while(gridcount(array1, a + 2, b) < gridcount(array1, a, b)) {
	    	a +=2; 
	    }
	    
	    while(gridcount(array1, a , b+ 2) < gridcount(array1, a, b)) {
	    	b +=2; 
	    }
	    while(gridcount(array1, a , b - 2) < gridcount(array1, a, b)) {
	    	b -=2; 
	    }
	    
	    
	    if(gridcount(array1, a, b) < max) max = gridcount(array1, a, b); 
	    
	   
	    
	  
	 
	
	    System.out.println(max);
	    PrintWriter out = new PrintWriter(new File("balancing.out")); 
	    
	    out.println(max); 
	    out.close(); 
	}
 	
 	static int gridcount(XObject[] array1, int a, int b) {
 		int[] quadrants = new int[4]; 
    	for(int i = 0; i < array1.length; i++) {
	    	XObject curr = array1[i]; 
	    	
	    	if(curr.x > a) {
	    		if(curr.y > b) quadrants[0]++;
	    		else quadrants[3]++; 
	    	}
	    	else {
	    		if(curr.y > b) quadrants[1]++; 
	    		else quadrants[2]++; 
	    	}
	    }
	    
	    Arrays.sort(quadrants);
	    
	    return quadrants[3]; 
 	}
 	
 	
}

class XObject implements Comparable<XObject> {
	int x; 
	int y; 
	
	XObject(int x, int y) {
		this.x = x; 
		this.y = y; 
	}
	public int compareTo(XObject object) {
		return this.x - object.x; 
	}
}
class YObject implements Comparable<YObject> {
	int x; 
	int y; 
	
	YObject(int x, int y) {
		this.x = x; 
		this.y = y; 
	}
	
	public int compareTo(YObject object) {
		return this.y - object.y; 
	}
}
