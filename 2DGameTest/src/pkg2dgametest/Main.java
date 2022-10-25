package pkg2dgametest;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import pkg2dgametest.Enums.KEY_CONTROLS;
import pkg2dgametest.Utilities.InputController;

/**
 *
 * @author iagoc
 */
public class Main {
    
    static boolean gameIsPaused = false;
    public static MainWindow mainWindow;
    static int height = 1080;
    static int width = 1920;
    public static void main(String[] args) {
        InputController.setupControls();
        mainWindow = new MainWindow(height, width, true);
        
        
        while(!gameIsPaused) {
            //get user input
            
            //update game state
            
            //render
        }
    }
    
}
