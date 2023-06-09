package presentation.documentaryProducer;

import java.util.List;

import domain.Documentary;
import domain.DocumentaryProducer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene; 
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import persistence.DocumentaryAccess;
import persistence.DocumentaryProducerAccess;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DocumentaryProducerCreate {
	static Scene documentaryProducerCreateScene(Stage primaryStage){
		Text text = new Text("Create Documentary Producer");
		
		Label idLbl = new Label("Choose documentary: ");
		Label nameLbl = new Label("Enter Name: ");
		Label emailLbl = new Label("Enter Email: ");
		Label styleLbl = new Label("Enter Style: ");
		Label nationalityLbl = new Label("Enter Nationality: ");
		
		
		ComboBox<String> documentariesComboBox = new ComboBox<>();
		//Add all documentary titles to the Combo box
		List<Documentary> docs = DocumentaryAccess.getAllDocumentaries();
		for(Documentary doc : docs) {
			documentariesComboBox.getItems().add(doc.getTitle());
		}
		
		documentariesComboBox.getItems().add("None");
		documentariesComboBox.getSelectionModel().selectLast();
		
		
		TextField nameTxtField = new TextField();
		TextField emailTxtField= new TextField();
		TextField styleTxtField= new TextField();
		TextField nationalityTxtField= new TextField();
		
		
		HBox hbox1 = new HBox(idLbl, documentariesComboBox);
		HBox hbox2 = new HBox(nameLbl, nameTxtField);
		HBox hbox3 = new HBox(emailLbl, emailTxtField);
		HBox hbox4 = new HBox(styleLbl, styleTxtField);
		HBox hbox5 = new HBox(nationalityLbl, nationalityTxtField);
		
		hbox1.setSpacing(30);
		hbox2.setSpacing(80);
		hbox3.setSpacing(80);
		hbox4.setSpacing(85);
		hbox5.setSpacing(50);
		
		Button btnCreateProducer = new Button("Create Documentary Producer");
		Button btnBack = new Button("Back");
		
		HBox hbox6 = new HBox(btnBack, btnCreateProducer);
		hbox5.setSpacing(50);
	
		text.setFont(new Font(30));
		
		btnCreateProducer.setMinWidth(100);
		btnCreateProducer.setMinHeight(40);
		
		btnBack.setMinWidth(100);
		btnBack.setMinHeight(40);
		
		btnCreateProducer.setOnAction(e ->{
			int documentaryChosenId = (documentariesComboBox.getSelectionModel().getSelectedIndex() < docs.size()) ? 
					docs.get(documentariesComboBox.getSelectionModel().getSelectedIndex()).getItemId() : -1;
			String name = nameTxtField.getText();
			String email = emailTxtField.getText();
			String style = styleTxtField.getText();
			String nationality = nationalityTxtField.getText();
			
			DocumentaryProducer tempProducer = DocumentaryProducerAccess.createDocumentaryProducer(name, email, style, nationality, documentaryChosenId);
			
			boolean createdProducer = (tempProducer != null);
			showCreatedAlert(createdProducer, name);
		});
		
		btnBack.setOnAction(e ->{
			Scene scene = DocumentaryProducerMenu.documentaryProducerMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		VBox vbox = new VBox(text, hbox1, hbox2, hbox3, hbox4, hbox5, hbox6);
	
		vbox.setSpacing(50);
		vbox.setMargin(hbox1,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox2,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox3,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox4,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox5,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox6,  new Insets(0, 0, 0, 170));
		vbox.setAlignment(Pos.CENTER);
		
		Scene documentaryProducerCreateScene = new Scene(vbox, 600, 600);
		
		
		return documentaryProducerCreateScene;
	}
	
	private static void showCreatedAlert(boolean createdProducer, String name) {
		if(createdProducer)
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Producer Added!");
			alert.setContentText(name + " is added into the system!");
			alert.showAndWait();
		}
		else
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Error!");
			alert.setContentText("There was a problem with adding the producer into the system.");
			alert.showAndWait();
		}
	}
}


