import java.util.Scanner;

public class TestProctor {
	//class variables
	private QuestionHandler questionHandler;
	//Scanner for excepting user input
	private Scanner console = new Scanner(System.in);
	//constructor
	public TestProctor() {
		questionHandler = new QuestionHandler();
	}
	public void administerTest() {
		//for loop to go through all question in QuestionsArray
		for(int i=0; i<questionHandler.getQuestionsArray().size();i++) {
			//present a question
			System.out.println(questionHandler.getQuestionAtIndex(i).getQuestion());
			//present answer choices
			for(int j=0; j< questionHandler.getQuestionAtIndex(i).getChoices().length;j++) {
				System.out.println((j+1)+") "+questionHandler.getQuestionAtIndex(i).getChoices()[j]);
			}
			if(console.nextInt() == questionHandler.getQuestionAtIndex(i).getAnswerIndex()) {
				System.out.println("Correct");
			}else {
				System.out.println("Wrong");
			}
			
		}
	}
	//method for creating question
	public void createQuestions() {
			questionHandler.createQuestionfromInput();
	}
	
}
