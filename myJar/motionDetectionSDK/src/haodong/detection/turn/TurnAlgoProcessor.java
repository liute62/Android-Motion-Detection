package haodong.detection.turn;

import java.util.ArrayList;

import haodong.detection.turn.algo.ITurnAlgo;
import haodong.model.sensor.AccelerationSensor;
import haodong.model.sensor.GyroscopeSensor;

public class TurnAlgoProcessor implements ITurnAlgo{

	
	private int ws = 5;
	
	private int wsStep = 2;
	
	private int threDegree = 80;
	
	private ArrayList<AccelerationSensor> accList;
	
	private ArrayList<GyroscopeSensor> gyroList;
	
	@Override
	public void feedData(ArrayList<AccelerationSensor> accs, ArrayList<GyroscopeSensor> gyro, ArrayList<Long> ts) {
		
	}
	
	private void turnDetection(){
		float[] accSmooth = new float[3];
		
	}

}
