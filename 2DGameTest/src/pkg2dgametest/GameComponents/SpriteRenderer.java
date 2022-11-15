/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author joanc
 */
public class SpriteRenderer extends GameComponent{
    private String spritePath;
    private BufferedImage sprite;
    
    int flipX;
    int flipY;
    
    public SpriteRenderer(String spritePath, GameObject gO) {
        this.spritePath = spritePath;
        gameObject = gO;
        componentName = "SpriteRenderer";
        this.flipX=1;
        this.flipY=1;
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
    public void paintComponent(Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(sprite, x-flipX*sprite.getWidth(), y-flipY*sprite.getHeight(), 
                flipX*(int) (sprite.getWidth()*gameObject.getScale()), flipY*(int)(sprite.getHeight()*gameObject.getScale()), null);
    }
    public int getWidth() {
        return sprite.getWidth();
    }
    public int getHeight() {
        return sprite.getHeight();
    }
    
    public void flipX(boolean flipX) {
        this.flipX = flipX ? -1:1;
    }
    public void flipY(boolean flipY) {
        this.flipY = flipY ? -1:1;
    }
}
