package usacoProblemsBronze;

public class test {
	public static void main(String[] args) {
		System.out.println(convertTo10("9")); 
		
	}
	 static double convertTo10(String a) {
	        double value = 0; 
	        for(int i = 0; i < a.length(); i++) {
	            double digit = 0; 
	            if((int)a.charAt(i) > 58) digit = (int)(a.charAt(i) - 'A' + 10);
	            else digit = (int) a.charAt(i)- '0'; 
	            
	            value += digit * Math.pow(16, a.length() - i - 1); 
	        }
	        
	        return value; 
	 }

}
