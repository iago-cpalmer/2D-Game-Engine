/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2dgametest.GameObjects;

import pkg2dgametest.GameComponents.SpriteRenderer;
import pkg2dgametest.GameObject;
import pkg2dgametest.Utilities.InputController;
import pkg2dgametest.Utilities.Time;
import pkg2dgametest.Utilities.Vector;

/**
 *
 * @author iagoc
 */
public class Player extends GameObject{
    float speed = 300;
    
    public Player() {
        super();
        position.setX(0);
        position.setY(0);
        components.add(new SpriteRenderer(1, "Images/test.png", this));
    }
    public Player(float x, float y) {
        super();
        position.setX(x);
        position.setY(y);
        components.add(new SpriteRenderer(1, "Images/test.png", this));
    }
    @Override
    public void update() {
        super.update();
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
        //System.out.println("Start player");
    }
    
}
