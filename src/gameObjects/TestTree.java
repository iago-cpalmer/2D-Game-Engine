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
    	System.out.println("Tree components added");
    	addComponent((new SpriteRenderer("Images/testTree.png", this)));
    }
    @Override
    public void update(){
        //this.setRotation(this.getRotation()+1);
        //System.out.println("Rotation: " + this.getRotation());
    	//System.out.println("holaaa");
    }
    
}
