package pkg2dgametest.Utilities;

import java.awt.MouseInfo;
import java.awt.Point;
import java.util.HashMap;
import javax.swing.SwingUtilities;
import pkg2dgametest.Main;
public class InputController {
    
    static final int N_CONTROLS = 4;
    static String[] controlNames = {"MOVE_LEFT", "MOVE_RIGHT", "JUMP", "INTERACT"};
    static HashMap<String, Integer> controls = new HashMap<String, Integer>(N_CONTROLS); //Name of control, e.g.: MOVE_LEFT & control's id
    static char[] keys = new char[N_CONTROLS]; //keys set to each id
    static boolean[] keysPressed = new boolean[N_CONTROLS]; //check if a key is pressed through id
    
    static boolean[] mousePressed = new boolean[3]; //left, middle, right
    static boolean[] mouseReleased = new boolean[3]; //left, middle, right
    public static void setupControls() {
        //Set-up controlNames with his ID;
        for(int i = 0; i < controlNames.length; i++) {
            controls.put(controlNames[i], i);
        }
        //Read from controls file: (Format: id-key)
        
        //Temporal:
        keys[0] = 'a';
        keys[1] = 'd';
        keys[2] = ' ';
        keys[3] = 'e';
    } 
    /**
     * Change key state
     * @param key
     * @param state 
     */
    public static void setKeyState(char key, boolean state) {
        int keyId = containsAndGetId(keys, Character.toLowerCase(key));
        if(keyId!=-1) {
            keysPressed[keyId] = state;
        }
    }
    
    public static void setMousePressedState(int mouseButtonId, boolean state) {
        mousePressed[mouseButtonId] = state;
    }
    
        public static void setMouseReleasedState(int mouseButtonId, boolean state) {
        mouseReleased[mouseButtonId] = state;
    }
    
    /**
     * Get key id of a character
     * @param c
     * @return 
     */
    public static int getKeyId(char c) {
        return containsAndGetId(keys, c);
    }
    /**
     * Returns whether a key is pressed or not
     * @param id
     * @return 
     */
    public static boolean isKeyPressed(int id) {
        return keysPressed[id];
    }
    
    public static int getControlId(String controlName) {
        return controls.get(controlName);
    }
    
    /**
     * 0: left click
     * 1: middle click
     * 2: right click
     * @param mouseButtonId
     * @return 
     */
    public static boolean isMousePressed(int mouseButtonId) {
        return mousePressed[mouseButtonId];
    }
    
    public static boolean isMouseReleased(int mouseButtonId) {
        return mouseReleased[mouseButtonId];
    }
    
    
    public static int containsAndGetId(char[] chars, char c) {
        for(int i = 0; i < keys.length;i++) {
            if(chars[i]==c) {
                return i;
            }
        }
        return -1;
    }
    
    public static Vector getMousePosition() {
        Point point = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(point, Main.mainWindow);
        return new Vector( (float) point.getX(), (float)point.getY());
    }
}
