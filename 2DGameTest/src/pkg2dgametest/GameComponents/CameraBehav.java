package pkg2dgametest.GameComponents;

import pkg2dgametest.GameComponents.GameComponent;
import pkg2dgametest.GameObject;
import pkg2dgametest.Main;

/**
 * Camera behaviour for testing purposes, will not be included in the final version
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
