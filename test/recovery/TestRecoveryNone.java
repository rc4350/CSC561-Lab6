package recovery;
/**
 * tests for RecoveryNone recovery behavior
 * @author Ryan Campbell
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class TestRecoveryNone
{

	
	
	
	//lab 1-2 tests
	@Test
	public void testAtFull()
	{
		int currentlife = 40;
		int maxlife = 40;
		
		RecoveryNone recnone = new RecoveryNone();
		int x = recnone.calculateRecovery(currentlife, maxlife);
		assertEquals(currentlife, x);
	}
	
	@Test
	public void testBelowFull()
	{
		RecoveryNone rn = new RecoveryNone();
		int x = rn.calculateRecovery(30, 40);
		assertEquals(30, x);
	}

}
