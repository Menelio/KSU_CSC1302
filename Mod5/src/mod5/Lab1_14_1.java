/**
 * Lab_5.1 exercise 14.1 
 * CSC 1302 M-W 11:00-3:50
 * Menelio Alvarez 
 * 7/5/2018
 * */
package mod5;
import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Lab1_14_1 extends Application  {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		//create image & imageView objects from files
		//U.K. flag image & imageView
		Image uk = new Image("assets/uk.jpg");
		ImageView ukV = new ImageView(uk);
		//Canada image & imageView
		Image canada = new Image("assets/canada.jpg");
		ImageView canadaV = new ImageView(canada);
		
		//China image & imageView
		Image china = new Image("assets/china.jpg");
		ImageView chinaV = new ImageView(china);
		//U.S.A. image & imageView
		Image usa = new Image("assets/usa.jpg");
		ImageView usaV = new ImageView(usa);
		
		//gridPane
		GridPane gPane = new GridPane();
		//add imageviews to gridPane
		gPane.add(ukV, 0, 0);
		gPane.add(canadaV, 1, 0);
		gPane.add(chinaV, 0, 1);
		gPane.add(usaV, 1, 1);
		
		//Scene & set stage to show
		Scene scene = new Scene(gPane);
		stage.setScene(scene);
		stage.show();
	}

}
