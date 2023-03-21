package gameComponents;

import gameEngine.GameObject;
import gameEngine.Main;

/**
 * Camera behavior for testing purposes, will not be included in the final version
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
