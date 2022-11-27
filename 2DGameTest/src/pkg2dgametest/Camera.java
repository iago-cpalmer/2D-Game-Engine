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
    Vector size;
    /*
    BufferedImage[] buffers = new BufferedImage[2];
    int activeBuffer = 0;*/
    
    public Camera(Vector position, Vector size) {
        super();
        this.position=position;
        this.size = size;
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
        float scaleFactorX = this.getWidth()/size.getX();
        float scaleFactorY = this.getHeight()/size.getY();
        float scale = Math.min(scaleFactorY, scaleFactorX);
        System.out.println(this.getWidth() + " - " + this.getHeight());
        for(GameObject o:Main.currentScene.getGameObjects()) {
            if(o.isActive()) {
                if(o.getPosition().getX() >= position.getX()-(this.getWidth()/2+500) && 
                        o.getPosition().getX() < position.getX()+(this.getWidth()/2+500) &&
                        o.getPosition().getY() >= position.getY()-(this.getHeight()/2+500) &&
                        o.getPosition().getY() < position.getY()+(this.getHeight()/2+500)) {
                    SpriteRenderer r = (SpriteRenderer)o.getComponent("SpriteRenderer");
                    if(r!=null) {
                        //calculate x and y position in camera from world coords
                        int x = (int) ((o.getPosition().getX()- (r.getWidth()*o.getScale())/2) - this.position.getX());
                        int y = (int) ((o.getPosition().getY()-(r.getHeight()*o.getScale())/2) - this.position.getY());
                        r.paintComponent(g, (int) (x+size.getX()/2), (int) (y+size.getY()/2), scale);

                    }
                }
                
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
    
    public Vector getCameraSize() {
        return size;
    }
}
