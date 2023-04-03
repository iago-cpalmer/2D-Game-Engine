package utilities;

import gameEngine.Main;

public class Raycast2 {
	public static boolean requestedRaycast;
	public static Vector vec;
	
	
	public static void sendRaycast(int _x, int _y) {
		requestedRaycast = true;
		vec = Main.camera.getWorldPositionFromCameraPosition(new Vector(_x, _y));
		System.out.println("Raycast: " + vec);
	}
}
