package gameEngine;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

import utilities.Vector;
import gameComponents.Collider;
import gameComponents.SpriteRenderer;

public class Camera extends JPanel{
    private Vector position;
    private Vector size;
    
    // Buffer array so a new BufferedImage object does not have to be
    // instantiated when painting
    private BufferedImage[] buffers = new BufferedImage[2];
    int activeBuffer = 0;
    
    public Camera(Vector position, Vector size, float scale) {
        super();
        this.position=position;
        this.size=new Vector(size.getX()*scale, size.getY()*scale);
        // Initialize the buffer array
        for(int i = 0; i < buffers.length;i++) {
            buffers[i] = new BufferedImage((int)size.getX(),(int) size.getY(), BufferedImage.TYPE_INT_ARGB);
        }
    }
    
    public void setScale(float scale) {
    	this.size.set(this.size.getX()*scale, this.size.getY()*scale);
    }

    @Override
    public void paintComponent(Graphics g) {
    	// Swap buffers
    	activeBuffer=(activeBuffer+1)%2;
        Graphics2D g2 = (Graphics2D) buffers[activeBuffer].getGraphics();
        // Paint on buffer
        super.paintComponent(g2);
        
        // Calculate the scaling factor
        
        float scaleFactorX = this.getWidth()/size.getX();
        float scaleFactorY = this.getHeight()/size.getY();
        float scale = Math.min(scaleFactorY, scaleFactorX);
        
        
        
        // Draw all GameObjects in the current scene
        for(ArrayList<GameObject> os:Main.currentScene.getGameObjects())  {
        	for(GameObject o: os) {
                if(o.isActive()) {
                	Vector objPos = new Vector(o.getPosition().getX()*Main.PX_PER_UNIT, -1*o.getPosition().getY()*Main.PX_PER_UNIT);
                    if(o.getPosition().getX() >= position.getX()-(size.getX()/2+500) && 
                    		o.getPosition().getX() < position.getX()+(size.getX()/2+500) &&
                    		o.getPosition().getY() >= position.getY()-(size.getY()/2+500) &&
                    				o.getPosition().getY() < position.getY()+(size.getY()/2+500)) {
                    	// GameObject's active and near to the camera in world coords, this
                    	// allows to avoid painting objects that will not be visible in camera
                        SpriteRenderer r = (SpriteRenderer)o.getComponent("SpriteRenderer");
                        if(DebugMode.DEBUG_MODE == 1) {
                        	Collider col = (Collider) o.getComponent("Collider");
                        	if(col!=null) {
                        		Vector ci = getCameraPositionFromWorldPosition(col.getInitCoords());
                            	Vector cf =  getCameraPositionFromWorldPosition(col.getFinalCoords());
                            	g2.setColor(Color.green);
                            	g2.drawRect((int)ci.getX(), (int)ci.getY(),(int) cf.getX(),(int) cf.getY());
                        	}
                        }
                        if(r!=null) {
                            //calculate x and y position in camera from world coords
                            int x = (int) ((objPos.getX()- (r.getWidth()*o.getScale())*o.getPivot().getX()) - this.position.getX()*Main.PX_PER_UNIT);
                            int y = (int) ((objPos.getY()-(r.getHeight()*o.getScale())*o.getPivot().getY()) + this.position.getY()*Main.PX_PER_UNIT);
                            r.paintComponent(g2, (int) (x+size.getX()/2), (int) (y+size.getY()/2), scale);

                        }
                    }
                    
                }
                
            }
        }
        
        // Draw grid
        if(DebugMode.DEBUG_MODE==1) {
        	// vertical lines
        	for(int x=(int) (-size.getX()/Main.PX_PER_UNIT); x <=size.getX()/Main.PX_PER_UNIT; x++)  {
        		float decimalPart = (float) (this.position.getX() - Math.floor(this.position.getX()));
        		int worldCoord = (int) (x+Math.floor(this.position.getX()));
        		int worldCoordToPixel = (int) (worldCoord*Main.PX_PER_UNIT - decimalPart*Main.PX_PER_UNIT);
        		int pxToCameraCoord  = (int) ((worldCoordToPixel + size.getX()/2)*scale);
        		if(worldCoord==0) {
        			g2.setStroke(new BasicStroke(5f));
        			g2.setColor(Color.black);
        		} else {
        			g2.setStroke(new BasicStroke(1f));
        			g2.setColor(Color.gray);
        		}
        		g2.drawLine((int) (pxToCameraCoord), 0,  
        				(int) (pxToCameraCoord),(int) ( this.getHeight()));
        	}
        	
        	for(int y=(int) -(size.getY()/Main.PX_PER_UNIT); y <=size.getY()/Main.PX_PER_UNIT; y++)  {
        		float decimalPart = (float) (this.position.getY() - Math.floor(this.position.getY()));
        		int worldCoord = (int) (y+Math.floor(this.position.getY()));
        		int worldCoordToPixel = (int) (worldCoord*Main.PX_PER_UNIT - decimalPart*Main.PX_PER_UNIT);
        		int pxToCameraCoord  = (int) ((worldCoordToPixel - size.getY()/2)*scale);
        		if(worldCoord==0) {
        			g2.setStroke(new BasicStroke(5f));
        			g2.setColor(Color.black);
        		} else {
        			g2.setStroke(new BasicStroke(1f));
        			g2.setColor(Color.gray);
        		}
        		g2.drawLine(0, -pxToCameraCoord,  
        				(int) (this.getWidth()), -pxToCameraCoord);
        	}
        		
        }
        g.drawImage(buffers[activeBuffer], 0, 0, this);
        
    }
    
    public Vector getCameraPositionFromWorldPosition(Vector c) {
    	float scale = getScale();
    	
    	float decimalPartX = (float) (this.position.getX() - Math.floor(this.position.getX()));
		int worldCoordX = (int) (c.getX());
		int worldCoordToPixelX = (int) (worldCoordX*Main.PX_PER_UNIT - decimalPartX*Main.PX_PER_UNIT);
		int pxToCameraCoordX  = (int) ((worldCoordToPixelX + size.getX()/2)*scale);
		
		float decimalPartY = (float) (this.position.getY() - Math.floor(this.position.getX()));
		int worldCoordY = (int) (c.getY());
		int worldCoordToPixelY = (int) (worldCoordY*Main.PX_PER_UNIT - decimalPartY*Main.PX_PER_UNIT);
		int pxToCameraCoordY  = (int) ((worldCoordToPixelY + size.getX()/2)*scale);
		
		return new Vector(pxToCameraCoordX, pxToCameraCoordY);
    }
    
    public float getScale() {
    	float scaleFactorX = this.getWidth()/size.getX();
        float scaleFactorY = this.getHeight()/size.getY();
        return Math.min(scaleFactorY, scaleFactorX);
    }
    
    public Vector getWorldPositionFromCameraPosition(Vector c) {
    	float scale = getScale();
    	float pxToWorld = c.getX() / (Main.PX_PER_UNIT * scale) + this.position.getX();
    	float xf = pxToWorld + (c.getX()%(Main.PX_PER_UNIT*scale))/Main.PX_PER_UNIT;
    	float x = ((((c.getX()) / (Main.PX_PER_UNIT*scale)) + this.position.getX()) + (c.getX()%(Main.PX_PER_UNIT*scale))/Main.PX_PER_UNIT);
    	float y = ((((c.getY()) / (Main.PX_PER_UNIT*scale)) + this.position.getY()) - (c.getY()%(Main.PX_PER_UNIT*scale))/Main.PX_PER_UNIT);
    	return new Vector(xf-(size.getX()/2)/Main.PX_PER_UNIT, -y+(size.getY()/2)/Main.PX_PER_UNIT);
    }
    

    
    public Vector getPosition() {
        return position;
    }
    
    public Vector getCameraSize() {
        return size;
    }
}
