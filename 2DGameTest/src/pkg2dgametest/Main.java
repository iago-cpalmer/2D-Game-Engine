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
        
        
        final int MAX_UPDATES_PER_SECOND = 60; //UPS
        final int MAX_FRAMES_PER_SECOND = 60; //FPS
        
        final double MAX_UPDATE_TIME = 1000000000/ MAX_UPDATES_PER_SECOND; //Time between each update
        final double MAX_FRAME_TIME = 1000000000/MAX_FRAMES_PER_SECOND; //Time between each frame
        
        double updateDeltaTime = 0;
        double frameDeltaTime = 0;
        
        long prevTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        int frames = 0, updates = 0;
        double timer2 = 0;
        
        while(gameIsRunning) {
            long currentTime = System.nanoTime();
            long elapsedTime = currentTime-prevTime;
            updateDeltaTime+=elapsedTime;
            frameDeltaTime+=elapsedTime;
            Time.deltaTime = updateDeltaTime/1000000000;
            prevTime = currentTime;
            //get user input
            
            //update game state

            if(updateDeltaTime > MAX_UPDATE_TIME) {
                currentScene.update();
                timer2+=Time.deltaTime;
                //System.out.println("Update: " + updateDeltaTime + " - " + MAX_UPDATE_TIME);
                updateDeltaTime -= MAX_UPDATE_TIME;
                updates++;
                //System.out.println("Update: " + updateDeltaTime + " - " + MAX_UPDATE_TIME);
            }
                       
            //render
            if(frameDeltaTime > MAX_FRAME_TIME) {
                mainWindow.repaint();
                frameDeltaTime -= MAX_FRAME_TIME;
                frames++;
                //System.out.println("Paint: " + frameDeltaTime + " - " + MAX_FRAME_TIME);
            }
            
            if(System.currentTimeMillis()-timer>=1000) {
                /*
                System.out.println(frames + " FPS. " + updates + " UPS" + " - FPSDeltaTime: "+1/Time.deltaTime + 
                        " - Timer2: " + timer2 + " - CurrentTime: "+System.currentTimeMillis());*/
                frames = 0;
                updates=0;
                timer+=1000;
                timer2=0;
            }
            
            
            
        }
        
    }
    
    
    
    
}

            
