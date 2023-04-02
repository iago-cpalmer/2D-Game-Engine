package gameObjects;

import gameComponents.CameraBehav;
import gameComponents.SpriteRenderer;
import utilities.InputController;
import utilities.Time;
import utilities.Vector;
import gameEngine.GameObject;

public class Player extends GameObject{
    private float speed = 300;
    public Player() {
        super();
        this.setPivot(0.5f, 0.5f);
    }
    public Player(float xp, float yp, float xr) {
        super(xp, yp, xr);
        this.setPivot(0.5f, 0.5f);
    }
    public Player(float xp, float yp, float xr, float scale) {
        super(xp, yp, xr, scale);
        this.setPivot(0.5f, 0.5f);
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
    @Override
    public void loadComponents() {
    	addComponent(new SpriteRenderer("Images/test.png", this));
        addComponent(new CameraBehav(this));
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
        if(InputController.isKeyPressed(InputController.getControlId("MOVE_UP"))){
            v.addY(-1);
        }
        
        if(InputController.isKeyPressed(InputController.getControlId("MOVE_LEFT"))) {
            v.addX(-1);
        }
        if(InputController.isKeyPressed(InputController.getControlId("MOVE_DOWN"))) {
        	v.addY(1);
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
