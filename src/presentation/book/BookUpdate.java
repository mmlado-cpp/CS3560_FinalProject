package presentation.book;

import java.util.Date;
import java.util.List;

import domain.Author;
import domain.Book;
import domain.Documentary;
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
import persistence.DocumentaryAccess;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class BookUpdate {
	static Scene bookUpdateScene(Stage primaryStage)
	{
		Text title= new Text("Update Book");
		title.setFont(new Font(30));
		
		Label lbl = new Label("Enter Book Code: ");
		
		TextField textField = new TextField();
		
		Button btnBack = new Button("Back");
		btnBack.setMinWidth(100);
		btnBack.setMinHeight(40);
		
		Button btnSubmit = new Button("Submit");
		btnSubmit.setMinWidth(100);
		btnSubmit.setMinHeight(40);
		
		Text textDocumentaryDetails = new Text();
		textDocumentaryDetails.setFont(new Font(15));
		
		
		btnSubmit.setOnAction(e -> {
			int code = Integer.valueOf(textField.getText());
			Book book = BookDataAccess.getBook(code);
			Scene scene = updateBookScene2(primaryStage, book.getBookId(), /*book.getStatus(), documentary.getTitle(), documentary.getDescription(), documentary.getLocation(), documentary.getDailyPrice(),*/ 
					book.getNumberPages(), book.getAuthors(), book.getPublisher()/*, book.getPublicationDate()*/);
			primaryStage.setScene(scene);
		});
		
		btnBack.setOnAction(e ->{
			Scene scene = BookMenu.bookMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		HBox hbox1 = new HBox(lbl, textField);
		
		HBox hbox2 = new HBox(btnBack, btnSubmit);
		hbox2.setSpacing(50);
		
		VBox vbox = new VBox(title, hbox1, hbox2, textDocumentaryDetails);
		
		vbox.setMargin(hbox1,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox2,  new Insets(0, 0, 0, 170));
		
		vbox.setAlignment(Pos.CENTER);
		
		vbox.setSpacing(30);
		
		Scene scene = new Scene(vbox, 600, 600);
		
		return scene;
	}
	
	static Scene updateBookScene2(Stage primaryStage, int bookId, /*book.getStatus(), documentary.getTitle(), documentary.getDescription(), documentary.getLocation(), documentary.getDailyPrice(),*/ 
			int numberPages, List<Author> authors, String bookPublisher/*, Date publicationDate*/){
		Text text = new Text("Update Book");

		Label titleLbl = new Label("Enter Book Title: ");
		Label descLbl = new Label("Enter Book Description: ");
		Label locationLbl = new Label("Enter Book Location: ");
		Label dailyPriceLbl = new Label("Enter Daily Price: ");

		Label lengthLbl = new Label("Enter Number of Pages: ");
		Label publisherLbl = new Label("Enter Publisher: ");
		Label releaseDate = new Label("Enter Publication Date: ");
		Label statusLbl = new Label("Enter Status: ");

		TextField titleTxtField = new TextField();
		//titleTxtField.setText(String.valueOf(title));
		TextField descTxtField = new TextField();
		//TODO: .setText(String.valueOf(attribute));
		TextField locationTxtField = new TextField();
		//TODO: .setText(String.valueOf(attribute));
		TextField dailyPriceTxtField = new TextField();
		//TODO: .setText(String.valueOf(attribute));
		TextField lengthTxtField = new TextField();
		lengthTxtField.setText(String.valueOf(numberPages));
		TextField publisherTxtField = new TextField();
		publisherTxtField.setText(String.valueOf(bookPublisher));
		TextField releaseDateTxtField = new TextField();
		//TODO: lengthTxtField.setText(String.valueOf(publicationDate));
		TextField statusTxtField= new TextField();
		//TODO: lengthTxtField.setText(String.valueOf(status));

		VBox labelVBox = new VBox(titleLbl, descLbl, locationLbl, dailyPriceLbl, lengthLbl, publisherLbl, releaseDate, statusLbl);
		labelVBox.setSpacing(14);
		VBox inputVBox = new VBox(titleTxtField, descTxtField, locationTxtField, dailyPriceTxtField, lengthTxtField, publisherTxtField, releaseDateTxtField, statusTxtField);
		inputVBox.setSpacing(6);
		
		Button btnUpdateBook = new Button("Update Book");
		Button btnBack = new Button("Back");

		HBox hbox0 = new HBox(btnBack, btnUpdateBook);
		hbox0.setSpacing(50);

		text.setFont(new Font(30));

		btnUpdateBook.setMinWidth(100);
		btnUpdateBook.setMinHeight(40);


		btnBack.setMinWidth(100);
		btnBack.setMinHeight(40);

		btnUpdateBook.setOnAction(e ->{
			try {
				String title = titleTxtField.getText();
				String description = descTxtField.getText();
				String location = locationTxtField.getText();
				double dailyPrice = Double.valueOf(dailyPriceTxtField.getText());
				int length = Integer.valueOf(lengthTxtField.getText());
				String publisher = publisherTxtField.getText();
				String release = releaseDateTxtField.getText(); //TODO: parse Date
				Boolean status = Boolean.valueOf(statusTxtField.getText());
				boolean createdBook = BookDataAccess.updateBook(bookId, status, release, title, description, location, dailyPrice, length, authors, publisher, null);
				showSubmittedAlert(createdBook, bookId);
			} catch (Exception error) {
				showSubmittedAlert(false, -1);
			}
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

	private static void showSubmittedAlert(boolean createdBook, int bookId) {
		if(createdBook)
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Book Updated!");
			alert.setContentText("Book with id " + bookId + " is updated!");
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