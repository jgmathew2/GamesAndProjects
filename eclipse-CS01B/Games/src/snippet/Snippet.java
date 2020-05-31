package snippet;

public class Snippet {
	Enemy1() {
			super(url, 250, 200, 50, 50);
			PApplet p = super.getPApplet();
			float angle = p.random(0, 360);
			float x = 1450 + 200 * p.sin(angle);
			float y = 800 + 200 * p.cos(angle);
			this.moveToPoint(x, y);
		}
}

