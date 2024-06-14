import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Exit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Exit extends Button
{
       public Exit() {
        GreenfootImage exit = new GreenfootImage(100, 60);
        exit = getImage();
        Font exitFont = new Font(true, false, 30);
        exit.setFont(exitFont);
        exit.setColor(Color.BLACK);
        // exit.drawString("Exit", 0, 30);
        exit.scale(125, 125);
        setImage(exit);
    }
    
    
    public void act()
    {
        checkMouse();
        
        if(Greenfoot.mouseClicked(this)) {
            Greenfoot.stop();
            
        }
    }
    
    
}
