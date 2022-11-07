/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2dgametest;

import java.awt.Graphics;
//import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import pkg2dgametest.GameComponents.SpriteRenderer;
import pkg2dgametest.Utilities.Vector;

/**
 *
 * @author joanc
 */
public class Camera extends JPanel{
    Vector position;
    /*
    BufferedImage[] buffers = new BufferedImage[2];
    int activeBuffer = 0;*/
    
    public Camera(Vector position) {
        super();
        this.position=position;
        /*
        for(int i = 0; i < buffers.length;i++) {
            buffers[i] = (BufferedImage)createImage(1920,1080);
        }*/
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        /*
        activeBuffer=(activeBuffer+1)%2;
        buffers[activeBuffer] = (BufferedImage)createImage(1920,1080);
        Graphics g2 = buffers[activeBuffer].getGraphics();
        */
        for(GameObject o:Main.currentScene.getGameObjects()) {
            SpriteRenderer r = (SpriteRenderer)o.getComponent("SpriteRenderer");
            if(r!=null) {
                //calculate x and y position in camera from world coords
                int x = (int) ((o.getPosition().getX()-r.getWidth()/2) - this.position.getX());
                int y = (int) ((o.getPosition().getY()-r.getHeight()/2) - this.position.getY());
                r.paintComponent(g, x+this.getWidth()/2, y+this.getHeight()/2);
                
            }
        }
        //g.drawImage(buffers[activeBuffer], 0, 0, this);
        
    }
    /*
    @Override
    public void repaint() {
        super.repaint();
        System.out.println("Camera repaint");
    }*/
    
    public Vector getPosition() {
        return position;
    }
}
