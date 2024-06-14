import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private boolean mouseOver = false;
    private static int maxTransparency = 255;
    
    public void act()
    {
        // Add your action code here.
    }

    
    public void checkMouse() {
        if(Greenfoot.mouseMoved(null))
        {
           mouseOver = Greenfoot.mouseMoved(this);
                       
        }
        
        if(mouseOver) {
            adjustTransparency(maxTransparency/2);
            
        } else {
            adjustTransparency(maxTransparency);
        }
           
    }
    
    public void adjustTransparency(int factor) {
        GreenfootImage tempImg = getImage();
        tempImg.setTransparency(factor);
        setImage(tempImg);
    }
    
    public void checkClick(World world) {
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(world);
        }
    }
    
    
}
