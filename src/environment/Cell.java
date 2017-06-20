package environment;

import lifeform.LifeForm;
import weapon.Weapon;

/**
 * holds a LifeForm
 * @author Ryan Campbell
 *
 */
public class Cell {
	private LifeForm myLifeForm;
	private Weapon weaponOne;
	private Weapon weaponTwo;
	
	public Cell()
	{
		myLifeForm = null;
	}
	/**
	 * 
	 * @return the LifeForm in this Cell
	 */
	public LifeForm getLifeForm() {
		// TODO Auto-generated method stub
		return myLifeForm;
	}
/**
 * 
 * Tries to add the LifeForm to the Cell. Will not add if
 * a LifeForm is already present.
 * @return true if the LifeForm was added to the Cell, false otherwise.
 */
	public boolean addLifeForm(LifeForm entity)
	{
		// TODO Auto-generated method stub
		if(myLifeForm == null) //checks that Life Form doesn't exist
		{
			myLifeForm = entity; //adds LifeForm
			return true;
		}
		else		//do not add if LifeForm already exists
			return false;
	}
public boolean removeLifeForm()
{
	// TODO Auto-generated method stub
	if(myLifeForm != null)
	{
		myLifeForm = null;
		return true;
	}
	else
	return false;
}
	public boolean addWeapon(Weapon wpn)
	{
		if(weaponOne == null)
		{
			weaponOne = wpn;
			return true;
		}
		else if (weaponTwo == null)
		{
			weaponTwo = wpn;
			return true;
		}
		else
			return false;
	}
	/**
	 * returns values of weaponOne
	 * @return weaponOne
	 */
	public Weapon getWeaponOne()
	{
		return weaponOne;
	}
	/**
	 * returns value of weaponTwo
	 * @return weaponTwo
	 */
	public Weapon getWeaponTwo()
	{
		return weaponTwo;
	}
	
	/**
	 * removes a weapon if it exists in the cell
	 * @param wpn weapon to remove
	 * @return true is weapon was removed, if weapon was not in cell returns false
	 */
	public boolean removeWeapon(Weapon wpn)
	{
		if(weaponOne == wpn)
		{
			weaponOne = null;
			return true;
		}
		else if(weaponTwo == wpn)
		{
			weaponTwo = null;
			return true;
		}
		else
			return false;
	}

}