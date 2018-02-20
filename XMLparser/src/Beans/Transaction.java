package Beans;

import java.util.Date;

public class Transaction {

	private String id;
	private float Money;
	private Date date;
	private String duration;
	private String car_id;
	private String customer_id;
	private String driver_id;
	private String state;
	
	
	public Date getTime() {
		return date;
	}
	public void setTime(Date time) {
		this.date = time;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public float getMoney() {
		return Money;
	}
	public void setMoney(float money) {
		Money = money;
	}
	public String getCar_id() {
		return car_id;
	}
	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getDriver_id() {
		return driver_id;
	}
	public void setDriver_id(String driver_id) {
		this.driver_id = driver_id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
}
