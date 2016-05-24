package haodong.utils;

import haodong.utils.MathUtil.Matrix;

public class CoorTransform {

	public static final String TAG = "CoorTransform";

	private float acc_phone_x;

	private float acc_phone_y;

	private float acc_phone_z;

	private float acc_global_x;

	private float acc_global_y;

	private float acc_global_z;

	private float orien_x;

	private float orien_y;

	private float orien_z;

	private Matrix<Float> matrixInner;

	private Matrix<Float> matrixAccPhone;

	private Matrix<Float> matrixAccGlobal;

	public CoorTransform(float x, float y, float z, float orien_x, float orien_y, float orien_z) {
		acc_phone_x = x;
		acc_phone_y = y;
		acc_phone_z = z;
		this.orien_x = orien_x;
		this.orien_y = orien_y;
		this.orien_z = orien_z;
	}

	private void createMatrix() {

		float m11 = (float) (Math.cos(orien_z) * Math.cos(orien_y)
				- Math.sin(orien_z) * Math.sin(orien_x) * Math.sin(orien_y));
		float m12 = (float) (Math.sin(orien_z) * Math.cos(orien_y)
				+ Math.cos(orien_z) * Math.sin(orien_x) * Math.sin(orien_z));
		float m13 = (float) (-Math.cos(orien_x) * Math.sin(orien_y));
		float m21 = (float) (-Math.sin(orien_z) * Math.cos(orien_x));
		float m22 = (float) (Math.cos(orien_z) * Math.cos(orien_x));
		float m23 = (float) (Math.sin(orien_x));
		float m31 = (float) (Math.cos(orien_z) * Math.sin(orien_y)
				+ Math.sin(orien_z) * Math.sin(orien_x) * Math.cos(orien_y));
		float m32 = (float) (Math.sin(orien_z) * Math.sin(orien_y)
				- Math.cos(orien_z) * Math.sin(orien_x) * Math.cos(orien_y));
		float m33 = (float) (Math.cos(orien_x) * Math.cos(orien_y));

		matrixInner = new Matrix<>(3, 3);
		matrixInner.setValue(1, 1, m11);
		matrixInner.setValue(1, 2, m12);
		matrixInner.setValue(1, 3, m13);
		matrixInner.setValue(2, 1, m21);
		matrixInner.setValue(2, 2, m22);
		matrixInner.setValue(2, 3, m23);
		matrixInner.setValue(3, 1, m31);
		matrixInner.setValue(3, 2, m32);
		matrixInner.setValue(3, 3, m33);

		matrixInner.transform();
	}

	public void transformWithoutGravity() {
		acc_global_x = -acc_phone_x / 9.80665f;
		acc_global_y = -acc_phone_x / 9.80665f;
		acc_global_z = acc_phone_x / 9.80665f;
	}

	public void transformToLocal() {
		createMatrix();
		matrixAccPhone = new Matrix<>(3, 1);
		matrixAccPhone.setValue(1, 1, acc_phone_x);
		matrixAccPhone.setValue(2, 1, acc_phone_y);
		matrixAccPhone.setValue(3, 1, acc_phone_z);
		matrixAccGlobal = Matrix.multiply(matrixInner, matrixAccPhone);
	}

	public float getAcc_phone_x() {
		return acc_phone_x;
	}

	public void setAcc_phone_x(float acc_phone_x) {
		this.acc_phone_x = acc_phone_x;
	}

	public float getAcc_phone_y() {
		return acc_phone_y;
	}

	public void setAcc_phone_y(float acc_phone_y) {
		this.acc_phone_y = acc_phone_y;
	}

	public float getAcc_phone_z() {
		return acc_phone_z;
	}

	public void setAcc_phone_z(float acc_phone_z) {
		this.acc_phone_z = acc_phone_z;
	}

	public float getAcc_global_x() {
		return acc_global_x;
	}

	public void setAcc_global_x(float acc_global_x) {
		this.acc_global_x = acc_global_x;
	}

	public float getAcc_global_y() {
		return acc_global_y;
	}

	public void setAcc_global_y(float acc_global_y) {
		this.acc_global_y = acc_global_y;
	}

	public float getAcc_global_z() {
		return acc_global_z;
	}

	public void setAcc_global_z(float acc_global_z) {
		this.acc_global_z = acc_global_z;
	}

	public Matrix<Float> getMatrixAccPhone() {
		return matrixAccPhone;
	}

	public void setMatrixAccPhone(Matrix<Float> matrixAccPhone) {
		this.matrixAccPhone = matrixAccPhone;
	}

}
