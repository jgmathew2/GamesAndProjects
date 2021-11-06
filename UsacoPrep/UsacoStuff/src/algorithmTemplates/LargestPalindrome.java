package algorithmTemplates;
/**
* @author Johan
 * @version Creation time: Jan 31, 2021 1:55:46 PM
 * Class Description
*/
public class LargestPalindrome {
	public static void main(String[] args) {
		
	}
	
	String findPalindrome(String input) {
		
		String result = ""; 
	    int resultLength = 0;
		
		for(int i = 0; i < input.length(); i++) {
			int left = i; 
			int right = i; 
			
			while (left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)) {
				if (right - left + 1 > resultLength) {
					result = input.substring(left, right+1);
	                resultLength = right - left + 1;
	            }
	                
	            left--;
	            right++;
            }
			
			left = i;
	        right = i+1;
	            
	        while (left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)) {
	        	if (right - left + 1 > resultLength) {
	        		result = input.substring(left, right+1);
	                resultLength = right - left + 1;
	            }
	                
	            left--;
	            right++;
	        }
		}
		
		return result; 
	}

}
