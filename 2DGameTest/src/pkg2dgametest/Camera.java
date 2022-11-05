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
    int width;
    int height;
    /*
    BufferedImage[] buffers = new BufferedImage[2];
    int activeBuffer = 0;*/
    
    public Camera(Vector position, int width, int height) {
        super();
        this.position=position;
        this.width=width;
        this.height=height;
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
                r.paintComponent(g, 100 + (int)o.getPosition().getX(), 100 + (int)o.getPosition().getY());
                
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
}
