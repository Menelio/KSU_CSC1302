import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PracticeTestAlpha {

	public static void main(String[] args) {
		//Scanner for user input 
		Scanner console = new Scanner(System.in);
		
		//ArrayList for questions
		ArrayList question = new ArrayList<String>();
		//ArrayList for answers
		ArrayList answer = new ArrayList<String>();
		//file for questions and its scanner
		File questionFile = new File("quistions.txt");
		//file for answers and its scanner
		File answerFile = new File("answer.txt");
		//main while loop
		int menu =0;
		
		//print out warning and instruction
		System.out.println("**************WARNING THIS PROGRAM IS INCOMPLETE*************\n"
				+          "->When entering quistions and anwsers enter in one line\n "
				+          "  questions an one line question. \n"
				+ 		   "->On the Main Menu ONLY ENTER INTEGERS OR WILL CRASH");
		
		
		loop:
		while(true) {
			//Main Menu
			System.out.println("-----------------Main Menu-------------------\n"
					     	 + "Please select one of the following options \n"
					     	 + "1) Add quistion \n"
					     	 + "2) Take practice test \n"
					     	 + "3) Quit");
			menu=console.nextInt();
			console.nextLine();
			
			switch (menu) {
				case 1:
					addQuestion(questionFile, answerFile, console);
					break;
				case 2:
					takeTest( question, answer,questionFile, answerFile,20);
					System.out.println("\n Please press enter to return to the main menu");
					console.nextLine();
					break;
				case 3:
					break loop;
					
			}
		}
	}
	//method for creating Scanners
	public static Scanner createScanner(File file) {
		try {
			return new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//method for adding questions
	public static void addQuestion(File questionFile, File answerFile, Scanner console) {
		System.out.println("Please enter question number");
		int numQ = console.nextInt();
				   console.nextLine();
		System.out.println("Please Enter question");
		try(FileWriter fw = new FileWriter(questionFile, true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.println(numQ+") "+console.nextLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("Please Enter answer to quistion");
		try(FileWriter fw = new FileWriter(answerFile, true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.println(numQ+") "+console.nextLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void takeTest(ArrayList question, ArrayList answer, File questionFile, File answerFile,int numOfQ) {
		//create Scanner to populate arrayList
		Scanner inputQ = createScanner(questionFile);
		Scanner inputA = createScanner(answerFile);
		//populate arrayList with loop
		while(inputQ.hasNextLine()&&inputA.hasNextLine()) {
			question.add(inputQ.nextLine());
			answer.add(inputA.nextLine());
		}
		//if question and answer don't match in size something went wrong quite
		if(question.size()!=answer.size()) {
			System.out.println("question.size()!=answer.size()");
			System.exit(0);
		}
		//pick random int to pick question and answer
		int QAnum = 0;
		//array of question numbers to check so there are no repeate questions
		int[] k = new int[numOfQ];

		//for loop to ask question	
		for(int i = 0;i<numOfQ;i++) {
			//gen number and check for repeat
			genNum:
			while(true) {
				check:
				while(true) {
					QAnum = (int)(Math.random() * question.size());
			
					for(int j=0;j<k.length;j++) {
						if(k[j]==QAnum) {
							break check;
						}
					}
					k[i]=QAnum;
					break genNum;
				}
				
			}
			//print out Q	
			System.out.println("Question: \n"+question.get(QAnum)+"\n"+ "Press enter to see answer.");
			//wait for user to hit enter
			new Scanner(System.in).nextLine();
			//display answer
			System.out.println("Answer:\n"+answer.get(QAnum)+"\n");
		}
	}
} 
