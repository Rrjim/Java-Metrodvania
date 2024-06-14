import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Warrior
{
    
     //private int countEnemiesByType = 0;
     //private List<Enemy> enemiesByType = new ArrayList<Enemy>();
 
    
    public void act()
    {
        
        if(this.getRemainingHp() <=0){
            
            getWorld().removeObject(this);
        }
        



    }
    
    
    
    public Enemy(String type) {
        setType(type);
                
        
    }
    
    
    public void turnMechanic()
    {
        if (Greenfoot.getRandomNumber(1000) > 995 || isAtEdge()){
           if(getDirection()[0] == 1) {
               setDirection(-1, getDirection()[1]);
           } else
           if(getDirection()[0] == -1) {
               setDirection(1, getDirection()[1]);
           }
        
            //getImage().mirrorHorizontally();
    }}
    
    @Override
    public boolean isAtEdge(){
        if(this.getX()< getImage().getWidth()/6 || this.getX() > getWorld().getWidth()-getImage().getWidth()/6){
            return true;
        } else {
            return false;
        }
    }
    
    public void moveAround(int xSpeed, GreenfootImage[] imgArrayMoveL) {
        if(getCooldown() > 0) {
            if(getDirection()[0] == 1){
            move(xSpeed);
            animate(20, reverseArrayImages(imgArrayMoveL)); 
            }
            else
            if(getDirection()[0] == -1) {
            move(-xSpeed);
            animate(20, imgArrayMoveL);
            }
    }
    }
    
    /* public void hitHero(String warriorType, Projectile p){
     if(p.getWarriorBasedOnType(warriorType) !=null){
             
        for(Warrior w : p.getWarriorBasedOnType(warriorType)){
            Hero h = (Hero) w;
            if((h.distanceTo(p) <=125) && h.getRemainingHp()>0){
            h.setHp(h.getRemainingHp()-5);
        } else 
        if(e.getRemainingHp()<=0){
            getWorld().removeObject(e);
            e = null;
        }
        }
        
                }
            }
    

               */ 
  
    /*public int countEnemiesByType(String type) {
        for(Enemy e : getWorld().getObjects(Enemy.class)) {
            if(e.getType() == type) {
                enemiesByType.add(e);
            } 
        }
        if(enemiesByType !=null)
        return countEnemiesByType;
    }*/
    
}

