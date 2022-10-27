/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2dgametest;

import pkg2dgametest.GameComponents.GameComponent;
import java.util.ArrayList;
import pkg2dgametest.GameComponents.Position;

/**
 *
 * @author joanc
 */
public abstract class GameObject {
    public ArrayList<GameComponent> components;
    public Position position;
    
    public GameObject() {
        position = new Position(0,0);
        components = new ArrayList<GameComponent>();
    }
    
    
    public ArrayList<GameComponent> getGameComponents() {
        return components;
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
    
    public Position getPosition() {
        return position;
    }
}
