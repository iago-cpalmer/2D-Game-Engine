package gameEngine;

import gameComponents.GameComponent;
import java.util.HashMap;

import utilities.Vector;

public abstract class GameObject {
    public HashMap<String, GameComponent> components;
    public Vector position;
    public float rotation;
    public float scale;
    public boolean isActive;
    public Vector pivot;
    public float sortingOrder;
    
    public GameObject() {
        position = new Vector(0,0);
        rotation = 0f;
        scale = 1;
        components = new HashMap<>();
        isActive = true;
        sortingOrder = 0;
        this.pivot = new Vector(0.0f, 0.0f);
        loadComponents();
    }
    
    public GameObject(float xp, float yp, float xr) {
        position = new Vector(xp, yp);
        rotation = xr;
        scale = 1;
        components =  new HashMap<>();
        isActive = true;
        this.pivot = new Vector(0.0f, 0.0f);
        loadComponents();
    }
    
    public GameObject(float xp, float yp, float xr, float scale) {
        position = new Vector(xp,yp);
        rotation = xr;
        this.scale = scale;
        components =  new HashMap<>();
        isActive=true;
        this.pivot = new Vector(0.0f, 0.0f);
        loadComponents();
    }
    
    
    
    public void update() {
    	components.forEach((key, value) -> value.update());
    }
    
    public abstract void loadComponents();
    
    public void start() {
    	components.forEach((key, value) -> value.start());
    }
    
    public void addComponent(GameComponent gc) {
        components.put(gc.getComponentName(), gc);
    }
    
    public GameComponent getComponent(String gameComponentName) {
        return components.get(gameComponentName);
    }
    
    public Vector getPosition() {
        return position;
    }
    public void setPosition(float x, float y) {
        position.setX(x);
        position.setY(y);
    }
    
    public float getRotation() {
        return rotation;
    }
    public void setRotation(float x) {
        rotation = x%360;
    }
    
    public void setPivot(float x, float y) {
    	this.pivot.set(x, y);
    }
    
    public Vector getPivot() {
    	return this.pivot;
    }
    
    public float getScale() {
        return scale;
    }
    public void setScale(int scale) {
        this.scale = scale;
    }
    
    public boolean isActive() {
        return isActive;
    }
    
    public void setActive(boolean isActive) {
        this.isActive=isActive;
    }
    
    public void setSortingOrder(float sortingOrder) {
        boolean b = Main.currentScene.removeObject(this.sortingOrder, this);
        this.sortingOrder = sortingOrder;
        if(b) {
        	Main.currentScene.addObject(this);
        }
        
    }
    
    public float getSortingOrder() {
        return this.sortingOrder;
    }
} 
