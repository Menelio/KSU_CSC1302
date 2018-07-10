/**
 * Lab_6.1 exercise 18.1 
 * CSC 1302 M-W 11:00-3:50
 * Menelio Alvarez 
 * 7/5/2018
 * */
package mod6;

import java.math.*;
import java.util.Scanner;

public class Lab1_18_1 {
	public static void main(String args[]) {
		//Scanner for user input
		Scanner console = new Scanner(System.in);
		//int for factorial
		int n=0;
		//prompt user to input integer
		System.out.println("Enter in n for factorial");
		//store user input in n
		n=console.nextInt();
		//printout result
		System.out.println(n+" is \n"+ factorial(n));
	}
	//recursive method to find factorial using BigInteger Class
	public static BigInteger factorial(int n) {
		if(n==0) {
			return new BigInteger(1+"");
		}else {
			return factorial(n - 1).multiply(new BigInteger(n+"")); 
		}
	} 
}
