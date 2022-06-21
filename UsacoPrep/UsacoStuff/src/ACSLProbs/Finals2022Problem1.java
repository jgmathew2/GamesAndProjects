package ACSLProbs;

import java.util.Arrays;

public class Finals2022Problem1 {
	public static void main(String[] args) {
		System.out.println(findMatch("helps", "roads track fears sight jumps zones")); 
	}
	
	public static String findMatch(String word, String guesses) {
		
		String[] guessStringList = guesses.split(" "); 
		Guess[] guessList = new Guess[guessStringList.length];  
		for(int i = 0; i < guessStringList.length; i++) {
			guessList[i] = new Guess(guessStringList[i], word); 
		}
		
		Arrays.sort(guessList);
		String result = ""; 
		
		if(guessList[guessList.length - 6].useless == true) {
			boolean[] repeated = new boolean[26]; 
			
			for(int i = 0; i < guessList.length; i++) {
				for(int j = 0; j < 5; j++) {
					char repeat = guessList[i].word.charAt(j);  
					
					repeated[repeat - 'a'] = true; 
				}
			}
			
			for(int i = 0 ; i < repeated.length; i++) {
				if(repeated[i] == false) result += ((char)('a' + i)); 
			}
		}
		else {
			for(int i = guessList.length; i > guessList.length - 6;  i--) {
				result += guessList[i - 1].word; 
				result+= " "; 
			}
		}
		
		return result; 

    }
    
    

}

class Guess implements Comparable<Guess> {
    String word; 
    String target; 
    boolean useless = false; 
    

    Guess(String word, String target) {
        this.word = word; 
        this.target = target; 
        
    }

	@Override
	public int compareTo(Guess OGuess) {
		int[] result1 = testWord(word); 
		int[] result2 = testWord(OGuess.word); 
		if(result1[1] == 0 && result1[0] == 0) useless = true; 
		if(result2[1] == 0 && result2[0] == 0) OGuess.useless = true;
		if(result1[0] != result2[0]) return result1[0] - result2[0]; 
		else if(result1[1] != result2[1]) return result1[1] - result2[1];
		else {
			if(result1[2] == 2 && result2[2] != 2) return 1; 
			else if(result1[2] != 2 && result2[2] == 2) return -1; 
			
			if(result1[6] == 2 && result2[6] != 2) return 1; 
			if(result1[6] != 2 && result2[6] == 2) return -1; 
			
			int greenVowel1 = 0; 
			int greenVowel2 = 0; 
			for(int i = 0; i < 4; i++) {
				if(result1[i + 2] == 2 && isVowel(word.charAt(i))) greenVowel1++; 
				if(result2[i + 2] == 2 && isVowel(OGuess.word.charAt(i))) greenVowel2++; 
				
			}
			if(greenVowel1 - greenVowel2 != 0) return greenVowel1 - greenVowel2;
			
			return -1 * word.compareTo(OGuess.word);  
		}
	}
	
	int[] testWord(String guess) {
		boolean[] repeats = new boolean[26]; 
		int[] result = new int[7]; 
		for(int i = 0; i < 5; i++) {
			char currChar = guess.charAt(i); 
			if(currChar == target.charAt(i)) {
				result[0]++; 
				result[i + 2]+=2; 
				if(repeats[currChar - 'a'] == true) {
					if(result[guess.indexOf(currChar) + 2] != 2) {
						if(target.indexOf(currChar) != i); 
						else {
							String cutTarget = target.substring(target.indexOf("" + currChar) + 1);
							if(cutTarget.indexOf("" + currChar) == -1) {
								result[guess.indexOf(currChar) + 2]--;  
								result[1]--; 
							}
						}
					}
				}
				repeats[currChar - 'a'] = true; 
			}
			else if(target.indexOf("" + currChar) != -1) {
				if(repeats[currChar - 'a']) {
					try { 
						String cutTarget = target.substring(target.indexOf("" + currChar) + 1);
						if(cutTarget.indexOf("" + currChar) != -1) {
							result[i + 2]++; 
							result[1]++; 
						}
					}
					catch(Exception e) {}; 
					
					
				}
				else {
					result[i + 2] += 1; 
					repeats[currChar - 'a'] = true;
					result[1]++;
				}
			}
	
		}
		
		return result; 
	}
	
	boolean isVowel(char test) {
		if(test == 'a' || test == 'e' || test == 'i' || test == 'o' || test == 'u') return true; 
		else return false; 
	}


	
}
