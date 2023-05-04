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

public class DocumentaryMenu {
	static Scene documentaryMenuScene(Stage primaryStage)
	{
		Text text = new Text("Documentary Menu");
		Button btnCreateDocumentary = new Button("Create Documentary");
		Button btnReadDocumentary = new Button("Read Documentary");
		Button btnUpdateDocumentary = new Button("Update Documentary");
		Button btnDeleteDocumentary = new Button("Delete Documentary");
		Button btnBack = new Button("Back");
		
		text.setFont(new Font(30));
		
		btnCreateDocumentary.setMinWidth(150);
		btnCreateDocumentary.setMinHeight(50);
		btnCreateDocumentary.setOnAction(e ->{
			Scene scene = DocumentaryCreate.documentaryCreateScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		btnReadDocumentary.setMinWidth(150);
		btnReadDocumentary.setMinHeight(50);
		
		btnUpdateDocumentary.setMinWidth(150);
		btnUpdateDocumentary.setMinHeight(50);
		
		btnDeleteDocumentary.setMinWidth(150);
		btnDeleteDocumentary.setMinHeight(50);
		
		btnBack.setMinWidth(150);
		btnBack.setMinHeight(50);
		
		btnBack.setOnAction(e ->{
			Scene scene = MainMenu.mainMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		
		
		btnReadDocumentary.setOnAction(e ->{
			Scene scene = ViewStudents.viewStudentScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		
		
		
		
		VBox vbox = new VBox(text, btnCreateDocumentary, btnReadDocumentary, btnUpdateDocumentary, btnDeleteDocumentary, btnBack);
	
		vbox.setSpacing(50);
		
		vbox.setAlignment(Pos.CENTER);
		
		Scene documentaryMenuScene = new Scene(vbox, 600, 600);
		
		
		return documentaryMenuScene;
	
	}

}
