package quizPractice;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
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
			String correctAnswer = questionArguements.getString(1);
			String[] choices= new String[questionArguements.getJSONArray(2).length()]; 
			for(int i=0; i<choices.length;i++) {
				choices[i]= (String)questionArguements.getJSONArray(2).get(i);
			}
			//add question to PracticeQuestions ArrayList
			
			questionsArray.add(createQuestion(question,choices,correctAnswer,names[h]));
		}
	}
	/**Creates a Question 
	 * @param String question : text of question
	 * @param String[] choices : array of possible choices
	 * @param String correctAnswer : index of correct answer
	 * @param String qID : Question ID
	 * @return Question : Question Object
	 * */
	//create Question move this funtionallity out to the class that implements 
	public static Question createQuestion(String question, String[] choices,String correctAnswer,String qID) {
		try {
			return new Question(question, choices, correctAnswer, qID);	
		} catch (MissingChoiceException | IOException e) {
			System.out.println("Creating question, "+qID+", threw an exception. createQuestion() has returned null");
			e.printStackTrace();
			return null;
		}
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
