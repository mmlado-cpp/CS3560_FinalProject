package presentation.mainMenu;
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
import presentation.book.BookMenu;
import presentation.documentary.DocumentaryMenu;
import presentation.mainMenu.MainMenu;
import presentation.student.StudentRegistration;

public class ItemMenu {
	static Scene itemMenuScene(Stage primaryStage)
	{
		Text text = new Text("Item Menu");
		
		
		Button btnBook = new Button("Book");
		Button btnDocuementary = new Button("Documentary");
		Button btnBack = new Button("Back");
		
		text.setFont(new Font(30));
		
		btnBook.setMinWidth(150);
		btnBook.setMinHeight(50);
		
		btnDocuementary.setMinWidth(150);
		btnDocuementary.setMinHeight(50);
		
		btnBack.setMinWidth(150);
		btnBack.setMinHeight(50);
		
		btnBack.setOnAction(e ->{
			Scene scene = MainMenu.mainMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		btnBook.setOnAction(e ->{
			Scene scene = BookMenu.bookMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		btnDocuementary.setOnAction(e ->{
			Scene scene = DocumentaryMenu.documentaryMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		
		
		
		
		VBox vbox = new VBox(text, btnBook, btnDocuementary, btnBack);
	
		vbox.setSpacing(50);
		
		vbox.setAlignment(Pos.CENTER);
		
		Scene itemMenuScene = new Scene(vbox, 600, 600);
		
		
		return itemMenuScene;
	
	}

}
