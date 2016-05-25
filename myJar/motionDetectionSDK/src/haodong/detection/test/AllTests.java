package haodong.detection.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	StepFilterTestCase.class,
	StepBonusTestCase.class,
	StepSeftAdjustTestCase.class,
	StepPeakTestCase.class,
	TurnAlgoTestCase.class,
	LevelAlgoTestCase.class})

public class AllTests {
	public static void main (String args[]) {
        org.junit.runner.JUnitCore.main("AllTests");
    }
}
