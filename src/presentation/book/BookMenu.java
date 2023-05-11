package presentation.book;
import javafx.scene.control.Button; 
import javafx.stage.Stage;
import presentation.author.AuthorMenu;
import presentation.documentaryProducer.DocumentaryProducerMenu;
import presentation.mainMenu.MainMenu;
import presentation.student.ViewStudents;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

public class BookMenu {
	public static Scene bookMenuScene(Stage primaryStage)
	{
		Text text = new Text("Book Menu");
		Button btnCreateBook = new Button("Create Book");
		Button btnReadBook = new Button("Read Book");
		Button btnUpdateBook = new Button("Update Book");
		Button btnDeleteBook = new Button("Delete Book");
		Button btnAuthor = new Button("Manage Authors");
		Button btnBack = new Button("Back");

		text.setFont(new Font(30));

		btnCreateBook.setMinWidth(150);
		btnCreateBook.setMinHeight(50);
		btnCreateBook.setOnAction(e ->{
			Scene scene = BookCreate.bookCreateScene(primaryStage);
			primaryStage.setScene(scene);
		});

		btnReadBook.setMinWidth(150);
		btnReadBook.setMinHeight(50);
		btnReadBook.setOnAction(e ->{
			Scene scene = BookSearch.bookSearchScene(primaryStage);
			primaryStage.setScene(scene);
		});

		btnUpdateBook.setMinWidth(150);
		btnUpdateBook.setMinHeight(50);
		btnUpdateBook.setOnAction(e ->{
			Scene scene = BookUpdate.bookUpdateScene(primaryStage);
			primaryStage.setScene(scene);
		});


		btnDeleteBook.setMinWidth(150);
		btnDeleteBook.setMinHeight(50);
		btnDeleteBook.setOnAction(e ->{
			Scene scene = BookDelete.bookDeleteScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		btnAuthor.setMinWidth(150);
		btnAuthor.setMinHeight(50);
		btnAuthor.setOnAction(e ->{
			Scene scene = AuthorMenu.authorMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});

		btnBack.setMinWidth(150);
		btnBack.setMinHeight(50);
		btnBack.setOnAction(e ->{
			Scene scene = MainMenu.mainMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});

		VBox vbox = new VBox(text, btnCreateBook, btnReadBook, btnUpdateBook, btnDeleteBook, btnAuthor, btnBack);

		vbox.setSpacing(40);

		vbox.setAlignment(Pos.CENTER);

		Scene documentaryMenuScene = new Scene(vbox, 600, 600);


		return documentaryMenuScene;

	}

}