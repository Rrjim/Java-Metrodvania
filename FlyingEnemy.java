import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class FlyingEnemy extends Enemy
{
    private static final int COOLDOWN_TIME_ENEMY = 360; // 2 seconds (60 acts per second)

    private GreenfootImage[] enemyProjImgF = new GreenfootImage[7];
    private GreenfootImage[] enemyProjImgB = new GreenfootImage[7];
    private GreenfootImage[] enemyProjImg = new GreenfootImage[14];
    
    private GreenfootImage[] enemyCdImgF = new GreenfootImage[10];
    private GreenfootImage[] enemyCdImgB = new GreenfootImage[10];
    private GreenfootImage[] enemyCdImg = new GreenfootImage[20];
    
    public void act()
    {
        if(this.getWorld() !=null){
        //System.out.println("here " +getDirection()[0] );//+ ySpeed);
        System.out.println("IDONTHAVEHP "+getRemainingHp());


        //jump(-40);
        
                //System.out.println("here " );//+ ySpeed);
            if(getCooldown()==0 && this!=null) {
                if(getDirection()[0] == 1){
                    move(1);
                    if(getCastingTime() < getCastDuration()) {
                       animate(10, reverseArrayImages(enemyProjImg));
                       castingStarted();
                    } else {
                Projectile p1 = new Projectile(this.getType(), 5, 1, -1);
                p1.setRotation(45);
                getWorld().addObject(p1, getX()+100, getY());
                            setCastingTime(0);
            setCooldown(COOLDOWN_TIME_ENEMY);
                
            }

            } else
            if(getDirection()[0] == -1) {
                move(-1);
                if(getCastingTime() < getCastDuration()) {

                animate(10, enemyProjImg);
                       castingStarted();
                    } else {
                setCastingTime(getCastDuration());
                Projectile p1 = new Projectile(this.getType(), 5, -1, -1);
                p1.setRotation(315);
                getWorld().addObject(p1, getX()-100, getY());
                            setCastingTime(0);
                            
            setCooldown(COOLDOWN_TIME_ENEMY);
            }
        }

            }
            moveAround(2,enemyCdImg);
            turnMechanic();
         
        
        reduceCooldown();
    }
    }
    
    public FlyingEnemy() {
        super("FlyingEnemy");
        setHp(100);
        
        getImage().mirrorHorizontally();
        getImage().scale(500, 200);
        //setCooldown(COOLDOWN_TIME_ENEMY);
        //setCastingTime(0);

        setDirection(1,0);
        
        enemyProjImgF = createImgForwardArray(7, "Eproj", 2, 4);
        enemyProjImgB = createImgBackwardArray(7, "Eproj", 2, 4);
        enemyProjImg = combineImgArrays(enemyProjImgF, enemyProjImgB);
        
        enemyCdImgF = createImgForwardArray(10, "Enemy", 2, 4);
        enemyCdImgB = createImgBackwardArray(10, "Enemy", 2, 4);
        enemyCdImg = combineImgArrays(enemyCdImgF, enemyCdImgB);
    }
    
}
