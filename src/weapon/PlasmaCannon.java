package weapon;

/**
 * PlasmaCannon class is kind of weapon
 * @author Ryan Campbell, Deema Alrashdan
 */
public class PlasmaCannon extends GenericWeapon
{
	
	/**
	 * PlasmaCannon constructor set the values for PlasmaCannon
	 */
	public PlasmaCannon()
	{
		super(50, 20, 1, 4);
	}
	
	/**
	 * Damage for Plasma Cannon
	 * @param distance
	 */
	@Override
	public int damage(int distance)
	{
		if(super.checkRange(distance) == true && super.actualAmmo > 0 && super.rofCheck())
		{
			int dam;
			dam = (int)((float)super.baseDamage * ((float)super.actualAmmo / (float)super.maxAmmo));
			super.actualAmmo--;
			super.fired++;
			return dam;
		}
		else  
			return 0;
		}
	}