package haodong.motiondetection;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import algorithm.CoorTransform;
import algorithm.PeakDetection;
import haodong.detection.step.StepAlgoListener;
import haodong.detection.step.StepAlgoManager;
import haodong.model.sensor.SensorDataListener;
import sensor.AccelerationSensor;

/**
 * Created by liuhaodong1 on 16/4/28.
 * The fragment for step's peak detection algorithm
 */
public class DemoFragment extends Fragment implements StepAlgoListener,SensorDataListener {


    public static final String TAG = "PeakAlgoFragment";

    private Context mContext;

    private Button mStart;

    private Button mStop;

    private TextView mAccX,mAccY,mAccZ,mAccTotal;

    private TextView mStepTotal;

    private StepAlgoManager stepAlgoManager;

    public static DemoFragment newInstance() {
        DemoFragment fragment = new DemoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stepAlgoManager = new StepAlgoManager(getContext());
        stepAlgoManager.setListener(this);
        stepAlgoManager.registerSensorDataListener(this);
        stepAlgoManager.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_main, container, false);
        return rootView;
    }

    @Override
    public void onStepResult(int i, int i1) {
        Log.e(TAG,"i "+i+" i1"+i1);
    }

    @Override
    public void onSensorReading(SensorEvent sensorEvent) {
        Log.e(TAG," sensor "+sensorEvent.values[0]+" "+sensorEvent.values[1]+" "+sensorEvent.values[2]);
    }

    @Override
    public void onDestroy() {
        if(!stepAlgoManager.isStop()) stepAlgoManager.stop();
        super.onDestroy();
    }
}
