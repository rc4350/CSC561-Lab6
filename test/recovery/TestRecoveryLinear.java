package recovery;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Tests for RecoveryLinear recovery behavior
 * @author Ryan Campbell
 *
 */
public class TestRecoveryLinear
{

	
	
	
	//lab 1-2 tests
	@Test
	public void testnoRecoveryWhenNotHurt()
	{
		RecoveryLinear rl = new RecoveryLinear(3);
		int maxLifePts = 30;
		int result = rl.calculateRecovery(maxLifePts, maxLifePts);
		assertEquals(maxLifePts, result);
	}

	@Test
	public void testNormalRecovery()
	{
		RecoveryLinear rl = new RecoveryLinear(3);
		int maxLifePts = 30;
		int currentLifePts = 25;
		int result = rl.calculateRecovery(currentLifePts, maxLifePts);
		assertEquals(currentLifePts+3, result);
	}
	
	@Test
	public void testOverRecovery()
	{
		RecoveryLinear rl = new RecoveryLinear(3);
		int maxLifePts = 30;
		int currentLifePts = 28;
		int result = rl.calculateRecovery(currentLifePts, maxLifePts);
		assertEquals(maxLifePts, result);
	}
	
	@Test
	public void testDead()
	{
		RecoveryLinear rl = new RecoveryLinear(3);
		int maxLifePts = 30;
		int currentLifePts = 0;
		int result = rl.calculateRecovery(currentLifePts, maxLifePts);
		assertEquals(0, result);
	}
	
	@Test
	public void testPerfect()
	{
		RecoveryLinear rl = new RecoveryLinear(3);
		int maxLifePts = 30;
		int currentLifePts = 27;
		int result = rl.calculateRecovery(currentLifePts, maxLifePts);
		assertEquals(maxLifePts, result);
	}
}
