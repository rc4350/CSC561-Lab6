package weapon;
/**
 * Pistol weapon type
 * @author Ryan Campbell, Deema Alrashdan
 *
 */
public class Pistol extends GenericWeapon
{

	public Pistol()
	{
		super(10, 25, 2,10);
	}
	
	/**
	 * method for pistol's damage calculation
	 */
	@Override
	public int damage(int distance)
	{
		if(super.checkRange(distance) && super.actualAmmo>0 &&super.rofCheck())
		{
			int dmg;
			dmg = (int) ((float)super.baseDamage *((float)((super.maxRange-distance)+5)/(float)super.maxRange));
			super.actualAmmo--;
			super.fired++;
			return dmg;
			
		}
		else
			return 0;
	}
}
