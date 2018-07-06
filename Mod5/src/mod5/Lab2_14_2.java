/**
 * Lab_5.2 exercise 14.2 
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

public class Lab2_14_2 extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		//GridPane
		GridPane gPane = new GridPane();
		
		gPane.setGridLinesVisible(true);
		//Scene
		Scene scene = new Scene(gPane);
		
		//Xs and Os images and views
		Image X = new Image("assets/X.jpg");
		Image O = new Image("assets/O.jpg");
		//randomly set rows and columns
		for(int i=0; i<3;i++) {
			for(int j=0; j<3;j++) {
				if(Math.random() > .5) {
					gPane.add(new ImageView(X), i, j);
				}else {
					gPane.add(new ImageView(O), i, j);
				}
			}
		}
		
		
		//set scene and show
		stage.setScene(scene);
		stage.show();
		
		
	}
	
	public static void main(String args[]) {
		launch(args);
	}
}
