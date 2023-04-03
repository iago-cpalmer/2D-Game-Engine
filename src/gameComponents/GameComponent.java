package gameComponents;

import gameEngine.GameObject;
public abstract class GameComponent {
    protected String componentName = "GameComponent";
    protected GameObject gameObject;
    
    public String getComponentName() {
        return componentName;
    }
    
    public void update() {
        
    }
    public void start() {
        
    }
}
