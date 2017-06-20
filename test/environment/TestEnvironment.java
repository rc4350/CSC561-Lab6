package environment;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.MyNewException;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import weapon.Pistol;
/**
 * Test Environment class
 * @author Ryan Campbell
 *
 */
public class TestEnvironment
{
    // Lab 6 Tests
    @Test
    public void testMoveLifeFormEastWestUnblocked() throws MyNewException
    {
        Environment testEnvironment;
        Environment.initialize(1,4);
        testEnvironment = Environment.getInstanceOf();
        MockLifeForm ml1 = new MockLifeForm("A", 50, 10);
        ml1.setSpeed(2);
        ml1.changeDirection(LifeForm.EAST);
        testEnvironment.addLifeForm(ml1, 0, 1);
        testEnvironment.moveLifeForm(ml1);
        assertEquals(ml1,testEnvironment.getLifeForm(0, 3));
        assertEquals(0,ml1.getLocation()[0]);
        assertEquals(3,ml1.getLocation()[1]);
        ml1.changeDirection(LifeForm.WEST);
        testEnvironment.moveLifeForm(ml1);
        assertEquals(ml1,testEnvironment.getLifeForm(0, 1));
        assertEquals(0,ml1.getLocation()[0]);
        assertEquals(1,ml1.getLocation()[1]);
    }

    @Test
    public void testMoveLifeFormNorthSouthUnblocked() throws MyNewException
    {
        Environment testEnvironment;
        Environment.initialize(4,1);
        testEnvironment = Environment.getInstanceOf();
        MockLifeForm ml1 = new MockLifeForm("A", 50, 10);
        ml1.setSpeed(2);
        ml1.changeDirection(LifeForm.SOUTH);
        testEnvironment.addLifeForm(ml1, 1, 0);
        testEnvironment.moveLifeForm(ml1);
        assertEquals(ml1,testEnvironment.getLifeForm(3, 0));
        assertEquals(3,ml1.getLocation()[0]);
        assertEquals(0,ml1.getLocation()[1]);
        ml1.changeDirection(LifeForm.NORTH);
        testEnvironment.moveLifeForm(ml1);
        assertEquals(ml1,testEnvironment.getLifeForm(1, 0));
        assertEquals(1,ml1.getLocation()[0]);
        assertEquals(0,ml1.getLocation()[1]);
    }

    @Test
    public void testMoveLifeFormNorthSouthEastWestEdge() throws MyNewException
    {
        Environment testEnvironment;
        Environment.initialize(2,2);
        testEnvironment = Environment.getInstanceOf();
        MockLifeForm ml1 = new MockLifeForm("A", 50, 10);
        ml1.setSpeed(3);
        ml1.changeDirection(LifeForm.WEST);
        testEnvironment.addLifeForm(ml1, 0, 1);
        testEnvironment.moveLifeForm(ml1);
        assertEquals(ml1,testEnvironment.getLifeForm(0, 0));
        ml1.changeDirection(LifeForm.SOUTH);
        testEnvironment.moveLifeForm(ml1);
        assertEquals(ml1,testEnvironment.getLifeForm(1, 0));
        ml1.changeDirection(LifeForm.EAST);
        testEnvironment.moveLifeForm(ml1);
        assertEquals(ml1,testEnvironment.getLifeForm(1, 1));
        ml1.changeDirection(LifeForm.NORTH);
        testEnvironment.moveLifeForm(ml1);
        assertEquals(ml1,testEnvironment.getLifeForm(0, 1));
    }

    @Test
    public void testMoveLifeFormEastBlocked() throws MyNewException
    {
        Environment testEnvironment;
        Environment.initialize(1,4);
        testEnvironment = Environment.getInstanceOf();
        MockLifeForm ml1 = new MockLifeForm("A", 50, 10);
        MockLifeForm ml2 = new MockLifeForm("B", 50, 10);
        ml1.setSpeed(2);
        ml1.changeDirection(LifeForm.EAST);
        testEnvironment.addLifeForm(ml1, 0, 1);
        testEnvironment.addLifeForm(ml2, 0, 3);
        testEnvironment.moveLifeForm(ml1);
        assertEquals(ml1,testEnvironment.getLifeForm(0, 2));
        assertEquals(0,ml1.getLocation()[0]);
        assertEquals(2,ml1.getLocation()[1]);

        MockLifeForm ml3 = new MockLifeForm("C", 50, 10);
        testEnvironment.removeLifeForm(0, 2);
        testEnvironment.addLifeForm(ml1, 0, 1);
        testEnvironment.addLifeForm(ml3, 0, 2);
        testEnvironment.moveLifeForm(ml1);
        assertEquals(ml1,testEnvironment.getLifeForm(0, 1));
        assertEquals(0,ml1.getLocation()[0]);
        assertEquals(1,ml1.getLocation()[1]);
    }

    @Test
    public void testMoveLifeFormWestBlocked() throws MyNewException
    {
        Environment testEnvironment;
        Environment.initialize(1,4);
        testEnvironment = Environment.getInstanceOf();
        MockLifeForm ml1 = new MockLifeForm("A", 50, 10);
        MockLifeForm ml2 = new MockLifeForm("B", 50, 10);
        ml1.setSpeed(2);
        ml1.changeDirection(LifeForm.WEST);
        testEnvironment.addLifeForm(ml1, 0, 3);
        testEnvironment.addLifeForm(ml2, 0, 1);
        testEnvironment.moveLifeForm(ml1);
        assertEquals(ml1,testEnvironment.getLifeForm(0, 2));
        assertEquals(0,ml1.getLocation()[0]);
        assertEquals(2,ml1.getLocation()[1]);

        MockLifeForm ml3 = new MockLifeForm("C", 50, 10);
        testEnvironment.removeLifeForm(0, 2);
        testEnvironment.addLifeForm(ml1, 0, 3);
        testEnvironment.addLifeForm(ml3, 0, 2);
        testEnvironment.moveLifeForm(ml1);
        assertEquals(ml1,testEnvironment.getLifeForm(0, 3));
        assertEquals(0,ml1.getLocation()[0]);
        assertEquals(3,ml1.getLocation()[1]);
    }

    @Test
    public void testMoveLifeFormSouthBlocked() throws MyNewException
    {
        Environment testEnvironment;
        Environment.initialize(4,1);
        testEnvironment = Environment.getInstanceOf();
        MockLifeForm ml1 = new MockLifeForm("A", 50, 10);
        MockLifeForm ml2 = new MockLifeForm("B", 50, 10);
        ml1.setSpeed(2);
        ml1.changeDirection(LifeForm.SOUTH);
        testEnvironment.addLifeForm(ml1, 1, 0);
        testEnvironment.addLifeForm(ml2, 3, 0);
        testEnvironment.moveLifeForm(ml1);
        assertEquals(ml1,testEnvironment.getLifeForm(2, 0));
        assertEquals(2,ml1.getLocation()[0]);
        assertEquals(0,ml1.getLocation()[1]);

        MockLifeForm ml3 = new MockLifeForm("C", 50, 10);
        testEnvironment.removeLifeForm(2, 0);
        testEnvironment.addLifeForm(ml1, 3, 0);
        testEnvironment.addLifeForm(ml3, 2, 0);
        testEnvironment.moveLifeForm(ml1);
        assertEquals(ml1,testEnvironment.getLifeForm(3, 0));
        assertEquals(3,ml1.getLocation()[0]);
        assertEquals(0,ml1.getLocation()[1]);
    }

    @Test
    public void testMoveLifeFormNorthBlocked() throws MyNewException
    {
        Environment testEnvironment;
        Environment.initialize(4,1);
        testEnvironment = Environment.getInstanceOf();
        MockLifeForm ml1 = new MockLifeForm("A", 50, 10);
        MockLifeForm ml2 = new MockLifeForm("B", 50, 10);
        ml1.setSpeed(2);
        ml1.changeDirection(LifeForm.NORTH);
        testEnvironment.addLifeForm(ml1, 3, 0);
        testEnvironment.addLifeForm(ml2, 1, 0);
        testEnvironment.moveLifeForm(ml1);
        assertEquals(ml1,testEnvironment.getLifeForm(2, 0));
        assertEquals(2,ml1.getLocation()[0]);
        assertEquals(0,ml1.getLocation()[1]);

        MockLifeForm ml3 = new MockLifeForm("C", 50, 10);
        testEnvironment.removeLifeForm(2, 0);
        testEnvironment.addLifeForm(ml1, 3, 0);
        testEnvironment.addLifeForm(ml3, 2, 0);
        testEnvironment.moveLifeForm(ml1);
        assertEquals(ml1,testEnvironment.getLifeForm(3, 0));
        assertEquals(3,ml1.getLocation()[0]);
        assertEquals(0,ml1.getLocation()[1]);
    }
	//lab 5 tests
	@Before
	public void reset()
	{
		Environment.reset();
	}
	@Test
	public void Test() throws MyNewException
	{
		Environment testEnvironment;
		testEnvironment = Environment.getInstanceOf();
		assertNull(testEnvironment);
		Environment.initialize(4,4);
		testEnvironment = Environment.getInstanceOf();
		assertNotNull(testEnvironment);
	}

	@Test(expected = MyNewException.class)
	public void testInitException() throws MyNewException
	{
		Environment.initialize(4,  4);
		Environment.initialize(0, 0);
	}

	@Test
	public void testReset() throws MyNewException
	{
		Environment testEnvironment;
		Environment.initialize(4,4);
		testEnvironment = Environment.getInstanceOf();
		Environment.reset();
		testEnvironment = Environment.getInstanceOf();
		assertNull(testEnvironment);
		Environment.initialize(5,5);
		testEnvironment = Environment.getInstanceOf();
		assertNotNull(testEnvironment);

	}
	@Test
	public void testAddWeapon() throws MyNewException
	{
		Environment testEnvironment;
		Environment.initialize(4,4);
		testEnvironment = Environment.getInstanceOf();
		Pistol pl = new Pistol();
		Pistol p2 = new Pistol();
		Pistol p3 = new Pistol();
		assertTrue(testEnvironment.addWeapon(pl, 1, 1));
		assertTrue(testEnvironment.addWeapon(p2, 1, 1));
		assertFalse(testEnvironment.addWeapon(p3, 1, 1));
		Cell cell = testEnvironment.getCell(1, 1);
		assertEquals(pl, cell.getWeaponOne());
	}

	@Test
	public void testRemoveWeapon() throws MyNewException
	{
		Environment testEnvironment;
		Environment.initialize(4,4);
		testEnvironment = Environment.getInstanceOf();
		Pistol pl = new Pistol();
		testEnvironment.addWeapon(pl, 1, 1);
		assertTrue(testEnvironment.removeWeapon(pl, 1,1));
		assertNull(testEnvironment.getCell(1, 1).getWeaponOne());
	}

	@Test
	public void testDistanceDiagonal() throws MyNewException
	{
		Environment testEnvironment;
		Environment.initialize(4,4);
		testEnvironment = Environment.getInstanceOf();
		MockLifeForm ml1 = new MockLifeForm("A", 50, 10);
		MockLifeForm ml2 = new MockLifeForm("B", 50, 10);
		testEnvironment.addLifeForm(ml1, 0, 0);
		testEnvironment.addLifeForm(ml2, 2, 3);
		assertEquals(18, testEnvironment.getDistance(ml1,ml2));

	}

	@Test
	public void testDistanceSameRow() throws MyNewException
	{
		Environment testEnvironment;
		Environment.initialize(4,4);
		testEnvironment = Environment.getInstanceOf();
		MockLifeForm ml1 = new MockLifeForm("A", 50, 10);
		MockLifeForm ml2 = new MockLifeForm("B", 50, 10);
		testEnvironment.addLifeForm(ml1, 0, 0);
		testEnvironment.addLifeForm(ml2, 0, 3);
		assertEquals(15, testEnvironment.getDistance(ml1,ml2));

	}
	@Test
	public void testDistanceSameColumn() throws MyNewException
	{
		Environment testEnvironment;
		Environment.initialize(4,4);
		testEnvironment = Environment.getInstanceOf();
		MockLifeForm ml1 = new MockLifeForm("A", 50, 10);
		MockLifeForm ml2 = new MockLifeForm("B", 50, 10);
		testEnvironment.addLifeForm(ml1, 0, 0);
		testEnvironment.addLifeForm(ml2, 2, 0);
		assertEquals(10, testEnvironment.getDistance(ml1,ml2));

	}

	//lab 1-2 tests - modified in lab 5
	/*@Test
	public void testInitialize() {
		Environment myenv = new Environment(1,1);
		assertNotNull(myenv);
	}*/
	@Test
	public void testAddCell() throws MyNewException
	{
		Environment myenv;
		Environment.initialize(2,3);
		myenv = Environment.getInstanceOf();
		LifeForm bob = new MockLifeForm("Bob", 40);
		boolean success;
		success = myenv.addLifeForm(bob, 0, 1);
		assertTrue(success);
		assertEquals(bob, myenv.getLifeForm(0, 1));
		int testLocation[] = bob.getLocation();
		assertEquals(0, testLocation[0]);
		assertEquals(1, testLocation[1]);
	}
	@Test
	public void testRemove() throws MyNewException
	{

		Environment myenv;
		Environment.initialize(2,3);
		myenv = Environment.getInstanceOf();
		LifeForm bob = new MockLifeForm("Bob", 40);
		myenv.addLifeForm(bob, 0, 1);
		boolean success;
		success = myenv.removeLifeForm(0,1);
		assertTrue(success);
		int testLocation[] = bob.getLocation();
		assertEquals(0, testLocation[0]);
		assertEquals(0, testLocation[1]);
	}
	@Test
	public void testBound() throws MyNewException
	{
		Environment myenv;
		Environment.initialize(1,1);
		myenv = Environment.getInstanceOf();
		LifeForm bob = new MockLifeForm("Bob", 40);
		boolean success;
		success = myenv.addLifeForm(bob, 0, 1);
		assertFalse(success);

		success = myenv.removeLifeForm(0, 1);
		assertFalse(success);

	}
}
