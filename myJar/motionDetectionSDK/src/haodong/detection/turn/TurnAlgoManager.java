package haodong.detection.turn;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import haodong.detection.step.StepAlgoManager;
import haodong.main.SensorDataListener;
import haodong.model.sensor.AccelerationSensor;
import haodong.model.sensor.GyroscopeSensor;

public class TurnAlgoManager {
	
	protected TurnAlgoListener listener = null;
	
	protected TurnAlgoListener listenerInner;
	
	private SensorDataListener sensorDataListenerInner = null;
	
	public static final int TYPE_ALGO_FILTER = 3;
	
	private boolean isPause = false;
	
	private boolean isStop = true;
	
	private TurnAlgoProcessor processor;
	
	private StepAlgoManager stepAlgoManager;
	
	private AccelerationSensor accSensor;

	private GyroscopeSensor gyroscopeSensor;

	private Context mContext;
	
	private SensorManager sensorManager;
	
	private Sensor accSensorAndroid;
	
	private Sensor gyroSensorAndroid;
	
	private SensorEventListener sensorEventListener;
	
	private SensorDataListener sensorDataListener;
	
	private int sensorRate = SensorManager.SENSOR_DELAY_GAME;

	public TurnAlgoManager(){
		
	}
	

	private void startSensorService(){
		sensorManager.registerListener(sensorEventListener, accSensorAndroid,sensorRate);
		sensorManager.registerListener(sensorEventListener, gyroSensorAndroid,sensorRate);
	}
	
	private void stopSensorService(){
		sensorManager.unregisterListener(sensorEventListener);
	}
	
	public void start(){
		isPause = false;
		isStop = false;
		startSensorService();
		//processor.feedData(accSensor);
	}
	
	public void pause(){
		isPause = true;
	}
	
	public void stop(){
		isStop = true;
		stopSensorService();
	}
	
	public TurnAlgoListener getListener() {
		if(this.listener == listenerInner) return null;
		return listener;
	}

	public void setListener(TurnAlgoListener l) {
		if(l == null) this.listener = listenerInner;
		else this.listener = l;
	}
	
	public void registerSensorDataListener(SensorDataListener l){
		if(l == null) this.sensorDataListener = sensorDataListenerInner;
		else this.sensorDataListener = l;
	}
	
	public void unregisterSensorDataListner(){
		this.sensorDataListener = sensorDataListenerInner;
	}

	public boolean isStop() {
		return isStop;
	}

	public boolean isPause() {
		return isPause;
	}
}
