package haodong.detection.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import haodong.detection.step.algo.StepFilterAlgo;

public class StepFilterTestCase {
	
	StepFilterAlgo stepFilterAlgo;
		
	public StepFilterTestCase() {
		stepFilterAlgo = new StepFilterAlgo();
	}
	
	@Test
	public void testForStepResultDefaultValue() {
		Assert.assertEquals(0, stepFilterAlgo.getStepResult());
	}
	
	@Test
	public void testForStepResultDefaultList(){
		ArrayList<Integer> tmp = stepFilterAlgo.getStepResultList();
		Assert.assertEquals((Integer)0, (Integer)tmp.get(tmp.size() - 1));
	}
	
	@Test
	public void testForFeedData(){
		stepFilterAlgo.feedData(0);
	}
	
	@Test
	public void a(){
		for (int i = 0; i < 100000; i++) {
			i++;
		}
		Assert.assertEquals(0, 0);
	}
	
	@Test
	public void b(){
		for (int i = 0; i < 100000; i++) {
			i++;
		}
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
