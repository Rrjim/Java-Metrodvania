import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Space2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space2 extends World
{

    
        private HealthMask[] maskArray;      

    public Space2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 

        Color c = new Color(55, 69, 199);
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

        GreenfootImage tree4 = new GreenfootImage("tree5.png");
        GreenfootImage tree4a = new GreenfootImage("tree5.png");
        GreenfootImage tree4b = new GreenfootImage("tree5.png");

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

        GreenfootImage treeu4 = new GreenfootImage("treeu5.png");
        treeu4.setTransparency(25);

        for(int i=1; i<=26; i+=5) {
            addPicture(getWidth()-30*i, getHeight()/2, getWidth()/2, getHeight(), treeu4);

        }

        GreenfootImage G2 = new GreenfootImage("BG3.png");
        G2.setTransparency(100);
        for(int i=1; i<=26; i+=2) {
            addPicture(getWidth()-50*i, getHeight()-50, getWidth()/2, getHeight(), G2);

        }
        
                GreenfootImage G3 = new GreenfootImage("G3.png");
        G3.setTransparency(100);
        for(int i=1; i<=26; i+=2) {
            addPicture(getWidth()-50*i, getHeight()-50, getWidth()/2, getHeight(), G3);

        }

        
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



        for(int i=1; i<=10; i++) {
            MovingSphere ms = new MovingSphere(3);
            ms.getImage().setTransparency(40);
            ms.getImage().scale(getWidth()/10, getHeight()/15);
            addObject(ms, i*100, getHeight() - i*75);

        }
        
           //FlyingEnemy flyingEnemy = new FlyingEnemy();
        //addObject(flyingEnemy, getWidth()/5, getHeight()/5);
        SpiderEnemy spiderEnemy = new SpiderEnemy(1);
        addObject(spiderEnemy, getWidth()/5, getHeight()/5);
        
        Hero hero = new Hero(this);      
        addObject(hero, getWidth()/2, getHeight() - hero.getImage().getHeight()/2);
        //GreenfootImage heroImg = new GreenfootImage("HeroRight1.png");
        //addPicture(getWidth()/2, getHeight()+325, getWidth()/8, getHeight()/5, heroImg);
        
      

        //addPicture(150, 150, hero.getImage().getWidth(), hero.getImage().getHeight(), hero.getImage());
        Platform ground = new Platform(0, getWidth(),50);
        addObject(ground, getWidth()/2, getHeight());
        ground.getImage().setTransparency(0);

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
    
    public void gameOver() 
    {
        addObject(new Board(2), getWidth()/2, getHeight()/2);
    }

    /**
     * Crete a given number of stars in space.
     */
   

    
    }

