/**
 * Lab_3 
 * CSC 1302 M-W 11:00-3:50
 * Menelio Alvarez 
 * 6/2/2018
 * */
package mod1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Lad_4_Menelio {

	public static void main(String[] args) {
		//create a file object to handle sampledata-io.txt
		File sampledata = new File("sampledata-io.txt");
		//create an array to hold data from sampledata-io.txt
		double[] data = new double[100];
		//create a scanner for reading sampledata using crtScanner method
		Scanner input = createScanner(sampledata);
		//Scanner for reading user input
		Scanner console = new Scanner(System.in);
		//int for counting data entered into data
		int c=0;
		//int for holding user selected option
		int op=0;
		//string to hold user input
		String in;
		//diplay options and prompt user for input 
		System.out.println("Please select one of the following options \n"+
							"1) Enter custom values into array (maximum of 100 values)\n"+
							"2) Read values from sampledata-io.txt.");
		//loop to get and test users input
		outerLoop:
		while (true) {
			innerLoop:
			//loop to test if user entered an integer, if not catch error 
			while(true) {
				try {
					op = Integer.parseInt(console.nextLine());
					//if integer was enterd break innerLoop
					break innerLoop;
				}catch (NumberFormatException e) {
					System.out.println("Please enter an Integer.");
				}	
			}
			//if statement to make sure integer enter is between one and 2
			if(op == 1 || op == 2) {
				break outerLoop;
			}else {
				System.out.println("Please select 1 or 2");
			}
		}
		//if statement to populate array based on option selected
		//Option 1
		if(op == 1) {
			
			System.out.println("Enter the array values, you may press q at any time to quite. ");
		    //for loop to enter in value into array
			outerLoop:
			for (int i = 0; i < data.length; i++) {
		    	//while loop to test user input
		    	innerLoop:
				while(true) {
		    		in=console.nextLine();
		    		if (in.equals("q") || in.equals("Q")) break outerLoop;
		    		try {
		    			//if q quite outerLoop
			    		
		    			data[i] = Double.parseDouble(in);
		    			break innerLoop;
		    		}catch(NumberFormatException e) {
		    			System.out.println("Please enter in a double");
		    		}
		    	}
		    }
		}else {
			//while loop to populate array data from sampledata
			while(input.hasNext()) {
				double d = input.nextDouble();
				if(d==-1.0)break;
				data [c] = d; 
				c++;
			}
		}
		
		//while loop to display options, prompt user for input, and display output 
		mainLoop:
		while (true) {
			System.out.println("Please select one of the following options \n"+
							"1) reverse array \n"+
							"2) add an element \n"+
							"3) remove an element \n"+ 
							"4) display array \n"+
							" you may enter q at any time to quite");
			in = console.nextLine();	
			if (in.equals("q") || in.equals("Q")) break mainLoop;
			//loop to get and test users input
			outerLoop:
			while (true) {
				innerLoop:
				//loop to test if user entered an integer, if not catch error 
				while(true) {
					try {	
						op = Integer.parseInt(in);
						//if integer was enterd break innerLoop
						break innerLoop;
					}catch (NumberFormatException e) {
						System.out.println("Please enter an Integer.");
					}	
				}
				//if statement to make sure integer enter is between one and 2
				if(op == 1 || op == 2 || op == 3 || op == 4) {
					break outerLoop;
				}else {
					System.out.println("Please select 1, 2, 3, or 4");
				}
			}
			switch(op) {
				case 1:
					data=reverseArray(data);
					break;
				case 2:
					data=insertIntoArray(data);
					break;
				case 3:
					removeElementFromArray(data);
					break;
				case 4:
					displayArray(data);
					break;
					
			}
		}
	}
	//method for displaying and array
	private static void displayArray(double[] data) {
		for(int i=0; i < data.length;i++) {
			System.out.println("Position "+i+" = "+data[i]);
		}
	}	
	//Method for creating Scanner 
	private static Scanner createScanner( File sampledata) {
		try {
			Scanner input = new Scanner(sampledata);
			return input;
		} catch (FileNotFoundException e) {
			System.out.println("Scanner threw exception");
			e.printStackTrace();
			System.exit(0);
		}
		return null;
	}
	//Method for reversing array
	private static double[] reverseArray(double[] data) {
		double [] reverse = new double[data.length];
		
		for(int i=0;i < reverse.length; i++) {
			reverse[i] = data[(data.length-1)-i];
		}
		
		return reverse;
	}
	//Method for inserting elements into a vacant space in an array
	private static double[] insertIntoArray(double[] data) {
		//while loop to check if array is full
		boolean space=false;
		int vacantSpace=0;
		for(int i=0; i<data.length;i++) {
			if(data[i]==0.0) {
				space=true;
				vacantSpace = i;
				break;
			}
		}
		//if no space print message and exit method
		if(!space) {
			System.out.println("Array is full");
			System.exit(0);
		}
		//scanner 
		Scanner console = new Scanner(System.in);
		//double for holding double enterd for user
		double d = 0.0;
		//int for holding index of inserted element
		int p = 0;
	
		
		//get user input
		System.out.println("enter in double");
		//loop to make sure user input is a double
		doubleLoop:
		while(true) {
			String t=console.next();
			try {
				d=Double.parseDouble(t);
				break doubleLoop;
			}catch(NumberFormatException e) {
				System.out.println("Please enter a double");
			}			
		}
		data[vacantSpace]=d;
		System.out.println("Element added");
		//return editedData
		return data;
	}
	//method for removing and element from an array
	private static double[] removeElementFromArray(double[] data) {
		//scanner for user input
		Scanner console = new Scanner(System.in);
		//int for index of element to be removed
		int p=0;
		//ask user for index of element to remove
		System.out.println("enter in int for position");
		//loop to make sure user input is an int
		indexLoop:
		while(true) {
			String t =console.next();
			try {
				p=Integer.parseInt(t);
				break indexLoop;
			}catch(NumberFormatException e) {
				System.out.println("Please enter an integer");
			}	
		}
		data[p]=0.0;
		System.out.println("Element removed");
		return data;
	}
	
}
