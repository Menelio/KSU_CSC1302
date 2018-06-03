/**
 * Lab_3 
 * CSC 1302 M-W 11:00-3:50
 * Menelio Alvarez 
 * 6/2/2018
 * */
package mod1;

import java.util.Arrays;
import java.util.Random;

public class Lab_3_Menelio {

	public static void main(String[] args) {
		//create random object 
		Random random = new Random();
		// create and initialize dice with random value from 1-6 
		int die_1;
		int die_2;
		//initialize int dice with the sum of both dice
		int dice;
		//initialize array rolls 
		int[] rolls = new int[36000];
		//counters for number of each result
		int twoCounter = 0;
		int threeCounter  = 0;
		int fourCounter  = 0;
		int fiveCounter  = 0;
		int sixCounter  = 0;
		int sevenCounter  = 0;
		int eightCounter  = 0;
		int nineCounter  = 0;
		int tenCounter  = 0;
		int elevanCounter  = 0;
		int twelveCounter  = 0;
		//for loop to generate rolls and increment individual number counters
		for(int i=0; i< rolls.length;i++) {
			die_1 = random.nextInt(5)+1;
			die_2 = random.nextInt(5)+1;
			rolls[i] = die_1 + die_2;
			//increment a number counter with a swtch
			switch(rolls[i]) {
				case 2:
					twoCounter++;
					break;
				case 3:
					threeCounter++;
					break;
				case 4:
					fourCounter++;
					break;
				case 5:
					fiveCounter++;
					break;
				case 6:
					sixCounter++;
					break;
				case 7:
					sevenCounter++;
					break;
				case 8:
					eightCounter++;
					break;
				case 9:
					nineCounter++;
					break;
				case 10:
					tenCounter++;
					break;
				case 11:
					elevanCounter++;
					break;
				case 12:
					twelveCounter++;
					break;
			}	
		}
		/*for testing
		System.out.println(Arrays.toString(rolls));
		System.out.println("two "+twoCounter+" three "+threeCounter+" four "+fourCounter
			+" five "+fiveCounter+" six "+sixCounter+" seven "+ sevenCounter +
			" eight "+eightCounter+" nine "+nineCounter+" ten "+tenCounter +
			" elevan "+elevanCounter+" twelve "+twelveCounter+"\n");
		*/
		
		//formate and print out results
		System.out.format("%3s %13s %14s%n", "Sum","Frequency","Percentage");
		System.out.format("%3s %13s %14s%n", "2",(twoCounter),precent( twoCounter, rolls.length));
		System.out.format("%3s %13s %14s%n", "3",(threeCounter),precent( threeCounter, rolls.length));
		System.out.format("%3s %13s %14s%n", "4",(fourCounter),precent( fourCounter, rolls.length));
		System.out.format("%3s %13s %14s%n", "5",(fiveCounter),precent( fiveCounter, rolls.length));
		System.out.format("%3s %13s %14s%n", "6",(sixCounter),precent( sixCounter, rolls.length));
		System.out.format("%3s %13s %14s%n", "7",(sevenCounter),precent(sevenCounter, rolls.length));
		System.out.format("%3s %13s %14s%n", "8",(eightCounter),precent(eightCounter, rolls.length));
		System.out.format("%3s %13s %14s%n", "9",(nineCounter),precent(nineCounter, rolls.length));
		System.out.format("%3s %13s %14s%n", "10",(tenCounter),precent(tenCounter, rolls.length));
		System.out.format("%3s %13s %14s%n", "11",(elevanCounter),precent(elevanCounter, rolls.length));
		System.out.format("%3s %13s %14s%n", "12",(twelveCounter),precent(twelveCounter, rolls.length));
	}
	
	//method for calculating and formating the frequency of a number
	private static double precent(int num, int length) {
		//fine decimal percent
		double x =((double)num/length);
		//convert to percent and round to nearest tenthes
		return Math.round(x*10000.0)/100.0;
	}
}
