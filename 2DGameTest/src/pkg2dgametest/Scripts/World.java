package pkg2dgametest.Scripts;

import pkg2dgametest.GameComponents.SpriteRenderer;
import pkg2dgametest.GameObjects.Player;
import pkg2dgametest.GameObjects.TestTree;
import pkg2dgametest.Main;

public class World {
    private Player player;
    
    public World() {
       player = new Player(300,300,0, 1);
       Main.currentScene.addObject(player);
       
       TestTree tree1 = new TestTree(100, 100, 0f);
       Main.currentScene.addObject(tree1);
       
       TestTree tree2 = new TestTree(2000,100, 0f);
       Main.currentScene.addObject(tree2);
       
       TestTree tree3 = new TestTree(400,400, 0f);
       Main.currentScene.addObject(tree3);
       
       // Stress test
       /*
       for(int i = 0; i < 1000; i++) {
           TestTree tree = new TestTree(100+i*10, 100+i*10);
           Main.currentScene.addObject(tree);
       }*/
    }
}
