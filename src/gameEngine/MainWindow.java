package gameEngine;

import java.awt.BorderLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

import utilities.InputController;

public class MainWindow extends JFrame implements KeyListener, MouseListener{
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
        addMouseListener(this);
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

    @Override
    public void mouseClicked(MouseEvent e) {
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch(e.getButton()) {
            case MouseEvent.BUTTON1:
                InputController.setMousePressedState(0, true);
                break;
            case MouseEvent.BUTTON2:
                InputController.setMousePressedState(1, true);
                break;
            case MouseEvent.BUTTON3:
                InputController.setMousePressedState(2, true);
                break;       
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch(e.getButton()) {
            case MouseEvent.BUTTON1:
                InputController.setMouseReleasedState(0, true);
                break;
            case MouseEvent.BUTTON2:
                InputController.setMouseReleasedState(1, true);
                break;
            case MouseEvent.BUTTON3:
                InputController.setMouseReleasedState(2, true);
                break;       
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
