package gui;

import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.Test;

public class TestGameDisplay {

	@Test
	public void test() {
		
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Create Cell Image Icon Correct For\nHuman(0,0) and Alien(1,1)\nDoes it look right?"));
	}
}