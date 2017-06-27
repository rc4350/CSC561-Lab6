/**
 * name: Deema Alrashdan
 */
package gui;

import static org.junit.Assert.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.junit.Test;
import environment.Environment;
import exceptions.MyNewException;
import lifeform.Alien;
import lifeform.Human;
import ui.command.Acquire1CMD;
import weapon.Pistol;
import weapon.PlasmaCannon;

public class TestGameDisplay
{
	private static Environment e ;

	/**
	 * TEST MAP
	 * @throws MyNewException
	 */
	@Test
	public void testMap() throws MyNewException
	{
		GUI gui = new GUI();
		
		ImageIcon imgIcon;
		Human h1 = new Human("Bob", 15, 3);
 
		gui.e.addLifeForm(h1, 4, 4);
		
		imgIcon = (ImageIcon) gui.SquareBtn[4][4].getIcon();  
		gui.SquareBtn[4][4].setIcon(gui.iconHuman(imgIcon, h1));
		
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Is the Human icon in the cell (4)(4) \nDoes it look right?"));
	
		/**
		 * ALIEN
		 */
		Alien a1 = new Alien("Alien", 30);
		gui.e.addLifeForm(a1, 4, 5);
		
		imgIcon = (ImageIcon) gui.SquareBtn[4][5].getIcon(); 
		gui.SquareBtn[4][5].setIcon(gui.iconAlien(imgIcon, a1));
	
		/**
		 * WEAPONS
		 */
		// 1 WEAPON
		Pistol gun = new Pistol();
		gui.e.addWeapon(gun, 1, 2);
		imgIcon = (ImageIcon) gui.SquareBtn[1][2].getIcon(); 
		gui.SquareBtn[1][2].setIcon(gui.iconWeaponOne(imgIcon, 0));
			
		// 2 Weapon
		PlasmaCannon pc = new PlasmaCannon();
		gui.e.addWeapon(pc, 6, 2);
		imgIcon = (ImageIcon) gui.SquareBtn[6][2].getIcon(); 
		gui.SquareBtn[6][2].setIcon(gui.iconWeaponTwo(imgIcon, 0));
				
		//Alien with weapon
		Alien a2 = new Alien("Predator", 30);
		Pistol gun3 = new Pistol();
		a2.pickUpWeapon(gun3);
		gui.e.addLifeForm(a2, 3, 2);

		imgIcon = (ImageIcon) gui.SquareBtn[3][2].getIcon(); 
		gui.SquareBtn[3][2].setIcon(gui.iconAlien(imgIcon, a2));
				
		//Human with weapon 
		Human h2 = new Human("Flash", 30, 10);
		Pistol gun4 = new Pistol();
		h2.pickUpWeapon(gun4);
		gui.e.addLifeForm(h2, 6, 6);

		imgIcon = (ImageIcon) gui.SquareBtn[6][6].getIcon(); 
		gui.SquareBtn[6][6].setIcon(gui.iconHuman(imgIcon, h2));		

		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Is the Alien icon in the cell (4)(5) \nDoes it look right?"));

		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Has the Alien a weapon in the cell (3)(2) \nDoes it look right?"));
	
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Has the Human a weapon in the cell (6)(6) \nDoes it look right?"));

		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "is the Pistol Weapon in the cell (1)(2) \nDoes it look right?"));

		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "is the PlasmaCannon Weapon in the cell (6)(2) \nDoes it look right?"));
	
	}

	/**
	 * TEST LEGEND
	 */
	@Test
	public void testHumanDisplay() 
	{
		//assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "If you click in the Cell (4)(4) of the Human, is the Information displayed correctly \nDoes it look right?"));
	}
	
	@Test
	public void testAlienDisplay() 
	{
		//assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "If you click in the Cell (4)(5) of the Alien, is the Information displayed correctly \nDoes it look right?"));
	}
	
	@Test
	public void testWeaponDisplay() 
	{
		//assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "If you click in the Cell (3)(2) of the Weapon, is the Information displayed correctly \nDoes it look right?"));
	}
}