import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

import org.json.JSONObject;

import com.utils.Utils;
import com.utils.json.JUtils;

public class Scratch {

	public static void main(String[] args) {
		String[] choices1 = {"answer1", "answer2","answer3","answer4"};
			//create question1
			Question q1 = createQuestion("Test q1",  choices1, 2, "q1ID");
			//create question2
			Question q2 = createQuestion("Test q2",  choices1, 3, "q2ID");
			//write Question 1
			q1.writeQuetsionToJson();
			//write Question 2
			q2.writeQuetsionToJson();
			
			
			//create a question object from 
			
	}
	public static Question createQuestion(String question, String[] choices,int answersIndex,String qID) {
		try {
			return new Question(question, choices, answersIndex, qID);	
		} catch (MissingChoiceException | IOException e) {
			System.out.println("Creating question, "+qID+", threw an exception. createQuestion() ha returned null");
			e.printStackTrace();
			return null;
		}
	}
}
