import java.util.Random;

import processing.core.PApplet;

class PlayerPaddle extends MoveableSprite {
	public static int bearing;
	static final String url = "/Users/johan/Desktop/PongPaddle.png";
	PlayerPaddle() {
		super(url, 300, 300, 120, 9);
	}
	
	public void move() {
		PApplet p = getPApplet();
	   	if (p.keyPressed) {
	   		
		   	if (p.keyCode == p.LEFT) {
		   		if(this.getX() > 60) {
		   			bearing-= 2;
		   		}
		   		
		   	}
		   	if (p.keyCode == p.RIGHT) {
		   		if(this.getX() < 740) {
		   			bearing += 2;
		   		}
		   		
		   	}
		   	
	   	}
	}
}
class EnemyPaddle extends PlayerPaddle {
	static final String url = "/Users/johan/Desktop/PongPaddle.png";
	EnemyPaddle() {
		super();
	}
	public void move(float ballXPosition) {
		if(this.getX() < ballXPosition) this.forward(2);
		if(this.getX() > ballXPosition) this.backward(2);
	}
}
class Ball extends MoveableSprite {
	public static int direction; 
	static final String url = "/Users/johan/Desktop/PongBall.png";
	Ball() {
		super(url, 300, 300, 20, 20);
	}
	public void move() {
		if(direction < 0) direction += 360;
		if(direction > 360) direction -= 360;
		this.turnToDir(direction - 180);
		this.forward(4);
	}
}

public class Pong extends PApplet {
	
	PlayerPaddle p;
	EnemyPaddle e;
	Ball ball;
	int enemyPoints = 0; 
	int playerPoints = 0;
	public void setup() {
		
		size(800, 800);
		background(0, 0, 0);
		Sprite.init(this);
		p = new PlayerPaddle();
		e = new EnemyPaddle();
		p.moveToPoint(400, 750);
		e.moveToPoint(400, 50);
		ball = new Ball();
		Random rand = new Random();
		Ball.direction = 270;
		
	}
	public void draw() {
		background(0, 0, 0);
		ball.display();
		ball.move();
		p.move();
		p.display();
		e.display();
		p.moveToPoint(400 + PlayerPaddle.bearing , 700);
		e.move(ball.getX());
		if(ball.getX() <= 0 || ball.getX() > 800) {
			int direction = Ball.direction;
			if(direction > 0 && direction < 180) {
				direction = 90 - direction + 90;
			}
			else {
				direction = 270 - direction + 270;
			}
			Ball.direction = direction;
		}
		if(ball.touchingSprite(p)) {
			Random rand = new Random();
			int random = rand.nextInt(30) + 60;
			if(Ball.direction > 179 && Ball.direction < 271) {
				
				Ball.direction -= random;
			}
			else if(Ball.direction > 270) {
				Ball.direction += random;
			}
			
		}
		if(ball.touchingSprite(e)) {
			Random rand = new Random();
			int random = rand.nextInt(30) + 60;
				if(Ball.direction < 91) {
					Ball.direction -= random;
				}
				if(Ball.direction > 90 && Ball.direction < 180) {
					Ball.direction += random;
				}

		
	
		}
		if(ball.getY() < 0) {
			playerPoints++;
			textSize(100);
			text("" + playerPoints + " - " + enemyPoints, 100, 400);
			p.moveToPoint(400, 750);
			e.moveToPoint(400, 50);
			ball = new Ball();
			ball.moveToPoint(400, 400);
			ball.display();
			Random rand = new Random();
			Ball.direction = 90;
			delay(2000);
		
		}
		if(ball.getY() > 800) {
			enemyPoints++;
			textSize(100);
			text("" + playerPoints + " - " + enemyPoints, 100, 400);
			p.moveToPoint(400, 750);
			e.moveToPoint(400, 50);
			
			ball = new Ball();
			ball.moveToPoint(400, 400);
			ball.display();
			Random rand = new Random();
			Ball.direction = 90;
			delay(2000);
		
		}
		if(playerPoints > 5) {
			text("You Win", 200, 400);
		}
		if(enemyPoints > 5) {
			text("You Lose", 200, 400);
		}
		
	}

}
