package gameEngine;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import utilities.Vector;
import gameComponents.SpriteRenderer;

public class Camera extends JPanel{
    private Vector position;
    private Vector size;
    
    private BufferedImage[] buffers = new BufferedImage[2];
    int activeBuffer = 0;
    
    public Camera(Vector position, Vector size) {
        super();
        this.position=position;
        this.size = size;
        
        for(int i = 0; i < buffers.length;i++) {
            buffers[i] = new BufferedImage((int)size.getX(),(int) size.getY(), BufferedImage.TYPE_INT_ARGB);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
    	activeBuffer=(activeBuffer+1)%2;
        buffers[activeBuffer] = (BufferedImage)createImage(1920,1080);
        Graphics g2 = buffers[activeBuffer].getGraphics();
        
        super.paintComponent(g2);
        float scaleFactorX = this.getWidth()/size.getX();
        float scaleFactorY = this.getHeight()/size.getY();
        float scale = Math.min(scaleFactorY, scaleFactorX);
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
                        r.paintComponent(g2, (int) (x+size.getX()/2), (int) (y+size.getY()/2), scale);

                    }
                }
                
            }
            
        }
       
        g.drawImage(buffers[activeBuffer], 0, 0, this);
        
    }
    
    public Vector getPosition() {
        return position;
    }
    
    public Vector getCameraSize() {
        return size;
    }
}
