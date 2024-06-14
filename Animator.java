import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Animator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Animator extends Actor
{
    
        private int currentImage;
        
        



    public void act()
    {
        // Add your action code here.
    }
    
    public int getCurrentImg() {
        return this.currentImage;
    }
    
    
    public GreenfootImage[] createImgForwardArray(int numberOfImages, String imgName,int scaleX, int scaleY) {
        GreenfootImage[] images = new GreenfootImage[numberOfImages];
        for(int i=0; i<images.length; i++) {
            images[i] = new GreenfootImage(imgName + (i+1) + ".png");
            if(i>12) images[i].scale(1000,800);

            images[i].scale(1000/scaleX,800/scaleY);
        }
        //currentImage = 0;
        //setImage(images[currentImage]);
        
        return images;
    }
    
       public GreenfootImage[] createImgBackwardArray(int numberOfImages, String imgName, int scaleX, int scaleY) {
        GreenfootImage[] images = new GreenfootImage[numberOfImages];
        for(int i=images.length-1; i>=0; i--) {
            images[i] = new GreenfootImage(imgName + (i+1) + ".png");
            if(i>12) images[i].scale(1000, 800);
            images[i].scale(1000/scaleX,800/scaleY);
        }
        //currentImage = 0;
        //setImage(images[currentImage]);
        
        return images;
    }
    
public GreenfootImage[] combineImgArrays(GreenfootImage[] imgArray1, GreenfootImage[] imgArray2) {
    GreenfootImage[] newArray = new GreenfootImage[imgArray1.length + imgArray2.length];
    int position = 0;
    
    // Copy elements of imgArray1 to newArray
    for (int i = 0; i < imgArray1.length; i++) {
        newArray[position] = imgArray1[i];
        position++;
    }
    
    // Copy elements of imgArray2 to newArray
    for (int i = 0; i < imgArray2.length; i++) {
        newArray[position] = imgArray2[i];
        position++;
    }
    
    return newArray;
}

public GreenfootImage[] reverseArrayImages(GreenfootImage[] imgArray) {
        GreenfootImage[] newArray = new GreenfootImage[imgArray.length];
        int position =0;
        for(GreenfootImage img : imgArray){
            GreenfootImage newImg = new GreenfootImage(img);
            newImg.mirrorHorizontally();
            newArray[position] =  newImg;
            position++;

        }
 
    return newArray;
    
}


public void animate(int animationSpeed, GreenfootImage[] imgArray) {
        // Increment the frame counter
        currentImage++;
        
        // Check if it's time to change to the next frame
        if (currentImage % animationSpeed == 0) {
            // Set the image to the next frame in the animation
            setImage(imgArray[currentImage / animationSpeed % imgArray.length]);
        }
    }
    


    
    // Method to scale down the image
    public GreenfootImage scaleImage(GreenfootImage oldImage, int scaleNumber) {
        int newWidth = oldImage.getWidth() - scaleNumber;
        int newHeight = oldImage.getHeight() - scaleNumber;
        GreenfootImage newImage = new GreenfootImage(newWidth, newHeight);
        return newImage;
    }
}


