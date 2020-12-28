package usacoProblemsBronze; 

/*
ID:johangma
LANG: JAVA
TASK: square
 */
import java.util.*;
import java.io.*;

public class square {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("square.in"));
	    double greatestX = Integer.MIN_VALUE; 
	    double lowestX = Integer.MAX_VALUE; 
	    double greatestY = Integer.MIN_VALUE;
	    double lowestY = Integer.MAX_VALUE; 
	    for(int i = 0; i < 4; i++) {
	    	int x = in.nextInt(); 
	    	int y = in.nextInt(); 
	    	
	    	if(x > greatestX) greatestX = x;
	    	if(x < lowestX) lowestX = x; 
	    	if(greatestY < y) greatestY = y;
	    	if(lowestY > y) lowestY = y; 
	    }
	    in.close();
	
	    int result = (int)Math.pow(Math.max(greatestX - lowestX, greatestY - lowestY), 2);
	    PrintWriter out = new PrintWriter(new File("square.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
}
