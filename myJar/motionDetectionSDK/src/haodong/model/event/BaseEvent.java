package haodong.model.event;

import java.io.Serializable;

public class BaseEvent implements Serializable {

	private static final long serialVersionUID = 4325649364910892453L;

	private long sampleId;
	
	private long timeStamp;

	public long getSampleId() {
		return sampleId;
	}

	public void setSampleId(long sampleId) {
		this.sampleId = sampleId;
	}
	
	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
