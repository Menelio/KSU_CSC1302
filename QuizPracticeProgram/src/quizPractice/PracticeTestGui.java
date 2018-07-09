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
	QuestionHandler qH = new QuestionHandler();
	//question index
	int questionIndex=0;
	@Override
	public void start(Stage stage) throws Exception {	
		//Anchor Pane
		AnchorPane ancPane = new AnchorPane();
		
		//test
		setMainMenu(ancPane);
		//scene
		Scene scene = new Scene(ancPane);
		
		//set scene and show
		stage.setScene(scene);
		stage.setMinHeight(500);
		stage.setMinWidth(500);
		stage.show();
		

	}
	//Method for setting up the Main menu in the AnchorPane
	public void setMainMenu(AnchorPane ancPane) {
		
		
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
		
		//add nodes to ancPane
		ancPane.getChildren().add(menuTitle);
		ancPane.getChildren().add(takeTest);
		ancPane.getChildren().add(addQuistion);
		
		//Set up events for buttons
		takeTest.setOnAction(e->{
			//clear all nodes from ancPane
			ancPane.getChildren().clear();
			//set up Test gui
			TestGui(ancPane);
		});
		addQuistion.setOnAction(e->{
			//clear all nodes from ancPane
			ancPane.getChildren().clear();
			//set up add question gui
			createQuestion(ancPane);
		});
	}
	public  void TestGui(AnchorPane ancPane) {
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
		check.setText("\nThis is just a test correct");
		gPane.add(check, 0, (choices.length+1));
		
		//Button to check
		Button checkBtn = new Button("CheckButn");
		//Button to move to next question
		Button nxtQuestion = new Button("Next Question");
		
		//check Button event
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
		checkBtn.setOnAction(e->{
			System.out.println(choicesToggleG.getSelectedToggle());
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
		ancPane.setRightAnchor(checkBtn, 125.0);
		ancPane.getChildren().add(checkBtn);
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
		
		//grid pane to hold text Boxes for choices
		GridPane gPane = new GridPane();
		
		//genChoices button event
		genChoices.setOnAction(e->{
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
				}else {
					for(int i=0; i< numberOfChoices;i++) {
						choicesTxt.add(new TextField()); 
					}
				}
			//populate gPane with choice TextField
				for(int i=0; i<choicesTxt.size();i++) {
					gPane.add(choicesTxt.get(i), 0, i);
				}
			}catch(NumberFormatException E){
				feedBack.setText("You must enter a number");
			}
		});
		//Save Question Button
		Button saveQ = new Button("Save Question");
		
		
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
				
	}
	public static void main(String[] args) {
		launch(args);

	}

}
