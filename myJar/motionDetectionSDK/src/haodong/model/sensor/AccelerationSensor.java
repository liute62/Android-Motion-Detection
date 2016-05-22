package haodong.model.sensor;

public class AccelerationSensor extends BaseSensor{

	private static final long serialVersionUID = -5617566392574758822L;
	
	private float acc_x;
	
	private float acc_y;
	
	private float acc_z;
	
	private float acc_total;
	
	private float acc_total_trans;
	
	public AccelerationSensor(){
		
	}
	
	public AccelerationSensor(float x, float y, float z){
		this.setAcc_x(x);
		this.setAcc_y(y);
		this.setAcc_z(z);
		acc_total = (float)Math.sqrt(x * x + y * y + z * z);
		float x2 = - x / 9.80665f;
		float y2 = -y / 9.80665f;
		float z2 = z / 9.80665f;
		acc_total_trans = (float)Math.sqrt(x2 * x2 + y2 * y2 + z2 * z2);
	}

	public float getAccTotal() {
		return acc_total;
	}

	public void setAccTotal(float acc_total) {
		this.acc_total = acc_total;
	}

	public float getAcc_x() {
		return acc_x;
	}

	public void setAcc_x(float acc_x) {
		this.acc_x = acc_x;
	}

	public float getAcc_y() {
		return acc_y;
	}

	public void setAcc_y(float acc_y) {
		this.acc_y = acc_y;
	}

	public float getAcc_z() {
		return acc_z;
	}

	public void setAcc_z(float acc_z) {
		this.acc_z = acc_z;
	}

	public float getAcc_total_trans() {
		return acc_total_trans;
	}

	public void setAcc_total_trans(float acc_total_trans) {
		this.acc_total_trans = acc_total_trans;
	}

}
