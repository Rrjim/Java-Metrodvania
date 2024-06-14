import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BeeEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BeeEnemy extends Enemy
{
    
    private static final int COOLDOWN_TIME_ENEMY = 150; // 2 seconds (60 acts per second)
    //private int[] direction = new int[2];
    private GreenfootImage[] beeImgF = new GreenfootImage[5];
    private GreenfootImage[] beeImgB = new GreenfootImage[5];
    private GreenfootImage[] beeImg = new GreenfootImage[10];
    
    private GreenfootImage[] beeJImgF = new GreenfootImage[5];
    private GreenfootImage[] beeJImgB = new GreenfootImage[5];
    private GreenfootImage[] beeJImg = new GreenfootImage[10];
    
    public void act()
    {
        System.out.println("IDONTHAVEHP "+getRemainingHp());
        //System.out.println(countEnemiesByType("Bee"));
        System.out.println((this.getType()));

         moveAround(2,beeImg);
            turnMechanic();
            if(onGround()==true && getCooldown() == 0){
            setYSpeed(-20);
            jump(getYSpeed());
            setCooldown(COOLDOWN_TIME_ENEMY);
        }
                    checkFalling(reverseArrayImages(beeJImg), beeJImg);
                    
                    if(this.isAtEdge() && getYSpeed() >0){
                        if(getX()<=getImage().getWidth()/2){
                          move(5);
                        } else 
                        if(getX()>=getWorld().getWidth() - getImage().getWidth()/2){
                            move(-5);
                        }
                    }

        
        reduceCooldown();
    
    }
    
    public BeeEnemy(int direction) {
        super("Bee");
        setHp(100);
        
        getImage().scale(200, 400);
        //setCooldown(COOLDOWN_TIME_ENEMY);
        //setCastingTime(0);

        setDirection(direction,0);
        
        beeImgF = createImgForwardArray(5, "Bee", 6, 2);
        beeImgB = createImgBackwardArray(5, "Bee", 6, 2);
        beeImg = combineImgArrays(beeImgF, beeImgB);
        
        beeJImgF = createImgForwardArray(5, "BeeJ", 6, 2);
        beeJImgB = createImgBackwardArray(5, "BeeJ", 6, 2);
        beeJImg = combineImgArrays(beeJImgF, beeJImgB);
        
    }
    
    @Override
    public boolean onGround() {
    Actor actor = getOneObjectAtOffset(0, -60+getImage().getHeight()/2, Platform.class);
    return actor != null;
}

}
