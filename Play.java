import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends Button
{
    public Play() {
        GreenfootImage play = new GreenfootImage(100, 60);
        play = getImage();
        Font playFont = new Font(true, false, 50);
        play.setFont(playFont);
        play.setColor(Color.BLACK);
        //play.drawString("Play", 100, 250);
        play.scale(125, 125);

        setImage(play);
    }

    public void act()
    {
        checkMouse();
        checkClick(new Space());
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Space());
        }
    
    }
}
