package pkg2dgametest;

import pkg2dgametest.GameComponents.GameComponent;
import java.util.ArrayList;
import pkg2dgametest.Utilities.Vector;

public abstract class GameObject {
    public ArrayList<GameComponent> components;
    public Vector position;
    public float rotation;
    public float scale;
    public boolean isActive;
    public float sortingOrder;
    
    public GameObject() {
        position = new Vector(0,0);
        rotation = 0f;
        scale = 1;
        components = new ArrayList<GameComponent>();
        isActive = true;
        sortingOrder = 0;
    }
    
    public GameObject(float xp, float yp, float xr) {
        position = new Vector(xp, yp);
        rotation = xr;
        scale = 1;
        components = new ArrayList<GameComponent>();
        isActive = true;
    }
    
    public GameObject(float xp, float yp, float xr, float scale) {
        position = new Vector(xp,yp);
        rotation = xr;
        this.scale = scale;
        components = new ArrayList<GameComponent>();
        isActive=true;
    }
    
    
    public ArrayList<GameComponent> getGameComponents() {
        return components;
    }
    
    public void update() {
        for(GameComponent g:components) {
            g.update();
        }
    }
    
    public void start() {
        for(GameComponent g:components) {
            g.start();
        }
    }
    
    public void addComponent(GameComponent gc) {
        components.add(gc);
    }
    
    public GameComponent getComponent(String gameComponentName) {
        for(GameComponent g:components) {
            if(g.getComponentName().equals(gameComponentName)) {
                return g;
            }
        }
        return null;
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
