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

public class BookMenu {
	static Scene bookMenuScene(Stage primaryStage)
	{
		Text text = new Text("Book Menu");
		Button btnCreateBook = new Button("Create Book");
		Button btnReadBook = new Button("Read Book");
		Button btnUpdateBook = new Button("Update Book");
		Button btnDeleteBook = new Button("Delete Book");
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

		btnUpdateBook.setMinWidth(150);
		btnUpdateBook.setMinHeight(50);

		btnDeleteBook.setMinWidth(150);
		btnDeleteBook.setMinHeight(50);

		btnBack.setMinWidth(150);
		btnBack.setMinHeight(50);

		btnBack.setOnAction(e ->{
			Scene scene = MainMenu.mainMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});



		btnReadBook.setOnAction(e ->{
			Scene scene = ViewStudents.viewStudentScene(primaryStage);
			primaryStage.setScene(scene);
		});





		VBox vbox = new VBox(text, btnCreateBook, btnReadBook, btnUpdateBook, btnDeleteBook, btnBack);

		vbox.setSpacing(50);

		vbox.setAlignment(Pos.CENTER);

		Scene documentaryMenuScene = new Scene(vbox, 600, 600);


		return documentaryMenuScene;

	}

}