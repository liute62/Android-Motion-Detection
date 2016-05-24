package haodong.model.event;

public class LevelEvent extends BaseEvent{

	private static final long serialVersionUID = -2063638892241485398L;
	
	public static final int LEVEL_STAY = 0;
	
	public static final int LEVEL_DOWNSTAIRS = 1;
	
	public static final int LEVEL_UPSTAIRS = -1;
	
	private long levelStart = 0;
	
	private long levelEnd = 0;

	private int level = LEVEL_STAY;
	
	public LevelEvent(){
		
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public long getLevelStart() {
		return levelStart;
	}

	public void setLevelStart(long levelStart) {
		this.levelStart = levelStart;
	}

	public long getLevelEnd() {
		return levelEnd;
	}

	public void setLevelEnd(long levelEnd) {
		this.levelEnd = levelEnd;
	}
}
