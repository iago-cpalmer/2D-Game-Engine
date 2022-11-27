package pkg2dgametest;

import pkg2dgametest.GameComponents.SpriteRenderer;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;
import javax.swing.JPanel;
import pkg2dgametest.GameObjects.Player;
import pkg2dgametest.Scripts.World;

public class Scene{
    //private ArrayList<GameObject> objects;
    private TreeMap<Float, GameObject> objects;
    private String sceneName;
    
    public Scene(String sceneName) {
        objects = new TreeMap<>();
        this.sceneName=sceneName;
        start();
    }
    
    public void removeObject(float key) {
        objects.remove(key);
    }
    
    public void addObject(GameObject o) {
        float sorting = o.getSortingOrder();
        while(objects.containsKey(sorting)) {
            sorting+=0.01f;
        }
        objects.put(sorting, o);
        o.start();
    }
    
    public Collection<GameObject> getGameObjects() {
        return objects.values();
    }
    
    public void update() {
        for(GameObject gameObject: getGameObjects()) {
            if(gameObject.isActive()) {
                gameObject.update();
            }
            
        }
    }
    
    public void start() {
        
    }
}
