package gameComponents;

import gameEngine.GameObject;
import utilities.Vector;

public class Collider extends GameComponent{
	
	private Vector ltCorner, rbCorner;
	
	public Collider(Vector ltCorner, Vector rbCorner, GameObject gameObject) {
		this.componentName="Collider";
		this.ltCorner=ltCorner;
		this.rbCorner=rbCorner;
		this.gameObject=gameObject;
	}
	
	public boolean contains(Vector v) {
		Vector i = getInitCoords();
		Vector f = getFinalCoords();
		System.out.println(i + " - " + f);
		return v.getX() >= i.getX() && v.getX() <= f.getX() && v.getY() <= i.getY() && v.getY() >= f.getY();
	}
	
	public Vector getInitCoords() {
		float xi = ltCorner.getX() + gameObject.getPosition().getX();
		float yi = ltCorner.getY() + gameObject.getPosition().getY();
		return new Vector(xi, yi);
	}
	public Vector getFinalCoords() {
		float xf = rbCorner.getX() + gameObject.getPosition().getX();
		float yf = rbCorner.getY() + gameObject.getPosition().getY();
		return new Vector(xf, yf);
	}
}
