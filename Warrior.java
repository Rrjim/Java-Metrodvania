import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Warrior extends Animator
{
    /**getDistance
     * Act - do whatever the Warrior wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    private GreenfootImage myImage = getImage();
    
  
    private int[] direction = new int[2];
    private int ySpeed=0;
    private int acceleration=1;
    private int cdTimer = 0;
    private String type;
    private int castingTime = 0;
    private static final int CASTING_TIME = 180;
    private int cdHit = 0;
    private int damageTaken=5;
    private int currentHp;
    private static final int HP=100;
    private static final int TOUCH_RADIUS =100;
    
    
    

    public Warrior() {
 
    }
    

    
    public void act()
    {
        if(this!=null)
           isTouchingOtherWarrior();
    }
   
    public void setHp(int hp) {
        this.currentHp = hp;
    }
    
    public int getRemainingHp() {
        return currentHp;
    }

    
   public void setDirection(int horizontal, int vertical) {
        direction[0] = horizontal;
        direction[1] = vertical;
    }
    
    
        public int[] getDirection() {
        return direction;
    }
    
    public void setType(String t) {
        this.type = t;
    }
    
    public String getType() {
        return this.type;
    }
    
    
    public void setYSpeed(int ySp) {
        this.ySpeed = ySp;
    }
    
    public int getYSpeed() {
        return ySpeed;
    }
    
    public void setAcceleration(int acc) {
        this.acceleration = acc;
    }
    
    public int getAcceleration() {
        return acceleration;
    }
    
    public boolean onGround() {
    Actor actor = getOneObjectAtOffset(0, getImage().getHeight()/2, Platform.class);
    return actor != null;
}

   public void checkFalling(GreenfootImage[] imgRightArray, GreenfootImage[] imgLeftArray) {
        if(onGround() == false){
           //System.out.println("not on the ground") ; 
                   if(this.getDirection()[0] == 1){
                animate(3, imgRightArray);

            }else
                        if(this.getDirection()[0] == -1){
                animate(3, imgLeftArray);
            }
           
        fall();
    }  
    if(onGround() == true){
            //System.out.println(" on the ground") ;                
               

              setYSpeed(0);
    }
}

    public void fall() {
        setLocation(getX(), getY() + ySpeed);
        ySpeed = ySpeed + acceleration;
    }
    
     public void jump(int ySp) {
    
            setYSpeed(ySp);
            fall();
        
    }
    
    public void reduceCooldown() {
        if (cdTimer > 0) {
            cdTimer--;
        }
    }
    
    public void setCooldown(int cd){
        this.cdTimer = cd;
    }
    
    public int getCooldown() {
        return cdTimer;
    }
    
    public void reduceHitCd() {
        if (cdHit > 0) {
            cdHit--;
        }
    }
    
    public void setHitCd(int hCd) {
        this.cdHit = hCd;
    }
    
    public int getHitCd() {
        return cdHit;
    }
    
    public void castingStarted() {
        if(castingTime < CASTING_TIME) {
            castingTime++;
        }
    }
    
    public void setCastingTime(int castTime) {
        this.castingTime = castTime;
    }
    
    public int getCastingTime() {
        return castingTime;
    }
    
    
    
    public int getCastDuration() {
        return CASTING_TIME;
    }
    
        
    
    
    public void takeDamage(int damage){
        
    }
    

 // Adjust this value to set the desired touching radius


    public boolean isTouchingOtherWarrior() {
        // Get a reference to the world
        World world = getWorld();

        // Check if there is an enemy within the desired radius
        for (Warrior otherWarrior : world.getObjects(Warrior.class)) {
            double distance = distanceTo(otherWarrior);
            if (otherWarrior !=this && distance <= TOUCH_RADIUS) {
                return true;
            }
        }

        return false;
    }
    
   /* public boolean isTouchingOtherProjectile() {
        for (Projectile otherProj : getWorld().getObjects(Projectile.class)) {
            double distance = distanceTo(otherProj);
            if(otherProj != this && distance <=TOUCH_RADIUS){
                return true;
            }
        }
        return false;
    }*/

    public double distanceTo(Actor otherActor) {
        // Calculate distance between this actor and another actor
        int dx = otherActor.getX() - getX();
        int dy = otherActor.getY() - getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
    
   
    
  public Projectile createProjectile(String type, int damage, int directionX, int directionY) {
         Projectile p = new Projectile(type,damage,directionX, directionY);
         if(type == "Hero") {
             if(directionX == 1){
            getWorld().addObject(p, this.getX() +50, this.getY());
    } else {
        if(directionX==-1) {
            getWorld().addObject(p, this.getX(), this.getY());

        }
    }
} else 
if(type == "FlyingEnemy") {
             if(directionX == 1){
                                             p.setRotation(45);
            getWorld().addObject(p, this.getX() +100, this.getY());

    } else {
        if(directionX==-1) {
                                        p.setRotation(315);
            getWorld().addObject(p, this.getX() -100, this.getY());


        }
    }
}
return p;

}


}


    
    
  
    
    
  
    

    
     

    
    
 

