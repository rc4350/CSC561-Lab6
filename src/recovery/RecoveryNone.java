package recovery;
/**
 * 
 * @author Ryan Campbell
 *Recovery behavior for aliens that do not recover
 */
public class RecoveryNone implements RecoveryBehavior
{
	/**
	 * returns the current life points of the alien
	 */
	@Override
	public int calculateRecovery(int currentLife, int maxLife)
	{
		// TODO Auto-generated method stub
		return currentLife;
	}
	

}
