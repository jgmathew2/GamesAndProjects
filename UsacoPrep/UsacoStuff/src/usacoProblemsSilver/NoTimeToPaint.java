package usacoProblemsSilver;

import java.io.File;
import java.util.Scanner;

public class NoTimeToPaint {
	public static void main(String[] args) throws Exception  {
		//Scanner in = new Scanner(System.in);

	    Scanner in = new Scanner(new File("NoTimeToPaint.in"));
		int N = in.nextInt(); 
		
		int Q = in.nextInt(); 
		
		in.nextLine(); 
		char[] desired = in.nextLine().toCharArray();
		
		for(int i = 0; i < Q; i++) {
			int end1 = in.nextInt() - 1; 
			
			int start2 = in.nextInt() - 1;
			
			System.out.println(evaluate(desired, 0, end1, 'A') + evaluate(desired, start2 + 1, desired.length, 'A')); 
			
			
		}
		
		in.close(); 
		
		
	}
	
	static int evaluate(char[] array, int start, int end, char curr) {
		if(end - start == 1) return 1; 
		if(end == start) return 0; 
		
		 
		int i = start; 
		while(i < end && array[i] != curr ) {
			i++; 
		}

		if(i == end) return evaluate(array, start, end, (char)(curr + 1)); 
		
		int result = 1; 
		
		result += evaluate(array, start, i, (char)(curr + 1)); 
		
		int previous = i; 
		
		i++; 
		
		while(i < end) {
			if(array[i] == curr) {
				result += evaluate(array, previous + 1, i, (char)(curr + 1));
				previous = i; 
			}
			i++; 
		}
		
		result += evaluate(array, previous + 1, end, (char)(curr + 1)); 
		
		return result; 
	}
	
	static char findSmallest(char[] array, int start, int end) {
		int smallest = (int) 'A'; 
		for(int i = start; i < end; i++) {
			if(smallest > (int)array[i]) smallest = (int) array[i]; 
		}
		
		return (char)smallest; 
	}

}
