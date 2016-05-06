package haodong.detection.step;

import haodong.detection.step.algo.StepBonusAlgo;
import haodong.detection.step.algo.StepPeakAlgo;
import haodong.detection.step.algo.StepSelfAdjustAlgo;
import haodong.model.sensor.AccelerationSensor;

public class StepAlgoManager {

	private StepAlgoListener listener = null;
	
	private StepAlgoListener listenerInner = null;
	
	private AccelerationSensor dataSensor;
	
	public static final int TYPE_ALGO_PEAK = 0;
	
	public static final int TYPE_ALGO_SELF_ADJUST = 1;
	
	public static final int TYPE_ALGO_BONUS = 2;
	
	private StepPeakAlgo stepPeakAlgo;
	
	private StepSelfAdjustAlgo stepSelfAdjustAlgo;
	
	private StepBonusAlgo stepBonusAlgo;
	
	public StepAlgoManager(){
		init();
	}
	
	private void init(){
		stepPeakAlgo = new StepPeakAlgo();
		listenerInner = new StepAlgoListener() {
			@Override
			public void onStepResult(int algoType, int stepNum) {				
			}
		};
	}
	
	public void feedData(AccelerationSensor accelerationSensor){
		dataSensor = accelerationSensor;
		stepPeakAlgo.feedData(dataSensor.getAccTotal());
		outputResult();
	}
	
	private void outputResult(){
		listener.onStepResult(TYPE_ALGO_PEAK,stepPeakAlgo.getStepResult());
		listener.onStepResult(TYPE_ALGO_SELF_ADJUST,stepSelfAdjustAlgo.getStepResult());
		listener.onStepResult(TYPE_ALGO_BONUS, stepBonusAlgo.getStepResult());
	}

	public StepAlgoListener getListener() {
		if(this.listener == listenerInner) return null;
		return listener;
	}

	public void setListener(StepAlgoListener l) {
		if(l == null) this.listener = listenerInner;
		else this.listener = l;
	}
}
