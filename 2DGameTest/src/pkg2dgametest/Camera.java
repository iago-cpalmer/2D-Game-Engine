/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2dgametest;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import pkg2dgametest.GameComponents.Position;
import pkg2dgametest.GameComponents.SpriteRenderer;

/**
 *
 * @author joanc
 */
public class Camera extends JPanel{
    Position position;
    int width;
    int height;
    
    public Camera(Position position, int width, int height) {
        super();
        this.position=position;
        this.width=width;
        this.height=height;
    }
    
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(GameObject o:Main.currentScene.getGameObjects()) {
            SpriteRenderer r = (SpriteRenderer)o.getComponent("SpriteRenderer");
            if(r!=null) {
                //calculate x and y position in camera from world coords
                r.paintComponent(g, 100 + (int)o.getPosition().getX(), 100 + (int)o.getPosition().getY());
            }
        }
        
        
    }
    /*
    @Override
    public void repaint() {
        super.repaint();
        System.out.println("Camera repaint");
    }*/
}
