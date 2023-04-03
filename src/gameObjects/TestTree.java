package gameObjects;

import gameComponents.Collider;
import gameComponents.SpriteRenderer;
import utilities.Vector;
import gameEngine.GameObject;


public class TestTree extends GameObject{
    
    public TestTree() {
        super();     
        this.setPivot(0.5f, 0.5f);
    }
    public TestTree(float x, float y, float xr) {
        super(x, y, xr);
        this.setPivot(0.5f, 0.5f);
    }
    
    @Override
    public void loadComponents() {
    	addComponent((new SpriteRenderer("Images/testTree.png", this)));
    	addComponent(new Collider(new Vector(-0.5f, 0.5f), new Vector(0.5f, -0.5f), this));
    }
    @Override
    public void update(){
    	super.update();
        //this.setRotation((this.getRotation()+0.5f)%360);
        
    }
    
    public void start() {
    	
    }
}
