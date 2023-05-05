package presentation;
import domain.Student;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import persistence.StudentDataAccess;

public class UpdateStudents {
	
	static Scene updateStudentScene(Stage primaryStage)
	{
		Text title= new Text("Update Student");
		title.setFont(new Font(30));
		
		Label lbl = new Label("Enter Bronco Id: ");
		
		TextField textField = new TextField();
		
		Button btnBack = new Button("Back");
		btnBack.setMinWidth(100);
		btnBack.setMinHeight(40);
		
		Button btnSubmit = new Button("Submit");
		btnSubmit.setMinWidth(100);
		btnSubmit.setMinHeight(40);
		
		Text textStudentDetails = new Text();
		textStudentDetails.setFont(new Font(15));
		
		
		
		btnSubmit.setOnAction(e -> {
			int broncoId = Integer.valueOf(textField.getText());
			Student student = StudentDataAccess.getStudent(broncoId);
			Scene scene = updateStudentScene2(primaryStage, student.getBroncoId(), student.getName(), student.getCourse(), student.getEmail());
			primaryStage.setScene(scene);
		});
		
		btnBack.setOnAction(e ->{
			Scene scene = StudentMenu.studentMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		HBox hbox1 = new HBox(lbl, textField);
		
		HBox hbox2 = new HBox(btnBack, btnSubmit);
		hbox2.setSpacing(50);
		
		VBox vbox = new VBox(title, hbox1, hbox2, textStudentDetails);
		
		vbox.setMargin(hbox1,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox2,  new Insets(0, 0, 0, 170));
		
		vbox.setAlignment(Pos.CENTER);
		
		vbox.setSpacing(30);
		
		Scene scene = new Scene(vbox, 600, 600);
		
		return scene;
	}
	
	static Scene updateStudentScene2(Stage primaryStage, int broncoId, String name, String course, String email)
	{
		Label studentNameLbl = new Label("Update Student Name: ");
		Label studentCourseLbl = new Label("Update Student Course: ");
		Label studentEmailLbl = new Label("Update Email: ");
		
		TextField studentNameTxtField = new TextField();
		studentNameTxtField.setText(String.valueOf(name));
		
		TextField studentCourseTxtField= new TextField();
		studentCourseTxtField.setText(String.valueOf(course));
		
		TextField studentEmailTxtField = new TextField();
		studentEmailTxtField.setText(String.valueOf(email));
		
		HBox hbox1 = new HBox(studentNameLbl, studentNameTxtField);
		HBox hbox2 = new HBox(studentCourseLbl, studentCourseTxtField);
		HBox hbox3 = new HBox(studentEmailLbl, studentEmailTxtField);
		
		hbox1.setSpacing(27);
		hbox2.setSpacing(18);
		hbox3.setSpacing(70);
		
		Button btnUpdateStudent = new Button("Update Student");
		Button btnBack = new Button("Back");
		
		HBox hbox4 = new HBox(btnBack, btnUpdateStudent);
		hbox4.setSpacing(50);
		
		btnUpdateStudent.setMinWidth(100);
		btnUpdateStudent.setMinHeight(40);
		
		btnBack.setMinWidth(100);
		btnBack.setMinHeight(40);
		
		btnUpdateStudent.setOnAction(e ->{
			String updatedName = studentNameTxtField.getText();
			String updatedCourse = studentCourseTxtField.getText();
			String updatedEmail = studentEmailTxtField.getText();			
			boolean updatedStudent = StudentDataAccess.updateStudent(broncoId, updatedName, updatedCourse, updatedEmail);
			showUpdatedAlert(updatedStudent, broncoId);
		});
		
		btnBack.setOnAction(e ->{
			Scene scene = StudentMenu.studentMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		VBox vbox = new VBox(hbox1, hbox2, hbox3, hbox4);
	
		vbox.setSpacing(50);
		vbox.setMargin(hbox1,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox2,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox3,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox4,  new Insets(0, 0, 0, 170));
		vbox.setAlignment(Pos.CENTER);
		
		Scene studentRegistrationScene = new Scene(vbox, 600, 600);
		
		
		return studentRegistrationScene;
	}
	
	private static void showUpdatedAlert(boolean createdStudent, int broncoId) {
		if(createdStudent)
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Student Updated!");
			alert.setContentText("Student with bronco id " + broncoId +" is updated!");
			alert.showAndWait();
		}
		else
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Error!");
			alert.setContentText("There was a problem with updating student with id " + broncoId);
			alert.showAndWait();
		}
	}
	

}