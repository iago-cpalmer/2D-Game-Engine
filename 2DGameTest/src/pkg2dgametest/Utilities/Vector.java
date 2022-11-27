/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2dgametest.Utilities;

public class Vector {
    private float x;
    private float y;

    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    
    public void addX(float x) {
        this.x +=x;
    }
    public void addY(float y) {
        this.y += y;
    }
    
    public void set(float x, float y) {
        this.x=x;
        this.y=y;
    }
    
    public void addVector(Vector v) {
        this.x+=v.getX();
        this.y+=v.getY();
    }
    
    public void set(Vector v) {
        this.x=v.getX();
        this.y=v.getY();
    }
}
