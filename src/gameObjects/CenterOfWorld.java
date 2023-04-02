package gameObjects;

import gameComponents.SpriteRenderer;
import gameEngine.GameObject;

public class CenterOfWorld extends GameObject{

	
	
	public CenterOfWorld() {
		super();
		this.setSortingOrder(5);
		this.setScale(1);
	}
	
	@Override
	public void loadComponents() {
		// TODO Auto-generated method stub
		addComponent(new SpriteRenderer("Images/test-copia.png", this));
	}
	
	
	@Override
	public void update() {
		super.update();
	}
	
	

}
