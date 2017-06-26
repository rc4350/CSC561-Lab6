package ui.command;

import static org.junit.Assert.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.junit.Before;
import org.junit.Test;

import environment.Environment;
import exceptions.MyNewException;
import lifeform.Alien;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import weapon.Pistol;
import weapon.PlasmaCannon;

public class TestCommandUI
{
	@Before
	public void reset()
	{
		Environment.reset();
	}
	@Test
	public void testinitialize() throws InterruptedException, MyNewException
	{
		Environment.initialize(8, 8);
		CommandUI cui = new CommandUI();
		assertNotNull(cui);
		@SuppressWarnings("unused")
		MockFrame mf = new MockFrame(cui);
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Does command panel look right?"));
	}

	@Test
	public void testButtons() throws MyNewException
	{
		Environment.initialize(8, 8);
		MockLifeForm mlf = new MockLifeForm("Bob", 40, 10);
		mlf.setSpeed(3);
		Alien al = new Alien("al", 100);
		Pistol pl = new Pistol();
		PlasmaCannon pc = new PlasmaCannon();
		Environment.getInstanceOf().addLifeForm(mlf, 4, 4);
		Environment.getInstanceOf().addWeapon(pl, 4, 7);
		Environment.getInstanceOf().addWeapon(pc, 4, 7);
		Environment.getInstanceOf().addLifeForm(al, 4, 6);
		Environment.getInstanceOf().setPlayer(mlf);
		CommandUI cui = new CommandUI();
		@SuppressWarnings("unused")
		MockFrame mframe = new MockFrame(cui);
		
		//turning
		cui.south.doClick();
		assertEquals(LifeForm.SOUTH, mlf.getCurrentDirection());
		cui.north.doClick();
		assertEquals(LifeForm.NORTH, mlf.getCurrentDirection());
		cui.west.doClick();
		assertEquals(LifeForm.WEST, mlf.getCurrentDirection());
		cui.east.doClick();
		assertEquals(LifeForm.EAST, mlf.getCurrentDirection());
		
		cui.attack.doClick();
		assertEquals(90, al.getCurrentLifePoints());
		
		cui.move.doClick();
		assertEquals(7, mlf.getLocation()[1]);
		
		cui.pickup1.doClick();
		assertNull(Environment.getInstanceOf().getWeapon1(mlf.getLocation()));
		assertEquals(pl, mlf.getWeapon());
		
		cui.drop.doClick();
		
		assertNull(mlf.getWeapon());
		
		cui.pickup2.doClick();
		assertEquals(pc, mlf.getWeapon());
		
		pc.setActualAmmo(0);
		cui.reload.doClick();
		assertEquals(pc.getMaxAmmo(), pc.getActualAmmo());
		
	}
}

class MockFrame extends JFrame
{

	/**
	 * TODO what is this for
	 */
	private static final long serialVersionUID = 1L;
	
	public MockFrame(CommandUI ui)
	{
		this.add(ui.getPanel());
		this.pack();
		this.setVisible(true);
	}
	
}
