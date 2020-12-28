package usacoProblemsBronze; 

import java.io.*;
import java.util.*;

public class agram {

    public static String agram(String leadCard, String[] dealerHand) {
    	
    	char suite = leadCard.charAt(1); 
    	int num = convert(leadCard.charAt(0)); 
    	
    	int solution = 0; 
    	
    	int smallestSuite = 0;
    	
    	int smallest = 0; 
    	
    	for(int i = 1; i < dealerHand.length; i++) {
    		String card = dealerHand[i]; 
    		
    		int cardNum = convert(card.charAt(0)); 
    		
    		if(cardNum < convert(dealerHand[smallest].charAt(0))) smallest = i; 
    		
    		if(card.charAt(1) != suite) continue; 
    		
    		if(cardNum  > num && cardNum < convert(dealerHand[solution].charAt(0))) {
    			
    		}
    	}
        return "";
    }
    //*******DO NOT CHANGE ANYTHING BELOW*******
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("agram.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("agram.out")));
        
        while(in.hasNext()){
        	String leadCard = in.next();
        	String[] dealerHand = new String[5];
        	for(int i = 0; i < 5; i++) {
        		dealerHand[i] = in.next();
        	}
            String result = agram(leadCard, dealerHand);      
            System.out.println(result);
            out.println(result);
        }
        in.close();
        out.close();    
    }
    
    static int convert(char a) {
    	if(a == 'A') return 1; 
    	if(a == 'T') return 10; 
    	if(a == 'J') return 11;
    	if(a == 'Q') return 12; 
    	if(a == 'K') return 13; 
    		
    	return (int) a; 
    }
}