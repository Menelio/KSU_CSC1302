/**
 * Mod4 Lab_1 
 * CSC 1302 M-W 11:00-3:50
 * Menelio Alvarez 
 * 6/30/2018
 * */
package mod4;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class PrintCalendarListing {
	static Calendar calendar;
	int year;
	int month;
	public static void main (String args[]) {
		//Create Scanner to get user input 
		Scanner console = new Scanner(System.in);
		
		//initialize class variables with user input
		System.out.print("Enter full year (e.g., 2001): ");
	    int year = console.nextInt();

	    System.out.print("Enter month in number between 1 and 12: ");
	    int month =console.nextInt();
	    
	    calendar = new GregorianCalendar(year, month - 1, 1);
	    
	    //array of months
	    String[] months = {"January", "February", "March", "April", "May", "June", 
				"July", "August", "September", "October", "November", "December"};
	    
	    //get length of spacing for the month
	    String formatSpaceLength="";
	    for(int i=0;i<(10 - months[month].length());i++) {
	    	formatSpaceLength=formatSpaceLength+"   ";
	    }
	 
	    //printout 
	    System.out.println("\n"+formatSpaceLength+ months[month-1]+year);
	    System.out.println("-----------------------------");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
	    
		// add spaces at begining for months
		for (int i = 1; i < calendar.get(Calendar.DAY_OF_WEEK); i++) 
			System.out.print("    ");
		
		// Print days in month
	 	while (calendar.get(Calendar.DATE) < calendar.getActualMaximum(Calendar.DATE)) {
	 		
	 		if (calendar.get(Calendar.DAY_OF_WEEK) == 7)
	 			System.out.printf("%4d\n", calendar.get(Calendar.DATE));
	 		else {
	 			System.out.printf("%4d", calendar.get(Calendar.DATE));
	 			}
	 			//increment the day of the month
	 			calendar.add(Calendar.DATE, 1);
	 		}
	 		System.out.printf("%4d\n", calendar.get(Calendar.DATE));
	}
}



