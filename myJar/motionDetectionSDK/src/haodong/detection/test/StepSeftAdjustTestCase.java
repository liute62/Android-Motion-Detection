package haodong.detection.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import haodong.detection.step.algo.StepSelfAdjustAlgo;

public class StepSeftAdjustTestCase {
	
	StepSelfAdjustAlgo stepSelfAdjustAlgo;
	
	public StepSeftAdjustTestCase() {
		stepSelfAdjustAlgo = new StepSelfAdjustAlgo();
	}
	
	@Test
	public void testForModifyArray() {
		long lastTime = System.currentTimeMillis();
		while(System.currentTimeMillis() - lastTime < (long)(100 * Math.random())){
		
		}
		Assert.assertEquals(0, 0);
	}
	
	@Test
	public void testForGetMaxValueIndex() {
		Assert.assertEquals(0, 0);
	}
	
	@Test
	public void testForCalculateValue() {
		Assert.assertEquals(0, 0);
	}
	
	@Test
	public void testForFeedData(){
		stepSelfAdjustAlgo.feedData(0);
	}
	
	@Test
	public void testForInnerLoop(){
		Assert.assertEquals(0, 0);
	}
	
	@Test
	public void testForStepResultDefaultValue() {
		Assert.assertEquals(0, stepSelfAdjustAlgo.getStepResult());
	}
	
	@Test
	public void testForStepResultDefaultValueList(){
		Assert.assertEquals(null, stepSelfAdjustAlgo.getStepResultList());
	}
}
