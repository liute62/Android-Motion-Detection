package haodong.main;

import android.content.Context;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;

public abstract class AlgoManager {
	
	protected boolean isPause = false;
	
	protected boolean isStop = true;
	
	protected Context mContext;
	
	protected SensorManager sensorManager;
			
	protected int sensorRate = SensorManager.SENSOR_DELAY_GAME;
	
	protected DetectionConfig detectionConfig = null;
	
	protected SensorDataListener sensorDataListener = null;
	
	protected SensorDataListener sensorDataListenerInner = null;
	
	public void setParamsBeforeCreate(){
		
	}
	
	public void onCreate(){
		setParamsBeforeCreate();
		initInner();
		initSensorService();
	}
	
	public void initInner(){
		sensorDataListenerInner = new SensorDataListener() {
			
			@Override
			public void onSensorReading(SensorEvent sensorEvent) {
				
			}
		};
	}
	
	public abstract void initSensorService();

	public void start(){
		isPause = false;
		isStop = false;
		startSensorService();
	}
	
	public void checkOutParams(){
		
	}
	
	public abstract void pause();
	
	public void stop(){
		isPause = false;
		isStop = true;
		stopSensorService();
	}
	
	public abstract void startSensorService();
	
	public abstract void stopSensorService();
	
	public abstract void registerSensorDataListener(SensorDataListener l);
	
	public abstract void unregisterSensorDataListner();
	
	public void setDetectionConfig(DetectionConfig config){
		this.detectionConfig = config;
	}
}
