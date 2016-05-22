package haodong.detection.step.algo;

import java.util.ArrayList;

public interface IStepAlgo {

	public void feedData(float acc_total);
	
	public int getStepResult();
	
	public ArrayList<Integer> getStepResultList();
}
