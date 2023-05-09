package presentation.documentaryProducer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import domain.Documentary;
import domain.DocumentaryProducer;
import domain.Student;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import persistence.DocumentaryAccess;
import persistence.DocumentaryProducerAccess;
import persistence.StudentDataAccess;

public class DocumentaryProducerUpdate {
	
	static Scene updateDocumentaryProducerScene(Stage primaryStage)
	{
		Text title= new Text("Update Producer");
		title.setFont(new Font(30));
		
		Label lbl = new Label("Enter Producer Id: ");
		
		TextField textField = new TextField();
		
		Button btnBack = new Button("Back");
		btnBack.setMinWidth(100);
		btnBack.setMinHeight(40);
		
		Button btnSubmit = new Button("Submit");
		btnSubmit.setMinWidth(100);
		btnSubmit.setMinHeight(40);
		
		Text textProducerDetails = new Text();
		textProducerDetails.setFont(new Font(15));
		
		
		
		btnSubmit.setOnAction(e -> {
			int id = Integer.valueOf(textField.getText());
			DocumentaryProducer producer = DocumentaryProducerAccess.getdocumentaryProducer(id);
			Scene scene = updateProducerScene2(primaryStage, producer.getId(), producer.getName(), producer.getEmail(), producer.getDocumentaries());
			primaryStage.setScene(scene);
		});
		
		btnBack.setOnAction(e ->{
			Scene scene = DocumentaryProducerMenu.documentaryProducerMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		HBox hbox1 = new HBox(lbl, textField);
		
		HBox hbox2 = new HBox(btnBack, btnSubmit);
		hbox2.setSpacing(50);
		
		VBox vbox = new VBox(title, hbox1, hbox2, textProducerDetails);
		
		vbox.setMargin(hbox1,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox2,  new Insets(0, 0, 0, 170));
		
		vbox.setAlignment(Pos.CENTER);
		
		vbox.setSpacing(30);
		
		Scene scene = new Scene(vbox, 600, 600);
		
		return scene;
	}
	
	static Scene updateProducerScene2(Stage primaryStage, int id, String name, String email, List<Documentary> documentaries)
	{
		Label producerNameLbl = new Label("Update Producer Name: ");
		Label producerEmailLbl = new Label("Update Producer Email: ");
		Label documentaryLbl = new Label("Choose Documentary: ");
		
		TextField producerNameTxtField = new TextField();
		producerNameTxtField.setText(String.valueOf(name));
		
		TextField emailTxtField= new TextField();
		emailTxtField.setText(String.valueOf(email));
		
		ComboBox<String> documentariesComboBox = new ComboBox<>();
		
		RadioButton add = new RadioButton("Add");
        RadioButton remove = new RadioButton("Remove");
        
        ToggleGroup addRemoveGroup = new ToggleGroup();
        add.setToggleGroup(addRemoveGroup);
        remove.setToggleGroup(addRemoveGroup);
		
		//Add all documentary titles to the Combo box
		List<Documentary> docs = DocumentaryAccess.getAllDocumentaries();
		for(Documentary doc : docs) {
			documentariesComboBox.getItems().add(doc.getTitle());
		}
		
		documentariesComboBox.getItems().add("Remove All Documentaries");
		
		HBox hbox1 = new HBox(producerNameLbl, producerNameTxtField);
		HBox hbox2 = new HBox(producerEmailLbl, emailTxtField);
		HBox hbox3 = new HBox(documentaryLbl, documentariesComboBox, add, remove);
		
		hbox1.setSpacing(27);
		hbox2.setSpacing(18);
		hbox3.setSpacing(24);
		
		Button btnUpdateProducer= new Button("Update Producer");
		Button btnBack = new Button("Back");
		
		HBox hbox4 = new HBox(btnBack, btnUpdateProducer);
		hbox4.setSpacing(50);
		
		btnUpdateProducer.setMinWidth(100);
		btnUpdateProducer.setMinHeight(40);
		
		btnBack.setMinWidth(100);
		btnBack.setMinHeight(40);
		
		btnUpdateProducer.setOnAction(e ->{
			String updatedName = producerNameTxtField.getText();
			String updatedEmail = emailTxtField.getText();
			//If documentary exists, send the ID, if not send -1 (-1 ID will never match any item)
			int documentaryChosenId = (documentariesComboBox.getSelectionModel().getSelectedIndex() < docs.size()) ? 
					docs.get(documentariesComboBox.getSelectionModel().getSelectedIndex()).getItemId() : -1;
			boolean addDocumentary = ((RadioButton) addRemoveGroup.getSelectedToggle()).getText().equalsIgnoreCase("Add") ? true : false;
			boolean updatedProducer = DocumentaryProducerAccess.updateDocumentaryProducer(id, updatedName, updatedEmail, documentaryChosenId, addDocumentary);
			showUpdatedAlert(updatedProducer, id);
		});
		
		btnBack.setOnAction(e ->{
			Scene scene = DocumentaryProducerMenu.documentaryProducerMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		VBox vbox = new VBox(hbox1, hbox2, hbox3, hbox4);
	
		vbox.setSpacing(50);
		vbox.setMargin(hbox1,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox2,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox4,  new Insets(0, 0, 0, 170));
		vbox.setAlignment(Pos.CENTER);
		
		Scene producerRegistrationScene = new Scene(vbox, 600, 600);
		
		
		return producerRegistrationScene;
	}
	
	private static void showUpdatedAlert(boolean createdProducer, int id) {
		if(createdProducer)
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Student Updated!");
			alert.setContentText("Producer with id " + id +" is updated!");
			alert.showAndWait();
		}
		else
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Error!");
			alert.setContentText("There was a problem with updating producer with id " + id);
			alert.showAndWait();
		}
	}
	

}