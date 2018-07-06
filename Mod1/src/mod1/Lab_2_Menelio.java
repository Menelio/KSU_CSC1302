/**
 * Lab_2 
 * CSC 1302 M-W 11:00-3:50
 * Menelio Alvarez 
 * 6/2/2018 Merge Test1
 * */

package mod1;

import java.util.Arrays;

public class Lab_2_Menelio {
	
	public static void main (String[] args) {
		int y;
		//initialize array
		int[] dates = {2683, 2654, 3090, 3325, 4881, 3300, 7456, 3780, 3232, 7270,
				   7773, 5553, 2850, 7619, 2762, 6965, 4539, 3131, 6066, 5404,
				   4183, 6830, 2424, 4517, 6599, 3714, 7351, 4243, 6688, 7819,
				   6449, 3781, 5565, 3283, 7427};
		//sort array from least to greatist
		Arrays.sort(dates);
		//print out max and min values
		System.out.println("Max value "+ dates[dates.length-1]);
		System.out.println("Min value "+ dates[0]);
		//calculate and print out total
		double total = 0;
		for(int i : dates) {
			total += i;
		}
		System.out.println("Total "+total);
		//calculate and print out average
		System.out.println("Average "+( total/dates.length ));
		
	}
}
