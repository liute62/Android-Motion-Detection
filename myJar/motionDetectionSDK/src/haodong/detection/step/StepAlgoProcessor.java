package haodong.detection.step;

import haodong.detection.step.algo.StepBonusAlgo;
import haodong.detection.step.algo.StepPeakAlgo;
import haodong.detection.step.algo.StepSelfAdjustAlgo;
import haodong.model.sensor.AccelerationSensor;

class StepAlgoProcessor {

	private StepPeakAlgo stepPeakAlgo;
	
	private StepSelfAdjustAlgo stepSelfAdjustAlgo;
	
	private StepBonusAlgo stepBonusAlgo;
	
	private AccelerationSensor dataSensor;
		
	private StepAlgoManager stepAlgoManager;
	
	protected StepAlgoProcessor(StepAlgoManager manager){
		stepAlgoManager = manager;
		init();
	}
	
	private void init(){
		stepPeakAlgo = new StepPeakAlgo();
		stepSelfAdjustAlgo = new StepSelfAdjustAlgo();
		stepBonusAlgo = new StepBonusAlgo();
	}
	
	protected void feedData(AccelerationSensor accelerationSensor){
		dataSensor = accelerationSensor;
		stepPeakAlgo.feedData(dataSensor.getAccTotal());
		stepSelfAdjustAlgo.feedData(dataSensor.getAccTotal());
		stepBonusAlgo.feedData(dataSensor.getAccTotal());
		outputResult();
	}
	
	private void outputResult(){
		stepAlgoManager.listener.onStepResult(StepAlgoManager.TYPE_ALGO_PEAK,stepPeakAlgo.getStepResult());
		stepAlgoManager.listener.onStepResult(StepAlgoManager.TYPE_ALGO_SELF_ADJUST,stepSelfAdjustAlgo.getStepResult());
		stepAlgoManager.listener.onStepResult(StepAlgoManager.TYPE_ALGO_BONUS, stepBonusAlgo.getStepResult());
	}
}
