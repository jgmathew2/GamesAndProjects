
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import processing.core.*;

class PlayableArea extends Sprite {
	static final String url = "/Users/johan/Desktop/BlackBox.png";
	PlayableArea() {
		super(url, 0, 0, 800, 800);
	}
	
}
class GridBox extends Sprite {
	boolean snaked = false;
	static final String url = "/Users/johan/Desktop/BlackBox.png";
	GridBox() {
		super(url, 0, 0, 50, 50);
	}
	GridBox(int size) {
		super(url, 0, 0, size, size);
	}
	GridBox(String url) {
		super(url, 0, 0, 50, 50);
	}
	GridBox(String url, int size) {
		super(url, 0, 0, size, size);
	}
	
}
class Snake extends GridBox {
	Snake() {
		super("/Users/johan/Desktop/GreenBox.png");
	}
	Snake(String url) {
		super(url);
	}
	
}
class SnakeHead extends Snake {
	SnakeHead() {
		super("/Users/johan/Desktop/SnakeHead.png");
	}
}
class Apple extends GridBox {
	Apple() {
		super("/Users/johan/Desktop/Apple.png");
	}
}
public class SnakeGame extends PApplet {
	int snakeLength = 3;
	
	 Snake snake;
	 Apple apple;
	 GridBox[][] position;
	 Coordinate snakeLocation;
	 Coordinate appleLocation;
	 GregorianCalendar lastTime = new GregorianCalendar();
	 ArrayList<Snake> snakeBody = new ArrayList<Snake>();
	 public int direction;
	
	 public void setup() {
		   	Sprite.init(this);
		   	
		   	background(243, 243, 243);
		   	size(1450, 800);
		   	snake = new Snake();
		   	apple = new Apple();
		   	position = new GridBox[16][16];
		    snakeLocation = randomSelect(15);
		    appleLocation = randomSelect(15);
		    direction = 1;
		    for(int i = 0; i < 16; i++) {
				for(int j = 0; j < 16; j++) {
					GridBox gridbox = new GridBox();
					position[i][j] = gridbox;
					gridbox.moveToPoint(350 + 50 * j, 25 + 50 * i);
					gridbox.display();
					
				}
		    }
		    position[appleLocation.x][appleLocation.y] = apple;
		    position[snakeLocation.x][snakeLocation.y] = snake;
		    
		    snakeBody.add(snake);
		    
		   
		    
		   	
	 }
	 
	 
	 
	 
	 	      
	 public void draw() {
		background(0, 243, 0);
		int score = snakeLength - 3;
		fill(100);
		textSize(50);
		text("Score: " + score, 0, 0, 300, 100);
		Snake p = new Snake();
		PApplet applet = p.getPApplet();
		final PlayableArea area = new PlayableArea();
		area.moveToPoint(725, 400);
		area.display();
		
		
		if(applet.keyPressed) {
			if(applet.keyCode == applet.UP)  {
				if(direction != 3) {
					direction = 1;
				}
				
			}
			if(applet.keyCode == applet.DOWN) {
				if(direction != 1) {
					direction = 3;
				}
			}
			if(applet.keyCode == applet.LEFT) {
				if(direction != 0) {
					direction = 2;
				}
			}
			if(applet.keyCode == applet.RIGHT) {
				if(direction != 2) {
					direction = 0;
				}
			}
		}
		
		for(int i = 0; i < 16; i++) {
			for(int j = 0; j < 16; j++) {
				GridBox gridbox = position[i][j];
				gridbox.moveToPoint(350 + 50 * j, 25 + 50 * i);
				gridbox.display();
			}
		}
		
		Calendar currentTime = new GregorianCalendar();
		currentTime.add(Calendar.MILLISECOND, -300);
		if(lastTime.compareTo(currentTime) < 0) {
			if(direction == 0) {
				snakeLocation.y++;
			}
			if(direction == 1) {
				snakeLocation.x--;
			}
			if(direction == 2) {
				snakeLocation.y--;
			}
			if(direction == 3) {
				snakeLocation.x++;
			}
			if(snakeLocation.x >= 16 || snakeLocation.y >= 16 || snakeLocation.x < 0 || snakeLocation.y < 0) {
				System.exit(0);
			}
			if(position[snakeLocation.x][snakeLocation.y] instanceof Snake) {
				System.exit(0);
			}
			Snake newHead = new Snake();
			position[snakeLocation.x][snakeLocation.y] = newHead; 
			
			
			snakeBody.add(newHead);
			if(snakeLocation.equals(appleLocation)) {
				snakeLength++;
				appleLocation = randomSelect(15);
				while(position[appleLocation.x][appleLocation.y] instanceof Snake) {
					appleLocation = randomSelect(15);
				}
				Apple apple = new Apple();
				position[appleLocation.x][appleLocation.y] = apple; 
			}
			
			Snake tail = snakeBody.get(0);
			
			
			
			if(snakeBody.size() - 1 == snakeLength) {
				
				Coordinate coordinate = getPosition(position, tail);
				GridBox replacement = new GridBox();
				position[coordinate.x][coordinate.y] = replacement; 
				snakeBody.remove(tail);
			}
			
			
			
			
			lastTime = new GregorianCalendar();
			
			
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
	 Coordinate getPosition(GridBox[][] grid, GridBox box) {
		 Coordinate position = new Coordinate();
		 for(int i = 0; i < grid.length; i++) {
			 GridBox[] row = grid[i];
			 ArrayList<GridBox> row1 = new ArrayList<GridBox>();
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

} 
class Coordinate {
	public int x = 0;
	public int y = 0;
	Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	Coordinate() {}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	
	
}
	

