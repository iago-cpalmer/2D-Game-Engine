package scripts;

import gameEngine.DebugMode;
import gameEngine.Main;
import gameComponents.SpriteRenderer;
import gameObjects.*;

public class World {
    private Player player;
    
    public World() {
    	
       player = new Player(0,0,0, 1);
       player.setSortingOrder(10);
      Main.currentScene.addObject(player);
       
       TestTree tree1 = new TestTree(3, 3, 0f);
       Main.currentScene.addObject(tree1);
       
       TestTree tree2 = new TestTree(-1,-1, 0f);
       Main.currentScene.addObject(tree2);
       
       TestTree tree3 = new TestTree(6, 2, 0f);
       Main.currentScene.addObject(tree3);
       
       if(DebugMode.DEBUG_MODE==1) {
    	   CenterOfWorld center = new CenterOfWorld(0, 0, 0);
           Main.currentScene.addObject(center);
       }
      
       
    }
}
