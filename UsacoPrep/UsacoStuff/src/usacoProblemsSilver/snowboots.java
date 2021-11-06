package usacoProblemsSilver;
/**
* @author Johan
 * @version Creation time: Feb 21, 2021 12:10:43 PM
 * Class Description
*/

import java.util.*;
import java.io.*;

public class snowboots {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("snowboots.in"));
	    int N = in.nextInt(); 
	    
	    int[] nums = new int[N]; 
	    in.close();
	
	    
	    
	    int result = 0;
	    PrintWriter out = new PrintWriter(new File("snowboots.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
}
