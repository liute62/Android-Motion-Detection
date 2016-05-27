package haodong.levelapp;

import android.hardware.SensorEvent;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

import haodong.detection.level.LevelAlgoManager;
import haodong.main.SensorDataFormat;
import haodong.main.SensorDataListener;
import haodong.utils.FileUtil;

public class MainActivity extends AppCompatActivity implements SensorDataListener{

    TextView mIsStart;

    TextView mStep;

    TextView mDirText;

    ImageView mDirImage;

    boolean isStart = false;

    String[] dirText = new String[]{"保持","上楼","下楼"};

    int[] dirImage = new int[]{R.drawable.stay,R.drawable.upstairs,R.drawable.downstairs};

    LevelAlgoManager levelAlgoManager;

    ArrayList<String> data = new ArrayList<>();

    ArrayList<Long> time = new ArrayList<>();

    long currentTime = 0;

    long lastTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isStart){
                    isStart = true;
                    mIsStart.setText("已停止");
                    mDirImage.setImageResource(dirImage[0]);
                    mDirText.setText(dirText[0]);
                    mStep.setText("114");
                    levelAlgoManager.start();

                }else {
                    isStart = false;
                    mIsStart.setText("已停止");
                    levelAlgoManager.stop();
                    SensorDataFormat sensorDataFormat = new SensorDataFormat();
                    String file = sensorDataFormat.listToString(time, data, " ");
                    FileUtil fileUtil = new FileUtil();
                    Log.e("path",Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator+"level.txt");
                    fileUtil.writeFileFromAbPath(Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator+"level.txt",file,false);
                }
            }
        });
        mIsStart = (TextView)findViewById(R.id.main_is_start);
        mDirImage = (ImageView)findViewById(R.id.main_level);
        mDirText = (TextView)findViewById(R.id.main_level_text);
        mStep = (TextView)findViewById(R.id.main_step);
        levelAlgoManager = new LevelAlgoManager(this);
        levelAlgoManager.registerSensorDataListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSensorReading(SensorEvent sensorEvent) {

           currentTime = System.currentTimeMillis();
        if(currentTime - lastTime > 20){
            lastTime = currentTime;
            data.add(String.valueOf(sensorEvent.values[0]));
            time.add(lastTime);
        }
    }
}
