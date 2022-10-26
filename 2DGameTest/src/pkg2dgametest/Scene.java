/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2dgametest;

import pkg2dgametest.GameComponents.SpriteRenderer;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author joanc
 */
public class Scene extends JPanel{
    private ArrayList<GameObject> objects;
    private String sceneName;
    
    public Scene(String sceneName) {
        objects = new ArrayList<GameObject>();
        this.sceneName=sceneName;
    }
    
    public void addObject(GameObject o) {
        objects.add(o);
    }
    
    public ArrayList<GameObject> getGameObjects() {
        return objects;
    }
}
