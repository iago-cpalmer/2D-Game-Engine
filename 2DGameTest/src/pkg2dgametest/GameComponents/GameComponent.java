/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
