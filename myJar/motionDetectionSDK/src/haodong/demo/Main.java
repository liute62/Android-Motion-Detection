package haodong.demo;

import haodong.detection.step.algo.StepBonusAlgo;
import haodong.detection.step.algo.StepFilterAlgo;
import haodong.detection.step.algo.StepPeakAlgo;
import haodong.detection.step.algo.StepSelfAdjustAlgo;

public class Main {

	public static void main(String[] args) {
	
		StepFilterAlgo stepFilterAlgo = new StepFilterAlgo();
		StepBonusAlgo stepBonusAlgo = new StepBonusAlgo();
		StepSelfAdjustAlgo stepSelfAdjustAlgo = new StepSelfAdjustAlgo();
		StepPeakAlgo stepPeakAlgo = new StepPeakAlgo();
		while(true){
			float result = (float)Math.random() + 1;
			stepBonusAlgo.feedData(result);
			stepFilterAlgo.feedData(result);
			stepSelfAdjustAlgo.feedData(result);
			stepPeakAlgo.feedData(result);
		}
	}
}
