package haodong.detection.turn;

import java.util.ArrayList;

import haodong.detection.turn.algo.ITurnAlgo;
import haodong.model.sensor.AccelerationSensor;
import haodong.model.sensor.GyroscopeSensor;

public class TurnAlgoProcessor implements ITurnAlgo{

	@Override
	public void feedData(ArrayList<AccelerationSensor> accs, ArrayList<GyroscopeSensor> gyro, ArrayList<Long> ts) {
		
	}

}
