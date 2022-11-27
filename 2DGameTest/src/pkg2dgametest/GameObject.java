package pkg2dgametest;

import pkg2dgametest.GameComponents.GameComponent;
import java.util.ArrayList;
import pkg2dgametest.Utilities.Vector;

public abstract class GameObject {
    public ArrayList<GameComponent> components;
    public Vector position;
    public float scale;
    public boolean isActive;
    public GameObject() {
        position = new Vector(0,0);
        scale = 1;
        components = new ArrayList<GameComponent>();
        isActive = true;
    }
    
    public GameObject(float x, float y) {
        position = new Vector(x, y);
        scale = 1;
        components = new ArrayList<GameComponent>();
        isActive = true;
    }
    
    public GameObject(float x, float y, float scale) {
        position = new Vector(x, y);
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
}
