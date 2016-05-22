package haodong.detection.step.algo;

import java.util.ArrayList;

public class StepPeakAlgo implements IStepAlgo{

	private float peakThreshold = 1.2f;
	
	private float peakInterval = 1.5f; 
	
	private long lastTime = 0;
	
	private int stepTotal = 0;
	
	private float currentPeakResult = 0;
	
	public StepPeakAlgo(){
		
	}
	
	@Override
	public void feedData(float acc_total){
		currentPeakResult = acc_total;
	}
	
	@Override
	public int getStepResult(){
		if(System.currentTimeMillis() - lastTime > peakInterval * 1000){
			if(currentPeakResult > peakThreshold){
				lastTime = System.currentTimeMillis();
				stepTotal++;
				currentPeakResult = 0;
			}
		}
		return stepTotal;
	}

	public float getPeakInterval() {
		return peakInterval;
	}

	public void setPeakInterval(float peakInterval) {
		this.peakInterval = peakInterval;
	}

	public float getPeakThreshold() {
		return peakThreshold;
	}

	public void setPeakThreshold(float peakThreshold) {
		this.peakThreshold = peakThreshold;
	}

	@Override
	public ArrayList<Integer> getStepResultList() {
		return null;
	}
}
