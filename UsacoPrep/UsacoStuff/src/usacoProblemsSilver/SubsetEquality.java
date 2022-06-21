package usacoProblemsSilver;
import java.util.*; 

public class SubsetEquality {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		String s = in.nextLine(); 
		char[] word1 = s.toCharArray(); 
		String t = in.nextLine(); 
		char[] word2 = t.toCharArray(); 
		
		HashSet<HashSet<Character>> failed = new HashSet<HashSet<Character>>(); 
		
		
		
		int Q = in.nextInt(); 

		
		in.nextLine(); 
		
		OUTER: for(int i = 0; i < Q; i++) {
			HashSet<Character> cypher = new HashSet<Character>();
			

			String q = in.nextLine(); 
			
			char[] query = q.toCharArray(); 
			
			for(char j : query) cypher.add(j);
			
			
			
			for(HashSet<Character> past : failed) {
				if(past.containsAll(cypher)) {
					System.out.println('N'); 
					continue OUTER; 
				}
			}
			
			
			if(test(s, t, cypher) == false) {
				failed.add(cypher); 
				System.out.print('N');
			}
			else System.out.print('Y');
			
			
		}
		
		
		

	}
	
	static boolean test(String s, String t, HashSet<Character> cypher) {
		
		char[] word1 = s.toCharArray(); 
		char[] word2 = t.toCharArray(); 
		
		
		
		char currS = word1[0]; 
		char currT = word2[0]; 
		
		int a = 0; 
		int b = 0; 
		
		while(a < word1.length && b < word1.length) {
			
			
			while(!cypher.contains(currS) && a < word1.length - 1) {
				a++; 
				currS = word1[a]; 
			}
			
			while(!cypher.contains(currT) && b < word2.length - 1)  {
				b++; 
				currT = word2[b]; 
			}
			
			if(currS != currT) {
				return false; 
			}
			
			try { 
			currS = word1[a + 1]; 
			currT = word2[b + 1]; 
			
			a++; 
			b++; 
			
			}
			
			catch(Exception e) {
				a++; 
				b++; 
			} 
			
		}
		
		if(a != b) return false; 
		else return true; 

	}

}
