/**
 * Mod2 Lab_3 (as done in video walk through)
 * CSC 1302 M-W 11:00-3:50
 * Menelio Alvarez 
 * 6/2/2018
 * */
package mod2;

import java.util.Scanner;

public class PrimeFactor {
	//Scanner to get user input
	private Scanner console = new Scanner(System.in);
	// int to hold user input
	private int num =0;
	//int to hold factor
	private int factor=0;
	//StackOfIntegers object to be used to hold prime factors as directed by assignment details
	StackOfIntegers stack = new StackOfIntegers();
	//method to find all prime factors
	public void findFactors() {
		//prompt user for number
		System.out.println("Enter number to find its prim factors");
		//while loop to make sure user enters integer
		while(true) {
			try {
				num=Integer.parseInt(console.nextLine());
				break;
			}catch (NumberFormatException e) {
				System.out.println("Please enter an Integer.");
			}	
		}
		//loop to find prime factors 
		//int for the factors starting at 2
		int factor=2;
		while(factor<=num) {
			if((num % factor)==0) {
				//if factor divides num push onto "stack"
				stack.push(factor);
				//divide num by factor and keep checking if it can divide again 
				num /= factor;
			}else {
				factor++;
			}
		}
	}
	//printout all prime factors on stack
	public void printOutStack() {	
		
		System.out.print("Prime factors are: ");
		int i=0;
		while(!stack.empty()) {
			System.out.print(stack.pop());
			if(stack.getSize()!= 0)System.out.print(", ");
		}
	}
	/*StackOfIntegers, found on p.g. 378 of text book, is defined here as an inner class,
	 *so that an instance of it is created when ever and instance of PrimeFactor is created. 
	 *It is used to hold the prime factors as directed by assignment 10.5
	 **/
	class StackOfIntegers{
		private int[] elements;
		private int size;
		public static final int DEFAULT_CAPACITY = 16;
		/** Construct a stack with the default capacity 16 */
		public StackOfIntegers() {
			this (DEFAULT_CAPACITY);
		}
		public StackOfIntegers(int capacity) {
			elements = new int[capacity];
		}
		/** Push a new integer to the top of the stack */
		public void push(int value) {
			if (size >= elements.length) {
				int[] temp = new int[elements.length * 2];
				System.arraycopy(elements, 0, temp, 0, elements.length);
				elements = temp;
			}
			elements[size++] = value;
		}
		/** Return and remove the top element from the stack */
		public int pop() {
			return elements[--size];
		}
		/** Return the top element from the stack */
		public int peek() {
			return elements[size - 1];
		}
		/** Test whether the stack is empty */
		public boolean empty() {
			return size == 0;
		}
		/** Return the number of elements in the stack */
		public int getSize() {
			return size;	
		}
	}
}



