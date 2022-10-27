/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2dgametest.GameObjects;

import pkg2dgametest.GameComponents.SpriteRenderer;
import pkg2dgametest.GameObject;

/**
 *
 * @author iagoc
 */
public class Player extends GameObject{
    public Player() {
        super();
        position.setX(0);
        position.setY(0);
        components.add(new SpriteRenderer(1, "Images/test.png", this));
    }
    @Override
    public void update() {
        System.out.println("Update player");
    }
    
    @Override
    public void start() {
        System.out.println("Start player");
    }
}
