import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instructions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instructions extends Button
{
    
    public Instructions() {
        GreenfootImage inst = new GreenfootImage(230, 60);
        inst = getImage();
        Font instFont = new Font(true, false, 30);
        inst.setFont(instFont);
        inst.setColor(Color.BLACK);
        //inst.drawString("Instructions", 0, 30);
        
        inst.scale(125, 125);

        setImage(inst);
    }
    
    
    public void act()
    {
        checkMouse();
        checkClick(new InstructionWorld());
    
    }
}
