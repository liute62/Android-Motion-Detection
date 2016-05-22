package haodong.stepapp;

import android.app.Activity;
import android.hardware.SensorEvent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import haodong.detection.step.StepAlgoListener;
import haodong.detection.step.StepAlgoManager;
import haodong.main.OnDebugListener;
import haodong.main.SensorDataListener;

/**
 * Created by liuhaodong1 on 16/5/22.
 */
public class PlaceholderFragment extends Fragment implements StepAlgoListener,SensorDataListener {

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_DATE = "section_date";

    TextView mStep;

    TextView mIsStart;

    FloatingActionButton mAction;

    boolean isStart = false;

    StepAlgoManager stepAlgoManager;

    Activity mActivity;

    public  PlaceholderFragment(){

    }

    public PlaceholderFragment(Activity activity) {
        this.mActivity = activity;
    }

    Handler UIHandler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(String date, Activity activity) {
        PlaceholderFragment fragment = new PlaceholderFragment(activity);
        Bundle args = new Bundle();
        args.putString(ARG_SECTION_DATE, date);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stepAlgoManager = new StepAlgoManager(getContext());
        stepAlgoManager.setListener(this);
        stepAlgoManager.registerSensorDataListener(this);
        mAction = (FloatingActionButton)mActivity.findViewById(R.id.main_fab);
        mIsStart = (TextView)getActivity().findViewById(R.id.main_is_start);
        mAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isStart) {
                    isStart = true;
                    stepAlgoManager.start();
                    mIsStart.setText("已启动");
                }else {
                    isStart = false;
                    stepAlgoManager.stop();
                    mIsStart.setText("已停止");
                }
            }
        });
        stepAlgoManager.registerDebugListener(new OnDebugListener() {
            @Override
            public void printValues(String s) {
                //Log.e("debug",s);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        TextView mDate = (TextView) rootView.findViewById(R.id.main_fragment_date);
        mDate.setText(getArguments().getString(ARG_SECTION_DATE));
        mStep = (TextView)rootView.findViewById(R.id.main_fragment_step);
        return rootView;
    }

    @Override
    public void onStepResult(int i, int i1) {
        if(i == StepAlgoManager.TYPE_ALGO_FILTER){
            Log.e("ss",String.valueOf(i1));
            mStep.setText(String.valueOf(i1));
        }
    }

    @Override
    public void onSensorReading(SensorEvent sensorEvent) {
      //  Log.e("tag",sensorEvent.values[0]+" "+sensorEvent.values[1]+" "+sensorEvent.values[2]);
    }
}
