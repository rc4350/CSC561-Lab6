package lifeform;

/**
 * mock class to test abstract LifeForm class
 * @author Ryan Campbell
 *
 */
public class MockLifeForm extends LifeForm
{
	public MockLifeForm(String name, int hp)
	{
		super(name, hp);
	}
	public MockLifeForm(String name, int hp, int ap)
	{
		super(name, hp, ap);
	}
	

}
