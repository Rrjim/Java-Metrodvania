import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.*;


/**
 * Space. Something for rockets to fly in.
 * 
 * @author Michael Kolling
 * @version 1.1
 */
public class Space extends World
{
    
    private HealthMask[] maskArray;      


    public Space() 
    {
        super(1200, 800, 1);

        Color c = new Color(249, 243, 209);
        GreenfootImage background = getBackground();
        background.setColor(c);
        background.fill();
        
        maskArray = new HealthMask[3]; 
        
initializeHealthMasks();

        GreenfootImage tree1 = new GreenfootImage("tree1.png");
        tree1.setTransparency(200);
        //for(int i=0; i<=8; i++) {
        //        addPicture(getWidth()-(100*i), getHeight()-175, getWidth()/2, getHeight(), tree1);

        //}
        //addPicture(getWidth()/2-100, getHeight()-250, getWidth()/2, getHeight(), tree1);
        //addPicture(getWidth()-250, getHeight()-250, getWidth()/2, getHeight(), tree1);

        //Explosion.initializeImages();
        //ProtonWave.initializeImages();

        GreenfootImage tree2 = new GreenfootImage("tree2.png");
        tree2.setTransparency(25);

        //       for(int i=1; i<=9; i++) {
        //        addPicture(i*100, getHeight()-175, getWidth()/2, getHeight(), tree2);

        //}
        //addPicture(getWidth()-100, getHeight()-250, getWidth()/2, getHeight(), tree2);
        //addPicture(getWidth()-400, getHeight()-250, getWidth()/2, getHeight(), tree2);
        //addPicture(100, getHeight()-250, getWidth()/2, getHeight(), tree2);
        //addPicture(250, getHeight()-250, getWidth()/2, getHeight(), tree2);

        GreenfootImage tree4 = new GreenfootImage("tree4.png");
        GreenfootImage tree4a = new GreenfootImage("tree4.png");
        GreenfootImage tree4b = new GreenfootImage("tree4.png");

        tree4.setTransparency(2);
        tree4a.setTransparency(120);
        tree4b.setTransparency(70);

        addPicture(100, getHeight()-175, getWidth()/2, getHeight(), tree4a);
        addPicture(getWidth()/2, getHeight()-175, getWidth()/2, getHeight(), tree4a);
        addPicture(getWidth()-100, getHeight()-175, getWidth()/2, getHeight(), tree4b);

        for(int i=1; i<=9; i++) {
            addPicture(i*100, getHeight()-175, getWidth()/2, 2*getHeight(), tree4);

        }
        //addPicture(100, getHeight()/2, getWidth()/2, getHeight(), tree4);
        //addPicture(250, getHeight()/2, getWidth()/2, getHeight(), tree4);
        //addPicture(getWidth()/2, getHeight()/2, getWidth()/2, getHeight(), tree4);
        //addPicture(getWidth()-250, getHeight()/2, getWidth()/2, getHeight(), tree4);
        //addPicture(getWidth()-100, getHeight()/2, getWidth()/2, getHeight(), tree4);

        GreenfootImage treeu5 = new GreenfootImage("treeu5.png");
        treeu5.setTransparency(20);

        for(int i=1; i<=26; i+=5) {
            addPicture(getWidth()-50*i, getHeight()/3, getWidth()/2, getHeight(), treeu5);

        }

        tree1.setTransparency(8);

        for(int i=1; i<=26; i+=5) {
            addPicture(getWidth()-50*i, getHeight()-250, getWidth()/2, getHeight(), tree1);

        }

        GreenfootImage treeu4 = new GreenfootImage("treeu4.png");
        treeu4.setTransparency(25);

        for(int i=1; i<=26; i+=5) {
            addPicture(getWidth()-30*i, getHeight()/2, getWidth()/2, getHeight(), treeu4);

        }

        GreenfootImage G2 = new GreenfootImage("G2.png");
        G2.setTransparency(100);
        for(int i=1; i<=26; i+=5) {
            addPicture(getWidth()-50*i, getHeight()-50, getWidth()/2, getHeight(), G2);

        }

        Platform plat1 = new Platform(0,getWidth()/2,45);
        addObject(plat1, getWidth()-200, 100+getHeight()/2);

        GreenfootImage plat1Bg = new GreenfootImage("plat1.png");
        //plat1Bg.setTransparency(50);
        addPicture(getWidth()-225, 100+getHeight()/2, getWidth()/2, 125, plat1Bg);

        GreenfootImage plat1BgT = new GreenfootImage("G3.png");
        plat1BgT.setTransparency(200);
        addPicture(getWidth()-200, 50+getHeight()/2, getWidth()/2, 125, plat1BgT);

        Platform plat2 = new Platform(0,-120+getWidth()/2,45);
        addObject(plat2, 0, getHeight()/2);

        GreenfootImage plat2Bg = new GreenfootImage("Plat2.png");
        //plat1Bg.setTransparency(50);
        addPicture(0, -25+getHeight()/2, getWidth()/2, 200, plat2Bg);

        
        GreenfootImage top = new GreenfootImage("UD.png");
        addPicture(getWidth()/2, 0, getWidth()+100, getHeight()/7, top);
        GreenfootImage bgBot = new GreenfootImage("G3.png");
        bgBot.setTransparency(20);

        addPicture(getWidth()/2, getHeight()+100, 2*getWidth(), getHeight(), bgBot);

        GreenfootImage glow = new GreenfootImage("Glowing.png");
        glow.setTransparency(12);

        for(int i=1; i<=9; i++) {
            addPicture(i*100, getHeight()-175, getWidth()/2, 2*getHeight(), glow);

        }



        for(int i=1; i<=4; i++) {
            MovingSphere ms = new MovingSphere(3);
            ms.getImage().setTransparency(40);
            ms.getImage().scale(getWidth()/10, getHeight()/15);
            addObject(ms, i*100, getHeight() - i*200);

        }
        
        FlyingEnemy flyingEnemy = new FlyingEnemy();
        addObject(flyingEnemy, getWidth()/5, getHeight()/5);
        
        BeeEnemy beeEnemy1 = new BeeEnemy(1);
        BeeEnemy beeEnemy2 = new BeeEnemy(-1);
        
        addObject(beeEnemy1, 200, 60+getHeight() - beeEnemy1.getImage().getHeight()/2);
        addObject(beeEnemy2, getWidth()-200, 60+getHeight() - beeEnemy2.getImage().getHeight()/2);


        Hero hero = new Hero(this);      
        addObject(hero, getWidth()/2, getHeight() - hero.getImage().getHeight()/2);
        //GreenfootImage heroImg = new GreenfootImage("HeroRight1.png");
        //addPicture(getWidth()/2, getHeight()+325, getWidth()/8, getHeight()/5, heroImg);
        
        

        //addPicture(150, 150, hero.getImage().getWidth(), hero.getImage().getHeight(), hero.getImage());
        Platform ground = new Platform(0, getWidth(),50);
        addObject(ground, getWidth()/2, getHeight());
        ground.getImage().setTransparency(0);

        prepare();
    }

    /**
     * Add a given number of asteroids to our world. Asteroids are only added into
     * the left half of the world.
     */
    private void addPicture(int x,int y, int scaleX, int scaleY, GreenfootImage img){
        img.scale(scaleX, scaleY);
        Picture pic = new Picture(img);
        addObject(pic, x, y);

    }

    private void initializeHealthMasks() {
        for (int i = 0; i < maskArray.length; i++) {
            HealthMask health = new HealthMask();
            maskArray[i] = health;
            addObject(maskArray[i], 50 + 50 * i, 40);
        }
    }

    public HealthMask[] getHeroHealth() {
        return maskArray; // Return the existing maskArray
    }


    /**
     * Crete a given number of stars in space.
     */
   

    /**
     * This method is called when the game is over to display the final score.
     */
    public void gameOver() 
    {
        addObject(new Board(1), getWidth()/2, getHeight()/2);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}