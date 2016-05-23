package haodong.detection.turn;

import haodong.model.event.TurnEvent;

public interface TurnAlgoListener {

	public void onTurnResult(int type,TurnEvent turnEvent);
	
}
