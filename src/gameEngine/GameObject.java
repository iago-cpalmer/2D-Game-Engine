package gameEngine;

import gameComponents.GameComponent;
import java.util.ArrayList;
import java.util.HashMap;

import utilities.Vector;

public abstract class GameObject {
    public HashMap<String, GameComponent> components;
    public Vector position;
    public float rotation;
    public float scale;
    public boolean isActive;
    public float sortingOrder;
    
    public GameObject() {
        position = new Vector(0,0);
        rotation = 0f;
        scale = 1;
        components = new HashMap<>();
        isActive = true;
        sortingOrder = 0;
        loadComponents();
    }
    
    public GameObject(float xp, float yp, float xr) {
        position = new Vector(xp, yp);
        rotation = xr;
        scale = 1;
        components =  new HashMap<>();
        isActive = true;
        loadComponents();
    }
    
    public GameObject(float xp, float yp, float xr, float scale) {
        position = new Vector(xp,yp);
        rotation = xr;
        this.scale = scale;
        components =  new HashMap<>();
        isActive=true;
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
        Main.currentScene.removeObject(this.sortingOrder);
        this.sortingOrder = sortingOrder;
        Main.currentScene.addObject(this);
    }
    
    public float getSortingOrder() {
        return this.sortingOrder;
    }
} 
