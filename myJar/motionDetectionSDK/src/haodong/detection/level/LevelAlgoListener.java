package haodong.detection.level;

import haodong.model.event.LevelEvent;

public interface LevelAlgoListener {

	public void onLevelResult(int type,LevelEvent levelEvent);
}
