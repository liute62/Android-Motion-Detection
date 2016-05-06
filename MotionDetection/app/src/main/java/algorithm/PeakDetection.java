package algorithm;

import java.util.ArrayList;
import java.util.List;

import sensor.AccelerationSensor;

/**
 * Created by liuhaodong1 on 16/4/28.
 */
public class PeakDetection {

    private int stepTotal = 0;

    private float peakThreshold = 1.4f;

    private float peakInterval = 1.5f;

    private AccelerationSensor lastSensor;

    private long lastTime = 0;

    private List<AccelerationSensor> accelerationlist;

    public PeakDetection(){
        stepTotal = 0;
        accelerationlist = new ArrayList<>();
        lastSensor = new AccelerationSensor();
    }

    public void feedData(AccelerationSensor sensor){
        accelerationlist.add(sensor);
    }

    public int getCurrentStep(){
        if(accelerationlist.size() > 0){
            AccelerationSensor sensor = accelerationlist.remove(accelerationlist.size() - 1);
            lastSensor = sensor;
            if(sensor.getAcc_total() > peakThreshold){
                if(System.currentTimeMillis() - lastTime > peakInterval * 1000) {
                    lastTime = System.currentTimeMillis();
                    stepTotal++;
                }
            }
        }
        return stepTotal;
    }

    public AccelerationSensor getLastSensor(){
        return lastSensor;
    }

}
