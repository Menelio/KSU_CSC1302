/*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 *!!!!!!!!!UNFINISHED DO NOT USE!!!!!!!!!!
 *!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * */
import java.io.File;
import java.io.IOException;
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
	
	
	//constructor for creating true or false question
	public Question(String question,int answerIndex, String qID) throws MissingChoiceException, IOException  {
		//set choice to true or false
		this.choices = new String[]{"True","False"};
		//test that there is a valid answer
		if(answerIndex < 2) {
			//initialize class variables
			this.question = question;
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
		//write test
	
		qJSON.append(qID,choices);
		qJSON.append(qID,question);
		qJSON.append(qID,answerIndex);
		//qJSON.put(qID, answer);
		
		JUtils.writeToJSON(path, qJSON);
		
	}
	//getters And setters
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String[] getChoices() {
		return choices;
	}
	public void setChoices(String[] choices) {
		this.choices = choices;
	}
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
