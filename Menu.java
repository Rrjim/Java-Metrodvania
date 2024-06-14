import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Menu()
    {    
        super(1100, 850, 1); 
        prepare();
    }
    
    private void prepare() {
        GreenfootImage logo = new GreenfootImage("Logo.png");
        logo.scale(2*getWidth()/3, 2*getHeight()/3);
        Picture p = new Picture(logo);
        addObject(p, getWidth()/2, 250);

        Play play = new Play();
        addObject(play, getWidth()/3, 9*getHeight()/10);

        Instructions inst = new Instructions();
        addObject(inst, getWidth()/2, 9*getHeight()/10);

        Exit exit = new Exit();
        addObject(exit, 2*getWidth()/3, 9*getHeight()/10);

    }
}
