import greenfoot.*;

public class Platform extends Actor {
    private int speed; // Adjust platform speed as needed
    private int width;
    private int height;
    
    public Platform(int sp, int w, int h) {
        this.speed = sp;
        getImage().scale(w, h);

    }

    public void act() {
        // Check for collision with actors on the platform
        /*Actor actorOnPlatform = getOneObjectAtOffset(0, 0, Actor.class);
        if (actorOnPlatform != null) {
            actorOnPlatform.setLocation(actorOnPlatform.getX() + speed, actorOnPlatform.getY());
        }
        */
        // Move the platform horizontally
        setLocation(getX() + speed, getY());
        
        // Check if the platform is at the edge of the world and change direction
        if (isAtEdge()) {
            speed = -speed; // Reverse direction
        }
    }
}