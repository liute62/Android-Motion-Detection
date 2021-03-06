package haodong.detection.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import haodong.detection.step.algo.StepPeakAlgo;

public class StepPeakTestCase {
	
	public StepPeakAlgo stepPeakAlgo;
	
	public StepPeakTestCase() {
		stepPeakAlgo = new StepPeakAlgo();
	}
	
	@Test
	public void testForStepResultDefaultValue() {
		Assert.assertEquals(0, stepPeakAlgo.getStepResult());
	}
	
	@Test
	public void testForStepResultDefaultList(){
		Assert.assertEquals(null, stepPeakAlgo.getStepResultList());
	}
	
	@Test
	public void testForFeedData(){
		stepPeakAlgo.feedData(0);
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
		for (int i = 0; i < 17100000; i++) {
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
