/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2dgametest.Scripts;

import pkg2dgametest.GameObjects.Player;
import pkg2dgametest.GameObjects.TestTree;
import pkg2dgametest.Main;

/**
 *
 * @author iagoc
 */
public class World {
    private Player player;
    
    public World() {
       player = new Player(300,300);
       Main.currentScene.addObject(player);
       
       TestTree tree1 = new TestTree(100,100);
       Main.currentScene.addObject(tree1);
       
       TestTree tree2 = new TestTree(2000,100);
       Main.currentScene.addObject(tree2);
       
       TestTree tree3 = new TestTree(400,400);
       Main.currentScene.addObject(tree3);
    }
}
