package haodong.demo;

import android.app.Activity;
import android.os.Bundle;
import haodong.detection.step.StepAlgoListener;
import haodong.detection.step.StepAlgoManager;

public class DemoActivity extends Activity implements StepAlgoListener{

	StepAlgoManager stepAlgoManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		stepAlgoManager = new StepAlgoManager();
		stepAlgoManager.setListener(this);
		System.out.println("onCreate");
	}

	@Override
	public void onStepResult(int algoType, int stepNum) {
		
	}
}
