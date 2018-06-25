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
	private String answer;
	//JSON Object
	private JSONObject qJSON;
	//question id
	private String qID;
	//path
	private static String path = "quistions/questions.json";
	
	
	//constructor for creating true or false question
	public Question(String question,String answer, String qID) throws MissingChoiceException, IOException  {
		//set choice to true or false
		this.choices = new String[]{"True","False"};
		//test that there is a valid answer
		if(answer.equalsIgnoreCase(this.choices[0])||answer.equalsIgnoreCase(this.choices[1])) {
			//initialize class variables
			this.question = question;
			this.answer = answer;
			this.qID = qID;
			//create file from Path and question ID
			Utils.createFile(path);
			qJSON = JUtils.getJSONObjectFromFile(path);
		}else {// if there is no valid answer throw exception
			throw new MissingChoiceException();
		}
	}
	//constructor for creating a multiple choice question
	public Question(String question, String[] choices,String answers,String qID) throws MissingChoiceException, IOException {
		//test that there is a valid answer
		if(Arrays.asList(choices).contains(answers)) {
			//initialize class variables
			this.question = question;
			this.choices = choices;
			this.answer = answer;
			this.qID = qID;
			//create file from Path and question ID
			Utils.createFile(path);
			qJSON = JUtils.getJSONObjectFromFile(path);
		}else {// if there is no valid answer throw exception
			throw new MissingChoiceException();
		}
	}
	//write question to json
	private void writeQuetsionToJson() {		
		//qJSON
		
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
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public JSONObject getqJSON() {
		return qJSON;
	}
	public void setqJSON(JSONObject qJSON) {
		this.qJSON = qJSON;
	}
	public String getAnswer() {
		return answer;
	}
	public String getqID() {
		return qID;
	}
	public void setqID(String qID) {
		this.qID = qID;
	}
	//for testing
	public static void main (String args[]) {
		Question q;
		
		try {
			q = new Question("ThisIsTheQuestion","False", "thisIsTheID");
			System.out.println(q.choices[0]);
			
			
			
		} catch (MissingChoiceException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
