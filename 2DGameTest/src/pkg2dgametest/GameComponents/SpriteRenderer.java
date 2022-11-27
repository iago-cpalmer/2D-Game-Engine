package pkg2dgametest.GameComponents;

import pkg2dgametest.GameComponents.GameComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import pkg2dgametest.GameObject;

public class SpriteRenderer extends GameComponent{
    private String spritePath;
    private BufferedImage sprite;
    
    boolean flipX;
    boolean flipY;
    
    public SpriteRenderer(String spritePath, GameObject gO) {
        this.spritePath = spritePath;
        gameObject = gO;
        componentName = "SpriteRenderer";
        this.flipX=false;
        this.flipY=false;
        try {
            this.sprite=ImageIO.read(new File(spritePath));
        } catch (IOException ex) {
            Logger.getLogger(SpriteRenderer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Paints the component in x & y coordinates in camera
     * @param g
     * @param x
     * @param y 
     */
    public void paintComponent(Graphics g, int x, int y, float scaleCamera) {
        Graphics2D g2d = (Graphics2D) g;
        /*g2d.drawImage(sprite, x-flipX*sprite.getWidth(), y-flipY*sprite.getHeight(), 
                flipX*(int) (sprite.getWidth()*gameObject.getScale()), flipY*(int)(sprite.getHeight()*gameObject.getScale()), null);*/
        int xf, yf, width, height;
        if(flipX) {
            xf= (int) (x+sprite.getWidth()*gameObject.getScale());
            width = (int) (-sprite.getWidth()*gameObject.getScale());
        } else {
            xf= (int) (x);
            width = (int) (sprite.getWidth()*gameObject.getScale());
        }
        
        if(flipY) {
            yf = (int) (y+sprite.getHeight()*gameObject.getScale());
            height = (int) (-sprite.getHeight()*gameObject.getScale());
        } else {
            yf = (int) (y);
            height = (int) (sprite.getHeight()*gameObject.getScale());
        }
        
        g2d.drawImage(sprite, (int) (xf * scaleCamera), (int) ( yf * scaleCamera), 
                (int) (width * scaleCamera), (int) (height * scaleCamera), null);
    }
    public int getWidth() {
        return sprite.getWidth();
    }
    public int getHeight() {
        return sprite.getHeight();
    }
    
    public void flipX(boolean flipX) {
        this.flipX = flipX;
    }
    public void flipY(boolean flipY) {
        this.flipY = flipY;
    }
}
