/**
 * Mod2 Lab_2 
 * CSC 1302 M-W 11:00-3:50
 * Menelio Alvarez 
 * 6/2/2018
 * */

package mod2;

public class MyInteger {
	//int value
	private int value;

	//No arg constructor
	public MyInteger() {
		
	}
	//Constructor with args
	public MyInteger(int value) {
		this.value = value;
	}
	//getter
	public int getValue() {
		return value;
	}
	//method to check if value is even
	public boolean isEven() {
		if((value % 2)==0) {
			return true;
		}
		return false;
	}
	//method to check if value is odd
	public boolean isOdd() {
		if((value % 2)==0) {
			return false;
		}
			return true;
		}
	//method to check if value is prime 
	public boolean isPrime() {
		//int to increment and to use to check if value is evenly divisible by any number other than one or it self
		int i = 2;
		//while loop to check numbers less than value (i)
		while(value > i) {
			//if evenly divisible return false
			if((value % i)==0) {
				return false;
			}
			i++;
		}
		//if no number evenly divides value then it is prime
		
		return true;
	}
	//Static Methods
	//method to check if value is even
		public boolean isEven(int value) {
			if((value % 2)==0) {
				return true;
			}
			return false;
		}
		//method to check if value is odd
		public boolean isOdd(int value) {
			if((value % 2)==0) {
				return false;
			}
				return true;
			}
		//method to check if value is prime 
		public boolean isPrime(int value) {
			//int to increment and to use to check if value is evenly divisible by any number other than one or it self
			int i = 2;
			//while loop to check numbers less than value (i)
			while(value > i) {
				//if evenly divisible return false
				if((value % i)==0) {
					return false;
				}
				i++;
			}
			//if no number evenly divides value then it is prime
			return true;
		}
		
		//method to check if value is even
		public boolean isEven(MyInteger myInt) {
			if((myInt.getValue() % 2)==0) {
				return true;
			}
			return false;
		}
		//method to check if value is odd
		public boolean isOdd(MyInteger myInt) {
			if((myInt.getValue() % 2)==0) {
				return false;
			}
				return true;
			}
		//method to check if value is prime 
		public boolean isPrime(MyInteger myInt) {
			//int to increment and to use to check if value is evenly divisible by any number other than one or it self
			int i = 2;
			//while loop to check numbers less than value (i)
			while(myInt.getValue() > i) {
				//if evenly divisible return false
				if((myInt.getValue() % i)==0) {
					return false;
				}
				i++;
			}
			//if no number evenly divides value then it is prime
			return true;
		}
		//equals Methods
		public boolean equals(int i) {
			if(i== value)return true;
			return false;
		}
		public boolean equals(MyInteger myInt) {
			if(myInt.getValue()== value)return true;
			return false;
		}
		//parse Methods
		public int parseInt(char[] chars) {
			return Integer.parseInt(String.copyValueOf(chars));
		}
		public int parseInt(String s) {
			return Integer.parseInt(s);
		}
		
	
}
