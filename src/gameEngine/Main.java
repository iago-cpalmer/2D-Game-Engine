package gameEngine;

import utilities.InputController;
import utilities.Time;
import utilities.Vector;
import scripts.World;

public class Main {
    
    static boolean gameIsRunning = true;
    public static MainWindow mainWindow;
    
    public static Camera camera;
    public static Scene currentScene;
    public static World world;
    public static float timeWhenFrameStarts;
    
    public static void main(String[] args) {
        InputController.setupControls();
        
        
        currentScene = new Scene("defaultScene");
        world = new World();
        camera = new Camera(new Vector(0,0), new Vector(1920,1080), 1.0f);
        mainWindow = new MainWindow(false);
        camera.setSize(mainWindow.getWidth(), mainWindow.getHeight());
        
        final int MAX_UPDATES_PER_SECOND = 120; //UPS
        final int MAX_FRAMES_PER_SECOND = 120; //FPS
        
        final double MAX_UPDATE_TIME = 1000000000/ MAX_UPDATES_PER_SECOND; //Time between each update
        final double MAX_FRAME_TIME = 1000000000/MAX_FRAMES_PER_SECOND; //Time between each frame
        
        double updateDeltaTime = 0;
        double frameDeltaTime = 0;
        
        long prevTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        int frames = 0, updates = 0;
        
        while(gameIsRunning) {
            long currentTime = System.nanoTime();
            long elapsedTime = currentTime-prevTime;
            updateDeltaTime+=elapsedTime;
            frameDeltaTime+=elapsedTime;
            Time.deltaTime = updateDeltaTime/1000000000;
            prevTime = currentTime;
            
            
            //update game state
            if(updateDeltaTime > MAX_UPDATE_TIME) {
                currentScene.update();
                updateDeltaTime -= MAX_UPDATE_TIME;
                updates++;
                
                //reset mouse states
                InputController.setMousePressedState(0, false);
                InputController.setMousePressedState(1, false);
                InputController.setMousePressedState(2, false);

                InputController.setMouseReleasedState(0, false);
                InputController.setMouseReleasedState(1, false);
                InputController.setMouseReleasedState(2, false);
            }
                       
            //render
            if(frameDeltaTime > MAX_FRAME_TIME) {
                mainWindow.repaint();
                frameDeltaTime -= MAX_FRAME_TIME;
                frames++;
            }
            
            if(System.currentTimeMillis()-timer>=1000) {
                
                /*System.out.println(frames + " FPS. " + updates + " UPS" + " - FPSDeltaTime: "+1/Time.deltaTime + 
                         " - CurrentTime: "+System.currentTimeMillis());*/
                frames = 0;
                updates=0;
                timer+=1000;
            }
            
            
            
            
        }
    }
    
    
    
    
}

            
