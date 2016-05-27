package haodong.main;

import java.util.List;

public class SensorDataFormat {

	public static final String TAG = "SensorDataFormat";
	
	public String listToString(List<Long> time,List<String> datas,String separator){
		String result = "";
		String aLine = "";
		for(int i = 0; i != datas.size(); i++){
			aLine = i+separator+time.get(i)+separator+datas.get(i)+'\n';
			result += aLine;
		}
		return result;
	}
}
