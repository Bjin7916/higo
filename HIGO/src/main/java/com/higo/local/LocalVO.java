package com.higo.local;

public class LocalVO {
	private int local_seq;
	private int metro_seq;
	private String local_name;
	private String fullCity;
	
	
	public LocalVO() {}	
	public LocalVO(int local_seq, int metro_seq, String local_name, String fullCity) {
		super();
		this.local_seq = local_seq;
		this.metro_seq = metro_seq;
		this.local_name = local_name;
		this.fullCity = fullCity;
	}
	public int getLocal_seq() {
		return local_seq;
	}
	public void setLocal_seq(int local_seq) {
		this.local_seq = local_seq;
	}
	public int getMetro_seq() {
		return metro_seq;
	}
	public void setMetro_seq(int metro_seq) {
		this.metro_seq = metro_seq;
	}
	public String getLocal_name() {
		return local_name;
	}
	public void setLocal_name(String local_name) {
		this.local_name = local_name;
	}
	public String getFullCity() {
		return fullCity;
	}
	public void setFullCity(String fullCity) {
		this.fullCity = fullCity;
	}
	
	
}
