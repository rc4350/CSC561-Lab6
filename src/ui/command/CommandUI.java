package ui.command;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import environment.Environment;

public class CommandUI implements ActionListener
{
	//JPanels used in command ui
	private JPanel mainPanel;
	private JPanel westPanel;
	private JPanel eastPanel;
	//buttons used in westPanel for direction change
	protected JButton north, south, east, west;
	//buttons used in eastPanel for actions
	protected JButton move, attack, reload, pickup1, pickup2, drop;
	protected CommandInterface northCD, eastCD, southCD, westCD,
	attackCD, moveCD, reloadCD, pickup1CD, pickup2CD, dropCD;
	
	
	public CommandUI()
	{
		mainPanel = new JPanel(new BorderLayout());
		westPanel = new JPanel(new BorderLayout());
		eastPanel = new JPanel(new GridLayout(2,3));
		
		buildWestPanel();
		buildEastPanel();
		mainPanel.add("West", westPanel);
		mainPanel.add("East", eastPanel);
		CommandBuilder cb = new CommandBuilder(Environment.getInstanceOf().getPlayer());
		cb.buildInvoker(this);
	}
	
	/**
	 * builds components of westPanel and adds them to the panel
	 */
	private void buildWestPanel()
	{
		north = new JButton("N");
		south = new JButton("S");
		east = new JButton("E");
		west = new JButton("W");
		
		north.addActionListener(this);
		south.addActionListener(this);
		east.addActionListener(this);
		west.addActionListener(this);
		
		westPanel.add("North", north);
		westPanel.add("South", south);
		westPanel.add("West", west);
		westPanel.add("East", east);
	}
	/**
	 * builds components of eastPanel and adds them to the panel
	 */
	private void buildEastPanel()
	{
		move = new JButton("MOVE");
		attack = new JButton("ATTACK");
		reload = new JButton("RELOAD");
		pickup1 = new JButton("PICK UP 1");
		pickup2 = new JButton("PICK UP 2");
		drop = new JButton("DROP");
		
		move.addActionListener(this);
		attack.addActionListener(this);
		reload.addActionListener(this);
		pickup1.addActionListener(this);
		pickup2.addActionListener(this);
		drop.addActionListener(this);
		
		eastPanel.add(move);
		eastPanel.add(attack);
		eastPanel.add(reload);
		eastPanel.add(pickup1);
		eastPanel.add(pickup2);
		eastPanel.add(drop);
	}
	/**
	 * gets the mainPanel and returns it.
	 * @return main JPanel for Command UI
	 */
	public JPanel getPanel()
	{
		// TODO Auto-generated method stub
		return mainPanel;
	}
	/**
	 * set command
	 * @param ci CommandInterface
	 */
	protected void setNorth(CommandInterface ci)
	{
		northCD = ci;
	}
	protected void setEast(CommandInterface ci)
	{
		eastCD = ci;
	}
	/**
	 * set command
	 * @param ci CommandInterface
	 */
	protected void setSouth(CommandInterface ci)
	{
		southCD = ci;
	}
	/**
	 * set command
	 * @param ci CommandInterface
	 */
	protected void setWest(CommandInterface ci)
	{
		westCD = ci;
	}
	/**
	 * set command
	 * @param ci CommandInterface
	 */
	protected void setAttack(CommandInterface ci)
	{
		attackCD = ci;
	}
	/**
	 * set command
	 * @param ci CommandInterface
	 */
	protected void setMove(CommandInterface ci)
	{
		moveCD = ci;
	}
	/**
	 * set command
	 * @param ci CommandInterface
	 */
	protected void setReload(CommandInterface ci)
	{
		reloadCD = ci;
	}
	/**
	 * set command
	 * @param ci CommandInterface
	 */
	protected void setPick1(CommandInterface ci)
	{
		pickup1CD = ci;
	}
	/**
	 * set command
	 * @param ci CommandInterface
	 */
	protected void setPick2(CommandInterface ci)
	{
		pickup2CD = ci;
	}
	/**
	 * set command
	 * @param ci CommandInterface
	 */
	protected void setDrop(CommandInterface ci)
	{
		dropCD = ci;
	}

	/**
	 * handles events
	 */
	@Override
	public void actionPerformed(ActionEvent event)
	{
		//check turns
		if(event.getSource() == north)
		{
			northCD.executeCMD();
		}
		else if(event.getSource() == south)
		{
			southCD.executeCMD();
		}
		else if(event.getSource() == east)
		{
			eastCD.executeCMD();
		}
		else if(event.getSource() == west)
		{
			westCD.executeCMD();
		}
		//check 6 commands
		else if (event.getSource() == attack)
		{
			attackCD.executeCMD();
		}
		else if (event.getSource() == move)
		{
			moveCD.executeCMD();
		}
		else if (event.getSource() == reload)
		{
			reloadCD.executeCMD();
		}
		else if (event.getSource() == pickup1)
		{
			pickup1CD.executeCMD();
		}
		else if (event.getSource() == pickup2)
		{
			pickup2CD.executeCMD();
		}
		else if (event.getSource() == drop)
		{
			dropCD.executeCMD();
		}
	}
}
