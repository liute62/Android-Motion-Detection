package haodong.detection.step;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import haodong.main.OnDebugListener;
import haodong.main.SensorDataListener;
import haodong.model.sensor.AccelerationSensor;

public class StepAlgoManager {

	protected StepAlgoListener listener = null;
	
	private StepAlgoListener listenerInner = null;
	
	private SensorDataListener sensorDataListener = null;
	
	private SensorDataListener sensorDataListenerInner = null;
	
	protected OnDebugListener onDebugListener = null;
	
	private OnDebugListener onDebugListenerInner = null;
		
	public static final int TYPE_ALGO_PEAK = 0;
	
	public static final int TYPE_ALGO_SELF_ADJUST = 1;
	
	public static final int TYPE_ALGO_BONUS = 2;
	
	public static final int TYPE_ALGO_FILTER = 3;
	
	private boolean isPause = false;
	
	private boolean isStop = true;
		
	private StepAlgoProcessor processor;
	
	private AccelerationSensor sensor;
	
	private Context mContext;
	
	private SensorManager sensorManager;
	
	private Sensor accSensor;
	
	private SensorEventListener sensorEventListener;
		
	private int sensorRate = SensorManager.SENSOR_DELAY_GAME;
	
	public StepAlgoManager(Context context){
		processor = new StepAlgoProcessor(this);
		mContext = context;
		initInner();
		initSensorService();
	}
	
	public StepAlgoManager(){
		processor = new StepAlgoProcessor(this);
		initInner();
	}
	
	private void initInner(){
		listenerInner = new StepAlgoListener() {
			@Override
			public void onStepResult(int algoType, int stepNum) {				
			}
		};
		sensorDataListenerInner = new SensorDataListener() {
			@Override
			public void onSensorReading(SensorEvent sensorEvent) {				
			}
		};
		onDebugListenerInner = new OnDebugListener() {

			@Override
			public void printValues(String TAG, String funcName, String str) {				
			}
		};
		sensor = new AccelerationSensor();
		sensorDataListener = sensorDataListenerInner;
		listener = listenerInner;
		onDebugListener = onDebugListenerInner;
	}
	
	private void initSensorService(){
		sensorManager = (SensorManager)mContext.getSystemService(Context.SENSOR_SERVICE);
		accSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		sensorEventListener = new SensorEventListener() {
			
			@Override
			public void onSensorChanged(SensorEvent arg0) {
				sensorDataListener.onSensorReading(arg0);
				sensor = new AccelerationSensor(arg0.values[0],arg0.values[1],arg0.values[2]);
				processor.feedData(sensor);
			}
			
			@Override
			public void onAccuracyChanged(Sensor arg0, int arg1) {
				
			}
		};
	}
	
	private void startSensorService(){
		sensorManager.registerListener(sensorEventListener, accSensor,sensorRate);
	}
	
	private void stopSensorService(){
		sensorManager.unregisterListener(sensorEventListener);
	}
	
	public void start(){
		isPause = false;
		isStop = false;
		startSensorService();
	}
	
	public void pause(){
		isPause = true;
	}
	
	public void stop(){
		isStop = true;
		stopSensorService();
		processor.reset();
	}

	public StepAlgoListener getListener() {
		if(this.listener == listenerInner) return null;
		return listener;
	}

	public void setListener(StepAlgoListener l) {
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
	
	public void registerDebugListener(OnDebugListener l){
		if(l == null) this.onDebugListener = onDebugListenerInner;
		this.onDebugListener = l;
	}

	public boolean isStop() {
		return isStop;
	}

	public boolean isPause() {
		return isPause;
	}
}
