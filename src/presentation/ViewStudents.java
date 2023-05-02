package presentation;

import javafx.scene.Scene;
import domain.Student;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.stage.Stage;
import persistence.StudentDataAccess;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import presentation.StudentMenu;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ViewStudents {
	
	static Scene viewStudentScene(Stage primaryStage)
	{
		Text title= new Text("View Student");
		title.setFont(new Font(30));
		
		Label lbl = new Label("Enter Bronco Id: ");
		
		TextField textField = new TextField();
		
		Button btnBack = new Button("Back");
		btnBack.setMinWidth(100);
		btnBack.setMinHeight(40);
		
		Button btnSearch = new Button("Submit");
		btnSearch.setMinWidth(100);
		btnSearch.setMinHeight(40);
		
		Text textStudentDetails = new Text();
		textStudentDetails.setFont(new Font(15));
		
		
		
		btnSearch.setOnAction(e -> {
			int broncoId = Integer.valueOf(textField.getText());
			String student = String.valueOf(StudentDataAccess.getStudent(broncoId));
			textStudentDetails.setText(student);
		});
		
		btnBack.setOnAction(e ->{
			Scene scene = StudentMenu.studentMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		HBox hbox1 = new HBox(lbl, textField);
		
		HBox hbox2 = new HBox(btnBack, btnSearch);
		hbox2.setSpacing(50);
		
		VBox vbox = new VBox(title, hbox1, hbox2, textStudentDetails);
		
		vbox.setMargin(hbox1,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox2,  new Insets(0, 0, 0, 170));
		
		vbox.setAlignment(Pos.CENTER);
		
		vbox.setSpacing(30);
		
		Scene scene = new Scene(vbox, 600, 600);
		
		return scene;
		
	
	}
	

}
