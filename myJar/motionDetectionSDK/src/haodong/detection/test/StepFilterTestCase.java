package haodong.detection.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import haodong.detection.step.algo.StepFilterAlgo;

public class StepFilterTestCase {
	
	StepFilterAlgo stepFilterAlgo;
	
	public StepFilterTestCase() {
		stepFilterAlgo = new StepFilterAlgo();
	}
	
	@Test
	public void test() {
		Assert.assertEquals(0, stepFilterAlgo.getStepResult());
	}

}
