package presentation.author;
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
import presentation.documentary.DocumentaryCreate;
import presentation.documentary.DocumentaryDelete;
import presentation.documentary.DocumentaryMenu;
import presentation.documentary.DocumentarySearch;
import presentation.documentary.DocumentaryUpdate;
import presentation.mainMenu.MainMenu;
import presentation.student.StudentRegistration;

public class AuthorMenu {
	public static Scene authorMenuScene(Stage primaryStage)
	{
		Text text = new Text("Author Menu");
		Button btnCreateDocumentaryProducer = new Button("Create Author");
		Button btnReadDocumentaryProducer = new Button("Read Author");
		Button btnUpdateDocumentaryProducer = new Button("Update Author");
		Button btnDeleteDocumentaryProducer = new Button("Delete Author");
		Button btnBack = new Button("Back");
		
		text.setFont(new Font(30));
		
		btnCreateDocumentaryProducer.setMinWidth(150);
		btnCreateDocumentaryProducer.setMinHeight(50);
		btnCreateDocumentaryProducer.setOnAction(e ->{
			Scene scene = AuthorCreate.authorCreateScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		btnReadDocumentaryProducer.setMinWidth(150);
		btnReadDocumentaryProducer.setMinHeight(50);
		btnReadDocumentaryProducer.setOnAction(e ->{
			Scene scene = AuthorSearch.authorSearchScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		btnUpdateDocumentaryProducer.setMinWidth(150);
		btnUpdateDocumentaryProducer.setMinHeight(50);
		btnUpdateDocumentaryProducer.setOnAction(e ->{
			Scene scene = AuthorUpdate.updateAuthorScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		btnDeleteDocumentaryProducer.setMinWidth(150);
		btnDeleteDocumentaryProducer.setMinHeight(50);
		btnDeleteDocumentaryProducer.setOnAction(e ->{
			Scene scene = AuthorDelete.deleteAuthorScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		btnBack.setMinWidth(150);
		btnBack.setMinHeight(50);
		
		btnBack.setOnAction(e ->{
			Scene scene = MainMenu.mainMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		
		VBox vbox = new VBox(text, btnCreateDocumentaryProducer, btnReadDocumentaryProducer, btnUpdateDocumentaryProducer, btnDeleteDocumentaryProducer, btnBack);
	
		vbox.setSpacing(50);
		
		vbox.setAlignment(Pos.CENTER);
		
		Scene documentaryMenuScene = new Scene(vbox, 600, 600);
		
		
		return documentaryMenuScene;
	
	}

}
