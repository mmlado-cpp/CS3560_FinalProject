package presentation.documentary;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import domain.Documentary;
import domain.DocumentaryProducer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import persistence.DocumentaryAccess;
import persistence.DocumentaryProducerAccess;

public class DocumentaryUpdate {
	
	static List<Integer> producerIds;
	
	public static Scene documentaryUpdateScene(Stage primaryStage)
	{
		Text title= new Text("Update Documentary");
		title.setFont(new Font(30));
		
		Label lbl = new Label("Enter Documentary Code: ");
		
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
			Documentary documentary = DocumentaryAccess.getDocumentary(code);
			Scene scene = updateDocumentaryScene2(primaryStage, documentary.getItemId(), documentary.getIsAvailable(), documentary.getTitle(), documentary.getDescription(), documentary.getLocation(), documentary.getDailyPrice(), documentary.getDirector(), documentary.getLength(), documentary.getReleaseDate());
			primaryStage.setScene(scene);
		});
		
		btnBack.setOnAction(e ->{
			Scene scene = DocumentaryMenu.documentaryMenuScene(primaryStage);
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
	
	static Scene updateDocumentaryScene2(Stage primaryStage, int id, boolean status, String title, String description, 
			   String location, double dailyPrice, String director, int length, String releaseDate)
	{
		Text text = new Text("Update Documentary");
		
		Label titleLbl = new Label("Update Documentary Title: ");
		Label descLbl = new Label("Update Description: ");
		Label locationLbl = new Label("Update Location: ");
		Label dailyPriceLbl = new Label("Update Daily Price: ");
		Label directorLbl = new Label("Update Director: ");
		Label lengthLbl = new Label("Update Length: ");
		Label releaseDateLbl = new Label("Update Release Date: ");
		Label statusLbl = new Label("Update Status: ");
		Label producerLbl = new Label("Select Producers: ");
		
		TextField titleTxtField = new TextField();
		titleTxtField.setText(String.valueOf(title));
		
		TextField descTxtField = new TextField();
		descTxtField.setText(String.valueOf(description));
		
		TextField locationTxtField = new TextField();
		locationTxtField.setText(String.valueOf(location));
		
		TextField dailyPriceTxtField = new TextField();
		dailyPriceTxtField.setText(String.valueOf(dailyPrice));
		
		TextField directorTxtField = new TextField();
		directorTxtField.setText(String.valueOf(director));
		
		TextField lengthTxtField = new TextField();
		lengthTxtField.setText(String.valueOf(length));
		
		TextField releaseDateTxtField = new TextField();
		releaseDateTxtField.setText(String.valueOf(releaseDate));
		
		ComboBox<Boolean> statusComboBox = new ComboBox<Boolean>();
		statusComboBox.getItems().add(true);
		statusComboBox.getItems().add(false);
		statusComboBox.getSelectionModel().select(Boolean.valueOf(status));
		
		ComboBox<String> producerComboBox = new ComboBox<String>();
		
		RadioButton add = new RadioButton("Add");
        RadioButton remove = new RadioButton("Remove");
        
        ToggleGroup addRemoveGroup = new ToggleGroup();
        add.setToggleGroup(addRemoveGroup);
        remove.setToggleGroup(addRemoveGroup);
        addRemoveGroup.selectToggle(add);
		
		HBox hbox2 = new HBox(titleLbl, titleTxtField);
		HBox hbox3 = new HBox(descLbl, descTxtField);
		HBox hbox4 = new HBox(locationLbl, locationTxtField);
		HBox hbox5 = new HBox(dailyPriceLbl, dailyPriceTxtField);
		HBox hbox6 = new HBox(directorLbl, directorTxtField);
		HBox hbox7 = new HBox(lengthLbl, lengthTxtField);
		HBox hbox8 = new HBox(releaseDateLbl, releaseDateTxtField);
		HBox hbox9 = new HBox(statusLbl, statusComboBox);
		HBox hbox10 = new HBox(producerLbl, producerComboBox, add, remove);
		
		hbox2.setSpacing(40);
		hbox3.setSpacing(75);
		hbox4.setSpacing(90);
		hbox5.setSpacing(80);
		hbox6.setSpacing(90);
		hbox7.setSpacing(95);
		hbox8.setSpacing(65);
		hbox9.setSpacing(98);
		
		Button btnUpdateDocumentary = new Button("Update Documentary");
		Button btnBack = new Button("Back");
		
		HBox hbox0 = new HBox(btnBack, btnUpdateDocumentary);
		hbox0.setSpacing(50);
	
		text.setFont(new Font(30));
		
		btnUpdateDocumentary.setMinWidth(100);
		btnUpdateDocumentary.setMinHeight(40);
		

		btnBack.setMinWidth(100);
		btnBack.setMinHeight(40);
		
		producerIds = addProducersToComboBox(producerComboBox, id);
		
		add.setOnAction(e -> {
			producerIds = addProducersToComboBox(producerComboBox, id);
		});
		
		remove.setOnAction(e -> {
			producerIds = removeProducersToComboBox(producerComboBox, id);
		});
		
		btnUpdateDocumentary.setOnAction(e ->{
			String updated_title = titleTxtField.getText();
			String updated_description = descTxtField.getText();
			String updated_location = locationTxtField.getText();
			double updated_dailyPrice = Double.valueOf(dailyPriceTxtField.getText());
			String updated_director = directorTxtField.getText();
			int updated_length = Integer.valueOf(lengthTxtField.getText());
			String updated_release = releaseDateTxtField.getText();
			Boolean updated_status = Boolean.valueOf(statusComboBox.getSelectionModel().getSelectedItem());
			
			int comboBoxIndex = producerComboBox.getSelectionModel().getSelectedIndex();
			int producerId = -1;
			int comboBoxSize = producerComboBox.getItems().size();
			
			if(comboBoxIndex < comboBoxSize - 1) {
				producerId = producerIds.get(comboBoxIndex);
			}
			
			boolean addProducer = ((RadioButton) addRemoveGroup.getSelectedToggle()).getText().equalsIgnoreCase("Add") ? true : false;
			
			System.out.println("producerId = " + producerId);
			boolean updated_Documentary = DocumentaryAccess.updateDocumentary(id, updated_status, updated_title, updated_description, updated_location, updated_dailyPrice, updated_director, updated_length, updated_release, producerId, addProducer);
			showUpdatedAlert(updated_Documentary, id);
			
			if(addProducer) {
				producerIds = addProducersToComboBox(producerComboBox, id);
			} else {
				producerIds = removeProducersToComboBox(producerComboBox, id);
			}
		});
		
		btnBack.setOnAction(e ->{
			Scene scene = DocumentaryMenu.documentaryMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		VBox vbox = new VBox(text, hbox2, hbox3, hbox4, hbox5, hbox6, hbox7, hbox8, hbox9, hbox10, hbox0);
	
		vbox.setSpacing(15);
		vbox.setMargin(hbox2,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox3,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox4,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox5,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox6,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox7,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox8,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox9,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox10,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox0,  new Insets(0, 0, 0, 170));
		vbox.setAlignment(Pos.CENTER);
		
		Scene documentaryCreateScene = new Scene(vbox, 600, 600);
		
		
		return documentaryCreateScene;
	}
	
	private static void showUpdatedAlert(boolean updated_Documentary, int code) {
		if(updated_Documentary)
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Documentary Updated!");
			alert.setContentText("Documentary with code " + code +" is updated!");
			alert.showAndWait();
		}
		else
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Error!");
			alert.setContentText("There was a problem with updating documentary with code " + code);
			alert.showAndWait();
		}
	}
	
	private static List<Integer> addProducersToComboBox(ComboBox<String> comboBox, int docId) {
		final List<DocumentaryProducer> producers = DocumentaryProducerAccess.getAllProducers();
		final List<Integer> docIds = DocumentaryAccess.getProducerIds(docId);
		final List<Integer> currentIdList = new ArrayList<Integer>();
		
		comboBox.getItems().clear();
		for(DocumentaryProducer producer : producers) {
			boolean notFound = true;
			for(int prodDoc : docIds) {
				if(producer.getId() == prodDoc) {
					notFound = false;
				}
			}
			
			if(notFound) {
				comboBox.getItems().add(producer.getName());
				currentIdList.add(producer.getId());
			}
		}
		comboBox.getItems().add("Do Nothing");
		comboBox.getSelectionModel().select("Do Nothing");
		
		return currentIdList;
	}
	
	private static List<Integer> removeProducersToComboBox(ComboBox<String> comboBox, int docId) {
		final List<Integer> docIds = DocumentaryAccess.getProducerIds(docId);
		
		comboBox.getItems().clear();
		for(int prodDoc : docIds) {
			comboBox.getItems().add(DocumentaryProducerAccess.getdocumentaryProducer(prodDoc).getName());
		}
		comboBox.getItems().add("Do Nothing");
		comboBox.getSelectionModel().select("Do Nothing");
		
		return docIds;
	}
}