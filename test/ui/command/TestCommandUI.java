package ui.command;

import static org.junit.Assert.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.junit.Test;

public class TestCommandUI
{

	@Test
	public void testinitialize() throws InterruptedException
	{
		CommandUI cui = new CommandUI();
		assertNotNull(cui);
		MockFrame mf = new MockFrame(cui);
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Does command panel look right?"));
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
