package ACSLProbs;





public class ACSLContest2Prob {

    /*
     * Complete the 'rearrangedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
	
	public static void main(String[] args) {
		System.out.println(rearrangedString("00aaaa00")); 
	}

    public static String rearrangedString(String s) {
        int[] numOfOcc = new int[62];
        
        
        
        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i); 
            
            if(current - '0' < 10 && current - '0' >= 0) {
                numOfOcc[current-'0']++; 
            }
            else if(current - 'A' < 26 && current - 'A' >= 0) {
                numOfOcc[current-'A' + 10]++; 
            }
            else if(current - 'a' < 26 && current - 'a' >= 0) {
                numOfOcc[current-'a' + 36]++; 
            }
        } 
        
        
        String[] values = new String[maxIndex(numOfOcc)]; 
        
        for(int i = 0; i < values.length; i++) {
            values[i] = ""; 
        }
        
        
        boolean up = true; 
        
        for(int i = values.length - 1; i >= 0; i--) {
            if(up) {
                values[i] += Integer.toString(i + 1); 
                for(int j = 0; j < numOfOcc.length; j++) {
                    if(numOfOcc[j] == i + 1) {
                        if(j < 10) {
                            values[i] += (char)('0' + j); 
                        }
                        else if(j < 36){
                            values[i] += (char)('A' + (j - 10)); 
                        }
                        else {
                            values[i] += (char)('a' + (j - 36)); 
                        }
                        
                    }
                }
                
                //values[i] = values[i].substring(4); 
                
                if(values[i].length() > 1) up = false; 
            }
            else {
                values[i] += Integer.toString(i + 1); 
                for(int j = numOfOcc.length - 1; j >= 0 ; j--) {
                    if(numOfOcc[j] == i + 1) {
                        if(j < 10) {
                            values[i] += (char)('0' + j); 
                        }
                        else if(j < 36){
                            values[i] += (char)('A' + (j - 10)); 
                        }
                        else {
                            values[i] += (char)('a' + (j - 36)); 
                        }
                        
                    }
                }
                
                //values[i] = values[i].substring(4); 
                
                if(values[i].length() > 1) up = true; 
            }
        }
        
        String answer = ""; 
        
        for(int i = values.length - 1; i >= 0; i--) {
        	if(values[i].length() > 1 && i < 10) {
        		answer += values[i]; 
            
        		answer += ",";
        	}
        	else if(values[i].length() > 2) {
        		answer += values[i]; 
                
        		answer += ",";
        	}
        }
        
        return answer.substring(0, answer.length() - 1); 
    }
    
    static int maxIndex(int[] array) {
        int index = 0; 
        int maxValue = array[0]; 
        
        for(int i = 0; i < array.length; i++) {
            if(array[i] > maxValue) {
                maxValue = array[i]; 
                index = i; 
            }
        }
        
        return maxValue; 
    }

}