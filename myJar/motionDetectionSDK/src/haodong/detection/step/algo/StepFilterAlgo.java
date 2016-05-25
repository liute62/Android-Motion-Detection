package haodong.detection.step.algo;

import java.util.ArrayList;
import java.util.Collections;

public class StepFilterAlgo implements IStepAlgo{
	
	private ArrayList<Float> accTotal;
	
	private ArrayList<ArrayList<Float>> accFilter;
	
	private ArrayList<Integer> resultStep;
	
	private int lastStep = 0;
	
	public static final int section = 300;
	
	private int size = 0;
	
	private int wsSmooth0 = 11; 
	
	private int wsSmooth1Half = 10; 
	
    private int wsPeak = 11; //windows size of peak detection //14,15
	
	private float peakJudge = 0.052f;
	
	private int totalSampleNum = 0;
	
	private boolean isDetected;
	
	private float alpha = 0.25f;
	
	public StepFilterAlgo() {
		accTotal = new ArrayList<Float>();
		accFilter = new ArrayList<ArrayList<Float>>();
		resultStep = new ArrayList<Integer>();
		resultStep.add(0);
	}
	
	@Override
	public void feedData(float acc_total) {
		isDetected = false;
		accTotal.add(acc_total);
		size = accTotal.size();
		totalSampleNum++;
		if(size == section){
			accTotal.remove(0);
			accFilter.remove(0);
			size = accTotal.size();
		}
		stepDetection();
	}
	
	public void reset(){
		accTotal = new ArrayList<Float>();
		accFilter = new ArrayList<ArrayList<Float>>();
		resultStep = new ArrayList<Integer>();
		resultStep.add(0);
		totalSampleNum = 0;
		size = 0;
	}
	
	private void stepDetection(){
		ArrayList<Float> accFilterTmp = new ArrayList<Float>();
        accFilterTmp.add(accTotal.get(size - 1));
        accFilterTmp.add(0.0f);
        accFilterTmp.add(0.0f);
        accFilter.add(accFilterTmp);
        resultStep.add(resultStep.get(resultStep.size() - 1)); //add the last one
        
        if(size > wsSmooth0){
        	ArrayList<Float> tmpSmooth0 = new ArrayList<Float>();
        	for(int j = size; j >= size - wsSmooth0 + 1; j--){
        		tmpSmooth0.add(accTotal.get(size-1));
        	}
        	Collections.sort(tmpSmooth0);
        	int tmpi = (wsSmooth0 - 1) / 2;
        	accFilter.get(size - tmpi - 1).set(0, tmpSmooth0.get(tmpi));
        }
        if(size >= wsSmooth1Half + 2){
        	int j = size - wsSmooth1Half;
        	int length = accFilter.size();
        	int tmp_i;
        	float avg1 = 0;
        	float avg2 = 0;
        	for(tmp_i = 0; tmp_i <= wsSmooth1Half - 1; tmp_i++){
        		avg2 += accFilter.get(length - tmp_i - 1).get(0);
        	}
        	avg2 = avg2 / tmp_i;
        	float middle = accFilter.get(length - tmp_i - 1).get(0);
        	tmp_i++;
        	while (tmp_i < Math.min(length, 2 * wsSmooth1Half + 1)) {
                avg1 += accFilter.get(length - tmp_i - 1).get(0);
                tmp_i++;
            }
        	avg1 = avg1 / (tmp_i - wsSmooth1Half - 1);
        	accFilter.get(j - 1).set(1, (float) (2 * middle - avg1 - avg2));
        	//low pass filter
        	accFilter.get(j - 1).set(2, accFilter.get(j - 2).get(2) + alpha * (accFilter.get(j - 1).get(1) - accFilter.get(j - 2).get(2)));
        	// peak detection
            if ((j >= 2 * wsPeak + 1) && (accFilter.get(j - wsPeak - 1).get(1) > peakJudge)) {
                ArrayList<Float> tmpPeakDetection = new ArrayList<Float>();
                for (int tmp_j = 1; tmp_j <= 2 * wsPeak + 1; tmp_j++) {
                    tmpPeakDetection.add(accFilter.get(j - tmp_j).get(2));
                }
                Collections.sort(tmpPeakDetection);
                if (tmpPeakDetection.get(tmpPeakDetection.size() - 1) == accFilter.get(j - wsPeak - 1).get(2)) {
                    isDetected = true;
                }
            }
            int tmp = totalSampleNum - wsSmooth1Half;

            if (isDetected) {
                resultStep.set(tmp - wsPeak - 1, resultStep.get(tmp - wsPeak - 2) + 1);
                lastStep = resultStep.get(tmp - wsPeak - 1);
            } else if (tmp > wsPeak + 1) {
                resultStep.set(tmp - wsPeak - 1, resultStep.get(tmp - wsPeak - 2));
            }
        }
        else {
            accFilter.get(size - 1).set(1, accFilter.get(size - 1).get(0));
        }
	}

	@Override
	public int getStepResult() {
		return lastStep;
	}

	@Override
	public ArrayList<Integer> getStepResultList() {
		return resultStep;
	}

}
