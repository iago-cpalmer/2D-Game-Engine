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
    private int scale;
    private String spritePath;
    private BufferedImage sprite;
    private GameObject gameObject;
    
    public SpriteRenderer(int scale, String spritePath, GameObject gameObject) {
        this.scale = scale;
        this.spritePath = spritePath;
        this.gameObject = gameObject;
        componentName = "SpriteRenderer";
        
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
        g2d.drawImage(sprite, x, y, sprite.getWidth(), sprite.getHeight(), null);
    }
    /*
    @Override
    public void update() {
        System.out.println("Sprite Renderer update");
    }
    
    @Override
    public void start() {
        System.out.println("Sprite Renderer start");
    }*/
}
