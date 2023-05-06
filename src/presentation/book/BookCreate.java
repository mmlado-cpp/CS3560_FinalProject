package presentation.book;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import persistence.BookDataAccess;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class BookCreate {
	static Scene bookCreateScene(Stage primaryStage){
		Text text = new Text("Create Book");

		Label titleLbl = new Label("Enter Book Title: ");
		Label descLbl = new Label("Enter Book Description: ");
		Label locationLbl = new Label("Enter Book Location: ");
		Label dailyPriceLbl = new Label("Enter Daily Price: ");

		Label lengthLbl = new Label("Enter Number of Pages: ");
		Label publisherLbl = new Label("Enter Publisher: ");
		Label releaseDate = new Label("Enter Publication Date: ");
		Label statusLbl = new Label("Enter Status: ");

		TextField titleTxtField = new TextField();
		TextField descTxtField = new TextField();
		TextField locationTxtField = new TextField();
		TextField dailyPriceTxtField = new TextField();
		TextField lengthTxtField = new TextField();
		TextField publisherTxtField = new TextField();
		TextField releaseDateTxtField = new TextField();
		TextField statusTxtField= new TextField();

		VBox labelVBox = new VBox(titleLbl, descLbl, locationLbl, dailyPriceLbl, lengthLbl, publisherLbl, releaseDate, statusLbl);
		labelVBox.setSpacing(14);
		VBox inputVBox = new VBox(titleTxtField, descTxtField, locationTxtField, dailyPriceTxtField, lengthTxtField, publisherTxtField, releaseDateTxtField, statusTxtField);
		inputVBox.setSpacing(6);

		Button btnCreateBook = new Button("Create Book");
		Button btnBack = new Button("Back");

		HBox hbox0 = new HBox(btnBack, btnCreateBook);
		hbox0.setSpacing(50);

		text.setFont(new Font(30));

		btnCreateBook.setMinWidth(100);
		btnCreateBook.setMinHeight(40);


		btnBack.setMinWidth(100);
		btnBack.setMinHeight(40);

		btnCreateBook.setOnAction(e ->{
			String title = titleTxtField.getText();
			String description = descTxtField.getText();
			String location = locationTxtField.getText();
			double dailyPrice = Double.valueOf(dailyPriceTxtField.getText());
			int length = Integer.valueOf(lengthTxtField.getText());
			String publisher = publisherTxtField.getText();
			String release = releaseDateTxtField.getText(); //TODO: parse Date
			Boolean status = Boolean.valueOf(statusTxtField.getText());

			boolean createdBook = BookDataAccess.createBook(status, title, description, location, dailyPrice, length, null, publisher, null);
			showSubmittedAlert(createdBook, title);
		});

		btnBack.setOnAction(e ->{
			Scene scene = BookMenu.bookMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});

		HBox inputFields = new HBox(labelVBox, inputVBox);
		VBox vbox = new VBox(text, inputFields, hbox0);

		vbox.setSpacing(15);
		vbox.setAlignment(Pos.CENTER);

		Scene bookCreateScene = new Scene(vbox, 600, 600);


		return bookCreateScene;
	}

	private static void showSubmittedAlert(boolean createdBook, String title) {
		if(createdBook)
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Book Added!");
			alert.setContentText(title + " is added into the system!");
			alert.showAndWait();
		}
		else
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Error!");
			alert.setContentText("There was a problem with adding the book into the system.");
			alert.showAndWait();
		}
	}
}