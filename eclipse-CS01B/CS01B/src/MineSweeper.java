import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import processing.core.PApplet;


class MineGridBox extends GridBox {
	boolean mined = false;
	boolean clicked = false;
	boolean flagged = false;
	int surroundingMines = 0;

	MineGridBox() {
		super();
		
	}
	MineGridBox(boolean isHovering) {
		super("/Users/johan/Desktop/GreyBox.png");
		
	}
	MineGridBox(int i) {
		super("/Users/johan/Desktop/BrownBox2.png");
	}
	MineGridBox(double j) {
		super("/Users/johan/Desktop/OrangeBox.png");
	}
}

public class MineSweeper extends PApplet {
	MineGridBox[][] position;
	int addedMines = 0;
	int noOfMines = 30;
	int minesLeft = noOfMines;
	int actualMinesLeft = noOfMines;
	
	public void setup() {
		Sprite.init(this);
			   	
		background(243, 243, 243);
		size(1450, 800);
		position = new MineGridBox[16][16];
		
		
		for(int i = 0; i < 16; i++) {
			for(int j = 0; j < 16; j++) {
				MineGridBox gridbox = new MineGridBox();
				position[i][j] = gridbox;
				gridbox.moveToPoint(350 + 50 * j, 25 + 50 * i);
				gridbox.display();
							
		    }
	    }

		while(addedMines < noOfMines) {
			Random rand = new Random();
			int mineX = rand.nextInt(16);
			int mineY = rand.nextInt(16);
			if(position[mineY][mineX].mined == false)  {
				position[mineY][mineX].mined = true;
				addedMines++;
			}
			
					
		}
	}
		
			    
			    
			   
			    
			   	
		
		 
		 
		 
		 
		 	      
	public void draw() {
		final String url = "/Users/johan/Desktop/SHovel.png";
		background(0, 0, 243);
		final PlayableArea area = new PlayableArea();
		area.moveToPoint(725, 400);
		area.display();
	
		
		for(int i = 0; i < 16; i++) {
			for(int j = 0; j < 16; j++) {
				if(position[i][j].clicked) {
					MineGridBox gridbox = position[i][j];
					gridbox = new MineGridBox(0);
					if(position[i][j].mined) {
						gridbox.mined = true;
					}
					position[i][j] = gridbox;
					gridbox.moveToPoint(350 + 50 * j, 25 + 50 * i);
					gridbox.display();
					gridbox.clicked = true;
				}
				else if(position[i][j].flagged) {
					MineGridBox gridbox = position[i][j];
					gridbox = new MineGridBox(2.2);
					if(position[i][j].mined) {
						gridbox.mined = true;
					}
					gridbox.clicked = false;
					gridbox.flagged = true;
					position[i][j] = gridbox;
					gridbox.moveToPoint(350 + 50 * j, 25 + 50 * i);
					gridbox.display();
				}
				else {
					MineGridBox gridbox = position[i][j];
					gridbox = new MineGridBox();
					if(position[i][j].mined) {
						gridbox.mined = true;
					}
					position[i][j] = gridbox;
					gridbox.moveToPoint(350 + 50 * j, 25 + 50 * i);
					
					gridbox.display();
				}
				
				if(position[i][j].mined == false) {
					if(i != 0 && position[i - 1][j].mined == true) position[i][j].surroundingMines++;
					if(i != 0 && j != 0 && position[i - 1][j - 1].mined == true) position[i][j].surroundingMines++;
					if(i != 0 && j != 15 && position[i - 1][j + 1].mined == true) position[i][j].surroundingMines++;
					if(j != 0 && position[i][j - 1].mined == true) position[i][j].surroundingMines++;
					if(j != 15 && position[i][j + 1].mined == true) position[i][j].surroundingMines++;
					if(i != 15 && position[i + 1][j].mined == true) position[i][j].surroundingMines++;
					if(i != 15 && j != 0 && position[i+ 1][j - 1].mined == true) position[i][j].surroundingMines++;
					if(i != 15 && j != 15 && position[i + 1][j + 1].mined == true) position[i][j].surroundingMines++;
				}
				if(position[i][j].clicked) {
					textSize(20);
					fill(255);
					text("" + position[i][j].surroundingMines, position[i][j].getX() , position[i][j].getY());
				}
				if(position[i][j].flagged) {
					textSize(20);
					fill(255);
					text("flag" , position[i][j].getX() - 15, position[i][j].getY());
				}
				if(position[i][j].surroundingMines == 0 && position[i][j].clicked) {
					if(i != 0) position[i - 1][j].clicked = true;
					if(i != 0 && j != 0) position[i - 1][j - 1].clicked = true;
					if(i != 0 && j != 15) position[i - 1][j + 1].clicked = true;
					if(j != 0) position[i][j - 1].clicked = true;
					if(j != 15) position[i][j + 1].clicked = true;
					if(i != 15) position[i + 1][j].clicked = true;
					if(i != 15 && j != 0) position[i + 1][j - 1].clicked = true;
					if(i != 15 && j != 15) position[i + 1][j + 1].clicked = true;
				}
				
				
				
			}
		}
		
	
		
		Coordinate mouseLocation = new Coordinate(mouseX, mouseY);
		Coordinate gridLocation = getGridLocation(mouseLocation);
		PApplet applet = position[0][0].getPApplet();
		if(gridLocation.x < 16 && gridLocation.x > -1 && gridLocation.y < 16 && gridLocation.y > -1) {
			//try {
				MineGridBox replacement = new MineGridBox(true);
				replacement.moveToSprite(position[gridLocation.x][gridLocation.y]);
				replacement.display();
			//}
			//catch(IndexOutOfBoundsException e) {
				
			//}
				
		}
		textSize(20);
		fill(255);
		text("Flags Left: " + minesLeft, 100, 100);
		if(actualMinesLeft == 0) {
			textSize(20);
			fill(255);
			text("You Win", 100, 200);
		}
		
		if(applet.mousePressed) {
			if(applet.mouseButton == applet.RIGHT) {
				if(minesLeft > 0) {
					
					Coordinate mouseClickedLocation = new Coordinate(mouseX, mouseY);
					Coordinate mouseGridLocation = getGridLocation(mouseClickedLocation);
					if(position[mouseGridLocation.x][mouseGridLocation.y].flagged == false) {
						minesLeft--;
						position[mouseGridLocation.x][mouseGridLocation.y].flagged = true;
						MineGridBox gridbox = new MineGridBox(2.2);
						gridbox.moveToSprite(position[mouseGridLocation.x][mouseGridLocation.y]);
						if(position[mouseGridLocation.x][mouseGridLocation.y].mined) {
							gridbox.mined = true;
							actualMinesLeft--;
						}
						gridbox.surroundingMines = position[mouseGridLocation.x][mouseGridLocation.y].surroundingMines;
						position[mouseGridLocation.x][mouseGridLocation.y] = gridbox;
						gridbox.display();
						gridbox.flagged = true;
						textSize(20);
						fill(255);
						text("flag", gridbox.getX() - 15, gridbox.getY());
					}
					
				}
			} 
			else {
				Coordinate mouseClickedLocation = new Coordinate(mouseX, mouseY);
				Coordinate mouseGridLocation = getGridLocation(mouseClickedLocation);
				if(position[mouseGridLocation.x][mouseGridLocation.y].clicked == false) {
					position[mouseGridLocation.x][mouseGridLocation.y].clicked = true;
					if(position[mouseGridLocation.x][mouseGridLocation.y].mined) {
						System.exit(0);
					}
					if(position[mouseGridLocation.x][mouseGridLocation.y].flagged) {
						minesLeft++;
					}
					MineGridBox gridbox = new MineGridBox(0);
					gridbox.moveToSprite(position[mouseGridLocation.x][mouseGridLocation.y]);
					gridbox.surroundingMines = position[mouseGridLocation.x][mouseGridLocation.y].surroundingMines;
					position[mouseGridLocation.x][mouseGridLocation.y] = gridbox;
					gridbox.display();
					gridbox.clicked = true;
					textSize(20);
					fill(255);
					text("" + position[mouseGridLocation.x][mouseGridLocation.y].surroundingMines, gridbox.getX() , gridbox.getY());
				}
			}
		}	
		
			
			
	}
	Coordinate randomSelect() {
		Random rand = new Random();
		int randomX = rand.nextInt(16);
		int randomY = rand.nextInt(16);
		Coordinate coordinate = new Coordinate(randomX, randomY);
		return coordinate;
	}
	Coordinate randomSelect(int bound) {
		Random rand = new Random();
		int randomX = rand.nextInt(bound);
		int randomY = rand.nextInt(bound);
		Coordinate coordinate = new Coordinate(randomX, randomY);
		return coordinate;
	}
	Coordinate getPosition(MineGridBox[][] grid, MineGridBox box) {
		Coordinate position = new Coordinate();
		for(int i = 0; i < grid.length; i++) {
			MineGridBox[] row = grid[i];
			ArrayList<MineGridBox> row1 = new ArrayList<MineGridBox>();
			//"converts" row into ArrayList
			for(int j = 0; j < row.length; j++) {
				row1.add(row[j]);
			}
				 //
			if(row1.contains(box)) {
				position.x = i;
				for(int k = 0; k < row.length; k++) {
					if(row[k].equals(box)) {
						position.y = k;
					}
				}
					 
			}
				 
		}
			 return position;
			 
	}
	Coordinate getGridLocation(Coordinate screenLocation) {
		int screenY = screenLocation.y;
		int screenX = screenLocation.x;
		screenX -= 325;
		return new Coordinate(screenY/50, screenX/50);
		
	}

} 

