package haodong.detection.level;

import java.util.ArrayList;

import haodong.detection.level.algo.ILevelAlgo;
import haodong.model.sensor.BarometerSensor;

public class LevelAlgoProcessor implements ILevelAlgo {

	LevelAlgoManager levelAlgoManager;
	
	public LevelAlgoProcessor(LevelAlgoManager manager){
		levelAlgoManager = manager;
	}
	
	@Override
	public void feedData(ArrayList<BarometerSensor> baroArray, ArrayList<Long> Ts) {
		
	}

	@Override
	public void feedData(float pressure) {
		
	}

}
