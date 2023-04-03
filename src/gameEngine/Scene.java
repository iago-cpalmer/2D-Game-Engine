package gameEngine;

import gameComponents.SpriteRenderer;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;
import javax.swing.JPanel;
import gameObjects.Player;
import scripts.World;
import utilities.Raycast2;

public class Scene{
    private TreeMap<Float, ArrayList<GameObject>> objects;
    private String sceneName;
    
    
    public Scene(String sceneName) {
        objects = new TreeMap<>();
        this.sceneName=sceneName;
        start();
    }
    
    public boolean removeObject(float key, GameObject obj) {
    	if(objects.get(key)!=null) {
    		return objects.get(key).remove(obj);
    	}
    	return false;
    	
    }
    
    public void addObject(GameObject o) {
        o.setSortingOrder(o.getSortingOrder());
        if(!objects.containsKey(o.getSortingOrder())) {
        	objects.put(o.getSortingOrder(), new ArrayList<GameObject>());
        }
        objects.get(o.getSortingOrder()).add(o);
        o.start();
    }
    
    public Collection<ArrayList<GameObject>> getGameObjects() {
        return objects.values();
    }
    
    public void update() {
        for(ArrayList<GameObject> gameObjects: getGameObjects()) {
        	for(GameObject gameObject : gameObjects) {
        		if(gameObject.isActive()) {
        			if(DebugMode.DEBUG_MODE==1) {
        				if(Raycast2.requestedRaycast && gameObject.contains(Raycast2.vec)) {
        					System.out.println(gameObject.getClass());
        					DebugMode.selected = gameObject;
        				}
        			}
        			
                    gameObject.update();
                }
        	}
            
        }
        if(DebugMode.DEBUG_MODE == 1) {
        	Raycast2.requestedRaycast=false;
        }
        
    }
    
    public void start() {
        
    }
}
