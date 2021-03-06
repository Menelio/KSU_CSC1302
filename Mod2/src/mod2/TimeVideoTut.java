/**
 * Mod2 Lab_1 (as done in video walk through)
 * CSC 1302 M-W 11:00-3:50
 * Menelio Alvarez 
 * 6/2/2018
 * */
package mod2;

public class TimeVideoTut {
	//class vars
	private int hour;
	private int minute;
	private int second;
	
	//No argument constructor 
	public TimeVideoTut() {
		convertMS2Time(System.currentTimeMillis());
	}
	//constructor with long parameter
	public TimeVideoTut(long t) {
		convertMS2Time(t);
	}
	
	//getters
	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	public int getSeconds() {
		return second;
	}
	public void setTime(long t) {
		convertMS2Time(t);
	}
	//convert milliseconds to time 
	private void convertMS2Time(long t) {
		hour = (int)((((t/(1000 * (60 * 60)))-5)%24)%12) ;
		minute = (int) (((t/(1000 *(60))))%60) ;
		second = (int)(((t/(1000)))%60);
	}
}
