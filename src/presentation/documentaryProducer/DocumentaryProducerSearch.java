package presentation.documentaryProducer;

import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button; 
import javafx.stage.Stage;
import persistence.DocumentaryProducerAccess;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class DocumentaryProducerSearch {
	
	public static Scene documentaryProducerSearchScene(Stage primaryStage)
	{
		Text title= new Text("Producer Search");
		title.setFont(new Font(30));
		
		Label lbl = new Label("Enter Producer ID: ");
		
		TextField textField = new TextField();
		
		Button btnBack = new Button("Back");
		btnBack.setMinWidth(100);
		btnBack.setMinHeight(40);
		
		Button btnSearch = new Button("Submit");
		btnSearch.setMinWidth(100);
		btnSearch.setMinHeight(40);
		
		Text textDocumentaryDetails = new Text();
		textDocumentaryDetails.setFont(new Font(15));
		
		
		
		btnSearch.setOnAction(e -> {
			int id = Integer.valueOf(textField.getText());
			String producer = String.valueOf(DocumentaryProducerAccess.getdocumentaryProducer(id));
			textDocumentaryDetails.setText(producer);
		});
		
		btnBack.setOnAction(e ->{
			Scene scene = DocumentaryProducerMenu.documentaryProducerMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		HBox hbox1 = new HBox(lbl, textField);
		
		HBox hbox2 = new HBox(btnBack, btnSearch);
		hbox2.setSpacing(50);
		
		VBox vbox = new VBox(title, hbox1, hbox2, textDocumentaryDetails);
		
		vbox.setMargin(hbox1,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox2,  new Insets(0, 0, 0, 170));
		
		vbox.setAlignment(Pos.CENTER);
		
		vbox.setSpacing(30);
		
		Scene scene = new Scene(vbox, 600, 600);
		
		return scene;
		
	
	}
	

}
