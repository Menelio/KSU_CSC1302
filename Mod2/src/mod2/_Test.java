/**
 * Mod2 _Test Class for Mod2 
 * CSC 1302 M-W 11:00-3:50
 * Menelio Alvarez 
 * 6/2/2018
 * */
package mod2;

import java.sql.Date;
import java.util.Scanner;

public class _Test {

	public static void main(String[] args) {
		
		//test Time class
		Time time = new Time();
		System.out.println("Current time using Time class");
		System.out.println(time.getHour()+":"+time.getMinute()+":"+time.getSecond());
		//add five minutes
		System.out.println("+5 mins");
		time.setTime(System.currentTimeMillis()+(60*1000*5));
		System.out.println(time.getHour()+":"+time.getMinute()+":"+time.getSecond());
		
		//test TimeVideoTut Class
		TimeVideoTut time2 = new TimeVideoTut();
		System.out.println("Current time using TimeVideoTut class");
		System.out.println(time2.getHour()+":"+time2.getMinute()+":"+time2.getSeconds());
		//add five minutes
		System.out.println("+5 mins");
		time2.setTime(System.currentTimeMillis()+(60*1000*5));
		System.out.println(time2.getHour()+":"+time2.getMinute()+":"+time2.getSeconds());
		
		//Test MyInteger
		System.out.println("Test MyInteger class. Please enter integer");
		MyInteger myInt = new MyInteger(new Scanner(System.in).nextInt());
		System.out.println(".isEven()= "+myInt.isEven());
		System.out.println(".isOdd()= "+myInt.isOdd());
		System.out.println(".isPrime()= "+myInt.isPrime());
		System.out.println(".isEven(15)= "+myInt.isEven(15));
		System.out.println(".isOdd(15)= "+myInt.isOdd(15));
		System.out.println(".isPrime(15)= "+myInt.isPrime(15));
		System.out.println(".isEven(MyInteger)= "+myInt.isEven(myInt));
		System.out.println(".isOdd(MyInteger)= "+myInt.isOdd(myInt));
		System.out.println(".isPrime(MyInteger)= "+myInt.isPrime(myInt));
		System.out.println(".equals(4)= "+myInt.equals(4));
		char[] c = {'1','5'};
		System.out.println(".parseInt(char[]) = "+myInt.parseInt( c ) );
		String s ="15";
		System.out.println(".parseInt(String s)"+myInt.parseInt(s));
		
		
		//Test PrimeFactor clas
		System.out.println("Test PrimeFactor class");
		PrimeFactor primeFactor = new PrimeFactor();
		primeFactor.findFactors();
		primeFactor.printOutStack();
		
		
	}

}
