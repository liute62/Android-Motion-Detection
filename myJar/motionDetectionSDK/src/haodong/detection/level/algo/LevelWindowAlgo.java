package haodong.detection.level.algo;

import java.util.ArrayList;

public class LevelWindowAlgo {
	
	public final int windowsMax = 18;
	
	public final int windowsMin = 5;
	
	public final float threshold = 0.32f; 

	private float lowPassAlpha = 0.25f;
	
	private int smoothStart = 200;
	
	private int baroSize;
	
	private ArrayList<Float> baroRaw;
	
	private ArrayList<Float> baroForSmooth;
	
	private ArrayList<Float> baroForLowPass;
	
	public LevelWindowAlgo(){
		baroForLowPass = new ArrayList<>();
		baroForSmooth = new ArrayList<>();
	}
	
	public void detection(){
		smoothFilter();
		lowPassFilter();
		
		float baroMax = 0;
		
		if(baroMax >= threshold){
			
		}
	}
	
	private void smoothFilter(){
		if(baroForSmooth.size() >= smoothStart){
			float tmp = 0;
			for(int i = 0; i < smoothStart; i++){
				tmp += baroRaw.get(baroSize - 1 - i);
			}
			baroForSmooth.add(tmp / smoothStart);
		}else {
			baroForSmooth.add(baroRaw.get(baroSize - 1));
		}
	}
	
	private void lowPassFilter(){
		int index = baroForSmooth.size();
		if(index >= 2){
			float tmp = baroForLowPass.get(index - 2) + lowPassAlpha *
					(baroForSmooth.get(index - 1) - baroForLowPass.get(index - 2));
			baroForLowPass.add(tmp);
		}else {
			baroForLowPass.add(baroForSmooth.get(index - 1));
		}
	}
}
