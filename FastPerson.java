import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * FastPerson Class
 * 
 * Moves mindlessly on the road, four times faster than the FastPerson.
 * Inherits from the Pedestrian class and reacts to cars that hit it, 
 * ambulances that heal it, buses that pick it up, and ice cream trucks 
 * that make it larger.
 * 
 * @author Star Xie
 * @version October 2019
 */
public class FastPerson extends Pedestrian
{
    //Instance variable
    private int startSpeed=4;
    public FastPerson()
    {
        // figure out own width (related to checking if at world's edge)
        GreenfootImage g = this.getImage();
        myWidth = g.getWidth();
        
        // Set current healthy status to true (alive and moving)
        healthy = true;
        // Set initial speed
        speed = startSpeed;
    }
    /**
     * Act - do whatever the FastPerson wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // move upwards
        setLocation (getX(), getY() - speed);
        // check if I'm at the edge of the world,
        // and if so, remove myself
        if (atWorldEdge())
        {
            getWorld().removeObject(this);
        }
    }    
}
