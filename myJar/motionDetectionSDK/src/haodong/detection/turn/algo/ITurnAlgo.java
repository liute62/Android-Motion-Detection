package haodong.detection.turn.algo;

import java.util.ArrayList;

import haodong.model.sensor.AccelerationSensor;
import haodong.model.sensor.GyroscopeSensor;

public interface ITurnAlgo {

	public void feedData(ArrayList<AccelerationSensor> accs,ArrayList<GyroscopeSensor> gyro,ArrayList<Long> ts);
}
