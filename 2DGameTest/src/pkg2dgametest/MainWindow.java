/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2dgametest;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import pkg2dgametest.Utilities.InputController;

/**
 *
 * @author iagoc
 */
public class MainWindow extends JFrame implements KeyListener{
    boolean  fullScreen;
    int height, width;
    public MainWindow(int height, int width, boolean fullScreen) {
        this.fullScreen=fullScreen;
        this.height=height;
        this.width=width;
        
        setLayout(null);
        initComponents();
        setTitle("2DGameTest");
        setSize(width, height);
        if(fullScreen) {
            setExtendedState(JFrame.MAXIMIZED_BOTH); 
            setUndecorated(true);
        }
       
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private void initComponents() {
        addKeyListener(this);
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
                setExtendedState(JFrame.MAXIMIZED_BOTH); 
                setUndecorated(true); 
           } else {
                setSize(width, height);
                setUndecorated(false); 
           }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        InputController.setKeyState(e.getKeyChar(), false);
    }

}
