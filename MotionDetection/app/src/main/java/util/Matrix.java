package util;

import android.util.Log;

/**
 * Created by liuhaodong1 on 16/5/13.
 */
public class Matrix<E> {

    private int rowNum = 0;

    private int colNum = 0;

    private Object[][] array;

    public Matrix(int rowNum, int colNum){
        this.rowNum = rowNum;
        this.colNum = colNum;
        array = new Object[rowNum][colNum];
    }

    public void setValue(int rowIndex,int colIndex,E value){
        array[rowIndex-1][colIndex-1] = value;
    }

    public E getValue(int rowIndex,int colIndex){
        return (E) array[rowIndex-1][colIndex-1];
    }

    public void transform(){
        int tmp = rowNum;
        rowNum = colNum;
        colNum = tmp;
        Object [][] a = new Object[rowNum][colNum];

        for(int i = 0; i != rowNum; i++){
            for(int j = 0; j != colNum; j++){
                a[i][j] = array[j][i];
            }
        }
        array = a;
    }

    public static Matrix<Float> multiply(Matrix<Float> a, Matrix<Float> b){
        Matrix<Float> matrix = new Matrix<>(a.rowNum,b.colNum);
        Float sum = 0.0f;
        int i;
        int j;
        int k;
        for (i = 0; i != a.rowNum; i++) {
            for (j = 0; j != b.colNum; j++) {
                for (k = 0; k != a.colNum; k++) {
                    sum += (Float) a.array[i][k] * (Float) b.array[k][j];
                }
                matrix.setValue(i+1,j+1,sum);
            }
        }
        return matrix;
    }

    public void print(){
        for(int i = 0; i != rowNum; i++){
            for(int j = 0; j != colNum; j++){
                Log.e("Matrix "+(i+1)+" "+(j+1),String.valueOf(array[i][j]));
            }
        }
    }
}
