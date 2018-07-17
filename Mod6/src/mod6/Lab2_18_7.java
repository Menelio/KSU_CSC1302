/**
 * Lab_6.2 exercise 18.7 
 * CSC 1302 M-W 11:00-3:50
 * Menelio Alvarez 
 * 7/5/2018
 * */
package mod6;

import java.util.Scanner;
//LISTING 18.2 ComputeFibonacci.java
public class Lab2_18_7 {
	//static class variable for counting how many times fib method is called
	static int count=0;
	/** Main method */
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an index for a Fibonacci number: ");
		int index = input.nextInt();

		// Find and display the Fibonacci number
		System.out.println("The Fibonacci number at index " + index + " is " + fib(index));
		//print out how many time fib method was called
		System.out.println("Fib Method was called "+count+" times");
	}

	/** The method for finding the Fibonacci number */
	public static long fib(long index) {
		//increment count
		count++;
		if (index == 0) // Base case
			return 0;
		else if (index == 1) // Base case
			return 1;
		else // Reduction and recursive calls
			return fib(index - 1) + fib(index - 2);
	}	
 }