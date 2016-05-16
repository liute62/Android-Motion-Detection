package haodong.model.sensor;

import android.hardware.SensorEvent;

public interface SensorDataListener {

	void onSensorReading(SensorEvent sensorEvent);
}
