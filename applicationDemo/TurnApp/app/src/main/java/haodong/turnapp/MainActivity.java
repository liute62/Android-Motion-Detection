package haodong.turnapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mIsStart;

    TextView mStep;

    TextView mDirText;

    ImageView mDirImage;

    boolean isStart = false;

    String[] dirText = new String[]{"笔直","向左","向右"};

    int[] dirImage = new int[]{R.drawable.straight,R.drawable.left,R.drawable.right};

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
                    mIsStart.setText("已启动");
                    mDirImage.setImageResource(dirImage[0]);
                    mDirText.setText(dirText[0]);
                    mStep.setText("0");

                }else {
                    isStart = false;
                    mIsStart.setText("已停止");
                }
            }
        });
        mIsStart = (TextView)findViewById(R.id.main_is_start);
        mDirImage = (ImageView)findViewById(R.id.main_direction);
        mDirText = (TextView)findViewById(R.id.main_direction_text);
        mStep = (TextView)findViewById(R.id.main_step);
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
}
