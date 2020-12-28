package usacoProblemsBronze;

/*
ID:johangma
LANG: JAVA
TASK: herding
 */
import java.util.*;
import java.io.*;

public class herding {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("herding.in"));
	    int a = in.nextInt(); 
	    int b = in.nextInt(); 
	    int c = in.nextInt(); 
	    int min = 2; 
	    int max = Math.max(b - a, c - b) - 1; 
	    in.close();
	    PrintWriter out = new PrintWriter(new File("herding.out")); 
	    
	    
	    
	    if(b - a == 2 || c - b == 2) min--;
	    
	    if(b - a == 1 && c - b == 1) min = 0; 
	
	
	    out.println(min);
	    out.println(max);
	    out.close();
	}
}
