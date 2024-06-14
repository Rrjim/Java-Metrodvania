import greenfoot.*;
import java.util.*;

public class Projectile extends Animator {
    private int travelDistance;
    private int damage = 5; // Damage value of the projectile
    
    private int[] direction = new int[2];
    
    private GreenfootImage[] projRightImgF = new GreenfootImage[6];
    private GreenfootImage[] projRightImgB = new GreenfootImage[6];
    private GreenfootImage[] projRightImg = new GreenfootImage[12];
    
    private GreenfootImage[] projELeftImgF = new GreenfootImage[3];
    private GreenfootImage[] projELeftImgB = new GreenfootImage[3];
    private GreenfootImage[] projELeftImg = new GreenfootImage[6];
    
    private GreenfootImage[] heroRightSprintImgF = new GreenfootImage[6];
    private GreenfootImage[] heroRightSprintImgB = new GreenfootImage[6];
    private GreenfootImage[] heroRightSprintImg = new GreenfootImage[12];
        
    private GreenfootImage[] heroLeftSprintImgF = new GreenfootImage[6];
    private GreenfootImage[] heroLeftSprintImgB = new GreenfootImage[6];
    private GreenfootImage[] heroLeftSprintImg = new GreenfootImage[12];
    
    private String type;
    
    
    
    public Projectile(String type, int dmg, int dirX, int dirY) {
        //getImage().scale(getImage().getWidth()/5, getImage().getHeight()/5);
        //getWarriorBasedOnType("");      
        this.damage = damage;
        this.direction[0] = dirX;
        this.direction[1] = dirY;
        this.type = type;
        getImage().setTransparency(0);
        projRightImgF = createImgForwardArray(6, "Blade", 8, 5);
        projRightImgB = createImgBackwardArray(6, "Blade", 8, 5);
        projRightImg = combineImgArrays(projRightImgF, projRightImgB);
        
        projELeftImgF = createImgForwardArray(3, "Proj", 3, 6);
        projELeftImgB = createImgBackwardArray(3, "Proj", 3, 6);
        projELeftImg = combineImgArrays(projELeftImgF, projELeftImgB);
        
        heroLeftSprintImgF = createImgForwardArray(6, "DashL", 8, 5);
        heroLeftSprintImgB = createImgBackwardArray(6, "DashL", 8, 5);
        heroLeftSprintImg = combineImgArrays(heroLeftSprintImgF, heroLeftSprintImgB);

        heroRightSprintImgF = createImgForwardArray(6, "DashL", 8, 5);
        heroRightSprintImgB = createImgBackwardArray(6, "DashL", 8, 5);
        heroRightSprintImg = combineImgArrays(heroRightSprintImgF, heroRightSprintImgB);
    }

    public void act() {
        //if(getWarriorBasedOnType("Hero").get(0) !=null && getWarriorBasedOnType("FlyingEnemy") != null){
        //System.out.println("neeee" + getWarriorBasedOnType("Hero").get(0).getType());
        
                //System.out.println("oxiiii" + getWarriorBasedOnType("FlyingEnemy").get(0).getType());
           // }
 

        if(this!=null && this.type =="Hero" /*getWarriorBasedOnType("Hero").get(0)*/)
           moveProjectile(20, 125, "Hero", projRightImg,projRightImg);
           
           
        if(this!=null && this.type == "FlyingEnemy"/*getWarriorBasedOnType("FlyingEnemy").get(0)*/)
           moveProjectile(20,500, "FlyingEnemy",projELeftImg, projELeftImg);
           
           if(this!=null && this.getWorld() !=null){
           //System.out.println(getDistance());
           //System.out.println(getDistance(this.getWarriorBasedOnType("FlyingEnemy").get(0), this.getWarriorBasedOnType("Hero").get(0)));
            //System.out.println(getDistance(this.getWarriorBasedOnType("Hero").get(0), this.getWarriorBasedOnType("FlyingEnemy").get(0)));

        }

        }
        
        //if(this!=null)
          //System.out.println("nea" + xPos);

        //checkCollision(); // Call the method to check for collisions
    
    


   public void moveProjectile(int hitSpeed, int maxDist, String type, GreenfootImage[] imgArrayR, GreenfootImage[] imgArrayL) {
    if (getWarriorBasedOnType(type).get(0) == null)
       return;
    if (getWarriorBasedOnType(type).get(0) != null) {
        int warrX = getWarriorBasedOnType(type).get(0).getX();
        int distanceToWarrior = Math.abs(getX() - warrX);

 
        // Move the projectile towards the hero
        if (getWarriorBasedOnType(type).get(0).getDirection()[0] == 1 && this.direction[0] == getWarriorBasedOnType(type).get(0).getDirection()[0]) {
            
            move(hitSpeed);
            animate(1, imgArrayR);
            
            if (isAtEdge() || distanceToWarrior > maxDist) {
                getWorld().removeObject(this);
            }
            
        } else if (getWarriorBasedOnType(type).get(0).getDirection()[0] == -1 && this.direction[0] == getWarriorBasedOnType(type).get(0).getDirection()[0]) {
            move(-hitSpeed);
            animate(1, reverseArrayImages(imgArrayL));
            
            if (isAtEdge() || distanceToWarrior > maxDist) {
                getWorld().removeObject(this);
            }
        } else
        if(this !=null){
                            getWorld().removeObject(this);

        }
        
                // Check if the projectile is out of range or has traveled max distance
        
    } else {
        // If hero is null (not found), remove the projectile
        getWorld().removeObject(this);
    }
}



        
    public List<Warrior> getWarriorBasedOnType(String type) {
        if(this != null){
        List<Warrior> warriors = getWorld().getObjects(Warrior.class);
        List<Warrior> returnedWarriors = new ArrayList<Warrior>();
    for(Warrior w : warriors){
      if (this!= null && !warriors.isEmpty() && w.getType() == type) {
        returnedWarriors.add(w);  // Return the first warrior found
      } 
    }
    if(returnedWarriors.size() ==0){
        return null;
    }
    if(returnedWarriors.get(0).getType() == type && !returnedWarriors.isEmpty() && !warriors.isEmpty()){
           return returnedWarriors;
    
    }  else {
 
        return null;
    
}

} else {
    return null;
}
}


    
       public void setDirection(int horizontal, int vertical) {
        direction[0] = horizontal;
        direction[1] = vertical;
    }
    
    
        public int[] getDirection() {
        return direction;
    }
    
    public String getType() {
        return this.type;
    }


    

    public boolean isTouchingProjectile() {
        World world = getWorld();

        for (Hero h : world.getObjects(Hero.class)) {
            double distance = h.distanceTo(this);
            if (distance <= 100 && this.type != h.getType()) {
                return true;
            }
        }

        return false;
    }
}
