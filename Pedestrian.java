import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Pedestrian Class
 * 
 * An abstract class that creates Pedestrians that move mindlessly up the 
 * road, reacting to cars that hit it, ambulances that heal it, 
 * and potentially buses that pick it up and an ice cream truck to make it 
 * larger in size.
 * 
 * @author Star Xie
 * @version October 2019
 */

public abstract class Pedestrian extends Actor
{
    // Instance variables
    protected int myWidth;
    protected boolean healthy;
    protected int startSpeed = 2;
    protected int speed; 

    /**
     * Method causes this Pedestrian to stop moving
     * and appear to fall over
     */
    protected void knockMeOver()
    {
        //Sets the speed to zero to simulate someone being knocked over
        speed = 0;
        //Sets rotation as if Pedestrian is knocked over
        setRotation (90);
        //Updates health accordingly
        healthy=false;
    }
    
    /**
     * Method causes this pedestrian to "heal" - regain
     * upright position and start moving again
     */
    protected void healMe ()
    {
        //Sets the speed to the start speed once more
        speed = startSpeed;
        //Makes pedestrian upright
        setRotation (0);
        //Updates health accordingly
        healthy=true;
    }
    
    /**
     * Method causes the pedestrian to get picked up
     * by the bus 
     */
    protected void pickMeUp()
    {
        //Check if the pedestrian is touching the bus class
        if(isTouching(Bus.class))
        {  
            //Remove the Pedestrian object
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Method causes the pedestrian to become bigger
     */
    protected void makeBigger()
    {
        //Create an image to alter
        GreenfootImage image= getImage();
        //If the pedestrian is healthy, scale the image accordingly
        if(healthy)
        {
            image.scale(image.getWidth()*102/100,image.getHeight()*102/100);
        }
    }
    
    /**
     * Handy method that checks if this object is at the edge
     * of the World
     * 
     * @return boolean  true if at or past the edge of the World, otherwise false
     */
    protected boolean atWorldEdge()
    {
        if (getX() < -(myWidth / 2) || getX() > getWorld().getWidth() + (myWidth / 2))
            return true;
        else if (getY() < -(myWidth / 2) || getY () > getWorld().getHeight() + (myWidth / 2))
            return true;
        else
            return false;
    }
}
