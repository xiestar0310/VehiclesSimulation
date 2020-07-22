import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Car Class
 * 
 * A class inherited from the Vehicle class, with a drive method and a method
 * to check for intersections with slow or fast pedestrians. 
 * 
 * @author Star Xie
 * @version October 2019
 */
public class Car extends Vehicle
{
    //Instance variable
    private int speed = 5;
    private int offset;
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        drive();
        checkHitPedestrian();
    }
    
    /**
     * Method that deals with movement
     */
    public void drive() 
    {
        move (speed);
    }    

    /**
     * check if I hit a Pedestrian, and if so, act
     * accordingly
     */
    public void checkHitPedestrian ()
    {
        // Check collision for a pedestrian one pixel ahead
        // of the Vehicle
        offset = (this.getImage().getWidth() / 2) + 1;

        Pedestrian p = (Pedestrian)getOneObjectAtOffset(offset, 0, Pedestrian.class);
        SuperHero s = (SuperHero)getOneObjectAtOffset((this.getImage().getWidth() / 2) + 1, 0, SuperHero.class);
        if (p != null&&s == null)
        {
            p.knockMeOver();
        }
        
        if(s != null)
        {
            move(0);
            s.animateExplosion();
            getWorld().removeObject(this);
        }
    }
}
