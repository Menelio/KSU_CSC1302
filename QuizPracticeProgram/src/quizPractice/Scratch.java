package quizPractice;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.utils.Utils;
import com.utils.json.JUtils;

public class Scratch {

	public static void main(String[] args) {
		String s = "e";
		int n= Integer.parseInt(s);
		String[] choices1 = {"answer1", "answer2","answer3","answer4"};
			//create question1
			Question q1 = createQuestion("Test q1",  choices1, 2, "q1ID");
			//create question2
			Question q2 = createQuestion("Test q2",  choices1, 3, "q2ID");
			//write Question 1
			q1.writeQuetsionToJson();
			//write Question 2
			q2.writeQuetsionToJson();
			
			//retrive question
			JSONArray qA1 = q1.getqJSON().getJSONArray(q1.getqID());
			
			JSONArray qA2 = q2.getqJSON().getJSONArray(q2.getqID());
			for(int i =0; i < qA1.length();i++) {
				System.out.println(qA1.get(i));
			}
			System.out.println();
			for(int i =0; i < qA2.length();i++) {
				System.out.println(qA2.get(i));
			}
			Scanner console = new Scanner(System.in);
			String test="";
			while(true) {
				String buf = console.nextLine();
				if(buf.equals(":q")||buf.equals(":Q"))break;
				if(buf.contains(":q")||buf.contains(":Q")) {
					buf=buf.replace(":q", "");
					buf=buf.replace(":Q", "");
					test = test + "\n"+ buf;
					break;
				}
				
				test = test + "\n"+ buf;
			}
			System.out.println(test);
			
			
			
	}
	//create Question
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
