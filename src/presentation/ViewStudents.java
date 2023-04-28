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
		
		
		
		Button btnSubmit = new Button("Submit");
		btnSubmit.setMinWidth(100);
		btnSubmit.setMinHeight(40);
		
		Text textStudentDetails = new Text();
		textStudentDetails.setFont(new Font(15));
		
		
		
		btnSubmit.setOnAction(e -> {
			int broncoId = Integer.valueOf(textField.getText());
			String student = String.valueOf(StudentDataAccess.getStudent(broncoId));
			textStudentDetails.setText(student);
		});
		
		HBox hbox = new HBox(lbl, textField);
		
		VBox vbox = new VBox(title, hbox, btnSubmit, textStudentDetails);
		
		vbox.setMargin(hbox,  new Insets(0, 0, 0, 170));
		
		vbox.setAlignment(Pos.CENTER);
		
		vbox.setSpacing(30);
		
		Scene scene = new Scene(vbox, 600, 600);
		
		return scene;
		
	
	}
	

}
