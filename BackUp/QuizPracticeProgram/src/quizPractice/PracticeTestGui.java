package quizPractice;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PracticeTestGui extends Application {
	//question handler
	QuestionHandler qH = new QuestionHandler();
	//question index
	int questionIndex=0;
	//String of choices for saving questions
	String[] choices= new String[0];
	@Override
	public void start(Stage stage) throws Exception {	
		//Anchor Pane
		AnchorPane ancPane = new AnchorPane();
		
		//set up main menu
		setMainMenu(ancPane,"");
		//scene
		Scene scene = new Scene(ancPane);
		
		//set scene and show
		stage.setScene(scene);
		stage.setMinHeight(500);
		stage.setMinWidth(500);
		stage.show();
		

	}
	//Method for setting up the Main menu in the AnchorPane
	public void setMainMenu(AnchorPane ancPane, String noFilePrompt) {
		
		
		//set label for main menu title, its font size and Pos
		Label menuTitle = new Label("Main Menu");
		Font value= new Font(20);
		menuTitle.setFont(value);
		ancPane.setTopAnchor(menuTitle, 25.0);
		ancPane.setLeftAnchor(menuTitle, 185.0);
		
		
		//button to take test and its pos
		Button takeTest = new Button("Take Test");
		ancPane.setTopAnchor(takeTest, 100.0);
		ancPane.setLeftAnchor(takeTest, 200.0);
		
		//button to add quistion and its Pos
		Button addQuistion = new Button("Add Quistion");
		ancPane.setTopAnchor(addQuistion, 150.0);
		ancPane.setLeftAnchor(addQuistion, 190.0);
		
		//Label for no question file
		Label noQuestionPrompt = new Label(noFilePrompt);
		ancPane.setTopAnchor(noQuestionPrompt , 75.0);
		ancPane.setLeftAnchor(noQuestionPrompt , 80.0);
		
		//add nodes to ancPane
		ancPane.getChildren().add(menuTitle);
		ancPane.getChildren().add(takeTest);
		ancPane.getChildren().add(addQuistion);
		ancPane.getChildren().add(noQuestionPrompt);
		
		
		
		//Set up events for buttons
		takeTest.setOnAction(e->{	
		//clear all nodes from ancPane
		ancPane.getChildren().clear();
		//try to set up Test gui
		try {
			TestGui(ancPane);
		}catch(IndexOutOfBoundsException E) {
			//if exception is thrown there are no question yet, set label to tell user to setup question
			setMainMenu(ancPane, "You must set up atleast one question before you take a test");
		}
		});
		addQuistion.setOnAction(e->{
			//clear all nodes from ancPane
			ancPane.getChildren().clear();
			//set up add question gui
			createQuestion(ancPane);
		});
	}
	public  void TestGui(AnchorPane ancPane) throws IndexOutOfBoundsException {
		//label for question
		Label question = new Label();
		
		question.setText(qH.getQuestionAtIndex(questionIndex).getQuestion());
		
		//grid pane for radio buttons for choices
		GridPane gPane = new GridPane();
		
		//radio buttons for choice
		String choices[] = qH.getQuestionAtIndex(questionIndex).getChoices();
		RadioButton[] choicesButton = new RadioButton[choices.length];
		ToggleGroup choicesToggleG = new ToggleGroup();
		for(int i = 0; i < choices.length;i++) {
			choicesButton[i]= new RadioButton();
			choicesButton[i].setText(choices[i]);
			choicesButton[i].setToggleGroup(choicesToggleG);
		}
	 
		//set up question and radio buttons in GridPane
		gPane.add(question, 0, 0);
		for(int i=0; i < choices.length;i++) {
			gPane.add(choicesButton[i], 0, (i+1));
		}
		
		//Label to show if answer is correct
		Label check = new Label();
		gPane.add(check, 0, (choices.length+1));
		
		//Back to Main Menu Button
		Button backToMain = new Button("Main Menu");
		//Button to check
		Button checkBtn = new Button("CheckButn");
		//Button to move to next question
		Button nxtQuestion = new Button("Next Question");
		
		//Next Question Button event
		nxtQuestion.setOnAction(e->{
			if(questionIndex < (qH.getQuestionsArray().size()-1)) {
				//clear all nodes from ancPane
				ancPane.getChildren().clear();
				//increment questionIndex to move to next question
				questionIndex++;
				//call TestGui to reset with new question
				TestGui(ancPane);
			}
		});
		//Check button event
		checkBtn.setOnAction(e->{
			//try catch block needed because if a radio button isn't selected checking it would throw NullPointerException
			try {
				if( (qH.getQuestionAtIndex(questionIndex).getAnswerIndex()).equals(((RadioButton)choicesToggleG.getSelectedToggle()).getText()) ) {
					check.setText("\nCorrect");
				}else {
					check.setText("\nIncorrect");
				}
				
			}catch(NullPointerException E) {
				//if exception thrown just do nothing 
			}
		});
		
		//Back to main menu even
		backToMain.setOnAction(e->{
			ancPane.getChildren().clear();
			qH = new QuestionHandler();
			setMainMenu(ancPane,"");
		});
		
		//add nodes to anchor Pane
		ancPane.setTopAnchor(gPane, 10.0);
		ancPane.setLeftAnchor(gPane, 20.0);
		ancPane.getChildren().add(gPane);
		
		//add next question button
		ancPane.setBottomAnchor(nxtQuestion, 25.0);
		ancPane.setRightAnchor(nxtQuestion, 25.0);
		ancPane.getChildren().add(nxtQuestion);
		
		//add check button
		ancPane.setBottomAnchor(checkBtn, 25.0);
		ancPane.setRightAnchor(checkBtn, 122.5);
		ancPane.getChildren().add(checkBtn);
		
		//add check button
		ancPane.setBottomAnchor(backToMain, 25.0);
		ancPane.setRightAnchor(backToMain, 200.0);
		ancPane.getChildren().add(backToMain);
	}
	public  void createQuestion(AnchorPane ancPane) {
		
		
		//Label for question ID
		Label qIdLbl = new Label("Question ID");
		//Text field for entering question ID
		TextField qIdTextField = new TextField();
		
		//Label for question text
		Label qTxtBox = new Label("Question Text");
		TextArea qTxt = new TextArea();
		qTxt.setMaxSize(430, 100);
		
		//text field, label, button to enter in number of choices and generate
		Label numChoicesLbl = new Label("Enter in number of choices");
		TextField numChoicesTxtBox = new TextField();
		numChoicesTxtBox.setMaxSize(25, 100);
		Button genChoices = new Button ("Generate choice text boxes");
		
		//label for feedback on user input in numChoicesTxtBox
		Label feedBack = new Label();
		feedBack.setTextFill(Color.RED);
		
		//Text Box array for actual chioces
		ArrayList<TextField> choicesTxt= new ArrayList<TextField>();
		ArrayList<RadioButton> choicesRB= new ArrayList<RadioButton>();
		ToggleGroup choicesRBTG = new ToggleGroup();
		//grid pane to hold text Boxes for choices
		GridPane gPane = new GridPane();
		
		//radio button instructions
		Label RadionInstruction = new Label();
		
		//genChoices button event
		genChoices.setOnAction(e->{
			RadionInstruction.setText("Fill in radion button next to correct answer.");
			gPane.getChildren().clear();
			choicesTxt.removeAll(choicesTxt);
			//int to hold number of choices
			int numberOfChoices;
			//try to parse string into Int
			try {
				numberOfChoices = Integer.parseInt(numChoicesTxtBox.getText());
				feedBack.setText("");
				if(numberOfChoices > 4) {
					feedBack.setText("You must enter a number less than 5");
				}else if(numberOfChoices< 1) {
					feedBack.setText("You must enter a number greater than 0");
				}else {
					for(int i=0; i< numberOfChoices;i++) {
						choicesTxt.add(new TextField());
						choicesRB.add(new RadioButton());
					
					}
				}
				//populate gPane with choice TextField
				for(int i=0; i<choicesTxt.size();i++) {
					gPane.add(choicesTxt.get(i), 0, i);
					gPane.add(choicesRB.get(i), 1, i);
					choicesRB.get(i).setToggleGroup(choicesRBTG);
				}
			}catch(NumberFormatException E){
				feedBack.setText("You must enter a number");
			}
			//to know how many text fields there are easily
			choices = new String[choicesTxt.size()];
		});
		//Save Question Button
		Button saveQ = new Button("Save Question");
		
		//Save button event
		saveQ.setOnAction(e->{
			//index of correct answer in choicesRG arraylist
			int correctAnswerIndex=0;

			//if there are text field go ahead with event
			if(choices.length>0) {
			   for(int i=0; i<choices.length;i++) {
				   choices[i]= choicesTxt.get(i).getText();
				   
				   if(choicesRB.get(i).isSelected()) {
					   correctAnswerIndex=i;
				   }
			   }
			qH.createQuestion(qTxt.getText(), choices,choices[correctAnswerIndex] , qIdTextField.getText()).writeQuetsionToJson();	
			}
		});
		//Back to Main Menu Button
		Button backToMain = new Button("Main Menu");
		//Back to main menu even
		backToMain.setOnAction(e->{
			ancPane.getChildren().clear();
			qH = new QuestionHandler();
			setMainMenu(ancPane,"");
		});
		//add nodes to anchor Pane
		//qIdLbl
		ancPane.setTopAnchor(qIdLbl, 20.0);
		ancPane.setLeftAnchor(qIdLbl, 25.0);
		ancPane.getChildren().add(qIdLbl);
		
		//qIdTextField
		ancPane.setTopAnchor(qIdTextField, 40.0);
		ancPane.setLeftAnchor(qIdTextField, 25.0);
		ancPane.getChildren().add(qIdTextField);
		
		//qIdLbl
		ancPane.setTopAnchor(qTxtBox, 65.0);
		ancPane.setLeftAnchor(qTxtBox, 25.0);
		ancPane.getChildren().add(qTxtBox);
		
		//qIdTextField
		ancPane.setTopAnchor(qTxt, 85.0);
		ancPane.setLeftAnchor(qTxt, 25.0);
		ancPane.getChildren().add(qTxt);
		
		//numChoicesLbl
		ancPane.setTopAnchor(numChoicesLbl, 185.0);
		ancPane.setLeftAnchor(numChoicesLbl, 25.0);
		ancPane.getChildren().add(numChoicesLbl);
		
		//numChoicesTxtBox
		ancPane.setTopAnchor(numChoicesTxtBox, 200.0);
		ancPane.setLeftAnchor(numChoicesTxtBox, 25.0);
		ancPane.getChildren().add(numChoicesTxtBox);
		
		//genChoices
		ancPane.setTopAnchor(genChoices, 200.0);
		ancPane.setLeftAnchor(genChoices, 55.0);
		ancPane.getChildren().add(genChoices);
		
		//genChoices
		ancPane.setTopAnchor(feedBack, 225.0);
		ancPane.setLeftAnchor(feedBack, 25.0);
		ancPane.getChildren().add(feedBack);
		
		//gPane
		ancPane.setTopAnchor(gPane, 250.0);
		ancPane.setLeftAnchor(gPane, 25.0);
		ancPane.getChildren().add(gPane);
		
		//Save question button
		ancPane.setTopAnchor(saveQ, 420.0);
		ancPane.setLeftAnchor(saveQ, 375.0);
		ancPane.getChildren().add(saveQ);
		
		//main menu button
		ancPane.setTopAnchor(backToMain, 420.0);
		ancPane.setLeftAnchor(backToMain, 290.0);
		ancPane.getChildren().add(backToMain);
		
		//radioLabel label
		ancPane.setTopAnchor(RadionInstruction, 275.0);
		ancPane.setLeftAnchor(RadionInstruction, 200.0);
		ancPane.getChildren().add(RadionInstruction);
	}
	public static void main(String[] args) {
		launch(args);

	}

}
