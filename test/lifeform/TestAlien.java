package lifeform;
/** Tests for Alien class
 * @author Ryan Campbell
 */
import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.MyNewException;
import gameplay.SimpleTimer;
import recovery.RecoveryFractional;
import recovery.RecoveryLinear;
import recovery.RecoveryNone;

public class TestAlien
{
	
	//lab 3 tests
	@Test
	public void testAttack()
	{
		RecoveryNone rn = new RecoveryNone();
		Alien bob = new Alien("Bob", 40, rn, 10);
		Alien joe = new Alien("Joe", 40, 10);
		assertNotNull(bob);
		assertNotNull(joe);
		joe.takeHit(bob.attack());
		assertEquals(30, joe.currentLifePoints);
	}
	
	@Test
	public void testTimer() throws MyNewException, InterruptedException
	{
		RecoveryLinear rl = new RecoveryLinear(10);
		Alien bob = new Alien("Bob", 100, rl, 10, 1);
		SimpleTimer st = new SimpleTimer(1000);
		int hp;
		bob.takeHit(50);
		hp = 50;
		st.addTimeObserver(bob);
		st.start();
		Thread.sleep(250);
		for (int x = 0; x< 7; x++)
		{
			assertEquals(hp, bob.currentLifePoints);
			if(hp <100)
				hp +=10;
			Thread.sleep(1000);
		}
	}
	
	@Test
	public void testTimerZero() throws MyNewException, InterruptedException
	{
		RecoveryLinear rl = new RecoveryLinear(10);
		Alien bob = new Alien("Bob", 100, rl, 10, 0);
		int hp;
		bob.takeHit(50);
		hp = 50;
		Thread.sleep(250);
		for (int x = 0; x< 7; x++)
		{
			assertEquals(hp, bob.currentLifePoints);
			Thread.sleep(1000);
		}
	}
	@Test
	public void testTimerNeg()
	{
		RecoveryLinear rl = new RecoveryLinear(10);
		Exception teste = null;
		try
		{
			@SuppressWarnings("unused")
			Alien bob = new Alien("Bob", 100, rl, 10, -5);
		} catch (MyNewException e)
		{
			teste = e;
		}
		assertNotNull(teste);
	}
	
	@Test
	public void testRoundHeal() throws MyNewException, InterruptedException
	{
		RecoveryLinear rl = new RecoveryLinear(10);
		Alien bob = new Alien("Bob", 100, rl, 10, 2);
		SimpleTimer st = new SimpleTimer(1000);
		int hp;
		bob.takeHit(50);
		hp = 50;
		st.addTimeObserver(bob);
		st.timeChanged();
		assertEquals(hp, bob.currentLifePoints);
		st.timeChanged();
		hp += 10;
		assertEquals(hp, bob.currentLifePoints);
	}
	@Test
	public void testRound3Heal() throws MyNewException, InterruptedException
	{
		RecoveryLinear rl = new RecoveryLinear(10);
		Alien bob = new Alien("Bob", 100, rl, 10, 3);
		SimpleTimer st = new SimpleTimer(1000);
		int hp;
		bob.takeHit(50);
		hp = 50;
		st.addTimeObserver(bob);
		st.timeChanged();
		assertEquals(hp, bob.currentLifePoints);
		st.timeChanged();
		assertEquals(hp, bob.currentLifePoints);
		st.timeChanged();
		hp += 10;
		assertEquals(hp, bob.currentLifePoints);
	}
	
	//lab 1-2 tests
	@Test
	public void testConstruct()
	{
		LifeForm bob = new Alien("Bob", 40);
		assertNotNull(bob);
	}

	@Test
	public void testLinearRecovery()
	{
		RecoveryLinear rl = new RecoveryLinear(3);
		Alien bob = new Alien("Bob", 40, rl);
		bob.setCurrentLifePoints(30);
		assertEquals(30, bob.currentLifePoints);
		bob.recover();
		assertEquals(33, bob.currentLifePoints);
	}
	@Test
	public void testFractionalRecovery()
	{
		RecoveryFractional rf = new RecoveryFractional(.10);
		Alien bob = new Alien("Bob", 95, rf);
		bob.setCurrentLifePoints(50);
		assertEquals(50, bob.currentLifePoints);
		bob.recover();
		assertEquals(60, bob.currentLifePoints);
	}
	@Test
	public void testNoRecovery()
	{
		RecoveryNone rn = new RecoveryNone();
		Alien bob = new Alien("Bob", 95, rn);
		bob.setCurrentLifePoints(50);
		assertEquals(50, bob.currentLifePoints);
		bob.recover();
		assertEquals(50, bob.currentLifePoints);
	}
}
