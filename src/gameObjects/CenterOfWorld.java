package gameObjects;

import gameComponents.SpriteRenderer;
import gameEngine.GameObject;

public class CenterOfWorld extends GameObject{

	 public CenterOfWorld() {
	        super(); 
	        this.setSortingOrder(5);
	        this.setScale(1);
	        this.setPivot(0.5f, 0.5f);
	    }
	    public CenterOfWorld(float x, float y, float xr) {
	        super(x, y, xr);
	        this.setSortingOrder(5);
	        this.setScale(1);
	        this.setPivot(0.5f, 0.5f);
	    }
	    
	    @Override
	    public void loadComponents() {
	    	System.out.println("World center components added");
	    	addComponent(new SpriteRenderer("Images/crosshair.png", this));
	    }
	    @Override
	    public void update(){
	    	super.update();
	        //this.setRotation((this.getRotation()+0.5f)%360);
	    	//System.out.println("holaaa");
	    }
	    
	

}
