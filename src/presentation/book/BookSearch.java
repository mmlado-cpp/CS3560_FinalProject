package presentation.book;

import javafx.scene.Scene;
import domain.Student;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.stage.Stage;
import persistence.BookDataAccess;
import persistence.DocumentaryAccess;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class BookSearch {
	
	static Scene bookSearchScene(Stage primaryStage)
	{
		Text title= new Text("Book Search");
		title.setFont(new Font(30));
		
		Label lbl = new Label("Enter Book Code: ");
		
		TextField textField = new TextField();
		
		Button btnBack = new Button("Back");
		btnBack.setMinWidth(100);
		btnBack.setMinHeight(40);
		
		Button btnSearch = new Button("Submit");
		btnSearch.setMinWidth(100);
		btnSearch.setMinHeight(40);
		
		Text textBookDetails = new Text();
		textBookDetails.setFont(new Font(15));
		
		
		
		btnSearch.setOnAction(e -> {
			int code = Integer.valueOf(textField.getText());
			String documentary = String.valueOf(BookDataAccess.getBook(code));
			textBookDetails.setText(documentary);
		});
		
		btnBack.setOnAction(e ->{
			Scene scene = BookMenu.bookMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		HBox hbox1 = new HBox(lbl, textField);
		
		HBox hbox2 = new HBox(btnBack, btnSearch);
		hbox2.setSpacing(50);
		
		VBox vbox = new VBox(title, hbox1, hbox2, textBookDetails);
		
		vbox.setMargin(hbox1,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox2,  new Insets(0, 0, 0, 170));
		
		vbox.setAlignment(Pos.CENTER);
		
		vbox.setSpacing(30);
		
		Scene scene = new Scene(vbox, 600, 600);
		
		return scene;
		
	
	}
	

}
