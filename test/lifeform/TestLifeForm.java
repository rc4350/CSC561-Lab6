package lifeform;
import static org.junit.Assert.*;

import org.junit.Test;

import environment.Range;
import gameplay.SimpleTimer;
import weapon.Pistol;

/**
 *  Test LifeForm class
 * @author Ryan Campbell, Deema Alrashdan
 *
 */

public class TestLifeForm
{
    // Lab 6 Tests
    @Test
    public void testInitialization()
    {
        LifeForm entity;
        entity = new MockLifeForm("Bob", 40);
        assertEquals("Bob", entity.getName());
        assertEquals(40, entity.getCurrentLifePoints());
        assertEquals(0,entity.attackPoints);
        assertEquals(0, entity.getSpeed());
        assertEquals(LifeForm.NORTH,entity.getCurrentDirection());
    }

    @Test
    public void testChangeDirection()
    {
        LifeForm entity;
        entity = new MockLifeForm("Bob", 40);
        // This should be enough
        entity.changeDirection(LifeForm.SOUTH);
        assertEquals(LifeForm.SOUTH,entity.getCurrentDirection());
        // Running these just to ensure the other constants are there.
        entity.changeDirection(LifeForm.EAST);
        assertEquals(LifeForm.EAST,entity.getCurrentDirection());
        entity.changeDirection(LifeForm.WEST);
        assertEquals(LifeForm.WEST,entity.getCurrentDirection());
    }


	//Lab 5 Test

	@Test
	public void testSetLocation()
	{
		MockLifeForm mf = new MockLifeForm("Bob", 40, 10);
		mf.setLocation(0,0);
		int testlocation[] = new int[2];
		testlocation[0] = 0;
		testlocation[1] = 0;

		for(int i = 0; i<2; i++)
		{
			assertEquals(testlocation[i], mf.location[i]);
		}
	}

	@Test
	public void testGetLocation()
	{
		MockLifeForm mf = new MockLifeForm("Bob", 40, 10);
		mf.setLocation(0,0);
		int testlocation[] = new int[2];
		testlocation[0] = 0;
		testlocation[1] = 0;

		int lfLocation[] = mf.getLocation();

		for(int i = 0; i<2; i++)
		{
			assertEquals(testlocation[i], lfLocation[i]);
		}
	}

	@Test
	public void testDistanceRightAngle()
	{
		MockLifeForm mf1 = new MockLifeForm("Bob", 40, 10);
		MockLifeForm mf2 = new MockLifeForm("Joe", 40, 10);

		//checking same column
		mf1.setLocation(0,0);
		mf2.setLocation(0,1);
		assertEquals(5, mf1.getDistance(mf2));

		mf1.setLocation(0, 1);
		mf2.setLocation(0, 0);
		assertEquals(5, mf1.getDistance(mf2));

		//checking same row
		mf1.setLocation(1, 1);
		mf2.setLocation(3, 1);
		assertEquals(10, mf1.getDistance(mf2));

		mf1.setLocation(5, 1);
		mf2.setLocation(3, 1);
		assertEquals(10, mf1.getDistance(mf2));

	}

	@Test
	public void testDistanceDiagonal()
	{
		MockLifeForm mf1 = new MockLifeForm("Bob", 40, 10);
		MockLifeForm mf2 = new MockLifeForm("Joe", 40, 10);

		mf1.setLocation(0,0);
		mf2.setLocation(2,3);
		assertEquals(18, mf1.getDistance(mf2));

		mf1.setLocation(2,3);
		mf2.setLocation(0,0);
		assertEquals(18, mf1.getDistance(mf2));

	}


	//Lab 4 tests

	/**
	 * testPickup
	 * can pickup a weapon
	 */
	@Test
	public void testPickupWeapon()
	{
		LifeForm entity;
		entity = new MockLifeForm("Bob", 40, 10);
		Pistol pl = new Pistol();

		entity.pickUpWeapon(pl);
		assertEquals(entity.baseWeapon, pl);
	}

	/**
	 * testCanNotPickupWeapon
	 * can't pickup a weapon if already carrying a weapon
	 */
	@Test
	public void testCanNotPickupWeapon()
	{
		LifeForm entity;
		entity = new MockLifeForm("Bob", 40, 10);
		Pistol pl = new Pistol();
		Pistol pl2 = new Pistol();
		entity.pickUpWeapon(pl);
		entity.pickUpWeapon(pl2);
		assertEquals(entity.baseWeapon, pl);
	}

	/**
	 * testDropWeapon
	 * life form drop the weapon
	 */
	@Test
	public void testDropWeapon()
	{
		LifeForm entity;
		entity = new MockLifeForm("Bob", 40, 10);
		Pistol pl = new Pistol();
		entity.pickUpWeapon(pl);
		entity.dropWeapon();
		assertEquals(entity.baseWeapon, null);
	}

	/**
	 * testWeaponForDamageWithammo
	 * uses weapon for damage if has ammo
	 */
	@Test
	public void testWeaponForDamageWithammo()
	{
		Range.distance = 10;
		LifeForm entity, entity2;
		entity = new MockLifeForm("Bob", 40, 10);
		entity2 = new MockLifeForm("Sponge", 40, 10);
		Pistol pl = new Pistol();
		entity.pickUpWeapon(pl);
		entity2.takeHit(entity.attack(Range.distance));
		assertEquals(32,entity2.currentLifePoints);
        assertEquals(9,pl.getActualAmmo());
	}

	/**
	 * testWeaponForDamageWithOutAmmo
	 * uses weapon for damage if has not ammo
	 * or doesn't have a weapon
	 */
	@Test
	public void testWeaponForDamageWithOutAmmo()
	{

		Range.distance = 10;
		LifeForm entity, entity2;
		entity = new MockLifeForm("Bob", 40, 10);
		entity2 = new MockLifeForm("Sponge", 40, 10);
		//doesn't have a weapon
		Range.distance = 3;
		entity2.takeHit(entity.attack());
		assertEquals(30,entity2.currentLifePoints);
		//weapon has no ammo
		Range.distance = 4;
		Pistol pl = new Pistol();
		pl.setActualAmmo(0);
		entity.pickUpWeapon(pl);
		entity2.takeHit(entity.attack());
		assertEquals(20,entity2.currentLifePoints);
        assertEquals(0,pl.getActualAmmo());
	}

	/**
	 * testWeaponForDamageWithammo
	 * attack strength does 0 damage if range > 10 feet
	 */
	@Test
	public void attackStrengthDoesZeroDamage()
	{

		Range.distance = 10;
		LifeForm entity, entity2;
		entity = new MockLifeForm("Bob", 40, 10);
		entity2 = new MockLifeForm("Sponge", 40, 10);
		Pistol pl = new Pistol();
		pl.setActualAmmo(0);
		entity.pickUpWeapon(pl);
		entity2.takeHit(entity.attack(Range.distance));
		assertEquals(40,entity2.currentLifePoints);
        assertEquals(0,pl.getActualAmmo());
	}

	/**
	 * reloadWeapon
	 * can reload a weapon
	 */
	@Test
	public void reloadWeapon()
	{
		Pistol pl = new Pistol();
		pl.setActualAmmo(0);
		pl.reload();
        assertEquals(10,pl.getActualAmmo());
	}

	//lab 3 tests
	@Test
	public void testTracker()
	{
		MockLifeForm mf = new MockLifeForm("Bob", 40);
		SimpleTimer timr = new SimpleTimer();
		mf.addTimer(timr);
		timr.addTimeObserver(mf);
		assertEquals(0, mf.round);
		timr.timeChanged();
		assertEquals(1, mf.round);

	}

	@Test
	public void testAttack()
	{
		LifeForm lf = new MockLifeForm("Bob", 40, 10);
		assertEquals(10, lf.attack());
	}
	@Test
	public void testAttackHit()
	{
		MockLifeForm ml1 = new MockLifeForm("Bob", 40, 10);
		MockLifeForm ml2 = new MockLifeForm("John", 100, 20);
		ml2.takeHit(ml1.attack());
		assertEquals(90, ml2.currentLifePoints);
	}
	@Test
	public void testDeadAttack()
	{
		MockLifeForm ml = new MockLifeForm("Bob", 0, 10);
		assertEquals(0, ml.attack());
	}

	//lab 1-2 tests


	@Test
	public void testHit()
	{
		MockLifeForm mlf = new MockLifeForm("Bob", 40);
		mlf.takeHit(10);
		assertEquals(30, mlf.currentLifePoints);
	}

	@Test
	public void testHitNegative()
	{
		MockLifeForm mlf = new MockLifeForm("Bob", 40);
		mlf.takeHit(50);
		assertEquals(0, mlf.currentLifePoints);
	}
	@Test
	public void testHitToZero()
	{
		MockLifeForm mlf = new MockLifeForm("Bob", 40);
		mlf.takeHit(40);
		assertEquals(0, mlf.currentLifePoints);
	}
	@Test
	public void testHitAtZero()
	{
		MockLifeForm mlf = new MockLifeForm("Bob", 0);
		mlf.takeHit(40);
		assertEquals(0, mlf.currentLifePoints);
	}
}
