package presentation;
import javafx.scene.control.Button; 
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import presentation.StudentRegistration;
import presentation.MainMenu;

public class StudentMenu {
	static Scene studentMenuScene(Stage primaryStage)
	{
		Text text = new Text("Student Menu");
		Button btnCreateStudent = new Button("Create Student");
		Button btnReadStudent = new Button("View Student");
		Button btnUpdateStudent = new Button("Update Student");
		Button btnDeleteStudent = new Button("Delete Student");
		Button btnBack = new Button("Back");
		
		text.setFont(new Font(30));
		
		btnCreateStudent.setMinWidth(150);
		btnCreateStudent.setMinHeight(50);
		
		btnReadStudent.setMinWidth(150);
		btnReadStudent.setMinHeight(50);
		
		btnUpdateStudent.setMinWidth(150);
		btnUpdateStudent.setMinHeight(50);
		
		btnDeleteStudent.setMinWidth(150);
		btnDeleteStudent.setMinHeight(50);
		
		btnBack.setMinWidth(150);
		btnBack.setMinHeight(50);
		
		btnBack.setOnAction(e ->{
			Scene scene = MainMenu.mainMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		btnCreateStudent.setOnAction(e ->{
			Scene scene = StudentRegistration.studentRegistrationScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		btnReadStudent.setOnAction(e ->{
			Scene scene = ViewStudents.viewStudentScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		btnUpdateStudent.setOnAction(e ->{
			Scene scene = UpdateStudents.updateStudentScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		btnDeleteStudent.setOnAction(e ->{
			Scene scene = DeleteStudents.deleteStudentScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		VBox vbox = new VBox(text, btnCreateStudent, btnReadStudent, btnUpdateStudent, btnDeleteStudent, btnBack);
	
		vbox.setSpacing(50);
		
		vbox.setAlignment(Pos.CENTER);
		
		Scene studentMenuScene = new Scene(vbox, 600, 600);
		
		
		return studentMenuScene;
	
	}

}
