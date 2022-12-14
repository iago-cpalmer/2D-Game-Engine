package pkg2dgametest.GameObjects;

import pkg2dgametest.GameComponents.CameraBehav;
import pkg2dgametest.GameComponents.SpriteRenderer;
import pkg2dgametest.GameObject;
import pkg2dgametest.Utilities.InputController;
import pkg2dgametest.Utilities.Time;
import pkg2dgametest.Utilities.Vector;

public class Player extends GameObject{
    float speed = 300;
    public Player() {
        super();
        components.add(new SpriteRenderer("Images/test.png", this));
        components.add(new CameraBehav(this));
    }
    public Player(float xp, float yp, float xr) {
        super(xp, yp, xr);
        components.add(new SpriteRenderer("Images/test.png", this));
        components.add(new CameraBehav(this));
    }
    public Player(float xp, float yp, float xr, float scale) {
        super(xp, yp, xr, scale);
        components.add(new SpriteRenderer("Images/test.png", this));
        components.add(new CameraBehav(this));
    }
    @Override
    public void update() {
        super.update();
        
        if(InputController.isMousePressed(0)) {
            System.out.println("pressed");
        }
        
        if(InputController.isMouseReleased(0)) {
            System.out.println("released");
        }
        
        movement(); //Testing
        
        
        
    }
    /**
     * Testing function for the movement of the player. 
     * (WILL NOT BE IMPLEMENTED IN THE FINAL VERSION OF THE GAME ENGINE)
     */
    public void movement() {
        Vector v = new Vector(0,0);
        
        if(InputController.isKeyPressed(InputController.getControlId("MOVE_RIGHT"))) {
            v.addX(1);
        }
        if(InputController.isKeyPressed(InputController.getControlId("JUMP"))){
            v.addY(-1);
        }
        
        if(InputController.isKeyPressed(InputController.getControlId("MOVE_LEFT"))) {
            v.addX(-1);
        }
        
        v.setX((float) (v.getX()*speed*Time.deltaTime));
        v.setY((float) (v.getY()*speed*Time.deltaTime));
        
        position.addVector(v);
    }
    
    @Override
    public void start() {
        super.start();
    }
    
}
