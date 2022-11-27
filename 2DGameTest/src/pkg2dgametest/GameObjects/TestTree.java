/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2dgametest.GameObjects;

import pkg2dgametest.GameComponents.SpriteRenderer;
import pkg2dgametest.GameObject;
import pkg2dgametest.Utilities.Vector;

/**
 *
 * @author joanc
 */

public class TestTree extends GameObject{
    
    public TestTree() {
        super();
        components.add(new SpriteRenderer("Images/testTree.png", this));
        
    }
    public TestTree(float x, float y) {
        super(x, y);
        components.add(new SpriteRenderer("Images/testTree.png", this));
    }
}
