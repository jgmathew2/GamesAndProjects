import processing.core.*;
//have to make project or package have a Maven dependency

public class Sprite {
	private static PApplet	forcedStaticPApplet;
	// do not modify these except through the provided methods
	private PImage	_img;
	private float	_w;
	private float	_h;
	private float	_x;
	private float	_y;
	private PVector	_rotVector;	// for movement
	private float	_front	= 0;	// angle of front relative to right of image
	
	private PVector	_hitboxCenter	= new PVector();
	private PVector[]	_hitbox;
	
	private boolean	_flipped	= false;
	private PVector	out	= new PVector(-10000, -10000);	// any outside point
	
	// single public constructor to avoid transpilation errors
	public static void init(PApplet pa) {
		Sprite.forcedStaticPApplet = pa;
	}
	
	protected PApplet getPApplet() {
		if (forcedStaticPApplet != null) {
			return forcedStaticPApplet;
		}
		
		throw new Error("Sprite is not bound to a PApplet. Please call Sprite.init(this) before");
	}
		
	public Sprite(String url, float x, float y, float w, float h) {
		_img = getPApplet().loadImage(url);
		_x = x;
		_y = y;
		_w = w;
		_h = h;
		_rotVector = new PVector(1, 0, 0);
		resetRectHitbox();
	}
	
	     
	public Sprite(float x, float y, float w, float h) {
		_img = getPApplet().createImage(1, 1, PConstants.RGB);
		_x = x;
		_y = y;
		_w = w;
		_h = h;
		_rotVector = new PVector(1, 0, 0);
		resetRectHitbox();
	}
	
	  
	public Sprite(Sprite s) {
		_img = s._img;
		_x = s._x;
		_y = s._y;
		_w = s._w;
		_h = s._h;
		_rotVector = new PVector(s._rotVector.x, s._rotVector.y, 0);
		_front = s._front;
		_hitboxCenter = new PVector(s._hitboxCenter.x, s._hitboxCenter.y);
		_hitbox = new PVector[s._hitbox.length];
		for (int i = 0; i < _hitbox.length; i++) {
			_hitbox[i] = new PVector(s._hitbox[i].x, s._hitbox[i].y);
		}
		_flipped = s._flipped;
	}
	
	/**
	        * Adjust the direction of the PImage of the Sprite
	* without changing its orientation
	        * @param degrees      The degrees of turn to adjust the PImage
	        */
	public void frontAngle(float degrees) {
		float newFront = PApplet.radians(degrees);
		
		// movement done from this direction from now on
		_rotVector.rotate(newFront - _front);
		
		_front = newFront;
	}
	
	public void setRectHitbox(float w, float h) {
		_hitbox = new PVector[] {
			new PVector(-w / 2, h / 2),
			new PVector(-w / 2, -h / 2),
			new PVector(w / 2, -h / 2),
			new PVector(w / 2, h / 2)
		};
	}
	    /**
	        * Resets the Sprite's hitbox to its own width and height
	        **/
	public void resetRectHitbox() {
	setRectHitbox(_w, _h);
	}
	
	/**
	        * Sets the Sprite's hitbox to a circle.
	        * @param r     The radius of the circle
	        */
	public void setRoundHitbox(float r) {
		_hitbox = new PVector[] {
				new PVector(r, r * 2)
		};
	}
	
	public void resetRoundHitbox() {
		setRoundHitbox((_w + _h) / 4);
	}
	
	       /**
	        * Recenter the Sprite's hitbox relative to its center
	        * @param x     the offset in the x direction, in pixels
	        * @param y     the offset in the y direction, in pixels
	        */
	public void setHitboxCenter(float x, float y) {
		_hitboxCenter = new PVector(x, y);
	}
	
	       /**
	        * Recenter the Sprite's hitbox to its center
	        */
	public void resetHitboxCenter() {
		_hitboxCenter = new PVector(0, 0);
	}
	
	       /**
	        * Set the Sprite's hitbox to a polygon defined by 
	        * a list of PVectors (points) relative to its center
	        * @param array         An array of points definig the hitbox polygon
	        */
	public void setHitboxPoints(PVector[] array) {
		if (array.length > 0) {
			boolean valid = true;
		for (PVector pv : array) 
			if (pv == null)
				valid = false;
		
		if (valid) {
		_hitbox = array;
		} else {
		PApplet.print("invalid hitbox: ");
		for (PVector pv : array) {
		pv.toString();
		}
		PApplet.println();
		}
		} else {
		PApplet.print("hitbox must have 3+ points: ");
		for (PVector pv : array) {
		pv.toString();
		}
		PApplet.println();
		}
	}
	
	/**
	        * Changes the color of a Sprite. This function is only supported
	        * for Sprites created without an image.
	        * @param r     The first parameter defining the color. 
	        *              In default RGB mode, this is the red value.
	        * @param g     The second parameter defining the color.
	        *              In default RGB mode, this is the green value.
	        * @param b     The third parameter defining the color.
	        *              In default RGB mode, this is the blue value.
	        */
	public void setColor(float r, float g, float b) {
	int c = getPApplet().color(r, g, b);
	for (int x = 0; x < _img.width; x++) {
	for (int y = 0; y < _img.height; y++) {
	_img.set(x, y, c);
	}
	}
	}
	
	/**
	        * Flips Sprite image across its X axis
	        */
	public void flip() {
	_flipped = !_flipped;
	}
	
	       /**
	        * Rotates the Sprite by a specified number of degrees
	        * @param degrees       The number of degrees to turn
	        */
	public void turn(float degrees) {
	_rotVector.rotate(PApplet.radians(degrees));
	}
	
	/*z*
	        * Rotates the Sprite to face the specified (x, y) location
	        * @param x       The x coordinate of the point to face
	        * @param y       The y coordinate of the point to face
	        */
	public void turnToPoint(float x, float y) {
	_rotVector.set(x - _x, y - _y, 0);
	_rotVector.setMag(1);
	}
	
	/**
	        * Rotates the Sprite to specified (absolute) angle.
	        * @param angle         The direction to turn to
	        */
	public void turnToDir(float angle) {
	float radian = PApplet.radians(angle);
	_rotVector.set(PApplet.cos(radian), PApplet.sin(radian));
	_rotVector.setMag(1);
	}
	
	/**
	        * Rotates the Sprite to the specified Sprite s
	        * @param s     The Sprite to turn to
	        */
	public void turnToSprite(Sprite s) {
	turnToPoint(s._x, s._y);
	}
	
	       /**
	        * Moves the Sprite to the specified coordinate.
	        * @param x     The x coordinate of the point to move to
	        * @param y     The y coordinate of the point to move to
	        */
	public void moveToPoint(float x, float y) {
	_x = x;
	_y = y;
	}
	
	       /**
	        * Moves the Sprite to the specified Sprite s
	        * @param s     The Sprite to move to
	        */
	public void moveToSprite(Sprite s) {
	_x = s._x;
	_y = s._y;
	}
	
	       /**
	        * Moves the Sprite in the x axis by the specified amount.
	        * @param x     The amount to move in pixels
	        */
	public void moveX(float x) {
	_x += x;
	}
	
	       /**
	        * Moves the Sprite in the y axis by the specified amount.
	        * @param y     The amount to move in pixels
	        */
	public void moveY(float y) {
	_y += y;
	}
	
	       /**
	        * Moves the Sprite in the x and y axes by the specified amounts.
	        * @param x     The amount to move in pixels in the x axis
	        * @param y     The amount to move in pixels in the y axis
	        */
	public void moveXY(float dx, float dy) {
	_x += dx;
	_y += dy;
	}
	
	
	       /**
	        * Moves the Sprite forward in the direction it is facing.
	        * @param steps The amount to move in pixels.
	        */
	public void forward(float steps) {
		_x += _rotVector.x * steps;
		_y += _rotVector.y * steps;
	}
	public void backward(float steps) {
		this.turn(180);
   		this.forward(steps);
   		this.turn(-180);
	}
	public void left(float steps) {
		this.turn(90);
		this.backward(steps);
		this.turn(-90);
	}
	public void right(float steps) {
		this.turn(-90);
		this.forward(steps);
		this.turn(-90);
	}
	
	
	       /**
	        * Moves the Sprite in the direction 90 degrees clockwise from its forward direction.
	        * @param steps The amount to move in pixels.
	        */
	public void sideStep(float steps) {
		_rotVector.rotate(PApplet.PI / 2);
		_x += _rotVector.x * steps;
		_y += _rotVector.y * steps;
		_rotVector.rotate(-PApplet.PI / 2);
	}
	
	/**
	        * Draws the Sprite. This function should be called in the <code>void draw()</code> function.
	        */
	public void display() {
	getPApplet().pushMatrix();
	getPApplet().pushStyle();
	
	getPApplet().translate(_x, _y);
	getPApplet().rotate(_rotVector.heading() - _front);
	if (_flipped)
	getPApplet().scale(-1, 1);
	getPApplet().imageMode(PApplet.CENTER);
	getPApplet().image(_img, 0, 0, _w, _h);
	
	getPApplet().popStyle();
	getPApplet().popMatrix();
	}
	
	/**
	        * Draws the Sprite's hitbox. This function should be called in the <code>void draw()</code> function.
	        */
	public void displayHitbox() {
	PVector cen = _getCenter();
	
	getPApplet().pushStyle();
	getPApplet().stroke(255, 0, 0);
	getPApplet().strokeWeight(5);
	getPApplet().noFill();
	
	if (_hitbox.length == 1) {
	getPApplet().ellipseMode(PApplet.CENTER);
	getPApplet().ellipse(cen.x, cen.y, _hitbox[0].y, _hitbox[0].y);
	} else {
	PVector[] corners = _getPoints();
	for (int i = 0; i < corners.length; i++) {
	PVector a = corners[i];
	PVector b = corners[(i + 1) % corners.length];
	getPApplet().line(a.x, a.y, b.x, b.y);
	}
	}
	
	getPApplet().line(cen.x, cen.y, cen.x + _rotVector.x * 20, cen.y + _rotVector.y * 20);
	
	getPApplet().fill(255, 0, 0);
	getPApplet().noStroke();
	getPApplet().ellipse(cen.x, cen.y, 15, 15);
	
	getPApplet().popStyle();
	}
	
	/**
	        * Changes the direction of the Sprite by flipping
	* the x component of its direction
	        */
	public void flipX() {
	_rotVector.x *= -1;
	}
	
	/**
	        * Changes the direction of the Sprite by flipping
	* the y component of its direction
	        */
	public void flipY() {
	_rotVector.y *= -1;
	}
	
	/**
	        * Sets the size of the Sprite. The Sprite's hitbox is automatically
	        * reset to be rectangular with the same size as the Sprite's new size.
	        * @param w     The width of the Sprite
	        * @param h     The height of the Sprite
	        */
	public void setSize(float w, float h) {
	_w = w;
	_h = h;
	               resetRectHitbox();
	}
	
	       /**
	        * Moves the Sprite to the specified coordinate.
	        * @param x     The x coordinate of the point to move to
	        * @param y     The y coordinate of the point to move to
	        */
	public void setCoor(float x, float y) {
	_x = x;
	_y = y;
	}
	
	/*
	        * Sets the x coordinate of the Sprite
	        * @param x     The x coordinate of the point to move to
	        */
	public void setX(float x) {
	_x = x;
	}
	
	/*
	        * Sets the y coordinate of the Sprite
	        * @param y     The y coordinate of the point to move to
	        */
	public void setY(float y) {
	_y = y;
	}
	
	       /**
	        * Changes the image of the Sprite
	        * @param img   The image to set the Sprite to
	        */
	public void setImage(PImage img) {
	_img = img;
	}
	
	/**
	        * Gets the x coordinate of the Sprite 
	        * @return the x coordinate of the sprite 
	        */
	public float getX() {
	return _x;
	}
	
	/**
	        * Gets the y coordinate of the Sprite 
	        * @return the y coordinate of the sprite 
	        */
	public float getY() {
	return _y;
	}
	
	/**
	        * Gets the width of the Sprite 
	        * @return the width of the sprite 
	        */
	public float getW() {
	return _w;
	}
	
	/**
	        * Gets the height of the Sprite 
	        * @return the height of the sprite 
	        */
	public float getH() {
	return _h;
	}
	
	/**
	        * Gets the image of the Sprite 
	        * @return the image of the sprite 
	        */
	public PImage getImage() {
	return _img;
	}
	
	/**
	        * Gets the direction of the Sprite 
	        * @return the direction (in degrees) the Sprite in facing
	        */
	public float getDir() {
	return PApplet.degrees(_rotVector.heading());
	}
	
	/**
	        * Calculates the distance from this Sprite to Sprite s
	        * @return the distance from this Sprite to Sprite s
	        * @param s     The Sprite to measure distance to
	        */
	public float distTo(Sprite s) {
	return PApplet.dist(_x, _y, s._x, s._y);
	}
	
	/**
	        * Calculates the distance from this Sprite to the specified point
	        * @return the distance from this Sprite to the specified point
	        * @param x     The x coordinate of the point
	        * @param y     The y coordinate of the point
	        */
	public float distToPoint(float x, float y) {
	return PApplet.dist(_x, _y, x, y);
	}
	
	/**
	        * Checks to see if this Sprite is touching Sprite s.
	        * @return true if this Sprite is touching Sprite s, false otherwise
	        * @param s     The Sprite to detect whethet this Sprite is touching
	        */
	public boolean touchingSprite(Sprite s) {
	if (s._hitbox.length == 1) {
	if (_hitbox.length == 1) {
	return PVector.dist(this._getCenter(), s._getCenter()) <= this._hitbox[0].x + s._hitbox[0].x;
	}
	return _circPoly(s._getCenter(), s._hitbox[0].x, this._getPoints());
	}
	if (_hitbox.length == 1) {
	return _circPoly(this._getCenter(), this._hitbox[0].x, s._getPoints());
	}
	
	PVector[] s1Points = s._getPoints();
	PVector[] s2Points = this._getPoints();
	
	for (int i = 0; i < s1Points.length; i++) {
	PVector a = s1Points[i], b = s1Points[(i + 1) % s1Points.length];
	for (int j = 0; j < s2Points.length; j++) {
	PVector c = s2Points[j], d = s2Points[(j + 1) % s2Points.length];
	
	// sprites touch if ab crosses cd
	if (_clockwise(a, c, d) != _clockwise(b, c, d) && // a & b on different sides of cd, and
	_clockwise(a, b, c) != _clockwise(a, b, d)) { // c & d on different sides of ab
	return true;
	}
	}
	}
	
	return _insidePts(s1Points, s2Points) || _insidePts(s2Points, s1Points);
	}
	
	/**
	        * Checks to see if this Sprite is fully inside another sprite.
	        * @return true if this Sprite is touching Sprite s, false otherwise
	        * @param s     The Sprite to detect whethet this Sprite is touching
	        */
	public boolean insideSprite(Sprite s) {
	if (s._hitbox.length == 1) {
	if (_hitbox.length == 1) {
	return PVector.dist(s._getCenter(), this._getCenter()) < s._hitbox[0].x - this._hitbox[0].x;
	}
	return _insideCirc(_getPoints(), s._getCenter(), s._hitbox[0].x);
	}
	if (s._hitbox.length == 1) {
	// TODO: check if center is in middle but NOT touching any side
	//   (will want to adapt existing _circPoly to separate side-touching
	//    code into individual method)
	return false;
	}
	return _insidePts(this._getPoints(), s._getPoints());
	}
	
	/**
	        * Checks whether this Sprite is touching the specified point.
	        * @return true if this Sprite is touching the point, false otherwise
	        * @param x     The x coordinate of the point
	        * @param y     The y coordinate of the point
	        */
	public boolean touchingPoint(float x, float y) {
	if (_hitbox.length == 1)
	return PApplet.dist(x, y, _hitboxCenter.x, _hitboxCenter.y) < _hitbox[0].x;
	return _ptPoly(new PVector(x, y), _getPoints());
	}
	
	/**
	        * Checks whether this Sprite's hitbox is at least partially inside the canvas
	        * @return true if this Sprite is at least partially inside the canvas, false otherwise
	        */
	// TODO: technically this returns true even if circular Sprite is just outside
	//   at the corners, and false if a tilted rectangular Sprite's edge crosses
	//   a corner with endpoints outside
	public boolean isInsideScreen() {
	if (_hitbox.length == 1) {
	float r = _hitbox[0].x;
	PVector c = _getCenter();
	return 0 <= c.x + r && c.x - r < getPApplet().width && 0 <= c.y + r && c.y - r < getPApplet().height;
	}
	
	PVector[] points = this._getPoints();
	for (PVector p : points) {
	if (0 <= p.x && p.x < getPApplet().width && 0 <= p.y && p.y < getPApplet().height) {
	return true;
	}
	}
	return false;
	}
	
	// (pseudo-static) checks whether pt touches polygon
	private boolean _ptPoly(PVector pt, PVector[] poly) {
	// count edges crossed by the line connecting the target point to "the outside"
	int count = 0;
	
	for (int i = 0; i < poly.length; i++) {
	PVector a = poly[i], b = poly[(i + 1) % poly.length]; // edge points
	if (_clockwise(a, pt, out) != _clockwise(b, pt, out) && // a & b on different sides of line
	_clockwise(a, b, pt) != _clockwise(a, b, out)) { // tgt & out on diff sides of edge
	count++;
	}
	}
	
	return count % 2 == 1;
	// a convex poly would be crossed on one edge;
	//   concave could be crossed on any odd # of edges
	}
	
	// (pseudo-static) checks whether circle is touching polygon
	//   (including one inside the other)
	private boolean _circPoly(PVector center, float r, PVector[] poly) {
	// center is in polygon
	if (_ptPoly(center, poly))
	return true;
	if (_insideCirc(poly, center, r))
	return true;
	
	// circle encloses any corner
	for (PVector corner : poly) {
	if (PApplet.dist(center.x, center.y, corner.x, corner.y) < r)
	return true;
	}
	
	// circle is adjacent and close enough to any side
	for (int i = 0; i < poly.length; i++) {
	if (_circSeg(center, r, poly[i], poly[(i + 1) % poly.length]))
	return true;
	}
	
	return false;
	}
	
	// (pseudo-static) 
	// checks if circle touches segment AB from a perpendicular direction,
	//   but NOT from "beyond the ends"
	//   (this should be checked separately if desired)
	// aka, checks if center forms a perpendicular to any point on segment
	//   with length <= r 
	private boolean _circSeg(PVector center, float r, PVector a, PVector b) {
	PVector ab = PVector.sub(b, a);
	PVector abPerp = (new PVector(-ab.y, ab.x));
	abPerp.normalize();
	abPerp.mult(r);
	
	PVector[] limits = new PVector[] {
	PVector.add(a, abPerp), // move perpendicular to the segment by
	PVector.sub(a, abPerp), // distance r from each of the endpoints,
	PVector.sub(b, abPerp), // forming a bounding rectangle
	PVector.add(b, abPerp)
	};
	
	return _ptPoly(center, limits);
	}
	
	// (pseudo-static) checks whether all inPts are completely within the outPts
	//   TODO: does not check whether edges between inPts are within outPts!
	private boolean _insidePts(PVector[] inPts, PVector[] outPts) {
	
	for (int i = 0; i < inPts.length; i++) {
	// direction of angular relationship to any side must match
	//   direction of relationship to opposite side
	if (!_ptPoly(inPts[i], outPts))
	return false;
	}
	return true;
	}
	
	// (pseudo-static) checks whether all inPts are completely within circle
	private boolean _insideCirc(PVector[] inPts, PVector center, float r) {
	
	for (int i = 0; i < inPts.length; i++) {
	// direction of angular relationship to any side must match
	//   direction of relationship to opposite side
	if (PVector.dist(inPts[i], center) > r)
	return false;
	}
	return true;
	}
	
	// get hitbox absolute center based on image center, relative offset, rotation, and front
	private PVector _getCenter() {
	PVector cen = new PVector(_hitboxCenter.x, _hitboxCenter.y);
	cen.rotate(_rotVector.heading() - _front);
	cen.x += _x;
	cen.y += _y;
	return cen;
	}
	
	// get points representing rectangular hitbox
	private PVector[] _getPoints() {
	PVector cen = _getCenter();
	
	PVector[] points = new PVector[_hitbox.length];
	float angle = _rotVector.heading();
	for (int i = 0; i < _hitbox.length; i++) {
	points[i] = new PVector(_hitbox[i].x, _hitbox[i].y);
	points[i].rotate(angle);
	points[i].x += cen.x;
	points[i].y += cen.y;
	}
	return points;
	}
	
	// checks whether motion in AB turns clockwise to follow BC
	// i.e. which way is angle ABC concave?
	private boolean _clockwise(PVector A, PVector B, PVector C) {
	return (C.y - A.y) * (B.x - A.x) > (B.y - A.y) * (C.x - A.x);
	}
}
