package ACSLProbs;
import java.util.*; 
public class SecondContest2022 {
	
	
	public static void main(String[] args) {
		
		
		System.out.println(fibCypher('E', 0, 1, 's', "Python Programming is easier"
				+ " than programmng in Java.")); 
		
		
		
		
		
	}
	
	public static String fibCypher(char option, int number1, int number2, char key, String msg) {
        String solution = ""; 
        
        if(option == 'D') {
            long num1 = number1; 
            long num2 = number2;
            String[] nums = msg.split(" "); 
            
            for(int i = 0; i < nums.length; i++) {
                
                char currLetter = key; 
                if((i + 1) % 2 == 1) {
                    int alphIndex = (currLetter - 'a'); 
                    
                    int shift = (int)((num1 + alphIndex) % 26); 
                    
                    char newChar = (char)('a' + ((shift) % 26)); 
                    
                    
                    
                    solution += (char)(Integer.parseInt(nums[i]) - 3 * newChar); 
            
                }
                else {
                    int alphIndex = (currLetter - 'a'); 
                    
                    int shift = (int)(num1 % 26); 
                    
                    char newChar = 'a'; 
                    if(alphIndex - shift < 0) { 
                        newChar  += alphIndex - shift + 26; 
                    }
                    else newChar += alphIndex - shift; 
                    
                
                    
                    solution += (char)(Integer.parseInt(nums[i]) - 3 * newChar); 
                }
            
           
                long nextNum  = num1 + num2; 
            
                num1 = num2; 
                num2 = nextNum; 
            
            }
            
            
            return solution; 
            
        }
        
        long num1 = number1; 
        long num2 = number2; 
        
        for(int i = 0; i < msg.length(); i++) {
            char curChar = msg.charAt(i); 
            
            char currLetter = key; 
            if((i + 1) % 2 == 1) {
                int alphIndex = (currLetter - 'a'); 
                
                int shift = (int)((num1 + alphIndex) % 26); 
                
                char newChar = (char)('a' + ((shift) % 26)); 
                
                int number = (int)(newChar * 3 + curChar); 
                
                solution = solution + number; 
                solution += " "; 
        
            }
            else {
                int alphIndex = (currLetter - 'a'); 
                
                int shift = (int)(num1 % 26); 
                
                char newChar = 'a'; 
                if(alphIndex - shift < 0) { 
                    newChar  += alphIndex - shift + 26; 
                }
                else newChar += alphIndex - shift; 
                
               int number = (int)(newChar * 3 + curChar); 
                
                solution = solution + number; 
                solution += " "; 
            }
            
           
            
            long nextNum  = num1 + num2; 
            
            num1 = num2; 
            num2 = nextNum; 
            
            
        }
        
        return solution; 
        
        
        

    }

}
