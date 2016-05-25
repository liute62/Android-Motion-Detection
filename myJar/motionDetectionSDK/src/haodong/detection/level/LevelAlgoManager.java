package haodong.detection.level;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import haodong.main.AlgoManager;
import haodong.main.SensorDataListener;
import haodong.model.sensor.BarometerSensor;

public class LevelAlgoManager extends AlgoManager {

	protected LevelAlgoListener levelAlgoListener = null;
	
	private LevelAlgoProcessor processor;
	
	private Context mContext;
		
	private Sensor sensor;
	
	private BarometerSensor baroSensor;
	
	private SensorEventListener sensorEventListener;
	
	public LevelAlgoManager(Context context){
		processor = new LevelAlgoProcessor(this);
		mContext = context;
		onCreate();
	}
	
	@Override
	public void initSensorService() {
		sensorManager = (SensorManager)mContext.getSystemService(Context.SENSOR_SERVICE);
		sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
		sensorEventListener = new SensorEventListener() {
			
			@Override
			public void onSensorChanged(SensorEvent arg0) {
				sensorDataListener.onSensorReading(arg0);
				baroSensor = new BarometerSensor(arg0.values[0]);
				processor.feedData(baroSensor.getPressure());
			}
			
			@Override
			public void onAccuracyChanged(Sensor arg0, int arg1) {
				
			}
		};
	}
	
	@Override
	public void startSensorService() {
		sensorManager.registerListener(sensorEventListener, sensor,sensorRate);		
	}

	@Override
	public void stopSensorService() {
		sensorManager.unregisterListener(sensorEventListener);
	}
	
	@Override
	public void start() {
		super.start();
	}
	
	@Override
	public void pause() {
		
	}
	
	@Override
	public void stop() {
		super.stop();
	}

	@Override
	public void registerSensorDataListener(SensorDataListener l) {
		if(l == null) sensorDataListener = sensorDataListenerInner;
		else sensorDataListener = l;
	}

	@Override
	public void unregisterSensorDataListner() {
		sensorDataListener = sensorDataListenerInner;
	}
}
