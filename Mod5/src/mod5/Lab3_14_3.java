/**
 * Lab_5.3 exercise 14.3 
 * CSC 1302 M-W 11:00-3:50
 * Menelio Alvarez 
 * 7/5/2018
 * */
package mod5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Lab3_14_3 extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		//Grid Pane
		GridPane gPane = new GridPane();
		//Randomly select card, use it create Image & ImageView objects, then set them in pain 
		gPane.add(new ImageView(new Image("assets/card/"+( (int) ((Math.random()*51)+1) )+".png")), 0, 0);
		gPane.add(new ImageView(new Image("assets/card/"+( (int) ((Math.random()*51)+1) )+".png")), 1, 0);
		gPane.add(new ImageView(new Image("assets/card/"+( (int) ((Math.random()*51)+1) )+".png")), 2, 0);
		//setScene and stage
		Scene scene = new Scene(gPane);
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
