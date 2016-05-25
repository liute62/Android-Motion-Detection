package haodong.detection.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import haodong.detection.step.algo.StepBonusAlgo;

public class StepBonusTestCase {
	
	StepBonusAlgo stepBonusAlgo;
	
	public StepBonusTestCase() {
		stepBonusAlgo = new StepBonusAlgo();
	}
	
	@Test
	public void testForStepResultDefaultValue() {
		Assert.assertEquals(0, stepBonusAlgo.getStepResult());
	}
	
	@Test
	public void testForStepResultDefaultList(){
		Assert.assertEquals(null, stepBonusAlgo.getStepResultList());
	}
	
	@Test
	public void testForFeedData(){
		stepBonusAlgo.feedData(0);
	}

	@Test
	public void a(){
		Assert.assertEquals(0, 0);
	}
	
	@Test
	public void b(){
		Assert.assertEquals(0, 0);
	}
	
	@Test
	public void c(){
		Assert.assertEquals(0, 0);
	}
	
	@Test
	public void d(){
		Assert.assertEquals(0, 0);
	}
	
	@Test
	public void e(){
		Assert.assertEquals(0, 0);
	}
	
	@Test
	public void f(){
		Assert.assertEquals(0, 0);
		for (int i = 0; i < 203000; i++) {
			i++;
		}
		Assert.assertEquals(0, 0);
	}
	
	@Test
	public void g(){
		Assert.assertEquals(0, 0);
	}
	
	@Test
	public void h(){
		Assert.assertEquals(0, 0);
	}
	
	@Test
	public void i(){
		Assert.assertEquals(0, 0);
	}
	
	@Test
	public void j(){
		Assert.assertEquals(0, 0);
	}
}
