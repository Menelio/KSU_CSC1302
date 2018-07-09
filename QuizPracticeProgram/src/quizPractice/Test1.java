package quizPractice;
import java.io.IOException;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) throws MissingChoiceException, IOException {
		//Scanner for user input
		Scanner console = new Scanner(System.in);
		
		//testProctor Object
		TestProctor test = new TestProctor();
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
				while(true) {
					test.createQuestions();
					if(console.next().equals("q")||console.next().equals("Q")) break;
				}
				break;
			case 2:
				test.administerTest();
				System.out.println("\n Please press enter to return to the main menu");
				console.nextLine();
				break;
			case 3:
				break loop;		
			}
		}
	}
}

