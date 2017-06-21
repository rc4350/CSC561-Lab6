package lifeform;

import weapon.Weapon;

/**
 * mock class to test abstract LifeForm class
 * @author Ryan Campbell
 *
 */
public class MockLifeForm extends LifeForm
{
	public MockLifeForm(String name, int hp)
	{
		super(name, hp);
	}
	public MockLifeForm(String name, int hp, int ap)
	{
		super(name, hp, ap);
	}

	/**
	 * Just for testing movement.
	 * @param value
	 */
	public void setSpeed(int value)
	{
	    speed = value;
	}
	public Weapon getWeapon()
	{
		// TODO Auto-generated method stub
		return super.baseWeapon;
	}


}
