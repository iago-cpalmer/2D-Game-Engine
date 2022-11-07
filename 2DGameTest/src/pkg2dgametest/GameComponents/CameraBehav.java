/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2dgametest.GameComponents;

import pkg2dgametest.GameComponents.GameComponent;
import pkg2dgametest.GameObject;
import pkg2dgametest.Main;

/**
 *
 * @author iagoc
 */
public class CameraBehav extends GameComponent{
    public CameraBehav(GameObject gO) {
        componentName="CameraBehav";
        gameObject = gO;
    }
    @Override
    public void update() {
       Main.camera.getPosition().set(gameObject.getPosition());
    }
}
