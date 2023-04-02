package gameEngine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import utilities.Vector;
import gameComponents.SpriteRenderer;

public class Camera extends JPanel{
    private Vector position;
    private Vector size;
    private float scale;
    
    // Buffer array so a new BufferedImage object does not have to be
    // instantiated when painting
    private BufferedImage[] buffers = new BufferedImage[2];
    int activeBuffer = 0;
    
    public Camera(Vector position, Vector size, float scale) {
        super();
        this.position=position;
        this.scale=2.0f;
        this.size=new Vector(size.getX()*scale, size.getY()*scale);
        // Initialize the buffer array
        for(int i = 0; i < buffers.length;i++) {
            buffers[i] = new BufferedImage((int)size.getX(),(int) size.getY(), BufferedImage.TYPE_INT_ARGB);
        }
    }
    
    public void setScale(float scale) {
    	this.scale=scale;
    	this.size.set(this.size.getX()*scale, this.size.getY()*scale);
    }

    @Override
    public void paintComponent(Graphics g) {
    	// Swap buffers
    	activeBuffer=(activeBuffer+1)%2;
        Graphics g2 = buffers[activeBuffer].getGraphics();
        // Paint on buffer
        super.paintComponent(g2);
        
        // Calculate the scaling factor
        
        float scaleFactorX = this.getWidth()/size.getX();
        float scaleFactorY = this.getHeight()/size.getY();
        float scale = Math.min(scaleFactorY, scaleFactorX);
        

        
        // Draw all GameObjects in the current scene
        for(GameObject o:Main.currentScene.getGameObjects()) {
            if(o.isActive()) {
                if(o.getPosition().getX() >= position.getX()-(size.getX()/2+500) && 
                        o.getPosition().getX() < position.getX()+(size.getX()/2+500) &&
                        o.getPosition().getY() >= position.getY()-(size.getY()/2+500) &&
                        o.getPosition().getY() < position.getY()+(size.getY()/2+500)) {
                	// GameObject's active and near to the camera in world coords, this
                	// allows to avoid painting objects that will not be visible in camera
                    SpriteRenderer r = (SpriteRenderer)o.getComponent("SpriteRenderer");
                    
                    if(r!=null) {
                        //calculate x and y position in camera from world coords
                        int x = (int) ((o.getPosition().getX()- (r.getWidth()*o.getScale())*o.getPivot().getX()) - this.position.getX());
                        int y = (int) ((o.getPosition().getY()-(r.getHeight()*o.getScale())*o.getPivot().getY()) - this.position.getY());
                        r.paintComponent(g2, (int) (x+size.getX()/2), (int) (y+size.getY()/2), scale);

                    }
                }
                
            }
            
        }
       // Draw the buffer
        //g2.setColor(Color.RED);
        //g2.fillOval((int) (this.getWidth()/2-10), (int) (this.getHeight()/2-10), 10,10);
        
        g.drawImage(buffers[activeBuffer], 0, 0, this);
        
    }
    

    
    public Vector getPosition() {
        return position;
    }
    
    public Vector getCameraSize() {
        return size;
    }
}
