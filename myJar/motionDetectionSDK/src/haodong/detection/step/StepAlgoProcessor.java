package haodong.detection.step;

import haodong.detection.step.algo.StepBonusAlgo;
import haodong.detection.step.algo.StepFilterAlgo;
import haodong.detection.step.algo.StepPeakAlgo;
import haodong.detection.step.algo.StepSelfAdjustAlgo;
import haodong.model.sensor.AccelerationSensor;

class StepAlgoProcessor {

	private StepPeakAlgo stepPeakAlgo;
	
	private StepSelfAdjustAlgo stepSelfAdjustAlgo;
	
	private StepBonusAlgo stepBonusAlgo;
	
	private StepFilterAlgo stepFilterAlgo;
	
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
		stepFilterAlgo = new StepFilterAlgo();
	}
	
	protected void feedData(AccelerationSensor accelerationSensor){
		dataSensor = accelerationSensor;
		stepPeakAlgo.feedData(dataSensor.getAccTotal());
		stepSelfAdjustAlgo.feedData(dataSensor.getAccTotal());
		stepBonusAlgo.feedData(dataSensor.getAccTotal());
		stepFilterAlgo.feedData(dataSensor.getAcc_total_trans());
		stepAlgoManager.onDebugListener.printValues("acc_total_trans "+dataSensor.getAcc_total_trans());
		outputResult();
	}
	
	protected void reset(){
		stepFilterAlgo.reset();
	}
	
	private void outputResult(){
		stepAlgoManager.listener.onStepResult(StepAlgoManager.TYPE_ALGO_PEAK,stepPeakAlgo.getStepResult());
		stepAlgoManager.listener.onStepResult(StepAlgoManager.TYPE_ALGO_SELF_ADJUST,stepSelfAdjustAlgo.getStepResult());
		stepAlgoManager.listener.onStepResult(StepAlgoManager.TYPE_ALGO_BONUS, stepBonusAlgo.getStepResult());
		stepAlgoManager.listener.onStepResult(StepAlgoManager.TYPE_ALGO_FILTER, stepFilterAlgo.getStepResult());
		stepAlgoManager.onDebugListener.printValues("acc_all"+stepFilterAlgo.getStepResultList());
	}
}
