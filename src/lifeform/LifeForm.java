package lifeform;

import environment.Environment;
import gameplay.SimpleTimer;
import gameplay.TimeObserver;
import gameplay.Timer;
import weapon.Weapon;


/**
 *
 * Keeps track of the information associated with a simple life form.
 * Also provides the functionality related to the life form
 *@author Ryan Campbell, Deema Alrashdan
 */
public class LifeForm implements TimeObserver
{
	public static final char NORTH = 'n';
	public static final char SOUTH = 's';
	public static final char EAST = 'e';
	public static final char WEST = 'w';

    protected String myName;
	protected int currentLifePoints;
	protected int attackPoints;
	protected Timer tracker;
	protected int round;
    protected Weapon baseWeapon;
    protected int location[];
    protected char currentDirection;
    protected int speed;



	/**
	 * create an instance
	 *
	 * @param name the name of the life form
	 * @param points the current starting life points of the life form
	 * @param ap
	 */
	public LifeForm(String name, int hp)
	{
		// TODO Auto-generated constructor stub
		myName = name;
		currentLifePoints = hp;
		if(currentLifePoints < 0)
		{
			currentLifePoints = 0;
		}
		location = new int[2];
		speed = 0;
		currentDirection = NORTH;
	}
	public LifeForm(String name, int hp, int ap)
	{
		this(name, hp);
		attackPoints = ap;
	}


	/**
	 * pickUpWeapon
	 * Life form pickup a weapon if doesn't have a weapon
	 * @param wp the weapon to pickup
	 */
	public void pickUpWeapon(Weapon wp)
	{
		if(baseWeapon == null)
		{
			baseWeapon = wp;
		}
	}

	/**
	 * updated 6/24 so weapon properly enters cell when dropped
	 * dropWeapon
	 * Life form drop the weapon
	 */
	public boolean dropWeapon()
	{
		if(baseWeapon != null)
		{
			boolean wpntocell;
			wpntocell = Environment.getInstanceOf().addWeapon(baseWeapon, location[0], location[1]);
			if (wpntocell == true)
			{
				baseWeapon = null;
				return true;
			}
			else
			{
				return false;
			}
		}
		else
			return false;
	}


	/**
	 *
	 * @return the name of the life form.
	 */
	public String getName() {
		// TODO Auto-generated method stub
		return myName;
	}
	/**
	 *
	 * @return the amount of current life points the life form has.
	 */
	public int getCurrentLifePoints() {
		// TODO Auto-generated method stub
		return currentLifePoints;
	}
	/**
	 * reduces current life points by the damage amount
	 * @param damage amount to reduce current life points
	 */
	public void takeHit(int damage)
	{
		currentLifePoints -= damage;
		if (currentLifePoints < 0)
		{
			currentLifePoints = 0;
		}
	}
	/**
	 * attack method for when weapon is equipped
	 * @param distance distance between attacking and receiving lifeforms
	 * @return damage value of weapon
	 */
	public int attack(int distance)
	{
		if (currentLifePoints == 0)
		{
			return 0;
		}
		// TODO Auto-generated method stub
		else if (baseWeapon == null)
			return attackPoints;
		else
		{
			return baseWeapon.damage(distance);
		}
	}
	/**
	 * attack method for no weapon
	 * @return lifeForm's  attack strength
	 */
	public int attack()
	{
		if (currentLifePoints == 0)
		{
			return 0;
		}
		// TODO Auto-generated method stub
		else
			return attackPoints;
	}
	protected void setAttackPoints(int sap)
	{
		attackPoints = sap;
	}
	public void addTimer(SimpleTimer timr)
	{
		tracker = timr;

	}
	@Override
	public void updateTime(int time)
	{
		round = tracker.getRound();

	}
	/**
	 * set's the location of lifeForm in the environment
	 * @param row row lifeform is in
	 * @param column column lifeform is in
	 */
	public void setLocation(int row, int column)
	{
		location[0] = row;
		location[1] = column;
	}
	/**
	 * get's lifeForms location
	 * @return returns location
	 */
	public int[] getLocation()
	{
		return location;
	}
	/**
	 * calculates distance between current lifeform and another
	 * @param target Lifeform
	 * @return returns distance between location and target location
	 */
	public int getDistance(LifeForm target)
	{
		int targetLocation[];
		targetLocation = target.getLocation();
		if(targetLocation[0] == location[0])
		{
			int distance = (targetLocation[1] - location[1])*5;
			distance = Math.abs(distance);
			return distance;
		}
		else if (targetLocation[1] == location[1])
		{
			int distance = (targetLocation[0] - location[0])*5;
			distance = Math.abs(distance);
			return distance;
		}
		else
		{
			int x, y, distance;
			x =Math.abs((targetLocation[0] - location[0])*5);
			y =Math.abs((targetLocation[1] - location[1])*5);
			distance = (int) Math.sqrt((x*x)+(y*y));
			return distance;

		}

	}

	/**
	 *
	 * @return How many spaces the LifeForm moves.
	 */
    public int getSpeed()
    {
        return speed;
    }
    /**
     *
     * @return The direction the LifeForm is facing.
     */
    public char getCurrentDirection()
    {
        return currentDirection;
    }
    /**
     * Changes the direction the LifeForm is facing.
     *
     * TODO Should make sure it is one of the four valid directions - Not required for Lab 6.
     * @param dir
     */
    public void changeDirection(char dir)
    {
        currentDirection = dir;

    }

    public void reload()
    {
    	if(baseWeapon != null)
    	{
    		baseWeapon.reload();
    	}
    }

    
    /**
   	 * has Weapon the lifeForm?
   	 * @return
   	 */
   	public boolean hasWeapon() {
   		if (baseWeapon != null)
   		{
   			return true; 
   		}
   		return false;
   	}
   	
   	/**
   	 * Return weapon
   	 * @return
   	 */
   	public Weapon getWeapon() 
   	{
   		return baseWeapon; 
   	}

}

