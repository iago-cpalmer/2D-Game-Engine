package scripts;

import gameEngine.Main;
import gameComponents.SpriteRenderer;
import gameObjects.*;

public class World {
    private Player player;
    
    public World() {
    	
       player = new Player(0,0,0, 1);
       player.setSortingOrder(10);
      Main.currentScene.addObject(player);
       
       TestTree tree1 = new TestTree(100, 100, 0f);
       Main.currentScene.addObject(tree1);
       
       TestTree tree2 = new TestTree(2000,100, 0f);
       Main.currentScene.addObject(tree2);
       
       TestTree tree3 = new TestTree(1000, 1000, 0f);
       Main.currentScene.addObject(tree3);
       
       if(Main.DEBUG_MODE==1) {
    	   CenterOfWorld center = new CenterOfWorld(0, 0, 0);
           Main.currentScene.addObject(center);
       }
      
       
    }
}
