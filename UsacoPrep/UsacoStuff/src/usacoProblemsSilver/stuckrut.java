package usacoProblemsSilver;

import java.io.File;
import java.util.*;


public class stuckrut {
	public static void main(String[] args) throws Exception {
		 
		 Scanner in = new Scanner(System.in);
		
		 //Scanner in = new Scanner(new File("stuckrut.in"));
		 
		 RutCow[] cows = new RutCow[in.nextInt()];
		 
		 int[] eaten = new int[cows.length]; 
		 
		 in.nextLine(); 
		 
		 for(int i = 0; i < cows.length; i++) {
			 cows[i] = new RutCow(); 
			 String[] values = in.nextLine().split(" "); 
			 
			 cows[i].dir = values[0].charAt(0); 
			 
			 cows[i].x = Integer.parseInt(values[1]); 
			 
			 cows[i].y = Integer.parseInt(values[2]); 
		 }
		 in.close(); 
		 // all good ^
		 for(int i = 0; i < cows.length; i++) {
			 for(int j = i + 1; j < cows.length; j++) {
				 if(cows[i].dir == cows[j].dir) continue; 
				 
				 RutCow eastCow; 
				 RutCow northCow; 
				 int eastCowInd; 
				 int northCowInd; 
				 
				 if(cows[i].dir == 'E') {
					 eastCow = cows[i]; 
					 northCow = cows[j]; 
					 eastCowInd = i; 
					 northCowInd = j; 
				 }
				 else {
					 eastCow = cows[j]; 
					 northCow = cows[i]; 
					 eastCowInd = j; 
					 northCowInd = i; 
				 }
				 
				 if(northCow.x < eastCow.x || northCow.y > eastCow.y) continue; 
				 
				 int destX = northCow.x; 
				 int destY = eastCow.y; 
				 
				 int northTime = destY - northCow.y; 
				 int eastTime = destX - eastCow.x; 
				 
				 if(northTime > eastTime) {
					 if(northCow.time > northTime && northCow.x < eastCow.stopped) {
						 northCow.time = northTime; 
						 northCow.stopped = eastCow.y - 1;
						 northCow.cowStopped = eastCowInd; 
					 }
				 }
				 
				 else if(northTime < eastTime) {
					 if(eastCow.time > eastTime && eastCow.y < northCow.stopped) {
						 eastCow.time = eastTime; 
						 eastCow.stopped = northCow.x - 1;
						 eastCow.cowStopped = northCowInd; 
					 }
				 }
			 }
		 }
		 
		 
		 for(int i = 0; i < cows.length; i++) {
			 
			 if(cows[i].dir == 'E') {
				 try {
				 if(cows[cows[i].cowStopped].stopped < cows[i].y) {
					 cows[i].time = Integer.MAX_VALUE;
					 cows[i].cowStopped = -1; 
				 }
				 }
				 catch(Exception e) {}; 
			 }
			 else if(cows[i].dir == 'N') {
				 try {
					 if(cows[cows[i].cowStopped].stopped < cows[i].x) {
						 cows[i].time = Integer.MAX_VALUE;
						 cows[i].cowStopped = -1; 
					 }
				 }
				 catch(Exception e) {}; 
			 }
			
			 for(int j = 0; j < cows.length; j++) {
				 if(cows[i].dir == cows[j].dir) continue; 
				 
				 RutCow eastCow; 
				 RutCow northCow; 
				 int eastCowInd; 
				 int northCowInd; 
				 
				 if(cows[i].dir == 'E') {
					 eastCow = cows[i]; 
					 northCow = cows[j]; 
					 eastCowInd = i; 
					 northCowInd = j; 
				 }
				 else {
					 eastCow = cows[j]; 
					 northCow = cows[i]; 
					 eastCowInd = j; 
					 northCowInd = i; 
				 }
				 
				 if(northCow.x < eastCow.x || northCow.y > eastCow.y) continue; 
				 
				 int destX = northCow.x; 
				 int destY = eastCow.y;
				 
				
				 
				 int northTime = destY - northCow.y; 
				 int eastTime = destX - eastCow.x; 
				 
				 if(northTime > eastTime) {
					 if(northCow.time > northTime && northCow.x < eastCow.stopped) {
						 northCow.time = northTime; 
						 northCow.stopped = eastCow.y - 1;
						 northCow.cowStopped = eastCowInd; 
					 }
				 }
				 
				 else if(northTime < eastTime) {
					 if(eastCow.time > eastTime && eastCow.y < northCow.stopped) {
						 eastCow.time = eastTime; 
						 eastCow.stopped = northCow.x - 1;
						 eastCow.cowStopped = northCowInd; 
					 }
				 }
			 }
		 }
		 int[] blame = new int[cows.length]; 
		 
		 
		 for(int i = 0; i < cows.length; i++) {
			 try {
			 blame[cows[i].cowStopped]+= 1 + blame[i]; 
			 
			 }
			 catch(Exception e) {}; 
		 }
		 int c = 5;
		 
		 blame = transitivity(blame, cows, blame.length); 
		
		
				 	
		
		c--;
		 
		 
		 for(int i = 0; i < cows.length; i++) {
			 System.out.println(blame[i]); 
		 }
		 
		 
		 
		 
		
	}
	
	static int[] transitivity(int[] blame, RutCow[] cows, int contraint) {
		if(contraint <= 0) return blame; 
		else {
			for(int i = 0; i < contraint; i++) {
				if(blame[i] != 0) {
					try {
						blame[cows[i].cowStopped]+= blame[i]; 
						return transitivity(blame, cows, i); 
					}
					catch(Exception e) {};			
				}
			}
		}
		
		return blame; 
		
	}
}

class RutCow {
	char dir; 
	int x; 
	int y;
	int time = Integer.MAX_VALUE; 
	int stopped = Integer.MAX_VALUE;
	int cowStopped = -1; 


}
