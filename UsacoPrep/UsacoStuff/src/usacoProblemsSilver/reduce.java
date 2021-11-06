package usacoProblemsSilver;
/**
* @author Johan
 * @version Creation time: Oct 23, 2021 6:43:41 PM
 * Class Description
*/
import java.util.*;
import java.io.*;

public class reduce {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(new File("reduce.in"));
    // TODO: read input
    Cow[] original = new Cow[in.nextInt()]; 
    
    for(int i = 0; i < original.length; i++) {
    	original[i] = new Cow(in.nextInt(), in.nextInt()); 
    }
   
    
    Cow[] sortedHoriz = new Cow[original.length]; 
    
    Cow[] sortedVert = new Cow[original.length]; 
    
    for(int i = 0; i < sortedVert.length; i++) {
    	sortedVert[i] = new Cow(original[i].x, original[i].y);
    	sortedHoriz[i] = new Cow(original[i].x, original[i].y); 
    }
    in.close();
    
    Arrays.sort(sortedHoriz, new HComparator());
    Arrays.sort(sortedVert, new VComparator());

 
    int xDistance = sortedHoriz[sortedHoriz.length - 1].x - sortedHoriz[0].x;
    int yDistance = sortedVert[sortedVert.length - 1].y - sortedVert[0].y; 
    
    int area = xDistance * yDistance; 		
    int xRemovedStart = 0; 
    int xRemovedEnd = 0; 
    int yRemovedStart = 0; 
    int yRemovedEnd = 0; 
    int totalRemoved = 0; 
    
    while(totalRemoved < 3 ) {
	
		int[] posAreas = new int[4]; 
		
		
		
		posAreas[0] = (sortedHoriz[sortedHoriz.length - (xRemovedEnd + 1)].x - sortedHoriz[xRemovedStart + 1].x) * (sortedVert[sortedVert.length - (yRemovedEnd + 1)].y - sortedVert[yRemovedStart].y); 
		posAreas[1] = (sortedHoriz[sortedHoriz.length - (xRemovedEnd + 2)].x - sortedHoriz[xRemovedStart].x) * (sortedVert[sortedVert.length - (yRemovedEnd + 1)].y - sortedVert[yRemovedStart].y); 
		posAreas[2] = (sortedHoriz[sortedHoriz.length - (xRemovedEnd + 1)].x - sortedHoriz[xRemovedStart].x) * (sortedVert[sortedVert.length - (yRemovedEnd + 1)].y - sortedVert[yRemovedStart + 1].y);
		posAreas[3] = (sortedHoriz[sortedHoriz.length - (xRemovedEnd + 1)].x - sortedHoriz[xRemovedStart].x) * (sortedVert[sortedVert.length - (yRemovedEnd + 2)].y - sortedVert[yRemovedStart].y);
		
		if(sortedHoriz[xRemovedStart].equals(sortedVert[yRemovedStart])) {
			posAreas[0] = (sortedHoriz[sortedHoriz.length - (xRemovedEnd + 1)].x - sortedHoriz[xRemovedStart + 1].x) * (sortedVert[sortedVert.length - (yRemovedEnd + 1)].y - sortedVert[yRemovedStart + 1].y);
		}
		if(sortedHoriz[sortedHoriz.length - (xRemovedEnd + 1)].equals(sortedVert[sortedVert.length - (yRemovedEnd + 1)])) {
			posAreas[3] = (sortedHoriz[sortedHoriz.length - (xRemovedEnd + 2)].x - sortedHoriz[xRemovedStart].x) * (sortedVert[sortedVert.length - (yRemovedEnd + 2)].y - sortedVert[yRemovedStart].y);
		}
		
		int index = findMin(posAreas); 
		
		area = posAreas[index]; 
		if(index == 0) {
			totalRemoved++;
		
			xRemovedStart++; 
			if(sortedHoriz[xRemovedStart] == sortedVert[yRemovedStart]) {
				yRemovedStart++; 
			}
			
		}
		if(index == 1) {
			totalRemoved++;
		 
			xRemovedEnd++; 
			
			if(sortedHoriz[sortedHoriz.length - (xRemovedEnd + 1)] == sortedVert[sortedVert.length - (yRemovedEnd + 1)]) {
				yRemovedEnd++; 
			}
		}
		if(index == 2) {
			totalRemoved++; 
		
			yRemovedStart++; 
			if(sortedHoriz[xRemovedStart] == sortedVert[yRemovedStart]) {
				xRemovedStart++; 
			}
		}
		if(index == 3) {
			totalRemoved++; 
			
			yRemovedEnd++; 
			
			if(sortedHoriz[sortedHoriz.length - (xRemovedEnd + 1)] == sortedVert[sortedVert.length - (yRemovedEnd + 1)]) {
				xRemovedEnd++; 
			}
		}
    	
    }
    int result = area; 
    // TODO: try removing some cows to get a smaller field
    
    PrintWriter out = new PrintWriter(new File("reduce.out"));
    System.out.println(result);
    out.println(result);
    out.close();
  }
  
  static int findMin(int[] array) {
	  int x = Integer.MAX_VALUE; 
	  int y = 0; 
	  
	  for(int i = 0; i < array.length; i++) {
		  if(array[i] < x) {
			  y = i; 
			  x = array[i]; 
		  }
	  }
	  return y; 
  }
  
  static class HComparator implements Comparator<Cow> {
      public int compare(Cow a, Cow b) {

    	  
    	  return a.x - b.x; 
    	  
      }
  }
  
  static class VComparator implements Comparator<Cow> {
      public int compare(Cow a, Cow b) {
    	  return a.y - b.y;
      }
  }
  
  static class Cow {
      int x; 
      int y; 
      
      Cow(int x, int y) {
    	  this.x = x; 
    	  this.y = y; 
      }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cow other = (Cow) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
      
      
      
  }
}