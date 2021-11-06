package algorithmTemplates;

import java.util.Scanner;

/**
* @author Johan
 * @version Creation time: Feb 6, 2021 1:32:42 PM
 * Class Description
*/
public class CowGenetics {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		
		int n = in.nextInt(); 
		int m = in.nextInt(); 
		
		in.nextLine(); 
		
		String[] genomes = new String[2 * n];
		
		for(int i = 0; i < genomes.length; i++) {
			genomes[i] = in.nextLine(); 
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				for(int k = j + 1; k < m; k++) {
					for(int l = k + 1; l < m; l++) {
						
					}
				}
			}
		}
		
		
		
		
		
		
		
	}

}
