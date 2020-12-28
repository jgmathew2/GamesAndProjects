package usacoProblemsSilver;

/*
ID:johangma
LANG: JAVA
TASK: moobuzz
 */
import java.util.*;
import java.io.*;

public class moobuzz {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("moobuzz.in"));
	    int number = in.nextInt(); 
	    in.close();
	    PrintWriter out = new PrintWriter(new File("moobuzz.out")); 
	    
	    if(number % 15 == 0) out.println("Moo"); 
	    else if(number % 5 == 0) out.println("Moo"); 
	    else if(number % 3 == 0) out.println("Moo"); 
	    else out.println(number); 
	
	 
	    out.close();
	}
}
