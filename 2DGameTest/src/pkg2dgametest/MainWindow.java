/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2dgametest;

import java.awt.BorderLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import pkg2dgametest.Utilities.InputController;

public class MainWindow extends JFrame implements KeyListener{
    boolean  fullScreen;
    int height, width;
    GraphicsEnvironment graphics;
    GraphicsDevice device;
    public MainWindow(boolean fullScreen) {
        this.fullScreen=fullScreen;
        initComponents();
        setLayout(new BorderLayout());
        
        graphics =GraphicsEnvironment.getLocalGraphicsEnvironment();
        device = graphics.getDefaultScreenDevice();
        
        this.height = device.getDisplayMode().getHeight();
        this.width = device.getDisplayMode().getWidth();
        //setSize(width, height);
        
        setTitle("2D Game Engine");
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        if(fullScreen) {
            setExtendedState(JFrame.MAXIMIZED_BOTH); 
            setUndecorated(true);
        }
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        
        //FullScreen mode
        
        
        if(fullScreen) {
            fullScreen = true;
            device.setFullScreenWindow(this); 
        }
    }
    
    private void initComponents() {
        addKeyListener(this);
        //add(Main.camera,  BorderLayout.CENTER);
        add(Main.camera, BorderLayout.CENTER);
        this.setContentPane(Main.camera);
    }

    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        InputController.setKeyState(e.getKeyChar(), true);
        
        //F11
        if(e.getKeyCode()==122) {
            
            if(!fullScreen) {
                fullScreen = true;
                device.setFullScreenWindow(this); 
            } else {
                device.setFullScreenWindow(null);
                setExtendedState(JFrame.MAXIMIZED_BOTH);
                fullScreen = false;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        InputController.setKeyState(e.getKeyChar(), false);
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public int getWidth() {
        return this.width;
    }

}
