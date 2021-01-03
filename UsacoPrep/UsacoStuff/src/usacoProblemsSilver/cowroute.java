package usacoProblemsSilver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class cowroute {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("cowroute.in"));
		int start = in.nextInt(); 
		int end = in.nextInt(); 
		int numRoutes = in.nextInt(); 
		
		int cost = Integer.MAX_VALUE; 
		
		for(int i = 0; i < numRoutes; i++) {
			int routeCost = in.nextInt(); 
			
			int routeLength = in.nextInt();
			
			boolean started = false; 
			
			for(int j = 0; j < routeLength; j++) {
				int city = in.nextInt(); 
				
				if(city == start) started = true; 
				
				else if(city == end && started) {
					if(routeCost < cost) cost = routeCost; 
				}
			}
		}
		in.close(); 
		
		PrintWriter out = new PrintWriter(new File("cowroute.out"));
		
		if(cost == Integer.MAX_VALUE) out.println(-1); 
		else out.println(cost); 
		
		out.close(); 
		
		
		
	}

}
