import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import environment.TestCell;
import environment.TestEnvironment;
import gameplay.TestSimpleTimer;
import lifeform.TestAlien;
import lifeform.TestHuman;
import lifeform.TestLifeForm;
import recovery.TestRecoveryFractional;
import recovery.TestRecoveryNone;
import weapon.TestAttachment;
import weapon.TestAttachmentWrap;
import weapon.TestGenericWeapon;
import weapon.TestPistoL;
import weapon.TestPlasmaCannon;
import weapon.TestScope;
import weapon.TestStabilizer;
import recovery.TestRecoveryLinear;

/**
 * Runs all the tests in this project
 * @author Ryan Campbell
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
{
	TestLifeForm.class,
	TestCell.class,
	TestEnvironment.class,
	TestHuman.class,
	TestRecoveryFractional.class,
	TestRecoveryLinear.class,
	TestRecoveryNone.class,
	TestAlien.class,
	TestSimpleTimer.class,
	TestAttachment.class,
	TestAttachmentWrap.class,
	TestGenericWeapon.class,
	TestPistoL.class,
	TestPlasmaCannon.class,
	TestScope.class,
	TestStabilizer.class
})

public class AllGameTests {

}
