
import java.util.ArrayList;

public class Lesson4FakeAsteroids {
	
	//inheritance is when a class extends another class
	//superclass(parent) refers to class being extended
	//subclass(child) is class extending
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CanvasObject player = new Player();
		ArrayList<CanvasObject> objects = new ArrayList<CanvasObject>();
		objects.add(player);
		
		for(int i = 0; i < 10; i++) {
			objects.add(new Asteroid());
		
		}
		for(CanvasObject o : objects) {
			o.display();
		}
	
	
	
	}

}
class CanvasObject {
	double x;
	double y;
	 
	CanvasObject(double x, double y) {
	this.x = x;
	this.y = y;
	}
	
	void display() {
	Utils.println("displaying object");
	}
	void move() {
		Utils.println("moving object");
	}
}
//the constructor of a subclass must call the constructor of the superclass
//if no call to the superclass is given, calls superclass's default constructor
class Asteroid extends CanvasObject {
	double x;
	double y;
	int size;
	//Asteroid inherits everything in Canvas Object
	//You no longer have to declare double x and double y, those were inherited
	Asteroid() {
		super((double) Math.random() * 500, (double) Math.random() * 500);
		size = 50;
	}
	//redefining the display function that was in Canvas Object is overriding
	// Completely replace original CanvasObject function with your own
	//To override, functions have to have the same name and inputs
	void display() {
		Utils.println("displaying asteroid");
	}
}
	
class Player extends CanvasObject {
	double x; 
	double y;
	int health;
	Player() {
		super(250, 250);
		health = 1000;
	}
	void move() {
	
	}
	void display() {
		Utils.println("displaying player");
	
	}
}

