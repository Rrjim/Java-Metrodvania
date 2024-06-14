import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MovingSphere here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MovingSphere extends Actor
{
   
    private int speed;
    
    
    public MovingSphere(int sp) {
        this.speed = sp;

    }
    public void act()
    {
        
        setLocation(getX(), getY() + speed);
        
        if (isAtEdge()) {
            speed = -speed; // Reverse direction
        }
    }
}
