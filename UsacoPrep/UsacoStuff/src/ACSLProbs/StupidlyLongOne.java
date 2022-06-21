package ACSLProbs;
import java.util.*; 

public class StupidlyLongOne {
	public static int numFibonacciCycles(float inputA, float inputB, float inputC, float inputD, float inputE) {
        int totalCount = 0; 
        double realPartLL = (Math.round(inputA * 1000.0) / 1000.0); 
        double imagPartLL = (Math.round(inputB * 1000.0) / 1000.0); 
        double realPartUR = (Math.round(inputC * 1000.0) / 1000.0); 
        double imagPartUR = (Math.round(inputD * 1000.0) / 1000.0); 
        double incr = (Math.round(inputE * 1000.0) / 1000.0); 
        for(double i = realPartLL; i <= realPartUR + 0.01; i += incr) {
            for(double j = imagPartLL; j <= imagPartUR+ 0.01; j += incr) {
                HashMap<Long, Integer> beenTo = new HashMap<Long, Integer>(); 
                i = (double)((Math.round(i * 1000.0)) / 1000.0);
                j = (double)((Math.round(j * 1000.0))/ 1000.0); 
                double real = i; 
                double imag = j; 
                
                if(Math.round(magnitude(real, imag) * 1000.0) / 1000.0 > 4) {
                 
                    continue; 
                }
                
                beenTo.put((long)(real * 10000 * 10000 + imag * 10000), 1); 
                int count = 1; 
                while(true) {
                    count++; 
                    double temp = real; 
                    real = real * real - imag * imag; 
                    imag = 2 * temp * imag; 
                    
                    real += i; 
                    imag += j; 
                    
                    double mag = magnitude(real, imag); 
                    
                    real = (double)(Math.round(real * 1000.0) / 1000.0);
                    imag = (double)(Math.round(imag * 1000.0) / 1000.0);  
                    mag = (double)(Math.round(mag * 1000.0) / 1000.0); 
                    long value = ((long)(real * 10000.0 * 10000.0 + imag * 10000.0)); 
                    mag = (double)(Math.round(mag * 1000.0) / 1000.0); 
                    if(beenTo.keySet().contains(value)) { 
                    	count -= beenTo.get(value); 
                    	break; 
                    }
                    if(mag > 4) {
                    	count = 0; 
                    	break; 
                    }
                    beenTo.put(value, count); 
                    
                }
                
                if(isFibonacci(count)) totalCount++; 
             
            }
        }
        
        return totalCount; 

    }
	
	public static void main(String[] args) {
		System.out.println(numFibonacciCycles((float) -0.1, (float)-0.3,
				(float)-0.05, (float)-0.2, (float) 0.005 )); 
	}
    
   
    static double magnitude(double imag, double real) {
        return (double)Math.sqrt(imag * imag + real * real); 
    }
    
    static boolean isFibonacci(int num) {
        int a = 0; 
        int b = 1; 
        
        int c = a + b; 
        
        while(c != num) {
            a = b; 
            b = c; 
            
            c= a + b; 
            
            if(c > num) return false; 
        }
        
        return true; 
    }

}
