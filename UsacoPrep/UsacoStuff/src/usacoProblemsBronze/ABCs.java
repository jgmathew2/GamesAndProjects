package usacoProblemsBronze;
import java.util.Scanner;

/**
* @author Johan
 * @version Creation time: Apr 4, 2021 5:27:53 PM
 * Class Description
*/
public class ABCs {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		
		int T = in.nextInt(); 
		
		for(int i = 0; i < T; i++) {
			int N = in.nextInt(); 
			
			int[] values = new int[N]; 
			
			for(int j = 0; j < N; j++) {
				values[j] = in.nextInt(); 
			}
			
			int max = values[N - 1]; 
			
			int triples = 0; 
			
			if(values.length == 4) {
				
			}
			
			if(values.length == 5) {
				
			}
			
			if(values.length == 6) {
				
			}
			if(values.length == 7) {
				
			}
			
			
			
			System.out.println(triples); 
			
			
		}
		
		in.close(); 
		
		int result = 0; 
		
		System.out.println(result); 
		
		
	}

}
