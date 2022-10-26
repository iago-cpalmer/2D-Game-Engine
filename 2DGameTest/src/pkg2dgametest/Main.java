package pkg2dgametest;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import pkg2dgametest.Enums.KEY_CONTROLS;
import pkg2dgametest.GameComponents.Position;
import pkg2dgametest.Utilities.InputController;

/**
 *
 * @author iagoc
 */
public class Main {
    
    static boolean gameIsRunning = true;
    public static MainWindow mainWindow;
    static int height = 1080;
    static int width = 1920;
    
    public static Camera camera;
    public static Scene currentScene;
    
    public static void main(String[] args) {
        InputController.setupControls();
        camera = new Camera(new Position(0,0), 1920, 1080);
        mainWindow = new MainWindow(height, width, true);
        
        
        while(gameIsRunning) {
            //get user input
            
            //update game state
            
            //render
            mainWindow.repaint();
        }
    }
    
    
    
    
}
