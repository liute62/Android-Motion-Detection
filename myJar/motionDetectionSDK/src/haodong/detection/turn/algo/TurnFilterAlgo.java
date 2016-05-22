package haodong.detection.turn.algo;

import java.util.ArrayList;

import haodong.model.sensor.AccelerationSensor;
import haodong.model.sensor.GyroscopeSensor;

public class TurnFilterAlgo implements ITurnAlgo{
	
	public final int windowsize = 5;
	
	public final int windowStepNum = 2;
	
	public final int turnDegree = 40;
	
	

	public TurnFilterAlgo(){
		
	}



	@Override
	public void feedData(ArrayList<AccelerationSensor> accs, ArrayList<GyroscopeSensor> gyro, ArrayList<Long> ts) {
		
	}
}
