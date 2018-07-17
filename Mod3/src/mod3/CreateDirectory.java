/**
 * Mod3 Lab_3 
 * CSC 1302 M-W 11:00-3:50
 * Menelio Alvarez 
 * 6/18/2018
 * */
package mod3;

import java.io.File;
import java.util.Scanner;

public class CreateDirectory {
	private static Scanner scanner;

	//create only a static method because nothing else is needed 
	public static void makeDir() {
		//prompt user to enter in a dir
		System.out.println("Enter in directory");
		scanner = new Scanner(System.in);
		File file = new File(scanner.nextLine());
		 //create dir and print out messages if successful, or message if not successful
		 if(file.mkdirs()) {
			 System.out.println("Directory made");
		 }else if(file.isDirectory()){
			 System.out.println("Directory already exist");
		 }else {
			 System.out.println("Directory was not made");
		 }
		
	}
}
