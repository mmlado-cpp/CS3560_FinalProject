package presentation.documentary;
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
import presentation.documentaryProducer.DocumentaryProducerMenu;
import presentation.mainMenu.MainMenu;
import presentation.student.StudentRegistration;

public class DocumentaryMenu {
	public static Scene documentaryMenuScene(Stage primaryStage)
	{
		Text text = new Text("Documentary Menu");
		Button btnCreateDocumentary = new Button("Create Documentary");
		Button btnReadDocumentary = new Button("Read Documentary");
		Button btnUpdateDocumentary = new Button("Update Documentary");
		Button btnDeleteDocumentary = new Button("Delete Documentary");
		Button btnProducer = new Button("Manage Producers");
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
		btnReadDocumentary.setOnAction(e ->{
			Scene scene = DocumentarySearch.documentarySearchScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		btnUpdateDocumentary.setMinWidth(150);
		btnUpdateDocumentary.setMinHeight(50);
		btnUpdateDocumentary.setOnAction(e ->{
			Scene scene = DocumentaryUpdate.documentaryUpdateScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		btnDeleteDocumentary.setMinWidth(150);
		btnDeleteDocumentary.setMinHeight(50);
		btnDeleteDocumentary.setOnAction(e ->{
			Scene scene = DocumentaryDelete.deleteDocumentaryScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		btnProducer.setMinWidth(150);
		btnProducer.setMinHeight(50);
		btnProducer.setOnAction(e ->{
			Scene scene = DocumentaryProducerMenu.documentaryProducerMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		btnBack.setMinWidth(150);
		btnBack.setMinHeight(50);
		
		btnBack.setOnAction(e ->{
			Scene scene = MainMenu.mainMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		
		VBox vbox = new VBox(text, btnCreateDocumentary, btnReadDocumentary, btnUpdateDocumentary, btnDeleteDocumentary, btnProducer,btnBack);
	
		vbox.setSpacing(40);
		
		vbox.setAlignment(Pos.CENTER);
		
		Scene documentaryMenuScene = new Scene(vbox, 600, 600);
		
		
		return documentaryMenuScene;
	
	}

}
