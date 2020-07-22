import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * MyWorld functions as the Controller for this Greenfoot
 * project which helps students understand inheritance
 * 
 * Written Task:
 * In the Vehicles assignment, I have made various changes involving 
 * inheritance to various classes and I have created new classes which 
 * implement inheritance. Firstly, I created a new class that was an Ice 
 * Cream Truck that inherited from the Vehicles superclass. The Ice Cream
 * Truck class made all Pedestrians (except for the SuperHero) get bigger
 * both horizontally and vertically. I also created three classes that 
 * inherited from the Pedestrian class. The first two classes I created were
 * a fast and slow pedestrian, moving at speeds of 4 and 1, respectively. The
 * only difference between the classes was to implement people crossing the 
 * street at different speeds. Another class I created that was part of the
 * Pedestrian class was the the SuperHero class. The concept behind that class
 * was to have a super hero baby that would sacrifice itself in an explosion
 * with a Car to fend for the greater good, as Cars killed the other 
 * Pedestrians that were walking fast and slow. in the SuperHero class, the
 * Ambulance, Bus and IceCreamTruck classes did not apply, so that the 
 * baby could not die, ride a bus, or get larger. Throughout my experiments,
 * having inheritance was essencial to avoid redundancy in the code, and 
 * inheritance itself had great uses in the project. By using protected 
 * variables and methods, I could reduce the amount of code for a lot of
 * my other classes and make my code clear and concise. As a programmer, 
 * allowing classes to inherit commonly used state and behaviour was really
 * helpful to the assignment as well. By creating a superclass, I avoided
 * having similar methods and variables in many of the classes I created in
 * this simulation. For example, instead of creating 4 classes of Pedestrians
 * and Vehicles, I could create a superclass and have that as a template
 * for creating classes with similar uses that were different. All in all,
 * inheritance has largely helped with this Vehicles assignment, and is 
 * very useful to avoid redundancy in coding. 
 * 
 * @author Star Xie
 * @version October 2019
 */
public class MyWorld extends World
{
    private int randomize;
    /**
     * Spawn Rates:
     * Lower number means more spawns
     * 3:spawnRate chance per act of spawning a random Vehicle
     * 1:pedSpawn chance per act of spawning a Pedestrian
     */
    //Declares instance variables
    private int spawnRate = 200; // must be higher than 3 ... should be higher than 30
    private int pedSpawn = 100; 
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
    }

    public void act ()
    {
        // Rum methods to see if any pedestrians or vehicles are going to be 
        // spawned this act:
        spawnPedestrians();
        spawnVehicles();       
    }
    
    private void spawnVehicles()
    {
        // Generate a random number to add a random element
        // to Vehicle spawning
        randomize = Greenfoot.getRandomNumber(spawnRate);
        
        
        // Chose a random lane in case a vehicle spawns
        int lane = Greenfoot.getRandomNumber (6);
        int spawnY = getYPosition (lane);

        // spawn vehicles
        if (randomize == 1)
        {
            // spawn a Car
            addObject (new Car(), 10, spawnY);
        }
        else if (randomize == 2)
        {
            // spawn a Bus
            addObject (new Bus(), 10, spawnY);
        }

        else if (randomize == 3)
        {
            // spawn a Car
            addObject (new Ambulance(), 10, spawnY);
        }
        else if(randomize == 4)
        {
            // spawn an Ice Cream Truck
            addObject (new IceCreamTruck(), 10, spawnY);
        }
    }
    
    private void spawnPedestrians()
    {
        // spawn pedestrians
        if (Greenfoot.getRandomNumber(pedSpawn) == 1)
        {
            //Spawn a Fast Person
            addObject (new FastPerson(), Greenfoot.getRandomNumber(600), 395);
        }
        if (Greenfoot.getRandomNumber(pedSpawn) == 2)
        {
            //Spawn a Slow Person
            addObject (new SlowPerson(), Greenfoot.getRandomNumber(600), 395);
        }
        if (Greenfoot.getRandomNumber(pedSpawn) == 3)
        {
            //Spawn a Super Hero
            addObject (new SuperHero(), Greenfoot.getRandomNumber(600), 395);
        }
    }
    
    /**
     * Returns the appropriate y coordinate for a given lane
     */
    private int getYPosition (int inLane)
    {
        // Manually input values based on the background graphic
        switch (inLane)
        {
            case 0: 
            return 79;

            case 1:
            return 127;

            case 2:
            return 175;

            case 3:
            return 222;

            case 4:
            return 272;

            case 5: 
            return 320;

        }  
        // In case an invalid value is passed in
        return 0;
    }
}

