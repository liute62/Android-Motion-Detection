package haodong.model.sensor;

import haodong.utils.MathUtil;

public class GyroscopeSensor extends BaseSensor {

	private static final long serialVersionUID = -9093149763947736249L;

	private float[] gyroValues;

	private float gyroX;

	private float gyroY;

	private float gyroZ;

	public GyroscopeSensor() {
		this.setGyroX(0);
		this.setGyroY(0);
		this.setGyroZ(0);
		gyroValues = new float[3];
		gyroValues[0] = 0;
		gyroValues[1] = 0;
		gyroValues[2] = 0;
	}

	public GyroscopeSensor(float x, float y, float z) {
		this.setGyroX(x);
		this.setGyroY(y);
		this.setGyroZ(z);
		gyroValues = new float[3];
		gyroValues[0] = x;
		gyroValues[1] = y;
		gyroValues[2] = z;
	}

	public GyroscopeSensor(float x, float y, float z, boolean toDegree) {
		if (toDegree) {
			x = (float) MathUtil.radiusToDegree(x);
			y = (float) MathUtil.radiusToDegree(y);
			z = (float) MathUtil.radiusToDegree(z);
			this.setGyroX(x);
			this.setGyroY(y);
			this.setGyroZ(z);
			gyroValues = new float[3];
			gyroValues[0] = x;
			gyroValues[1] = y;
			gyroValues[2] = z;
		} else {
			this.setGyroX(x);
			this.setGyroY(y);
			this.setGyroZ(z);
			gyroValues = new float[3];
			gyroValues[0] = x;
			gyroValues[1] = y;
			gyroValues[2] = z;
		}
	}

	public float getGyroX() {
		return gyroX;
	}

	public void setGyroX(float gyroX) {
		this.gyroX = gyroX;
	}

	public float getGyroY() {
		return gyroY;
	}

	public void setGyroY(float gyroY) {
		this.gyroY = gyroY;
	}

	public float getGyroZ() {
		return gyroZ;
	}

	public void setGyroZ(float gyroZ) {
		this.gyroZ = gyroZ;
	}
}
