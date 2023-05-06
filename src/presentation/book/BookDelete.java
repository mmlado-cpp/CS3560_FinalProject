package presentation.book;

import javafx.scene.Scene;
import domain.Book;
import domain.Documentary;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.stage.Stage;
import persistence.BookDataAccess;
import persistence.DocumentaryAccess;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import presentation.DocumentaryMenu;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class BookDelete {
	
	static Scene bookDeleteScene(Stage primaryStage)
	{
		Text title= new Text("Delete Book");
		title.setFont(new Font(30));
		
		Label lblCode = new Label("Enter Book Code: ");
		
		TextField textField = new TextField();
		
		Button btnBack = new Button("Back");
		btnBack.setMinWidth(100);
		btnBack.setMinHeight(40);
		
		Button btnDelete = new Button("Delete");
		btnDelete.setMinWidth(100);
		btnDelete.setMinHeight(40);
		
		Text textDocumentaryDetails = new Text();
		textDocumentaryDetails.setFont(new Font(15));
		
		btnDelete.setOnAction(e -> {
			int code = Integer.valueOf(textField.getText());
			boolean bookDeleted = (BookDataAccess.deleteBook(code) != null);
			showDeletedAlert(bookDeleted, code);
		});
		
		btnBack.setOnAction(e ->{
			Scene scene = BookMenu.bookMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		HBox hbox1 = new HBox(lblCode, textField);
		
		HBox hbox2 = new HBox(btnBack, btnDelete);
		hbox2.setSpacing(50);
		
		VBox vbox = new VBox(title, hbox1, hbox2, textDocumentaryDetails);
		
		vbox.setMargin(hbox1,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox2,  new Insets(0, 0, 0, 170));
		
		vbox.setAlignment(Pos.CENTER);
		
		vbox.setSpacing(30);
		
		Scene scene = new Scene(vbox, 600, 600);
		
		return scene;
	}
	
	private static void showDeletedAlert(boolean deletedBook, int code) {
		if(deletedBook)
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Book Deleted!");
			alert.setContentText("Book with code " + code + " is deleted!");
			alert.showAndWait();
		}
		else
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Error!");
			alert.setContentText("There was a problem with deleting the book");
			alert.showAndWait();
		}
	}
	
}