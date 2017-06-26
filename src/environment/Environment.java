package environment;

import exceptions.MyNewException;
import lifeform.LifeForm;
import weapon.Weapon;

/**
 * Holds 2D array of cells
 * and can add or remove lifeforms from cells
 * @author Ryan Campbell
 *
 */
public class Environment
{
	private static Environment theWorld;
	private Cell cell[][];
	private int myrow;
	private int mycol;
	private LifeForm player;


	/**
	 *
	 * @param row the number of rows
	 * @param col the number of columns
	 */
	private Environment(int row, int col) {
		//save number of rows and columns for bounds checks
		myrow = row;
		mycol = col;
		cell = new Cell[row][col]; //initialize cell[][]
		for(int i = 0; i <row; i++)
		{
			for (int j = 0; j<col; j++)
				cell[i][j] = new Cell();
		}

	}
	/**
	 * initializes theWorld
	 * @param height
	 * @param width
	 * @throws MyNewException
	 */
	public static void initialize(int height, int width) throws MyNewException
	{
		if(theWorld == null)
		{
			theWorld = new Environment(height, width);
		}
		else
		{
			throw new MyNewException();
		}
	}
	/**
	 *
	 * @return theWorld
	 */
	public static Environment getInstanceOf()
	{
		return theWorld;
	}
	/**
	 * resets environment for testing purposes
	 */
	public static void reset()
	{
		theWorld = null;
	}

	/**
	 *
	 * @param gcrow row index
	 * @param gccol column index
	 * @return LifeForm in cell at index
	 */
	public LifeForm getLifeForm(int gcrow, int gccol)
	{
		if(gcrow >= myrow || gccol >= mycol)
		{
			System.out.println("index out of bounds");
			return null;
		}
		else
			return cell[gcrow][gccol].getLifeForm();
	}
	/**
	 * adds lifeform to cell
	 * @param adlife lifeform to add
	 * @param adrow row index
	 * @param adcol column index
	 * @return true if successfully added, false if not
	 */
	public boolean addLifeForm(LifeForm adlife, int adrow, int adcol) {
		// TODO Auto-generated method stub
		if (adrow >= myrow || adcol >=mycol) //check that bounds are correct
		{
			return false;
		}
		else
		{	adlife.setLocation(adrow, adcol);
			return cell[adrow][adcol].addLifeForm(adlife);
		}
	}
	/**
	 * removes life form from cell
	 * @param rerow row index
	 * @param recol column index
	 * @return return true if lifeform was removed from cell
	 */
	public boolean removeLifeForm(int rerow, int recol) {
		// TODO Auto-generated method stub
		if (rerow >= myrow || recol >=mycol) //check bounds
		{
			return false;
		}
		else
			cell[rerow][recol].getLifeForm().setLocation(0, 0);
			return cell[rerow][recol].removeLifeForm();
	}
	/**
	 * get cell method for testing
	 */
	protected Cell getCell(int row, int col)
	{
		return cell[row][col];
	}
	/**
	 * adds a weapon to the cell if able
	 * @param wpn weapon to add
	 * @param row row of cell
	 * @param col column of cell
	 * @return false if out of bounds or unable to add weapon to cell
	 */
	public boolean addWeapon(Weapon wpn, int row, int col)
	{
		if (row >= myrow || col >=mycol) //check that bounds are correct
		{
			return false;
		}
		else
			return cell[row][col].addWeapon(wpn);

	}
	/**
	 * removes weapon from the cell if able
	 * @param wpn to remove
	 * @param row row of cell
	 * @param col column of cell
	 * @return returns false if out of bounds or unable to remove weapon
	 */
	public boolean removeWeapon(Weapon wpn, int row, int col)
	{
		if (row >= myrow || col >=mycol) //check that bounds are correct
		{
			return false;
		}
		else
			return cell[row][col].removeWeapon(wpn);
	}
	/**
	 * gets distance between two lifeforms
	 * @param lifeFormOne First Life Form
	 * @param lifeFormTwo Second Life Form
	 * @return distance between them
	 */
	public int getDistance(LifeForm lifeFormOne, LifeForm lifeFormTwo)
	{
		int oneLocation[];
		int twoLocation[];
		oneLocation = lifeFormOne.getLocation();
		twoLocation = lifeFormTwo.getLocation();
		if(oneLocation[0] == twoLocation[0])
		{
			int distance = (oneLocation[1] - twoLocation[1])*5;
			distance = Math.abs(distance);
			return distance;
		}
		else if (oneLocation[1] == twoLocation[1])
		{
			int distance = (oneLocation[0] - twoLocation[0])*5;
			distance = Math.abs(distance);
			return distance;
		}
		else
		{
			int x, y, distance;
			x =Math.abs((oneLocation[0] - twoLocation[0])*5);
			y =Math.abs((oneLocation[1] - twoLocation[1])*5);
			distance = (int) Math.sqrt((x*x)+(y*y));
			return distance;

		}

	}
	/**
	 * Will move a LifeForm based on its speed and direction.
	 * @param life
	 */
    public void moveLifeForm(LifeForm life)
    {
        int[] loc = new int[2];
        loc[0] = life.getLocation()[0];
        loc[1] = life.getLocation()[1];
        int dest = -1;
        int spd = life.getSpeed();
        this.removeLifeForm(loc[0], loc[1]);
        if (life.getCurrentDirection() == LifeForm.EAST)
        {
            if (checkMoveEdge(loc[0], loc[1]+spd))
                dest = loc[1] + spd;
            else
                dest = mycol-1;

            while (!checkCellEmpty(loc[0],dest))
                 dest--;

             this.addLifeForm(life, loc[0], dest);
        }
        else if (life.getCurrentDirection() == LifeForm.WEST)
        {
            if (checkMoveEdge(loc[0], loc[1]-spd))
                dest = loc[1] - spd;
            else
                dest = 0;

            while (!checkCellEmpty(loc[0],dest))
                 dest++;

             this.addLifeForm(life, loc[0], dest);
        }
        else if (life.getCurrentDirection() == LifeForm.NORTH)
        {
            if (checkMoveEdge(loc[0]-spd, loc[1]))
                dest = loc[0] - spd;
            else
                dest = 0;

            while (!checkCellEmpty(dest,loc[1]))
                 dest++;

             this.addLifeForm(life, dest, loc[1]);
        }
        else if (life.getCurrentDirection() == LifeForm.SOUTH)
        {
            if (checkMoveEdge(loc[0]+spd, loc[1]))
                dest = loc[0] + spd;
            else
                dest = myrow-1;

            while (!checkCellEmpty(dest,loc[1]))
                 dest--;

             this.addLifeForm(life, dest, loc[1]);
        }

    }

    /**
     * Checks to make sure a location in the Environment is within bounds.
     * @param row
     * @param col
     * @return
     */
    private boolean checkMoveEdge(int row, int col)
    {
      //check that bounds are correct
        if (row >= myrow || col >=mycol)
        {
            return false;
        }
        if (row < 0 || col < 0)
            return false;
        return true;
    }

    /**
     * Checks if there is a life form in the requested cell.
     * Assumes it is a valid cell in the environment.
     * @param row
     * @param col
     * @return
     */
    private boolean checkCellEmpty(int row, int col)
    {
        if (cell[row][col].getLifeForm() == null)
            return true;
        return false;
    }
    
    /**
     * 
     * @param location location of cell to get weapon 1 from
     * @return returns weaponOne of the specified cell
     */
	public Weapon getWeapon1(int[] location)
	{
		return cell[location[0]][location[1]].getWeaponOne();
	}
	/**
     * 
     * @param location location of cell to get weapon 2 from
     * @return returns weaponTwoof the specified cell
     */
	public Weapon getWeapon2(int[] location)
	{
		return cell[location[0]][location[1]].getWeaponTwo();
	}
	/**
	 * getWeapon
	 * @param row
	 * @param col
	 * @return
	 */
	public Weapon getWeapon( int row, int col)
	{
			return cell[row][col].getWeaponOne();
	}
    
	public LifeForm findNearest(LifeForm focus)
	{
		LifeForm nearest = null;
		int row;
		int col;
		//holds values for life for search
		
		int offset;
		if(focus.getCurrentDirection() == LifeForm.NORTH)
		{
			row = focus.getLocation()[0]-1;
			col = focus.getLocation()[1];
			offset = 1;
				
			while(nearest == null && row >=0 )
			{
				//System.out.println("row: "+row+"  col: "+col); //debug
				if((nearest=cell[row][col].getLifeForm()) != null && focus.getClass() != nearest.getClass())
				{
					return  nearest;
				}
				else
				{
					for(int i = 1; i <= offset; i++)
					{
						//System.out.println("row: "+row+"  colo: "+(col-i));  //debug
						if(col-i >= 0 && (nearest=cell[row][col-i].getLifeForm()) != null && focus.getClass() != nearest.getClass())
						{
							return nearest;
						}
						else if(col+i < mycol && (nearest=cell[row][col+i].getLifeForm()) != null && focus.getClass() != nearest.getClass())
						{
							return nearest;
						}
					}
					row--;
					offset++;
				}
			}
		}
		else if(focus.getCurrentDirection() == LifeForm.WEST)
		{
			row = focus.getLocation()[0];
			col = focus.getLocation()[1]-1;
			offset = 1;
				
			while(nearest == null && col >= 0)
			{
	
				if((nearest=cell[row][col].getLifeForm()) != null && focus.getClass() != nearest.getClass())
				{
					return  nearest;
				}
				else
				{
					for(int i = 1; i <= offset; i++)
					{
						//System.out.println("row: "+row+"  colo: "+(col-i));  //debug
						if(row+i < mycol&& (nearest=cell[row+i][col].getLifeForm()) != null && focus.getClass() != nearest.getClass())
						{
							return nearest;
						}
						else if(row-i >= 0  && (nearest=cell[row-i][col].getLifeForm()) != null && focus.getClass() != nearest.getClass())
						{
							return nearest;
						}
					}
					col--;
					offset++;
				}
			}
		}
		else if(focus.getCurrentDirection() == LifeForm.SOUTH)
		{
			row = focus.getLocation()[0]+1;
			col = focus.getLocation()[1];
			offset = 1;
				
			while(nearest == null && row <myrow )
			{
	
				if((nearest=cell[row][col].getLifeForm()) != null && focus.getClass() != nearest.getClass())
				{
					return  nearest;
				}
				else
				{
					for(int i = 1; i <= offset; i++)
					{
						//System.out.println("row: "+row+"  colo: "+(col-i));  //debug
						if(col+i < mycol && (nearest=cell[row][col+i].getLifeForm()) != null && focus.getClass() != nearest.getClass())
						{
							return nearest;
						}
						else if(col-i >= 0 && (nearest=cell[row][col-i].getLifeForm()) != null && focus.getClass() != nearest.getClass())
						{
							return nearest;
						}
					}
					row++;
					offset++;
				}
			}
		}
		else if(focus.getCurrentDirection() == LifeForm.EAST)
		{
			row = focus.getLocation()[0];
			col = focus.getLocation()[1]+1;
			offset = 1;
				
			while(nearest == null && col <mycol)
			{
	
				if((nearest=cell[row][col].getLifeForm()) != null && focus.getClass() != nearest.getClass())
				{
					return  nearest;
				}
				else
				{
					for(int i = 1; i <= offset; i++)
					{
						//System.out.println("row: "+row+"  colo: "+(col-i));  //debug
						if(row-i >= 0&& (nearest=cell[row-i][col].getLifeForm()) != null && focus.getClass() != nearest.getClass())
						{
							return nearest;
						}
						else if(row+i < mycol && (nearest=cell[row+i][col].getLifeForm()) != null && focus.getClass() != nearest.getClass())
						{
							return nearest;
						}
					}
					col++;
					offset++;
				}
			}
		}
		else
			return null;
		return null;

	}
	/**
	 * the attacker life attacks the nearest enemy if able
	 * @param attacker
	 */
	public  void Attack(LifeForm attacker)
	{
		LifeForm defender = findNearest(attacker);
		if(defender!= null)
		{
			defender.takeHit(attacker.attack(getDistance(attacker, defender)));
		}
		
	}
	/**
	 * sets the player character
	 * @param lf player character
	 */
	public void setPlayer(LifeForm lf)
	{
		player = lf;
		
	}
	/**
	 * gets the player character
	 * @return player
	 */
	public LifeForm getPlayer()
	{
	
		return player;
	}
}
