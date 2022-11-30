package pkg2dgametest.GameObjects;

import pkg2dgametest.GameComponents.SpriteRenderer;
import pkg2dgametest.GameObject;
import pkg2dgametest.Utilities.Vector;


public class TestTree extends GameObject{
    
    public TestTree() {
        super();
        components.add(new SpriteRenderer("Images/testTree.png", this));
        
    }
    public TestTree(float x, float y, float xr) {
        super(x, y, xr);
        components.add(new SpriteRenderer("Images/testTree.png", this));
    }
    @Override
    public void update(){
        //this.setRotation(this.getRotation()+1);
        System.out.println("Rotation: " + this.getRotation());
    }
    
}
