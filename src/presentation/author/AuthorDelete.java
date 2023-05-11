package presentation.author;

import javafx.scene.Scene;
import domain.Student;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.stage.Stage;
import persistence.AuthorDataAccess;
import persistence.DocumentaryProducerAccess;
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

public class AuthorDelete{
	
	static Scene deleteAuthorScene(Stage primaryStage)
	{
		Text title= new Text("Delete Author");
		title.setFont(new Font(30));
		
		Label lblId = new Label("Enter Id: ");
		
		TextField textField = new TextField();
		
		Button btnBack = new Button("Back");
		btnBack.setMinWidth(100);
		btnBack.setMinHeight(40);
		btnBack.setOnAction(e ->{
			Scene scene = AuthorMenu.authorMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		Button btnDelete = new Button("Delete");
		btnDelete.setMinWidth(100);
		btnDelete.setMinHeight(40);
		
		Text textProducerDetails = new Text();
		textProducerDetails.setFont(new Font(15));
		
		btnDelete.setOnAction(e -> {
			int id = Integer.valueOf(textField.getText());
			boolean producerDeleted = AuthorDataAccess.deleteAuthor(id);
			showDeletedAlert(producerDeleted, id);
		});
		
		
		
		HBox hbox1 = new HBox(lblId, textField);
		
		HBox hbox2 = new HBox(btnBack, btnDelete);
		hbox2.setSpacing(50);
		
		VBox vbox = new VBox(title, hbox1, hbox2, textProducerDetails);
		
		vbox.setMargin(hbox1,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox2,  new Insets(0, 0, 0, 170));
		
		vbox.setAlignment(Pos.CENTER);
		
		vbox.setSpacing(30);
		
		Scene scene = new Scene(vbox, 600, 600);
		
		return scene;
	}
	
	private static void showDeletedAlert(boolean deletedProducer, int id) {
		if(deletedProducer)
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Student Deleted!");
			alert.setContentText("Producer with Id " + id + " is deleted!");
			alert.showAndWait();
		}
		else
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Error!");
			alert.setContentText("There was a problem with deleting the producer");
			alert.showAndWait();
		}
	}
	
}