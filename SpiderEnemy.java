import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BeeEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpiderEnemy extends Enemy
{
    
    private static final int COOLDOWN_TIME_ENEMY = 50; // 2 seconds (60 acts per second)
    //private int[] direction = new int[2];
    private GreenfootImage[] spImgF = new GreenfootImage[8];
    private GreenfootImage[] spImgB = new GreenfootImage[8];
    private GreenfootImage[] spImg = new GreenfootImage[16];
    
    
    public void act()
    {
        System.out.println("IDONTHAVEHP "+getRemainingHp());
        //System.out.println(countEnemiesByType("Bee"));
        System.out.println((this.getType()));

         moveAround(30,spImg);
            turnMechanic();
            if(onGround()==true && getCooldown() == 0){
            setYSpeed(-30);
            jump(getYSpeed());
            setCooldown(COOLDOWN_TIME_ENEMY);
        }
                    checkFalling(spImg, reverseArrayImages(spImg));
                    
                    if(this.isAtEdge() && getYSpeed() >0){
                        if(getX()<=getImage().getWidth()/2){
                          move(12);
                        } else 
                        if(getX()>=getWorld().getWidth() - getImage().getWidth()/2){
                            move(-12);
                        }
                    }

        
        reduceCooldown();
    
    }
    
    public SpiderEnemy(int direction) {
        super("Spider");
        setHp(200);
        
        getImage().scale(333, 500);
        //setCooldown(COOLDOWN_TIME_ENEMY);
        //setCastingTime(0);

        setDirection(direction,0);
        
        spImgF = createImgForwardArray(8, "Spider", 3, 2);
        spImgB = createImgBackwardArray(8, "Spider", 3, 2);
        spImg = combineImgArrays(spImgF, spImgB);
        
    
        
    }
    
    @Override
    public boolean onGround() {
    Actor actor = getOneObjectAtOffset(0, -60+getImage().getHeight()/2, Platform.class);
    return actor != null;
}

}
