package haodong.detection.step.algo;

import java.util.ArrayList;

import haodong.utils.MathUtil;

public class StepSelfAdjustAlgo implements IStepAlgo {

	public static final int DEFAULT_ARRAY_LENGTH = 24;
	
	public static float DEFAULT_SELF_ADJUST_THRESHOLD = 0.7f;
	
	public static float DEFAULT_DEVIATION_THRESHHOLD = 0.5f;
	
	private float[] array = new float[DEFAULT_ARRAY_LENGTH];
	
	private int arrayLength = 0;
	
	private int stepTotalNum = 0;
	
	public StepSelfAdjustAlgo(){
	}

	@Override
	public void feedData(float acc_total) {
		if(arrayLength < DEFAULT_ARRAY_LENGTH){
			array[arrayLength] = acc_total;
			arrayLength++;
		}else{
			
			ArrayList<Model> models = new ArrayList<>();
			
			for(int i = 1; i != 8; i++){
				models.add(loopInner(i, array));
			}
			
			int index = getMaxSelfAdjustIndex(models);
			Model aimed = models.get(index);
			
			if(isStepDetected(aimed.bDeviation,aimed.selfAdjust) )
				stepTotalNum++;
			
			int bLengthMax = aimed.bLength;
			array = arrayModify(bLengthMax);
			arrayLength -= bLengthMax;
		}
	}
	
	private Model loopInner(int i,float[] array){
		
		float[] aArray = new float[i+5];
		float[] bArray = new float[i+5];
		
		for(int index = 0;index != i+5; index++){
			aArray[index] = array[index];
			bArray[index] = array[index+7];
		}
		//calculate standard deviation for bArray
		float bDeviation = MathUtil.getNormalDeviationValue(bArray);
		//calculate self adjust value for aArray, bArray
		float selfAdjust = calSelfAdjustValue(aArray,bArray);
		Model model = new Model();
		model.selfAdjust = selfAdjust;
		model.bDeviation = bDeviation;
		model.bLength = bArray.length;
		return model;
	}
	
	private float calSelfAdjustValue(float[] aArray,float[] bArray){
		
		float aMean = MathUtil.getMeanValue(aArray);
		float bMean = MathUtil.getMeanValue(bArray);
		float aDeviation = MathUtil.getNormalDeviationValue(aArray);
		float bDeviation = MathUtil.getNormalDeviationValue(bArray);
		float sum = 0;
		
		for(int i = 0; i != aArray.length; i++){
			sum += (aArray[i] - aMean) * (bArray[i] - bMean);
		}
		return sum / (aArray.length * aDeviation * bDeviation);
	}
	
	private int getMaxSelfAdjustIndex(ArrayList<Model> models){
		
		float tmp = -1;
		int index = 0;
		
		for(int i = 0; i != models.size(); i++){
			if(models.get(i).selfAdjust > tmp){
				tmp = models.get(i).selfAdjust;
				index = i;
			}
		}
		return index;
	}
	
	private float[] arrayModify(int length){
		float[] newArray = new float[DEFAULT_ARRAY_LENGTH];
		
		for(int i = 0; i != DEFAULT_ARRAY_LENGTH - length; i++){
			newArray[i] = array[i+length];
		}
		return newArray;
	}
	
	private boolean isStepDetected(float deviation,float selfAdjust){
		if(deviation > DEFAULT_DEVIATION_THRESHHOLD && 
			selfAdjust > DEFAULT_SELF_ADJUST_THRESHOLD)
		return true;
		else return false;
	}
	
	private class Model{
		public float selfAdjust = 0;
		public float bDeviation = 0;
		public int bLength = 0;
	}

	@Override
	public int getStepResult() {
		return stepTotalNum;
	}
	
}
