package com.higo.metro;

public class MetroVO {
	private int metro_seq;
	private String metro_name;
	
	public MetroVO() {}
	
	public MetroVO(int metro_seq, String metro_name) {
		super();
		this.metro_seq = metro_seq;
		this.metro_name = metro_name;
	}

	public int getMetro_seq() {
		return metro_seq;
	}

	public void setMetro_seq(int metro_seq) {
		this.metro_seq = metro_seq;
	}

	public String getMetro_name() {
		return metro_name;
	}

	public void setMetro_name(String metro_name) {
		this.metro_name = metro_name;
	}
	
	
}
