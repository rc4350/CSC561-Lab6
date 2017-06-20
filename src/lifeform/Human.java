package lifeform;
/**
 *
 * @author Ryan Campbell
 * holds human lifeform
 *
 */
public class Human extends LifeForm
{
	private int myarmor; //holds armor points for human

	/**
	 * constructor with name, life, armor
	 * @param name name of human
	 * @param life max life points of human
	 * @param armor armor value of human
	 */
	public Human(String name, int life, int armor)
	{
		// TODO Auto-generated constructor stub
		super(name, life);

		if(!setArmorPoints(armor))
		{
			setArmorPoints(0);
		}
		speed = 3;
		super.setAttackPoints(5);

	}
	/**
	 * constructor with name, life, armor, and attack points
	 * @param name name of human
	 * @param life max life points of human
	 * @param armor armor value of human
	 * @param ap attack points of human
	 */
	public Human(String name, int life, int armor, int ap)
	{
		this(name, life, armor);
		super.setAttackPoints(ap);
	}
	/**
	 * gets the armor points for a human
	 * @return Human's armor points
	 */
	public int getArmorPoints()
	{
		// TODO Auto-generated method stub
		return myarmor;
	}
	/**
	 * sets the armor points for a human
	 * @param sap new armor point value
	 * @return returns true if armor points changed, false if invalid value
	 */
	public boolean setArmorPoints(int sap)
	{
		if(sap <0)
		{
			return false;
		}
		else
		{
			myarmor = sap;
			return true;
		}
	}

	/**
	 * overide take hit method to work with human's armor
	 */
	@Override
	public void takeHit(int damage)
	{
		if(damage > myarmor)
		{
			int temp;
			temp =  damage-myarmor;
			super.currentLifePoints -=temp;
		}
	}

}
