import greenfoot.*;

public class InstructionWorld extends World {
    private String[] sentences = {"  Press Left / Right Arrow Buttons to Move", 
        "  Press (Space) keyword to Jump", 
        "  Press (Z) keyword to Hit your Enemies", 
        "  Press (S) keyword to Dash Forward",
        "  Your Starting Hit Points are 3"};
        
    private int currentSentenceIndex = 0;
    private int currentLetterIndex = 0;
    private int delay = 3; // Adjust this value to control the speed of letter loading
    private int timer = delay;
    private GreenfootImage textImage;
    private NextButton nextButton;
  public InstructionWorld() {
        super(1150, 800, 1);
        Color c = new Color(125, 112, 152);
        GreenfootImage background = getBackground();
        background.setColor(c);
        background.fill();
        
        GreenfootImage tree4 = new GreenfootImage("tree4.png");
        tree4.setTransparency(40);
        addPicture(getWidth()/2, getHeight()-175, getWidth(), getHeight(), tree4);

        GreenfootImage header = new GreenfootImage("Instruct.png");
        addPicture(getWidth()/2, getHeight()/10, getWidth()/2, getHeight()/3, header);

        
        
        textImage = new GreenfootImage(getWidth(), getHeight()/2);
        addObject(new InstructionText(), getWidth() / 2, getHeight() / 2);

        addObject(new InstructionText(), getWidth() / 2, getHeight() / 2);
        nextButton = new NextButton(this);
        nextButton.turn(90);
        addObject(nextButton, getWidth()/2, getHeight()- 150);
        
        
                Play play = new Play();
        addObject(play, getWidth()/10, 9*getHeight()/10);
    }
 

    public void act() {
        timer--;
        if (timer <= 0 && currentLetterIndex < sentences[currentSentenceIndex].length()) {
            addNextLetter();
            timer = delay;
        }
    }

    private void addNextLetter() {
        char nextChar = sentences[currentSentenceIndex].charAt(currentLetterIndex);
        textImage.drawString(String.valueOf(nextChar), currentLetterIndex * 20, currentSentenceIndex * 30 + 50);
        currentLetterIndex++;
        repaint();
    }
    
    public void nextSentence() {
        currentSentenceIndex = (currentSentenceIndex + 1) % sentences.length;
        currentLetterIndex = 0;
        textImage.clear();
    }

    private class InstructionText extends Actor {
        public InstructionText() {
            setImage(textImage);
        }
    }
    
        private void addPicture(int x,int y, int scaleX, int scaleY, GreenfootImage img){
        img.scale(scaleX, scaleY);
        Picture pic = new Picture(img);
        addObject(pic, x, y);

    }
    

}


  

 