/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2dgametest.Utilities;

import java.util.HashMap;
import pkg2dgametest.Enums.KEY_CONTROLS;
import pkg2dgametest.Enums.MOUSE_CONTROLS;

/**
 *
 * @author iagoc
 */
public class InputController {
    
    static final int N_CONTROLS = 4;
    
    static HashMap<Character, Integer> keysControls = new HashMap<Character, Integer>(N_CONTROLS); // Char of key and its id in keysPressed
    
    static boolean[] keysPressed = new boolean[N_CONTROLS]; //A, D, SPACE, E
    static boolean[] mousePressed = new boolean[MOUSE_CONTROLS.values().length]; //left, middle, right
    
    public static void setupControls() {
        //Read from controls file
        
        //Temporal:
        keysControls.put('a', 0);
        keysControls.put('d', 1);
        keysControls.put(' ', 2);
        keysControls.put('e', 3);
    } 
    /**
     * Change key state
     * @param key
     * @param state 
     */
    public static void setKeyState(char key, boolean state) {
        if(keysControls.containsKey(key)) {
            int id = keysControls.get(key);
            keysPressed[id] = state;
        }
        
    }
    /**
     * Get key code of a character
     * @param c
     * @return 
     */
    public static int getKeyCode(char c) {
        return keysControls.get(c);
    }
    /**
     * Returns whether a key is pressed or not
     * @param id
     * @return 
     */
    public boolean isKeyPressed(int id) {
        return keysPressed[id];
    }
    
    /**
     * 0: left click
     * 1: middle click
     * 2: right click
     * @param mouseButtonId
     * @return 
     */
    public boolean isMouseClicked(short mouseButtonId) {
        return mousePressed[mouseButtonId];
    }
    
}
