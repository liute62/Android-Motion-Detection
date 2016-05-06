package sensor;

/**
 * Created by liuhaodong1 on 16/4/28.
 */
public class AccelerationSensor {

    private float acc_x;

    private float acc_y;

    private float acc_z;

    private float acc_total;

    public AccelerationSensor(){
        acc_x = 0;
        acc_y = 0;
        acc_z = 0;
        acc_total = 0;
    }

    public AccelerationSensor(float x,float y,float z){
        acc_x = -x / 9.80665f;
        acc_y = -y / 9.80665f;
        acc_z = z / 9.80665f;
        acc_total = (float)Math.sqrt(acc_x * acc_x + acc_y * acc_y+ acc_z * acc_z);
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

    public float getAcc_total() {
        return acc_total;
    }

    public void setAcc_total(float acc_total) {
        this.acc_total = acc_total;
    }
}
