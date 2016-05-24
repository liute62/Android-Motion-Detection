package haodong.model.event;

public class TurnEvent extends BaseEvent{

	private static final long serialVersionUID = 3182938221795983813L;
	
	public static final int TURN_STRAIGHT = 0;
	
	public static final int TURN_LEFT = -1;
	
	public static final int TURN_RIGHT = 1;
	
	private int turnDir = TURN_STRAIGHT; //0: straight, -1: left; 1:right
	
	private int turnDegree = 0;

	public TurnEvent(){
		
	}

	public int getTurnDir() {
		return turnDir;
	}

	public void setTurnDir(int turnDir) {
		this.turnDir = turnDir;
	}

	public int getTurnDegree() {
		return turnDegree;
	}

	public void setTurnDegree(int turnDegree) {
		this.turnDegree = turnDegree;
	}
}
