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
import ui.command.TestAcquire1CMD;
import ui.command.TestAcquire2CMD;
import ui.command.TestAttackCMD;
import ui.command.TestCommandBuilder;
import ui.command.TestCommandUI;
import ui.command.TestDropCMD;
import ui.command.TestMoveCMD;
import ui.command.TestReloadCMD;
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
	TestStabilizer.class,
	TestAcquire1CMD.class,
	TestAcquire2CMD.class,
	TestAttackCMD.class,
	TestCommandBuilder.class,
	TestCommandUI.class,
	TestDropCMD.class,
	TestMoveCMD.class,
	TestReloadCMD.class
})

public class AllGameTests {

}
