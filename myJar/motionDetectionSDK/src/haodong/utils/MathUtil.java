package haodong.utils;

import java.util.ArrayList;

public class MathUtil {
	
    public static double radiusToDegree(double radius) {
        return radius * (180 / 3.1415926);
    }

	public static float getMeanValue(ArrayList<Float> data) {

		if (data == null || data.size() == 0)
			return 0;

		float sum = 0;
		for (int i = 0; i != data.size(); i++) {
			sum += data.get(i);
		}
		return sum / data.size();
	}

	public static float getMeanValue(float[] data) {

		if (data == null || data.length == 0)
			return 0;

		float sum = 0;
		for (int i = 0; i != data.length; i++) {
			sum += data[i];
		}
		return sum / data.length;
	}

	public static float getNormalDeviationValue(ArrayList<Float> data) {
		if (data == null || data.size() == 0)
			return 0;

		float mean = getMeanValue(data);
		float sum = 0;
		for (int i = 0; i != data.size(); i++) {
			sum += (data.get(i) - mean) * (data.get(i) - mean);
		}
		float result = (float) Math.sqrt(sum / data.size());
		return result;
	}

	public static float getNormalDeviationValue(float[] data) {
		if (data == null || data.length == 0)
			return 0;

		float mean = getMeanValue(data);
		float sum = 0;
		for (int i = 0; i != data.length; i++) {
			sum += (data[i] - mean) * (data[i] - mean);
		}
		float result = (float) Math.sqrt(sum / data.length);
		return result;
	}

	public static class Matrix<E> {

		private int rowNum = 0;

		private int colNum = 0;

		private Object[][] array;

		public Matrix(int rowNum, int colNum) {
			this.rowNum = rowNum;
			this.colNum = colNum;
			array = new Object[rowNum][colNum];
		}

		public void setValue(int rowIndex, int colIndex, E value) {
			array[rowIndex - 1][colIndex - 1] = value;
		}

		@SuppressWarnings("unchecked")
		public E getValue(int rowIndex, int colIndex) {
			return (E) array[rowIndex - 1][colIndex - 1];
		}

		public void transform() {
			int tmp = rowNum;
			rowNum = colNum;
			colNum = tmp;
			Object[][] a = new Object[rowNum][colNum];

			for (int i = 0; i != rowNum; i++) {
				for (int j = 0; j != colNum; j++) {
					a[i][j] = array[j][i];
				}
			}
			array = a;
		}

		public static Matrix<Float> multiply(Matrix<Float> a, Matrix<Float> b) {
			Matrix<Float> matrix = new Matrix<>(a.rowNum, b.colNum);
			Float sum = 0.0f;
			int i;
			int j;
			int k;
			for (i = 0; i != a.rowNum; i++) {
				for (j = 0; j != b.colNum; j++) {
					for (k = 0; k != a.colNum; k++) {
						sum += (Float) a.array[i][k] * (Float) b.array[k][j];
					}
					matrix.setValue(i + 1, j + 1, sum);
				}
			}
			return matrix;
		}

		public void print() {
			for (int i = 0; i != rowNum; i++) {
				for (int j = 0; j != colNum; j++) {
				}
			}
		}
	}
}
