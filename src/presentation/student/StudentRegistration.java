package presentation.student;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.stage.Stage;
import persistence.StudentDataAccess;
import presentation.student.StudentMenu;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class StudentRegistration {
	static Scene studentRegistrationScene(Stage primaryStage){
		Text text = new Text("Create Student");
		
		Label broncoIdLbl = new Label("Enter BroncoID: ");
		Label studentNameLbl = new Label("Enter Student Name: ");
		Label studentCourseLbl = new Label("Enter Student Course: ");
		Label studentEmailLbl = new Label("Email: ");
		
		TextField broncoIdTxtField = new TextField();
		TextField studentNameTxtField = new TextField();
		TextField studentCourseTxtField= new TextField();
		TextField studentEmailTxtField = new TextField();
		
		
		HBox hbox1 = new HBox(broncoIdLbl, broncoIdTxtField);
		HBox hbox2 = new HBox(studentNameLbl, studentNameTxtField);
		HBox hbox3 = new HBox(studentCourseLbl, studentCourseTxtField);
		HBox hbox4 = new HBox(studentEmailLbl, studentEmailTxtField);
		
		hbox1.setSpacing(55);
		hbox2.setSpacing(27);
		hbox3.setSpacing(25);
		hbox4.setSpacing(108);
		
		Button btnCreateStudent = new Button("Create Student");
		Button btnBack = new Button("Back");
		
		HBox hbox5 = new HBox(btnBack, btnCreateStudent);
		hbox5.setSpacing(50);
	
		text.setFont(new Font(30));
		
		btnCreateStudent.setMinWidth(100);
		btnCreateStudent.setMinHeight(40);
		
		btnBack.setMinWidth(100);
		btnBack.setMinHeight(40);
		
		btnCreateStudent.setOnAction(e ->{
			int broncoId = Integer.valueOf(broncoIdTxtField.getText());
			String name = studentNameTxtField.getText();
			String course = studentCourseTxtField.getText();
			String email = studentEmailTxtField.getText();			
			boolean createdStudent = StudentDataAccess.createStudent(broncoId, name, course, email);
			showCreatedAlert(createdStudent, name);
		});
		
		btnBack.setOnAction(e ->{
			Scene scene = StudentMenu.studentMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		VBox vbox = new VBox(text, hbox1, hbox2, hbox3, hbox4, hbox5);
	
		vbox.setSpacing(50);
		vbox.setMargin(hbox1,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox2,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox3,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox4,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox5,  new Insets(0, 0, 0, 170));
		vbox.setAlignment(Pos.CENTER);
		
		Scene studentRegistrationScene = new Scene(vbox, 600, 600);
		
		
		return studentRegistrationScene;
	}
	
	private static void showCreatedAlert(boolean createdStudent, String name) {
		if(createdStudent)
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Student Added!");
			alert.setContentText(name + " is added into the system!");
			alert.showAndWait();
		}
		else
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Error!");
			alert.setContentText("There was a problem with adding the student into the system.");
			alert.showAndWait();
		}
	}
}


