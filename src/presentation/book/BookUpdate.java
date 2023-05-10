package presentation.book;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import domain.Author;
import domain.Book;
import domain.Documentary;
import domain.DocumentaryProducer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import persistence.AuthorDataAccess;
import persistence.BookDataAccess;
import persistence.DocumentaryAccess;
import persistence.DocumentaryProducerAccess;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class BookUpdate {
	
	static List<Integer> authorIds;
	
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
			Scene scene = updateBookScene2(primaryStage, book.getItemId(), book.getIsAvailable(), book.getTitle(), book.getDescription(), book.getLocation(), book.getDailyPrice(),
					book.getNumberPages(), book.getPublisher(), book.getPublicationDate());
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
	
	static Scene updateBookScene2(Stage primaryStage, int id, boolean status, String title, String description, String location, double dailyPrice, int numberPages, 
			String bookPublisher, String publicationDate){
		Text text = new Text("Update Book");

		Label titleLbl = new Label("Enter Book Title: ");
		Label descLbl = new Label("Enter Book Description: ");
		Label locationLbl = new Label("Enter Book Location: ");
		Label dailyPriceLbl = new Label("Enter Daily Price: ");

		Label lengthLbl = new Label("Enter Number of Pages: ");
		Label publisherLbl = new Label("Enter Publisher: ");
		Label releaseDate = new Label("Enter Publication Date: ");
		Label statusLbl = new Label("Enter Status: ");
		Label authorLbl = new Label("Choose Author: ");

		TextField titleTxtField = new TextField();
		titleTxtField.setText(String.valueOf(title));
		
		TextField descTxtField = new TextField();
		descTxtField.setText(String.valueOf(description));
		
		TextField locationTxtField = new TextField();
		locationTxtField.setText(String.valueOf(location));
		
		TextField dailyPriceTxtField = new TextField();
		dailyPriceTxtField.setText(String.valueOf(dailyPrice));
		
		TextField lengthTxtField = new TextField();
		lengthTxtField.setText(String.valueOf(numberPages));
		
		TextField publisherTxtField = new TextField();
		publisherTxtField.setText(String.valueOf(bookPublisher));
		
		TextField releaseDateTxtField = new TextField();
		releaseDateTxtField.setText(String.valueOf(publicationDate));
		
		ComboBox<Boolean> statusComboBox = new ComboBox<Boolean>();
		statusComboBox.getItems().add(true);
		statusComboBox.getItems().add(false);
		statusComboBox.getSelectionModel().select(Boolean.valueOf(status));
		
		ComboBox<String> authorComboBox = new ComboBox<String>();
		
		RadioButton add = new RadioButton("Add");
        RadioButton remove = new RadioButton("Remove");
        
        ToggleGroup addRemoveGroup = new ToggleGroup();
        add.setToggleGroup(addRemoveGroup);
        remove.setToggleGroup(addRemoveGroup);
        addRemoveGroup.selectToggle(add);

		VBox labelVBox = new VBox(titleLbl, descLbl, locationLbl, dailyPriceLbl, lengthLbl, publisherLbl, releaseDate);
		labelVBox.setSpacing(14);
		VBox inputVBox = new VBox(titleTxtField, descTxtField, locationTxtField, dailyPriceTxtField, lengthTxtField, publisherTxtField, releaseDateTxtField);
		inputVBox.setSpacing(6);
		HBox statusHBox = new HBox(statusLbl, statusComboBox);
		HBox authorHBox = new HBox(authorLbl, authorComboBox, add, remove);
		
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
			String updated_title = titleTxtField.getText();
			String updated_description = descTxtField.getText();
			String updated_location = locationTxtField.getText();
			double updated_dailyPrice = Double.valueOf(dailyPriceTxtField.getText());
			int updated_length = Integer.valueOf(lengthTxtField.getText());
			String updated_publisher = publisherTxtField.getText();
			String updated_release = releaseDateTxtField.getText(); 
			Boolean updated_status = Boolean.valueOf(statusComboBox.getSelectionModel().getSelectedItem());
			
			int comboBoxIndex = authorComboBox.getSelectionModel().getSelectedIndex();
			int authorId = -1;
			int comboBoxSize = authorComboBox.getItems().size();
			
			if(comboBoxIndex < comboBoxSize - 1) {
				authorId = authorIds.get(comboBoxIndex);
			}
			
			boolean addAuthor = ((RadioButton) addRemoveGroup.getSelectedToggle()).getText().equalsIgnoreCase("Add") ? true : false;
			
			boolean createdBook = BookDataAccess.updateBook(id, updated_status, updated_title, updated_description, 
					updated_location, updated_dailyPrice, updated_length, updated_publisher, updated_release,
					authorId, addAuthor);
			showSubmittedAlert(createdBook, id);
			
			if(addAuthor) {
				authorIds = addAuthorToComboBox(authorComboBox, id);
			} else {
				authorIds = removeAuthorToComboBox(authorComboBox, id);
			}
		});

		btnBack.setOnAction(e ->{
			Scene scene = BookMenu.bookMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});

		HBox inputFields = new HBox(labelVBox, inputVBox);
		VBox vbox = new VBox(text, inputFields, statusHBox, authorHBox, hbox0);

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
	
	private static List<Integer> addAuthorToComboBox(ComboBox<String> comboBox, int bookId) {
		final List<Author> authors = AuthorDataAccess.getAllAuthors();
		final List<Integer> authorIds = BookDataAccess.getAuthorIds(bookId);
		final List<Integer> currentIdList = new ArrayList<Integer>();
		
		comboBox.getItems().clear();
		for(Author author : authors) {
			boolean notFound = true;
			for(int authorId : authorIds) {
				if(author.getAuthorId() == authorId) {
					notFound = false;
				}
			}
			
			if(notFound) {
				comboBox.getItems().add(author.getName());
				currentIdList.add(author.getAuthorId());
			}
		}
		comboBox.getItems().add("Do Nothing");
		comboBox.getSelectionModel().select("Do Nothing");
		
		return currentIdList;
	}
	
	private static List<Integer> removeAuthorToComboBox(ComboBox<String> comboBox, int bookId) {
		final List<Integer> authorIds = BookDataAccess.getAuthorIds(bookId);
		
		comboBox.getItems().clear();
		for(int authorId : authorIds) {
			comboBox.getItems().add(AuthorDataAccess.getAuthor(authorId).getName());
		}
		comboBox.getItems().add("Do Nothing");
		comboBox.getSelectionModel().select("Do Nothing");
		
		return authorIds;
	}
}