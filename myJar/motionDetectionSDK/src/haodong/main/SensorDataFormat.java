package haodong.main;

import java.util.List;

public class SensorDataFormat {

	public static final String TAG = "SensorDataFormat";
	
	public String listToString(List<Long> time,List<String> datas,char separator){
		String result = "";
		for(int i = 0; i != datas.size(); i++){
			result += time.get(i)+separator+datas.get(i) +"/n";
		}
		return result;
	}
}
