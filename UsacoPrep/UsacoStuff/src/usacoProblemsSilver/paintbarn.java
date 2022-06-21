package usacoProblemsSilver;

import java.util.*;
import java.io.*;

public class paintbarn {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(new File("Paintbarn.in"));
    
    
    
    int N = in.nextInt(); 
    int K = in.nextInt(); 
    
    Paint[] xSorted = new Paint[N]; 
    Paint[] ySorted = new Paint[N]; 
    
    for(int i = 0; i < N; i++) {
        int startX = in.nextInt(); 
        int startY = in.nextInt(); 
        int endX = in.nextInt(); 
        int endY = in.nextInt(); 
        
        xSorted[i] = new Paint(startX, startY, endX, endY); 
        ySorted[i] = new Paint(startX, startY, endX, endY); 
    }
    
    
    Arrays.sort(xSorted, new XComparator());
    Arrays.sort(ySorted, new YComparator());
    
    
    in.close();
    
    int paint; 

    int result = 0;
    
    PrintWriter out = new PrintWriter(new File("Paintbarn.out"));
    System.out.println(result);
    out.println(result);
    out.close();
  }
}

class Paint {
    int startX; 
    int startY; 
    int endX; 
    int endY; 
    
    Paint(int startX, int startY, int endX, int endY) {
        this.startX = startX; 
        this.startY = startY; 
        this.endX = endX; 
        this.endY = endY; 
    }
}

class XComparator implements Comparator<Paint> {
    public int compare(Paint paint1, Paint paint2) {
        return paint1.startX - paint2.endX; 
    }
}
class YComparator implements Comparator<Paint> {
    public int compare(Paint paint1, Paint paint2) {
        return paint1.startY - paint2.startY; 
    }
}