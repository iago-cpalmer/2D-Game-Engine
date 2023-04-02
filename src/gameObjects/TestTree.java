package gameObjects;

import gameComponents.SpriteRenderer;
import utilities.Vector;
import gameEngine.GameObject;


public class TestTree extends GameObject{
    
    public TestTree() {
        super();        
    }
    public TestTree(float x, float y, float xr) {
        super(x, y, xr);
    }
    
    @Override
    public void loadComponents() {
    	addComponent((new SpriteRenderer("Images/testTree.png", this)));
    }
    @Override
    public void update(){
    	super.update();
        this.setRotation((this.getRotation()+0.5f)%360);
        this.setPivot(0.5f, 1.0f);
    }
    
    public void start() {
    	
    }
}
