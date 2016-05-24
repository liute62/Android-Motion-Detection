package haodong.model.sensor;

public class BarometerSensor extends BaseSensor{

	private static final long serialVersionUID = -3046483654505477113L;
	
	private float pressure;

	public BarometerSensor(){
		
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}
}
