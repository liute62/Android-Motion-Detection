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

import algorithm.PeakDetection;
import sensor.AccelerationSensor;

/**
 * Created by liuhaodong1 on 16/4/28.
 * The fragment for step's peak detection algorithm
 */
public class PeakAlgoFragment extends Fragment implements SensorEventListener{


    public static final String TAG = "PeakAlgoFragment";

    private PeakDetection peakDetection;

    private Context mContext;

    private SensorManager sensorManager;

    private Sensor acceleration;

    private final int sensorRate = SensorManager.SENSOR_DELAY_GAME;

    private boolean isStop;

    private Button mStart;

    private Button mStop;

    private TextView mAccX,mAccY,mAccZ,mAccTotal;

    private TextView mStepTotal;

    public static PeakAlgoFragment newInstance() {
        PeakAlgoFragment fragment = new PeakAlgoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    public void start(){
        if (!isStop) return;
        isStop = false;
        sensorManager.registerListener(this, acceleration, sensorRate);
        peakDetection = new PeakDetection();
    }

    public void stop(){
        if(isStop) return;
        isStop = true;
        sensorManager.unregisterListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_peak, container, false);
        mStart = (Button)rootView.findViewById(R.id.peak_start);
        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }
        });
        mStop = (Button)rootView.findViewById(R.id.peak_stop);
        mStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
            }
        });
        mAccX = (TextView)rootView.findViewById(R.id.peak_acc_x);
        mAccY = (TextView)rootView.findViewById(R.id.peak_acc_y);
        mAccZ = (TextView)rootView.findViewById(R.id.peak_acc_z);
        mAccTotal = (TextView)rootView.findViewById(R.id.peak_acc_total);
        mStepTotal = (TextView)rootView.findViewById(R.id.peak_step_total);
        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(!isStop) stop();
    }

    private void init(){
        isStop = true;
        mContext = getActivity();
        sensorManager = (SensorManager)mContext.getSystemService(Context.SENSOR_SERVICE);
        acceleration = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            peakDetection.feedData(new AccelerationSensor(event.values[0], event.values[1], event.values[2]));
            int step = peakDetection.getCurrentStep();
            mAccX.setText(String.valueOf(event.values[0]));
            mAccY.setText(String.valueOf(event.values[1]));
            mAccZ.setText(String.valueOf(event.values[2]));
            mAccTotal.setText(String.valueOf(peakDetection.getLastSensor().getAcc_total()));
            mStepTotal.setText(String.valueOf(peakDetection.getCurrentStep()));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
