package gameComponents;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gameEngine.GameObject;
import gameEngine.Main;

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
        int xf, yf, width, height;
        if(flipX) {
            xf= (int) (x+sprite.getWidth()*gameObject.getScale()*scaleCamera);
            width = (int) (-sprite.getWidth()*gameObject.getScale()*scaleCamera);
        } else {
            xf= (int) (x*scaleCamera);
            width = (int) (sprite.getWidth()*gameObject.getScale()*scaleCamera);
        }
        
        if(flipY) {
            yf = (int) (y+sprite.getHeight()*gameObject.getScale()*scaleCamera);
            height = (int) (-sprite.getHeight()*gameObject.getScale()*scaleCamera);
        } else {
            yf = (int) (y*scaleCamera);
            height = (int) (sprite.getHeight()*gameObject.getScale()*scaleCamera);
        }
        
        AffineTransform old = g2d.getTransform();
        g2d.rotate(Math.toRadians(gameObject.getRotation()), 
        		(xf)+(gameObject.getPivot().getX()*width),
        		(yf+(gameObject.getPivot().getY()*height)));
       
        
        g2d.drawImage(sprite, (int) (xf), (int) ( yf) , 
                (int) (width), (int) (height), null);
        g2d.setTransform(old);
        
        if(Main.DEBUG_MODE == 1) {
        	g2d.setColor(Color.BLUE);
        	g2d.drawRect((int) (xf),(int) (yf), (int) (width), (int) (height));
        	
        	g2d.setColor(Color.RED);
            g2d.fillOval((int) ((xf)+(gameObject.getPivot().getX()*width))-5, 
            		(int) (yf + (gameObject.getPivot().getY()*height) -5), 10, 10);
        }
        
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
