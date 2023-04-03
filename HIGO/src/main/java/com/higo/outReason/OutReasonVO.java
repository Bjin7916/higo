package com.higo.outReason;

public class OutReasonVO {
	private int outReason;
	private String reason_content;
	
	public OutReasonVO() {}
	
	public OutReasonVO(int outReason, String reason_content) {
		super();
		this.outReason = outReason;
		this.reason_content = reason_content;
	}
	
	public int getOutReason() {
		return outReason;
	}
	public void setOutReason(int outReason) {
		this.outReason = outReason;
	}
	public String getReason_content() {
		return reason_content;
	}
	public void setReason_content(String reason_content) {
		this.reason_content = reason_content;
	}
	
	
	
}
