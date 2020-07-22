import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * IceCreamTruck Class
 * 
 * A class inherited from the Vehicle class, with a drive method and a method
 * to check for intersections with slow or fast pedestrians. 
 * 
 * @author Star Xie
 * @version October 2019
 */
public class IceCreamTruck extends Vehicle
{
    //Declare instance variable
    private int speed=2;
    /**
     * Constructor - Resizes the image to fit the road, is automatically 
     * called whenever an IceCreamTruck object is created
     */
    public IceCreamTruck()
    {
        //Get the greenfoot image and scale it to fit the road image
        GreenfootImage image = getImage();
        //Reduce original size by a factor of 4
        image.scale(image.getWidth()/4,image.getHeight()/4);
        //Mirror the image to be facing in the correct direction
        image.mirrorHorizontally();
        //Set the image as the IceCreamTruck image
        setImage(image);
    }
    
    /**
     * Act - do whatever the IceCreamTruck wants to do. This method is called
     * whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        drive();
        checkHitPedestrian();
    }    
    
    public void drive()
    {
        move(speed);
    }
    
    public void checkHitPedestrian()
    {
        //Creates pedestrian and superhero objects to check for collision
        Pedestrian p = (Pedestrian)getOneObjectAtOffset((this.getImage().getWidth() / 2) + 1, 0, Pedestrian.class);
        SuperHero s = (SuperHero)getOneObjectAtOffset((this.getImage().getWidth() / 2) + 1, 0, SuperHero.class);
        if (p != null& s == null)
        {
            //if a pedestrian has collided (not a SuperHero), the following
            //code is executed
            p.makeBigger();
        }
    }
}
