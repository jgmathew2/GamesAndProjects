
import processing.core.PApplet;
import processing.event.KeyEvent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.TreeSet;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
 import javax.sound.sampled.Clip;



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
class TurretBox extends MoveableSprite {
	static final String url = "/Users/johan/Desktop/Turret Box.png";
	TurretBox(int x, int y) {
		super(url, 0, 0, 50, 70);
		this.moveToPoint(x, y);
	}
	public void move() {
		
	}
}
class Turret extends MoveableSprite {
	int health = 200;
	boolean isDestroyed = false;
	static final String url = "/Users/johan/Desktop/Eclipse Game Turret.png";
	Turret(TurretBox box) {
		super(url, 0, 0, 50, 50);
		this.moveToSprite(box);
	}
	public void move() {}
}
class MegaAsteroid extends MoveableSprite {
	boolean isDestroyed = false;
    static final String url = "/Users/johan/Desktop/Screen Shot 2019-07-24 at 10.09.02 PM.png";
    float speed = 1;

	
	MegaAsteroid() {
		super(url, 0, 0, 100, 100);
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
	static final String url = "file:///Users/johan/Desktop/Bullet.png";
	public boolean isDestroyed;
	Bullet() {
		super(url, 50, 50, 50, 15);
	}
	Bullet(String url, float x, float y, float w, float h) {
	    super(url, x, y, w, h);
	}
	public void move() {
		//while(this.isInsideScreen()) forward(3);
		this.left(3);
		
	}
	
}
class PlayerBullet extends Bullet {
	int health = 40;
	public boolean isDestroyed;
	PlayerBullet() {
		super();
	}
	public void move() {
		//while(this.isInsideScreen()) forward(3);
		this.left(3);
		
	}
	
	
}
class EnemyBullet extends Bullet {
	static final String url = "file:///Users/johan/Desktop/EnemyBullet.png";
	int health = 15;
	boolean isDestroyed = false;
	
	EnemyBullet() {
		super(url, 50, 50, 50, 15);
	}
	public void move() {
		//while(this.isInsideScreen()) forward(3);
		this.left(3);
		
	}
}
class Boss1 extends Enemy1 {
	boolean isDestroyed;
	
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
	Enemy1(int size) {
		super(url, 250, 200, size, size);
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
	public int health = 60;
	static final String url = "file:///Users/johan/Desktop/Screen Shot 2019-08-03 at 4.44.52 PM.png";
	float x;
	float y;
	Enemy2() {
		super(url, 250, 200, 50, 50);
		PApplet p = super.getPApplet();
		float angle = p.random(0, 360);
		x = 1450 + 200 * p.sin(angle);
		y = 800 + 200 * p.cos(angle);
		this.moveToPoint(x, y);
		
		this.turn(p.random(0, 360));
	}
	public void move() {
		this.left(speed);
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


public class SpaceFighter extends PApplet {
	private int destroyedAsteroids = 0;
	private int destroyedEnemies = 0;
    static APlayer p;
    Calendar lastTime = new GregorianCalendar();
    Calendar lastTime2 = new GregorianCalendar();
    //Sprite turretBoxPosition1 = new 
    
    
   
  
    static ArrayList<MoveableSprite> sprites;
    //public: variables or methods declared public can be used and are visible outside the class. 
    //private:variables declared private cannot be used outside the class.
    public static int round = 1;
    public static int actualRound = 1;
    public static boolean roundCompleted = false;

    public void setup() {
    	
   	Sprite.init(this);
   	p = new APlayer();
   	//PApplet applet = p.getPApplet();
   	
   	
   	
   	size(1450, 800);

      sprites = new ArrayList<MoveableSprite>();
      sprites.add(p);
      
        
      
      
 }
      
      

    	  
    	


    public void draw()  {
    	
    	
    	boolean enemyFire = false;
    	int count = 0;
	    background(0, 0, 0);
    	
    	if(destroyedAsteroids == 10 && actualRound == 1) {
  		  sprites.clear();
  		  sprites.add(p);
  		  round = 2;
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
  		if((destroyedAsteroids + destroyedEnemies) == 15 && actualRound == 3) {
  			sprites.clear();
  			sprites.add(p);
  			round = 4;
  			roundCompleted = true;
  			destroyedAsteroids = 0; 
  			destroyedEnemies = 0;
  			
  		}
  		if(destroyedEnemies == 1 && actualRound == 4) {
  			sprites.clear();
  			sprites.add(p);
  			round = 5;
  			roundCompleted = true;
  			destroyedAsteroids = 0;
  			destroyedEnemies = 0;
  			p.health = 120;
  		}
  		if((destroyedEnemies + destroyedAsteroids) == 43 && actualRound == 5) {
  			sprites.clear();
  			sprites.add(p);
  			round = 6;
  			roundCompleted = true;
  			destroyedAsteroids = 0;
  			destroyedEnemies = 0;
  		}
  		if(actualRound == 6 && destroyedEnemies == 3) {
  			sprites.clear();
  			sprites.add(p);
  			round = 7; 
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
		    fill(0);
		    text(roundCompletedText, 300, 300, 500, 500);
		    roundCompleted = false;
	    }
	    if(round == 1) {
	      	  SpaceFighter.roundCompleted = false;
	      	  for(int i = 0; i < 10; i++) {
	      		  sprites.add(new AAsteroid());
	      	  }
	      	  round = 0;
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
	    if(round == 4) {
	    	actualRound = 4;
	    	round = 0; 
	    	TurretBox box = new TurretBox(670, 360);
	    	sprites.add(box);
	    	sprites.add(new Turret(box));
	    }
	    if(round == 5) {
	    	actualRound = 5;
	    	SpaceFighter.roundCompleted = false;
	    	for(int i = 0; i < 6; i++) {
	    		sprites.add(new Enemy2());
	    	}
	    	for(int i = 0; i < 5; i++) {
	    		sprites.add(new AAsteroid());
	    	}
	    	for(int i = 0; i < 4; i++) {
	    		sprites.add(new MegaAsteroid());
	    	}
	    	round = 0;
	    		
	    }
	    if(round == 6) {
	    	actualRound = 6; 
	    	TurretBox box = new TurretBox(335, 360);
	    	TurretBox box2 = new TurretBox(670, 360);
	    	TurretBox box3 = new TurretBox(1105, 360);
	    	box.display();
	    	box2.display();
	    	box3.display();
	    	sprites.add(new Turret(box));
	    	sprites.add(new Turret(box2));
	    	sprites.add(new Turret(box3));
	    	round = 0;
	    }
	    if(round == 7) {
	    	actualRound = 7;
	    	round = 0;
	    	TurretBox box = new TurretBox(670, 360);
	    	box.display();
	    	sprites.add(new Turret(box));
	    	for(int i = 0; i < 10; i++) {
	    		sprites.add(new Enemy1());
	    	}
	    	
	    }
	   
	    PApplet applet = p.getPApplet();
	    //boolean timer = true;
	    Calendar currentTime = new GregorianCalendar();
		currentTime.add(Calendar.MILLISECOND, -500);
		if(lastTime.compareTo(currentTime) < 0) {
		    if(applet.keyPressed) {
		    	if(applet.key == ' ') {
		    		//if(timer) {
			    		PlayerBullet bullet = new PlayerBullet();
			    		bullet.moveToSprite(p);
			    		bullet.turn(APlayer.playerRotation + 90);
			    		sprites.add(bullet);
			    		lastTime = new GregorianCalendar();
		    	}
		    }
	    }
		Calendar currentTime2  = new GregorianCalendar();
		currentTime2.add(Calendar.SECOND, -1);
		if(lastTime2.compareTo(currentTime2) < 0) {
			enemyFire = true;
		    lastTime2 = new GregorianCalendar();
	    }
	    if(APlayer.health <= 0)  {
	    	textSize(100);
	    	fill(255);
	    	text("Game Over", 550, 400, 500, 500);
	    	stop();
	    }
	    HashSet<Enemy2> enemy2Army = new HashSet<Enemy2>();
	    HashSet<Turret> turretArmy = new HashSet<Turret>();
	    
	    
	    
	    ListIterator<MoveableSprite> iter = sprites.listIterator();
	    
	    
	    
	   
	    while(iter.hasNext()) {
	    	MoveableSprite s = iter.next();
		    s.display();
		    if(s instanceof Enemy2) {
		    	Enemy2 enemy = (Enemy2) s;
		    	if(enemy.health <= 0) enemy.isDestroyed = true;
		    	if(((Enemy2) s).isDestroyed) {
		    		iter.remove();
		    		destroyedEnemies++;
		    		
		    	}	
		    	
		    	
		    		  	
		    }
		    
		    
		   
	
    		
		    
		    if(s instanceof Enemy1) {
		    	if(((Enemy1) s).isDestroyed) {
		    		iter.remove();
		    		destroyedEnemies++;
		    		
		    	}
		    }
		    if(s instanceof Turret) {
		    	if(((Turret) s).health < 0 || ((Turret) s).isDestroyed) {
		    		iter.remove();
		    		destroyedEnemies++;
		    	}
		    }
		  
		        
		    
		   
		    if(s instanceof EnemyBullet) {
		    	if(((EnemyBullet) s).health <= 0) iter.remove();
		    	else if(s.isInsideScreen() == false) iter.remove();
		    	else if(((EnemyBullet) s).isDestroyed) iter.remove();
		    }
		    else if(s instanceof PlayerBullet) {
		    	if(((PlayerBullet) s).health <= 0) iter.remove();
		    	else if(s.isInsideScreen() == false) iter.remove();
		    	else if(((PlayerBullet) s).isDestroyed) iter.remove();
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
		    if(s instanceof MegaAsteroid && s.touchingSprite(p)) {
		    	p.health -= 80;
		    	iter.remove();
		    	destroyedAsteroids++;
		    	for(int i = 0; i < 7; i++) {
		    		AAsteroid asteroid = new AAsteroid();
		    		asteroid.display();
		    		asteroid.moveToSprite(s);
			    	asteroid.turn(45 * i);
					for(int j = 0; j < 50; j++) {
						asteroid.forward(1);
					}
					iter.add(asteroid);
		    	}
		    	
		    	continue;
		    	
		    }
		    if(s instanceof MegaAsteroid && (((MegaAsteroid) s).isDestroyed)) {
		    	iter.remove();
		    	destroyedAsteroids++;
			    for(int i = 0; i < 7; i++) {
		    		AAsteroid asteroid = new AAsteroid();
		    		asteroid.display();
		    		asteroid.moveToSprite(s);
			    	asteroid.turn(45 * i);
					for(int j = 0; j < 50; j++) {
						asteroid.forward(1);
					}
					
					iter.add(asteroid);
					continue;
					
		    	}
			    
		    }
		    if(s instanceof Enemy1 && s.touchingSprite(p)) {
		    	p.health -= 10;
		    	destroyedEnemies++;
		    	iter.remove();
		    } 
		    if(s instanceof Enemy2 && s.touchingSprite(p)) {
		    	p.health -= 25;
		    	destroyedEnemies++;
		    	iter.remove();
		    } 
		    if(s instanceof EnemyBullet && s.touchingSprite(p)) {
		    	p.health -= 15;
		    	iter.remove();
		    }
		    //List<MoveableSprite> tempSrite = new ArrayList<>();
		    for(MoveableSprite s2 : sprites) {
		    	if(s == s2) {
		    		continue;
		    	}
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
		    	if(s instanceof MegaAsteroid && s2 instanceof PlayerBullet && s.touchingSprite(s2)) {
			    	((PlayerBullet) s2).isDestroyed = true;
			    	((MegaAsteroid) s).isDestroyed = true;
			    	
			    }
		    	if(s instanceof Enemy1 && s2 instanceof PlayerBullet && s.touchingSprite(s2)) {
		    		((PlayerBullet) s2).health -= ((Enemy1) s).health;
		    		((Enemy1) s).isDestroyed = true;
		    	}
		    	if(s instanceof Enemy2 && s2 instanceof PlayerBullet && s.touchingSprite(s2)) {
		    		((Enemy2) s).health -= 40;
		    		((PlayerBullet) s2).isDestroyed = true;
		    	}
		    	if(s instanceof Turret && s2 instanceof PlayerBullet && s.touchingSprite(s2)) {
		    		((PlayerBullet) s2).isDestroyed = true;
		    		((Turret) s).health -= 40;
		    	}
		    	if(s2 instanceof Enemy2) {
		    		enemy2Army.add((Enemy2) s2);
		    	}
		    	if(s2 instanceof Turret) {
		    		turretArmy.add((Turret) s2);
		    	}
		    	
		    	
		    
		    }
		    if(enemyFire) {
		    	for(Enemy2 enemy: enemy2Army) {
		    		EnemyBullet bullet = new EnemyBullet();
		    		bullet.moveToSprite(enemy);
		    		bullet.turn(enemy.getDir());
		    		bullet.move();
		    		iter.add(bullet);
		    		
		    	}
		    	for(Turret turret: turretArmy) {
		    		turret.turnToSprite(p);
		    		EnemyBullet bullet = new EnemyBullet();
		    		bullet.moveToSprite(turret);
		    		bullet.turn(turret.getDir() + 90);
		    		bullet.move();
		    		iter.add(bullet);
		    	}
		    	
		    	enemyFire = false;
		    	
		    	
		    	
		    }
		    
			    	  
		    
	    }  	
    }
}

