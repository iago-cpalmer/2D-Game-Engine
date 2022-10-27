/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2dgametest.Scripts;

import pkg2dgametest.GameObjects.Player;
import pkg2dgametest.Main;

/**
 *
 * @author iagoc
 */
public class World {
    private Player player;
    
    public World() {
       player = new Player();
       Main.currentScene.addObject(player);
    }
}
