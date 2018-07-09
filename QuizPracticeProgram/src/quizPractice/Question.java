package quizPractice;
/*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 *!!!!!!!!!UNFINISHED DO NOT USE!!!!!!!!!!
 *!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;
import com.utils.Utils;
import com.utils.json.*;

public class Question {
	//String class var for holding questoin
	private String question;
	//String array for holding possible choices
	private String[] choices;
	//correct answer String
	private int answerIndex;
	//JSON Object
	private static JSONObject qJSON;
	//question id
	private String qID;
	//path
	private static String path = "quistions/questions.json";

	//constructor for creating a multiple choice question
	public Question(String question, String[] choices,int answerIndex,String qID) throws MissingChoiceException, IOException {
		//test that there is a valid answer
		if(answerIndex <= choices.length) {
			//initialize class variables
			this.question = question;
			this.choices = choices;
			this.answerIndex = answerIndex;
			this.qID = qID;
			//create file from Path and question ID
			Utils.createFile(path);
			qJSON= new JSONObject();
			qJSON = JUtils.getJSONObjectFromFile(path);
		}else {// if there is no valid answer throw exception
			throw new MissingChoiceException();
		}
	}
	//write question to json
	public void writeQuetsionToJson() {		
		//ArrayList to be written to JSON
		ArrayList<Object> temp = new ArrayList<>();
		//add question attributes to ArrayList
		temp.add(question);
		temp.add(answerIndex);
		temp.add(choices);
		//writer temp To JSON with qID as Key
		qJSON.put(qID, temp );
		JUtils.writeToJSON(path, qJSON);
		
	}
	//getters And setters
	/**returns question text
	 * @return String : question text
	 * */
	public String getQuestion() {
		return question;
	}
	/**set the question text
	 * @param String question : question text
	 * */
	public void setQuestion(String question) {
		this.question = question;
	}
	/**returns the question's array of choices
	 * @return String[] : choices
	 * */
	public String[] getChoices() {
		return choices;
	}
	/**sets the question's array of choices
	 * @param String[] choices : Array of choices
	 * */
	public void setChoices(String[] choices) {
		this.choices = choices;
	}
	/**set the array index of the answer
	 * @param int answerIndedx : index of answer in array of choices
	 * */
	public void setAnswer(int answerIndex) {
		this.answerIndex = answerIndex;
	}
	public JSONObject getqJSON() {
		return qJSON;
	}
	public void setqJSON(JSONObject qJSON) {
		this.qJSON = qJSON;
	}
	public int getAnswerIndex() {
		return answerIndex;
	}
	public String getqID() {
		return qID;
	}
	public void setqID(String qID) {
		this.qID = qID;
	}
	
}
