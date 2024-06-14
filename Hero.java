import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Hero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hero extends Warrior
{

    private boolean leftPressed = false; // Flag to track if left key was previously pressed
    private static final int COOLDOWN_TIME = 120; // 2 seconds (60 acts per second)
    private int currentFrame = 0;
    private int jumpFrame =0;
    private boolean isJumping = false;
    private static final int CD_HIT = 5;
    private int xSpeed=250;
    private boolean sprintFlag = false;
    private static final int SPRINT_DURATION =4000;
    private int sprintTimer =0;
    private HealthMask[] maskArray = new HealthMask[3];
    private static final int TOUCHED = 50;
    private int touched = 0;
    private int touchedTimes =2;
    private Space s;
    private Space2 s2;


 

    
    
    //private int acceleration = 500;
    private int apexTimer;

    
    
    private GreenfootImage[] heroRightStandingImgF = new GreenfootImage[3];
    private GreenfootImage[] heroRightStandingImgB = new GreenfootImage[3];
    private GreenfootImage[] heroRightStandingImg = new GreenfootImage[6];
    
    private GreenfootImage[] heroLeftStandingImgF = new GreenfootImage[3];
    private GreenfootImage[] heroLeftStandingImgB = new GreenfootImage[3];
    private GreenfootImage[] heroLeftStandingImg = new GreenfootImage[6];


    private GreenfootImage[] heroLeftImgF = new GreenfootImage[8];
    private GreenfootImage[] heroLeftImgB = new GreenfootImage[8];
    private GreenfootImage[] heroLeftImg = new GreenfootImage[16];


    private GreenfootImage[] heroRightImgF = new GreenfootImage[8];
    private GreenfootImage[] heroRightImgB = new GreenfootImage[8];
    private GreenfootImage[] heroRightImg = new GreenfootImage[16];
    
    
    private GreenfootImage[] heroRightJumpImgF = new GreenfootImage[3];
    private GreenfootImage[] heroRightJumpImgB = new GreenfootImage[3];
    private GreenfootImage[] heroRightJumpImg = new GreenfootImage[6];
    
    private GreenfootImage[] heroLeftJumpImgF = new GreenfootImage[3];
    private GreenfootImage[] heroLeftJumpImgB = new GreenfootImage[3];
    private GreenfootImage[] heroLeftJumpImg = new GreenfootImage[6];
    
    private GreenfootImage[] heroRightHitImgF = new GreenfootImage[12];
    private GreenfootImage[] heroRightHitImgB = new GreenfootImage[12];
    private GreenfootImage[] heroRightHitImg = new GreenfootImage[24];
    
    private GreenfootImage[] heroLeftHitImgF = new GreenfootImage[12];
    private GreenfootImage[] heroLeftHitImgB = new GreenfootImage[12];
    private GreenfootImage[] heroLeftHitImg = new GreenfootImage[24];
    
    private GreenfootImage[] heroRightSprintImgF = new GreenfootImage[6];
    private GreenfootImage[] heroRightSprintImgB = new GreenfootImage[6];
    private GreenfootImage[] heroRightSprintImg = new GreenfootImage[12];
        
    private GreenfootImage[] heroLeftSprintImgF = new GreenfootImage[6];
    private GreenfootImage[] heroLeftSprintImgB = new GreenfootImage[6];
    private GreenfootImage[] heroLeftSprintImg = new GreenfootImage[12];
    
    
    private GreenfootImage[] heroRightProjImgF = new GreenfootImage[6];
    private GreenfootImage[] heroRightProjImgB = new GreenfootImage[6];
    private GreenfootImage[] heroRightProjImg = new GreenfootImage[12];
    
    public Hero(Space2 space2){
                    
        getImage().scale(1000/8, 800/5);
        setType("Hero");
        this.s2 = space2;

        //setHpCounter(3);

setHeroAnimations(); 
    }
    
    public Hero(Space space) {
            
        getImage().scale(1000/8, 800/5);
        setType("Hero");
        this.s = space;


setHeroAnimations();        


    }
    
    public void setHeroAnimations() {
                heroLeftStandingImgF = createImgForwardArray(3, "StandingLeft", 8, 5);
        heroLeftStandingImgB = createImgBackwardArray(3, "StandingLeft", 8, 5);
        heroLeftStandingImg = combineImgArrays(heroLeftStandingImgF, heroLeftStandingImgB);
        
        heroRightStandingImgF = createImgForwardArray(3, "StandingRight", 8, 5);
        heroRightStandingImgB = createImgBackwardArray(3, "StandingRight", 8, 5);
        heroRightStandingImg = combineImgArrays(heroRightStandingImgF, heroRightStandingImgB);
        
        heroLeftImgF = createImgForwardArray(8, "HeroLeft", 8, 5);
        heroLeftImgB = createImgBackwardArray(8, "HeroLeft", 8, 5);
        heroLeftImg = combineImgArrays(heroLeftImgF, heroLeftImgB);


        heroRightImgF = createImgForwardArray(8, "HeroRight", 8, 5);
        heroRightImgB = createImgBackwardArray(8, "HeroRight", 8, 5);
        heroRightImg = combineImgArrays(heroRightImgF, heroRightImgB);
        
        heroLeftJumpImgF = createImgForwardArray(3, "HeroFly-", 8, 5);
        heroLeftJumpImgB = createImgBackwardArray(3, "HeroFly-", 8, 5);
        heroLeftJumpImg = combineImgArrays(heroLeftJumpImgF, heroLeftJumpImgB);

        heroRightJumpImgF = createImgForwardArray(3, "HeroFly", 8, 5);
        heroRightJumpImgB = createImgBackwardArray(3, "HeroFly", 8, 5);
        heroRightJumpImg = combineImgArrays(heroRightJumpImgF, heroRightJumpImgB);
        
        heroLeftHitImgF = createImgForwardArray(12, "HeroHit-", 8, 5);
        heroLeftHitImgB = createImgBackwardArray(12, "HeroHit-", 8, 5);
        heroLeftHitImg = combineImgArrays(heroLeftHitImgF, heroLeftHitImgB);

        heroRightHitImgF = createImgForwardArray(12, "HeroHit", 8, 5);
        heroRightHitImgB = createImgBackwardArray(12, "HeroHit", 8, 5);
        heroRightHitImg = combineImgArrays(heroRightHitImgF, heroRightHitImgB);
        
        heroLeftSprintImgF = createImgForwardArray(6, "DashL", 8, 5);
        heroLeftSprintImgB = createImgBackwardArray(6, "DashL", 8, 5);
        heroLeftSprintImg = combineImgArrays(heroLeftSprintImgF, heroLeftSprintImgB);

        heroRightSprintImgF = createImgForwardArray(6, "DashL", 8, 5);
        heroRightSprintImgB = createImgBackwardArray(6, "DashL", 8, 5);
        heroRightSprintImg = combineImgArrays(heroRightSprintImgF, heroRightSprintImgB);
        
        heroRightProjImgF = createImgForwardArray(6, "Blade", 8, 5);
        heroRightProjImgB = createImgBackwardArray(6, "Blade", 8, 5);
        heroRightProjImg = combineImgArrays(heroRightProjImgF, heroRightProjImgB);
    }
    



    public void act()
    {
        if(this.s !=null)
          moveToS2();
                        //setHeroHealth(3);
if(this!=null){
    if (this.isTouchingOtherWarrior() || this.isTouchingOtherProjectile()) {
if(this.s !=null) {
  heroGotTouched(s.getHeroHealth());
} else 
if(this.s2 !=null) {
    heroGotTouched(s2.getHeroHealth());
}
}

        //System.out.println("here " );//+ ySpeed);
            if(Greenfoot.isKeyDown("space") && onGround() == true)
        {
            setYSpeed(-25);
        jump(getYSpeed());
    }
        checkFalling(heroRightJumpImg, heroLeftJumpImg);


        checkKeys();
        reduceCooldown();
        reduceHitCd();
        
    }
        

    // Check conditions for triggering animations
        
        /*else 
        
            if(this.getDirection()[0] == 1 && this.getDirection()[1] == 1) {
            animateStanding(animationSpeed, heroRightJumpImg);
        } else 
            if(this.getDirection()[0] == -1 && this.getDirection()[1] == 1) {
            animateStanding(animationSpeed, heroLeftJumpImg);

        } else 
    
        
         if(this.getDirection()[0] == 1 && Greenfoot.isKeyDown("z")) {
            
            //switchImage(heroRightJumpImg);
            animateStanding(animationSpeed, heroRightHitImg);
        } else 
        if(this.getDirection()[0] == -1 && Greenfoot.isKeyDown("z")) {
            //switchImage(heroLeftJumpImg);
            animateStanding(animationSpeed, heroLeftHitImg);

            
        } 
        */
       

        
        
        
        //deb();
        //deb2();
    }
    
    public void deb() {
    for(int i=0 ; i<= heroRightJumpImg.length-1; i++){
     //System.out.println("haha" + heroRightJumpImg[i]) ; 
  
}
}

    public void deb2() {
    for(int i=0 ; i<= heroLeftSprintImg.length-1; i++){
     //System.out.println("haha" + heroLeftSprintImg[i]) ; 
  
}
}

public void setTouchedCd(int cd) {
    this.touched = cd;
}

public int getTouchedCd() {
    return touched;
}

public boolean arrayNull() {
    return s.getHeroHealth()[1] == null;
}

    public boolean isTouchingOtherProjectile() {
        // Get a reference to the world
        World world = getWorld();

        // Check if there is an enemy within the desired radius
        for (Projectile p : world.getObjects(Projectile.class)) {
            double distance = this.distanceTo(p);
            if (distance <= 200 && this.getType() != p.getType()) {
                return true;
            }
        }

        return false;
    }


public void heroGotTouched(HealthMask[] healthArray) {
    if(this!=null){
    if (getTouchedCd() == 0) {
        //System.out.println("TOUCHED");
        //setHpCounter(getHpCounter() - 1);
        //System.out.println(arrayNull());
        
               // System.out.println(healthArray.length);


        // Remove the health bar for the lost health
       if (touchedTimes >= 0 && touchedTimes < healthArray.length && healthArray[touchedTimes] != null) {
    //System.out.println("Length Array " + healthArray.length);
    getWorld().removeObject(healthArray[touchedTimes]);
    healthArray[touchedTimes] = null;
    touchedTimes--;
}

        // Set the cooldown for being touched
        setTouchedCd(TOUCHED);
    }

    if (healthArray[0] == null) {
        if(this.getWorld() == s) {
        s.gameOver();
        Greenfoot.stop();
    } else 
    if(this.getWorld() == s2) {
        s2.gameOver();
                Greenfoot.stop();
    }
    }


    if (touched > 0) {
        touched--;
    }
}
}


    
        private void checkKeys() 
    {

 
        
        if(Greenfoot.isKeyDown("z") && getDirection()[0] == 1 && getHitCd() ==0) {
            //setRotation(360);
            Projectile p = createProjectile("Hero", 5, 1, 0);
            //p.animate(1, heroRightProjImg);
            if(p.getWorld() !=null){
              hitEnemies("FlyingEnemy", p);
              hitEnemies("Bee", p);
              hitEnemies("Spider", p);

            }
            //p.getDistance(this, enemy);
            /*
                       if(p.getWorld() !=null && p.getWarriorBasedOnType("Bee") !=null){
                    if(p.getWarriorBasedOnType("Bee").size()>1){
                            hitEnemies("Bee", 1,p);
                            hitEnemies("Bee", 0, p);
                        }else 
                        if(p.getWarriorBasedOnType("Bee").size() ==1) {
                            hitEnemies("Bee",0, p);
                        }
              
                        }
*/
 

            //Enemy e2 = (Enemy)p.getWarriorBasedOnType("Bee").get(0);
            //e2.getDamageFromHero(p, "Bee");
            //Enemy e3 = (Enemy)p.getWarriorBasedOnType("Bee").get(1);
            //e3.getDamageFromHero(p, "Bee");
                        //System.out.println("Aristeraaa "+e1.getRemainingHp());
                                  //              System.out.println("Aristeraaa "+e2.getRemainingHp());
                        //System.out.println("Aristeraaa "+e3.getRemainingHp());



            animate(1,heroRightHitImg);
            setHitCd(CD_HIT); 
        
        } else if (Greenfoot.isKeyDown("z") && getDirection()[0] == -1 && getHitCd()==0) {
            //setRotation(360);
            //Projectile p = new Projectile(this.getType(),5,-1,0);
            //turnTowards(getX(), getY());
            //getWorld().addObject(p, getX(), getY());
            Projectile p = createProjectile("Hero", 5, -1, 0);
            //p.animate(1, reverseArrayImages(heroRightProjImg));
           if(p.getWorld() !=null){
              hitEnemies("FlyingEnemy", p);
              hitEnemies("Bee", p);
              hitEnemies("Spider", p);

            }
             /* 
              if(p.getWorld() !=null && p.getWarriorBasedOnType("Bee") !=null){
                    if(p.getWarriorBasedOnType("Bee").size()>1){
                            hitEnemies("Bee", 1,p);
                            hitEnemies("Bee", 0, p);
                        }else 
                        if(p.getWarriorBasedOnType("Bee").size() ==1) {
                            hitEnemies("Bee",0, p);
                        }
              
                        }
            */
            //Enemy e2 = (Enemy)p.getWarriorBasedOnType("Bee").get(0);
            //e2.getDamageFromHero(p, "Bee");
            //Enemy e3 = (Enemy)p.getWarriorBasedOnType("Bee").get(1);
            //e3.getDamageFromHero(p, "Bee");
            //System.out.println("Deksiap "+e1.getRemainingHp());
                       // System.out.println("Deksiap "+e2.getRemainingHp());
            //System.out.println("Deksiap "+e3.getRemainingHp());


            animate(1,heroLeftHitImg);
            setHitCd(CD_HIT);

        }
        
            if (Greenfoot.getKey() == null   && this.getDirection()[0] == 1 && this.getDirection()[1] == 0 && !Greenfoot.isKeyDown("left") && !Greenfoot.isKeyDown("right")) {
  
            animate(45, heroRightStandingImg);
         
    } else if (Greenfoot.getKey() == null && this.getDirection()[0] == -1 && this.getDirection()[1] == 0 && !Greenfoot.isKeyDown("left") && !Greenfoot.isKeyDown("right")) {
   
            animate(45, heroLeftStandingImg);
        } 

        

        
        if (Greenfoot.isKeyDown("left")) 
        {

            move(-5);
            setDirection(-1,getDirection()[1]);

            if(getDirection()[1] == 0 && onGround()){
            animate(5, heroLeftImg);  
        }
            


        }
        

        if (Greenfoot.isKeyDown("right")) 
        {
            move(5);
            setDirection(1,getDirection()[1]);

            if(getDirection()[1] == 0 && onGround()){
            animate(5, heroRightImg);
        } 
        
            
        }
        
            if(Greenfoot.isKeyDown("s") && getDirection()[0] == -1 && !sprintFlag && getCooldown() ==0){
                setYSpeed(0); //ySpeed =0;
                sprintFlag = true;
                sprintTimer = SPRINT_DURATION;
                int maxSprintDist = Math.abs(250 + getX());



                if(sprintTimer >0) {
                sprint(-xSpeed);
                animate(1, heroLeftSprintImg);
  
                        
                setCooldown(COOLDOWN_TIME);
            
        }


            }
            
            
        
        
                if(Greenfoot.isKeyDown("s") && getDirection()[0] == 1 && !sprintFlag && getCooldown() ==0){
            setYSpeed(0); //ySpeed =0;
            sprintFlag = true;
            sprintTimer = SPRINT_DURATION;

            if(sprintTimer >0){
            sprint(xSpeed);
            animate(1, reverseArrayImages(heroRightSprintImg));
            setCooldown(COOLDOWN_TIME);
        }



            }
            
            
        }
        
        

 public void hitEnemies(String warriorType, Projectile p){
     if(p.getWarriorBasedOnType(warriorType) !=null){
             
        for(Warrior w : p.getWarriorBasedOnType(warriorType)){
            Enemy e = (Enemy) w;
            if((e.distanceTo(p) <=125) && e.getRemainingHp()>0){
            e.setHp(e.getRemainingHp()-5);
        } else 
        if(e.getRemainingHp()<=0){
            getWorld().removeObject(e);
            e = null;
        }
        }
        
                }
            }
       

    
    public void sprint(int horizontalSpeed) {
        if(sprintFlag){
            
            sprintTimer--;
    
        setLocation(getX()+horizontalSpeed, getY());
       
        sprintFlag = false;
    }
    }
    
    public int getSprintTimer() {
        return this.sprintTimer;
    }
    
    public void decreaseSprintTimer() {
        this.sprintTimer--;
    }
    
       public boolean getSprintFlag() {
       return sprintFlag;
   }
   
   public void setSprintFlag(boolean spFlag) {
       this.sprintFlag = spFlag;
   }
   
  
   public void moveToS2(){
       if(s.getObjects(Enemy.class).size() ==0) {
           Greenfoot.setWorld(new Space2());
       }
       //System.out.println(s.getObjects(Enemy.class).size());
   }
   


   
    }
    
    
    
    
    



    
 


    
    
    

    
    
