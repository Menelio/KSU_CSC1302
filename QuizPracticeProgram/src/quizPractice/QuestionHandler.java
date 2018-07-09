package quizPractice;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.utils.Utils;
import com.utils.json.JUtils;
/**A Handler Method for Question Class 
 * @author Menelio M Alvarez Jr
 * @version .1 7/07/2018
 * */
public class QuestionHandler {
	//ArrayList of question
	private ArrayList<Question> questionsArray = new ArrayList<Question>();
	//JSON Object
	private JSONObject testJSONObject = JUtils.getJSONObjectFromFile("quistions/questions.json");;
	/**QuestionHandler Constructor
	 * Contains a try catch which throws a NullPointerException if question 
	 * JSON is empty and tells user to create one
	 * Msg : "There are no questions stored you must create one and restart program"
	 * */
	public QuestionHandler() {
		//try to populatePracQArray
		try{
			populatePracQArray();
		//if questions.json is empty catch NullPointerException and call createQuestionfromInput()
		}catch(NullPointerException e) {
			System.out.println("There are no questions stored you must create one and restart program");
			createQuestionfromInput();
		}
	}
	/**Creates a question Objects from question JSON "quistions/questions.json"
	 *  throws a NullPointerException if questions.json is empty
	 * */
	//create question Objects from question JSON "quistions/questions.json" throws a NullPointerException if questions.json is empty
	public void populatePracQArray() throws NullPointerException  {
		//get names of questionArguements arrays
		String[] names = JSONObject.getNames(testJSONObject); 
		for(int h=0; h < names.length;h++) {
			//grab Question argument array from json with name from name array
			JSONArray questionArguements = testJSONObject.getJSONArray(names[h]);
			//set up arguments
			String question = questionArguements.getString(0);
			int answerIndex = questionArguements.getInt(1);
			String[] choices= new String[questionArguements.getJSONArray(2).length()]; 
			for(int i=0; i<choices.length;i++) {
				choices[i]= (String)questionArguements.getJSONArray(2).get(i);
			}
			//add question to PracticeQuestions ArrayList
			
			questionsArray.add(createQuestion(question,choices,answerIndex,names[h]));
		}
	}
	/**Creates a Question 
	 * @param String question : text of question
	 * @param String[] choices : array of possible choices
	 * @param int answerIndex : index of correct answer
	 * @param String qID : Question ID
	 * @return Question : Question Object
	 * */
	//create Question move this funtionallity out to the class that implements 
	public static Question createQuestion(String question, String[] choices,int answersIndex,String qID) {
		try {
			return new Question(question, choices, answersIndex, qID);	
		} catch (MissingChoiceException | IOException e) {
			System.out.println("Creating question, "+qID+", threw an exception. createQuestion() has returned null");
			e.printStackTrace();
			return null;
		}
	}
	//this is a temporary method for creating a question from user input, will replace with gui.
	public void createQuestionfromInput() {
		//Scanner for user input
		Scanner console = new Scanner(System.in);
		System.out.println("Enter Question ID");
		String qID =console.nextLine();
		//Prompt user to enter question
		System.out.println("Enter Question, enter in :q when done");
		//loop to allow for multi line questions
		String question="";
		while(true) {
			String buf = console.nextLine();
			if(buf.equals(":q")||buf.equals(":Q"))break;
			if(buf.contains(":q")||buf.contains(":Q")) {
				buf=buf.replace(":q", "");
				buf=buf.replace(":Q", "");
				question =question + "\n"+ buf;
				break;
			}
			question = question + "\n"+ buf;
		}
		//prompt user to enter in number of answer choices
		System.out.println("Enter in number of answer choices");
		String[] choices = new String[console.nextInt()];
		console.nextLine();
		//for loop to prompte user to enter in answer choice and populate choice array
		for(int i=0;i < choices.length;i++) {
			System.out.println("Enter choice "+i);
			choices[i]=console.nextLine();
		}
		//prompt user to enter correct answer index
		System.out.println("Enter number of correct answer");
		int answerIndex = console.nextInt();
		//create question
		createQuestion(question, choices, answerIndex, qID).writeQuetsionToJson();
		//populatePracQArray();
	}
	/**Checks if answer is correct
	 * @param String aID : Question ID
	 * @Param int selectedAnswer : answer a
	 * */
	//Method for checking if answer is correct
	public boolean checkAnswer(String qID, int selectedAnswer) {
		for(int i=0; i<questionsArray.size();i++) {
			if( questionsArray.get(i).getqID().equals(qID) && questionsArray.get(i).getAnswerIndex()==selectedAnswer ) {
				return true;
			}
		}
		return false;
	}
	/**Gets a question at the given index
	 * @param index : index of question to return
	 * @return Question : Question Object at given index
	 * */
	//for simply returning a question at a particular index
	public Question getQuestionAtIndex(int index) {
		return questionsArray.get(index);
	}
	//getters and setter

	public ArrayList<Question> getQuestionsArray() {
		return questionsArray;
	}

	public void setQuestionsArray(ArrayList<Question> questionsArray) {
		this.questionsArray = questionsArray;
	}

	public JSONObject getTestJSONObject() {
		return testJSONObject;
	}

	public void setTestJSONObject(JSONObject testJSONObject) {
		this.testJSONObject = testJSONObject;
	}
}
