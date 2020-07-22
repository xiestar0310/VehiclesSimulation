import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Ambulance Class
 * 
 * A class inherited from the Vehicle class, with a drive method and a method
 * to check for intersections with slow or fast pedestrians. 
 * 
 * @author Star Xie
 * @version October 2019
 */
public class Ambulance extends Vehicle
{
    //Instance variable
    private int speed = 4;
    /**
     * Act - do whatever the Ambulance wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act ()
    {
        drive();
        checkHitPedestrian ();
    }

    public void drive ()
    {
        move (speed);
    }

    public void checkHitPedestrian ()
    {
        // Check collision for a pedestrian one pixel ahead
        // of the Vehicle
        Pedestrian p = (Pedestrian)getOneObjectAtOffset((this.getImage().getWidth() / 2) + 1, 0, Pedestrian.class);
        SuperHero s = (SuperHero)getOneObjectAtOffset((this.getImage().getWidth() / 2) + 1, 0, SuperHero.class);
        if (p != null&&s == null)
        {
            p.healMe();
        }
    }
}
