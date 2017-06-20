package recovery;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Test for Fractional Recovery recovery behavior
 * @author Ryan Campbell
 *
 */
public class TestRecoveryFractional
{

	
	
	
	//lab 1-2 tests
	@Test
	public void testConstruct()
	{
		RecoveryBehavior rf = new RecoveryFractional(.50);
		assertNotNull(rf);
	}

	@Test
	public void testRecovery()
	{
		RecoveryFractional rf = new RecoveryFractional(.10);
		int maxlife = 99;
		int currentlife = 40;
		currentlife = rf.calculateRecovery(currentlife, maxlife);
		assertEquals(50, currentlife);
	}
	@Test
	public void testOver()
	{
		RecoveryFractional rf = new RecoveryFractional(.50);
		int maxlife = 99;
		int currentlife = 80;
		currentlife = rf.calculateRecovery(currentlife, maxlife);
		assertEquals(99, currentlife);
	}
	@Test
	public void testDead()
	{
		RecoveryFractional rf = new RecoveryFractional(.80);
		int maxlife = 100;
		int currentlife = 0;
		currentlife = rf.calculateRecovery(currentlife, maxlife);
		assertEquals(0, currentlife);
	}
	@Test
	public void testPerfect()
	{
		RecoveryFractional rf = new RecoveryFractional(.10);
		int maxlife = 100;
		int currentlife = 90;
		currentlife = rf.calculateRecovery(currentlife, maxlife);
		assertEquals(100, currentlife);
	}
	@Test
	public void testHealthy()
	{
		RecoveryFractional rf = new RecoveryFractional(.10);
		int maxlife = 100;
		int currentlife = 100;
		currentlife = rf.calculateRecovery(currentlife, maxlife);
		assertEquals(100, currentlife);
	}
}
