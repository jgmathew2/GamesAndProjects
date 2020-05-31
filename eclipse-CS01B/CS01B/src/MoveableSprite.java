
 abstract public class MoveableSprite extends Sprite {
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
