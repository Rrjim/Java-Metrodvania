import greenfoot.*;

public class NextButton extends Button {
    private InstructionWorld world; // Reference to the InstructionWorld

    public NextButton(InstructionWorld world) {
        this.world = world; // Store the reference to the InstructionWorld
        GreenfootImage buttonImage = new GreenfootImage("Next.png");
        setImage(buttonImage);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            world.nextSentence(); // Call the nextSentence() method in the InstructionWorld
        }
    }
}
