package haodong.detection.level.algo;

import java.util.ArrayList;

import haodong.model.sensor.BarometerSensor;

public interface ILevelAlgo {

	public void feedData(ArrayList<BarometerSensor> baroArray,ArrayList<Long> Ts);
}
