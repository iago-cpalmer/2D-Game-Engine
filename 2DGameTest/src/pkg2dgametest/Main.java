package pkg2dgametest;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import javax.swing.JFrame;
import pkg2dgametest.GameComponents.Position;
import pkg2dgametest.Scripts.World;
import pkg2dgametest.Utilities.InputController;
import pkg2dgametest.Utilities.Time;

/**
 *
 * @author iagoc
 */
public class Main {
    
    static boolean gameIsRunning = true;
    public static MainWindow mainWindow;
    static int height = 500;
    static int width = 500;
    
    public static Camera camera;
    public static Scene currentScene;
    public static World world;
    public static float timeWhenFrameStarts;
    
    public static void main(String[] args) {
        InputController.setupControls();
        
        camera = new Camera(new Position(0,0), 1920, 1080);
        currentScene = new Scene("defaultScene");
        world = new World();
        
        mainWindow = new MainWindow(height, width, false);
        
        Date date = new Date();
        
        long updateTime = 2; //1s/60frames * 1000ms
        long accumTime = 0;
        long prevTime = date.getTime();
        
        while(gameIsRunning) {
            long currentTime = date.getTime();
            long elapsedTime = currentTime-prevTime;
            Time.deltaTime=elapsedTime;
            prevTime = date.getTime();
            accumTime+=elapsedTime;
            //System.out.println(Time.deltaTime);
            //get user input
            
            //update game state
            while(accumTime >= updateTime) {
                currentScene.update();
                accumTime -= updateTime;
                System.out.println(accumTime + " - " + updateTime);
            }
            //render
            System.out.println("render");
            mainWindow.repaint();
            
            
            
        }
        
    }
    
    
    
    
}
