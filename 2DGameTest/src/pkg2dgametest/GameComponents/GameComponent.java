package pkg2dgametest.GameComponents;

import pkg2dgametest.GameObject;
public abstract class GameComponent {
    String componentName = "GameComponent";
    GameObject gameObject;
    
    public String getComponentName() {
        return componentName;
    }
    
    public void update() {
        
    }
    public void start() {
        
    }
}
