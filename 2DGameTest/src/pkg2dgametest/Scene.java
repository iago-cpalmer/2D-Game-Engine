package pkg2dgametest;

import pkg2dgametest.GameComponents.SpriteRenderer;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import pkg2dgametest.GameObjects.Player;
import pkg2dgametest.Scripts.World;

public class Scene{
    private ArrayList<GameObject> objects;
    private String sceneName;
    
    public Scene(String sceneName) {
        objects = new ArrayList<GameObject>();
        this.sceneName=sceneName;
        start();
    }
    public void addObject(GameObject o) {
        objects.add(o);
        o.start();
    }
    
    public ArrayList<GameObject> getGameObjects() {
        return objects;
    }
    
    public void update() {
        for(GameObject gameObject:objects) {
            if(gameObject.isActive()) {
                gameObject.update();
            }
            
        }
    }
    
    public void start() {
        
    }
}
