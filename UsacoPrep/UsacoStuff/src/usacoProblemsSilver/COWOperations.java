package usacoProblemsSilver;

import java.util.*; 

public class COWOperations {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		
		String code = in.nextLine(); 
		
	
		int substrings = in.nextInt(); 
		
		for(int i = 0; i < substrings; i++) {
			String curr = code.substring(in.nextInt() - 1, in.nextInt()); 
			
			simplify(curr); 
			
		}
		
		in.close(); 
		
		
		
	}
	
	public static void simplify(String code) {
		
		if(code.length() <= 1) {
			if(code.equals("C")) System.out.print("Y"); 
			else System.out.print("N");
		
			return; 
		
		}
	
		
		String copy = ""; 
		
		
		for(int i = 0; i < code.length() - 1; i++) {
			 String port = code.substring(i, i + 2); 
			 
			 if((port.equals("CC") || port.equals("WW") || port.equals("OO") )) {
				 i++; 
			 }
			 else if(port.equals("OW") || port.equals("WO") ) {
				 copy += 'C'; 
				 i++; 
			 }
			 else if(port.equals("CO") || port.equals("OC") ) {
				 copy += 'W'; 
				 i++; 
			 }
			 else if(port.equals("CW") || port.equals("WC") ) {
				 copy += 'O'; 
				 i++; 
			 }
			
		}
		
		
		
		
		
		if(code.length() > 1) simplify(copy); 
		else if(copy.equals("C")) System.out.print("Y"); 
		else System.out.print("N");
		
		
	}

}
