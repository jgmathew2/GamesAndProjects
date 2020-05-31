import processing.core.PApplet;
	import processing.event.KeyEvent;

	import java.util.ArrayList;
	import java.util.Calendar;
	import java.util.GregorianCalendar;
	import java.util.Iterator;
	
public class SpaceFighterSave2 {
	//This is just a second save, used for copy pasting, not for running
}
/*
	

	


	class AAsteroid extends MoveableSprite {
		boolean isDestroyed = false;
	    static final String url = "/Users/johan/Desktop/Screen Shot 2019-07-24 at 10.09.02 PM.png";
	    int health = 60; 

	    float speed = 2;

	    AAsteroid() {
	    	super(url, 0, 0, 50, 50);
			PApplet p = super.getPApplet();
			float angle = p.random(0, 360);
			float x = 1450 + 200 * p.sin(angle);
			float y = 800 + 200 * p.cos(angle);
			this.moveToPoint(x, y);
			
			this.turn(p.random(0, 360));
	    }

	    public void move() {
	    	this.forward(speed);
	    	
	    	
	    }

	}
	class Bullet extends MoveableSprite {
		int health = 30;
		static final String url = "file:///Users/johan/Desktop/Screen Shot 2019-07-31 at 9.39.21 AM.png";
		public boolean isDestroyed;
		Bullet() {
			super(url, 50, 50, 50, 15);
		}
		public void move() {
			//while(this.isInsideScreen()) forward(3);
			left(3);
			
		}
	}
	class PlayerBullet extends Bullet {
		int health = 30;
		static final String url = "file:///Users/johan/Desktop/Screen Shot 2019-07-31 at 9.39.21 AM.png";
		public boolean isDestroyed;
		PlayerBullet() {
			super();
		}
		public void move() {
			//while(this.isInsideScreen()) forward(3);
			left(3);
			
		}
		
		
	}
	class Enemy1 extends MoveableSprite {
		boolean isDestroyed;
		static final String url = "file:///Users/johan/Desktop/Screen Shot 2019-08-01 at 1.03.41 PM.png";
		Enemy1() {
			super(url, 250, 200, 50, 50);
			PApplet p = super.getPApplet();
			float angle = p.random(0, 360);
			float x = 1450 + 200 * p.sin(angle);
			float y = 800 + 200 * p.cos(angle);
			this.moveToPoint(x, y);
		}
		public void move() {
			this.turnToSprite(SpaceFighter.p);
			this.forward(2);
		}
	}
	class Enemy2 extends MoveableSprite {
		boolean isDestroyed;
		float speed = 2;
		public int health = 25;
		static final String url = "file:///Users/johan/Desktop/Screen Shot 2019-08-03 at 4.44.52 PM.png";
		Enemy2() {
			super(url, 250, 200, 50, 50);
			PApplet p = super.getPApplet();
			float angle = p.random(0, 360);
			float x = 1450 + 200 * p.sin(angle);
			float y = 800 + 200 * p.cos(angle);
			this.moveToPoint(x, y);
			
			this.turn(p.random(0, 360));
		}
		public void move() {
			this.left(speed);
		}
		public void fire() {
			EnemyBullet bullet = new EnemyBullet();
			SpaceFighter.sprites.add(bullet);
			bullet.moveToSprite(this);
			bullet.turnToDir(this.getDir());
		}
	}
	class EnemyBullet extends PlayerBullet {
		EnemyBullet() {
			super();
		}
	}
	class APlayer extends MoveableSprite {
		double rotation;
	    static final String url = "http://1.bp.blogspot.com/-SqwrVIJoXXY/U9vXJm7TiiI/AAAAAAAABwU/DyQAiOXcIgU/s1600/blueships1.png";
	    static int playerRotation = 0;

	    static int health = 100;

	    APlayer() {
	    	super(url, 250, 200, 50, 50);
	    }

	    // overrides the superclass's move function
	    public void move() {
		   	PApplet p = getPApplet();
		   	if (p.keyPressed) {
			   	if (p.keyCode == p.LEFT) {
			   	this.turn(-5);
			   	playerRotation += -5;
			   	}
			   	if (p.keyCode == p.RIGHT) {
			   		this.turn(5);
			   		playerRotation += 5;
			   	}
			   	if (p.keyCode == p.UP) {
			   		this.forward(2);
			   	}
			   	if(p.keyCode == p.DOWN) {
			   		this.turn(180);
			   		this.forward(2);
			   		this.turn(-180);
			   	}
			   	if(p.keyCode == 1) {
			   		this.backward(1);
			   	}
		   	}
		   	
		}
	    void setHealth(int health) {
	    	this.health = health;
	    }
	}
	//class Enemy extends  MoveableSprite {
		
	//}
	abstract class MoveableSprite extends Sprite {
		int health;

	    MoveableSprite(String url, float x, float y, float w, float h) {
	   	super(url, x, y, w, h);
	    }

	    // meant to be overridden by the subclass to move this Sprite
	    public abstract void move();
	    
	    public void wrap() {
	    if(super.getX() < 0) {
	    	super.moveX(1450);
	    }
	    if(super.getX() > 1450) {
	    	super.moveX(-1450);
	    }
	    if(super.getY() < 0) {
	        super.moveY(800);
	    }
	    if(super.getY() > 800) {
	       super.moveY(-800);
	    }

	    }
	}
	public class SpaceFighter extends PApplet {
		private int destroyedAsteroids = 0;
		private int destroyedEnemies = 0;
	    static APlayer p;
	    Calendar lastTime = new GregorianCalendar();
	   
	  
	    static ArrayList<MoveableSprite> sprites;
	    //public: variables or methods declared public can be used and are visible outside the class. 
	    //private:variables declared private cannot be used outside the class.
	    public static int round = 1;
	    public static int actualRound = 1;
	    public static boolean roundCompleted = false;

	    public void setup() {
	    	
	   	Sprite.init(this);
	   	p = new APlayer();
	   	PApplet applet = p.getPApplet();
	   	
	   	
	   	
	   	size(500, 400);

	      sprites = new ArrayList<MoveableSprite>();
	      sprites.add(p);
	      
	      if(round == 1) {
	      	  SpaceFighter.roundCompleted = false;
	      	  for(int i = 0; i < 10; i++) {
	      		  sprites.add(new AAsteroid());
	      	  }
	      }
	        
	      
	      
	 }
	      
	      

	    	  
	    	


	    public void draw() {
	    	boolean enemyFire = false;
	    	int count = 0;
		    background(0, 0, 0);
	    	
	    	if(destroyedAsteroids == 10 && round == 1) {
	  		  sprites.clear();
	  		  sprites.add(p);
	  		  round++;
	  		  roundCompleted = true;
	  		  destroyedAsteroids = 0;
	    	}
	  		if((destroyedAsteroids + destroyedEnemies) == 15 && actualRound == 2) {
	  			sprites.clear();
	  			sprites.add(p);
	  			round = 3;
	  			roundCompleted = true;
	  			destroyedAsteroids = 0; 
	  			destroyedEnemies = 0;
	  		}
	  	  
	    	
		    textSize(20);
		    fill(255);
		    text("Health: " + p.health, 100, 100);
		    text("Round" + actualRound, 100, 100, 100, 100);
		    text("Destroyed:" + (destroyedAsteroids + destroyedEnemies), 100, 120, 600, 600);
		    if(roundCompleted) {
			    String roundCompletedText = "Round " + round + " Completed";
			    textSize(60);
			    fill(255);
			    text(roundCompletedText, 300, 300, 500, 500);
				delay(4000);
			    fill(0);
			    text(roundCompletedText, 300, 300, 500, 500);
			    roundCompleted = false;
		    }
		    
		    	if(round == 2) {
		      	  SpaceFighter.roundCompleted = false;
		      	  for(int i = 0; i < 5; i++) {
		      		  sprites.add(new AAsteroid());
		      	  }
		      	  for(int i = 0; i < 10; i++) {
		      		  sprites.add(new Enemy1());
		          }
		      	  actualRound = 2;
		      	  round = 0;
		    	}
		    	if(round == 3) {
			      	  SpaceFighter.roundCompleted = false;
			      	  for(int i = 0; i < 10; i++) {
			      		  sprites.add(new AAsteroid());
			      	  }
			      	  for(int i = 0; i < 5; i++)  {
			      		  sprites.add(new Enemy2());
			      	  }
			      	  actualRound = 3;
			      	  round = 0;
			      	  
		    	}
		    	
		   
		    PApplet applet = p.getPApplet();
		    //boolean timer = true;
		    Calendar currentTime = new GregorianCalendar();
			currentTime.add(Calendar.MILLISECOND, -500);
			if(lastTime.compareTo(currentTime) < 0) {
				enemyFire = true;
		    if(applet.keyPressed) {
		    	if(applet.key == 'f') {
		    		//if(timer) {
			    		PlayerBullet bullet = new PlayerBullet();
			    		bullet.moveToSprite(p);
			    		bullet.turn(APlayer.playerRotation + 90);
			    		sprites.add(bullet);
			    		
			    		
			    		lastTime = new GregorianCalendar();
		    		}
		    		//}
		    		/*Thread timerThread = new Thread();
		    		timerThread.start();
		    		try {
						timerThread.wait(2000);
						timer = true;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					*/
		    	
		    		
/*		    		
		    	}
		    }
			else {
				enemyFire = false;
			}
		    if(APlayer.health <= 0)  {
		    	textSize(100);
		    	fill(255);
		    	text("Game Over", 550, 400, 500, 500);
		    	stop();
		    }
		    Iterator<MoveableSprite> iter = sprites.iterator();
		    Iterator<MoveableSprite> iter2 = sprites.iterator();
		    while(iter.hasNext()) {
		    	MoveableSprite s = iter.next();
			    s.display();
		
	    		
			    
			    if(s instanceof Enemy1) {
			    	if(((Enemy1) s).isDestroyed) {
			    		iter.remove();
			    		destroyedEnemies++;
			    		
			    	}
			    }
			    if(s instanceof Enemy2) {
			    	if(((Enemy2) s).isDestroyed) {
			    		iter.remove();
			    		destroyedEnemies++;
			    	}	
			    	if(enemyFire) {
				    	((Enemy2) s).fire();
			    		  	
			    	}
			        
			    }
			    if(s instanceof PlayerBullet) {
			    	if(((PlayerBullet) s).health <= 0) iter.remove();
			    	if(s.isInsideScreen() == false) iter.remove();
			    	if(((PlayerBullet) s).isDestroyed) iter.remove();
			    }
			    
			    else s.wrap();
			    s.move();
			    if(s instanceof AAsteroid && ((AAsteroid) s).health <= 0) {
			    	iter.remove();
			    	destroyedAsteroids++;
			    	continue;
			    }
			    if(s instanceof AAsteroid && s.touchingSprite(p)) {
			    	if(s.touchingSprite(p)) {
					    s.turn(45);
					    for(int i = 0; i < 50; i++) {
				              
					    	  s.forward(1);
					    }
					    	  
					    p.health-= 20;
					    AAsteroid sa = (AAsteroid) s;
					    sa.health -= 20;
			    	}
			    	
				    
			    }
			    for(MoveableSprite s2 : sprites) {
			    	
			    	if(s instanceof AAsteroid && s2 instanceof AAsteroid && s.touchingSprite(s2) && s != s2) {
			    		s = (AAsteroid) s;
			    		s2 = (AAsteroid) s2;
			    		s.turn(45);
			    		s2.turn(-45);
			    		for(int i = 0; i < 50; i++) {
				    		  
					    	  s.forward(3);
					    }
			    		for(int i = 0; i < 50; i++) {	  
					    	  s2.forward(3);
					    }
			    		AAsteroid sa = (AAsteroid) s;
			    		AAsteroid sa2 = (AAsteroid) s2;
			    		sa.health -= 10;
			    		sa2.health -= 10;
			    
			    	}
			    	if(s instanceof PlayerBullet && s2 instanceof AAsteroid && s.touchingSprite(s2)) {
			    		((AAsteroid) s2).health -= 40;
			    		((PlayerBullet) s).isDestroyed = true;
			    	}
			    	if(s instanceof Enemy1 && s2 instanceof PlayerBullet && s.touchingSprite(s2)) {
			    		((PlayerBullet) s2).health -= ((Enemy1) s).health;
			    		((Enemy1) s).isDestroyed = true;
			    	}
			    	if(s instanceof Enemy2 && s2 instanceof PlayerBullet && s.touchingSprite(s2)) {
			    		((PlayerBullet) s2).health -= ((Enemy2) s).health;
			    		((Enemy2) s).isDestroyed = true;
			    	}
			    	
			    
			    }
			    if(s instanceof Enemy1 && s.touchingSprite(p)) {
			    	p.health -= 10;
			    	((Enemy1) s).isDestroyed = true;
			    } 
			    if(s instanceof Enemy2 && s.touchingSprite(p)) {
			    	p.health -= 25;
			    	((Enemy2) s).isDestroyed = true;
			    } 
			    if(s instanceof EnemyBullet && s.touchingSprite(p)) {
			    	p.health -= 15;
			    	((EnemyBullet) s).isDestroyed  = true;
			    }
				    	  
			    
		    }  	
	    }
*/



