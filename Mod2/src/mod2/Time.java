package mod2;

import java.sql.Date;

public class Time {
	//class var
	private int hour;
	private int minute;
	private int second;
	
	
	//no args constructor
	public Time () {
		//initialize time with current time 
		setTime(System.currentTimeMillis());
		
	}
	
	//args constructor
	public Time(long t) {
		
	}
	//method for setting time 
	public void setTime(long t) {
		java.sql.Time time = new java.sql.Time(t);
		this.hour = (time.getHours()%12);
		this.minute = time.getMinutes();
		this.second =time.getSeconds();
		 
	}
	//getters

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	public int getSecond() {
		return second;
	}
	
}
