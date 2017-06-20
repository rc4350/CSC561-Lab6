package weapon;

import gameplay.TimeObserver;
/**
 * Weapon class holds by lifeform
 * @author Ryan Campbell, Deema Alrashdan
 */

public interface Weapon extends TimeObserver
{
	/**
     *  to calculate damage for the weapon
     */
	public int damage(int distance);
	/**
     * to reload the ammo
     */
	public void reload();
	/**
	 * set actual ammo
	 */
	public void setActualAmmo(int value);
	/**
	 * get base damage
	 */
	public int getBaseDamage();
	 /**
     * get max range
     */
	public int getMaxRange();
	 /**
     * get rate of fire
     */
	public int getRateOfFire();
	/**
     * get max ammo
     */
	public int getMaxAmmo();
	/**
     * get actual ammo
     */
	public int getActualAmmo();
	/**
	 * to check the range
	 */
	public boolean checkRange(int distance);
	/**
	 * get attachment count
	 */
	public int getAttachmentCount();
	/**
	 * to increase the attachment count
	 */
	public void increaseAttachmentCount();
}