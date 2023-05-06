package presentation.documentary;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import persistence.DocumentaryAccess;
import presentation.mainMenu.MainMenu;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

public class DocumentaryCreate {
	public static Scene documentaryCreateScene(Stage primaryStage){
		Text text = new Text("Create Documentary");
		
		Label codeLbl = new Label("Enter Documentary Code: ");
		Label titleLbl = new Label("Enter Documentary Title: ");
		Label descLbl = new Label("Enter Description: ");
		Label locationLbl = new Label("Enter Location: ");
		Label dailyPriceLbl = new Label("Enter Daily Price: ");
		Label directorLbl = new Label("Enter Director: ");
		Label lengthLbl = new Label("Enter Length: ");
		Label releaseDateLbl = new Label("Enter Release Date: ");
		Label statusLbl = new Label("Enter Status: ");
		
		
		TextField codeTxtField = new TextField();
		TextField titleTxtField = new TextField();
		TextField descTxtField = new TextField();
		TextField locationTxtField = new TextField();
		TextField dailyPriceTxtField = new TextField();
		TextField directorTxtField = new TextField();
		TextField lengthTxtField = new TextField();
		TextField releaseDateTxtField = new TextField();
		TextField statusTxtField= new TextField();
		
		HBox hbox1 = new HBox(codeLbl, codeTxtField);
		HBox hbox2 = new HBox(titleLbl, titleTxtField);
		HBox hbox3 = new HBox(descLbl, descTxtField);
		HBox hbox4 = new HBox(locationLbl, locationTxtField);
		HBox hbox5 = new HBox(dailyPriceLbl, dailyPriceTxtField);
		HBox hbox6 = new HBox(directorLbl, directorTxtField);
		HBox hbox7 = new HBox(lengthLbl, lengthTxtField);
		HBox hbox8 = new HBox(releaseDateLbl, releaseDateTxtField);
		HBox hbox9 = new HBox(statusLbl, statusTxtField);
		
		hbox1.setSpacing(38);
		hbox2.setSpacing(40);
		hbox3.setSpacing(75);
		hbox4.setSpacing(90);
		hbox5.setSpacing(80);
		hbox6.setSpacing(90);
		hbox7.setSpacing(95);
		hbox8.setSpacing(65);
		hbox9.setSpacing(98);
		
		Button btnCreateDocumentary = new Button("Create Documentary");
		Button btnBack = new Button("Back");
		
		HBox hbox0 = new HBox(btnBack, btnCreateDocumentary);
		hbox0.setSpacing(50);
	
		text.setFont(new Font(30));
		
		btnCreateDocumentary.setMinWidth(100);
		btnCreateDocumentary.setMinHeight(40);
		

		btnBack.setMinWidth(100);
		btnBack.setMinHeight(40);
		
		btnCreateDocumentary.setOnAction(e ->{
			int code = Integer.valueOf(codeTxtField.getText());
			String title = titleTxtField.getText();
			String description = descTxtField.getText();
			String location = locationTxtField.getText();
			double dailyPrice = Double.valueOf(dailyPriceTxtField.getText());
			String director = directorTxtField.getText();
			int length = Integer.valueOf(lengthTxtField.getText());
			String release = releaseDateTxtField.getText();
			
			Boolean status = Boolean.valueOf(statusTxtField.getText());
			
			boolean createdDocumentary = DocumentaryAccess.createDocumentary(code, status, title, description, location, dailyPrice, director, length, release);
			showSubmittedAlert(createdDocumentary, title);
		});
		
		btnBack.setOnAction(e ->{
			Scene scene = DocumentaryMenu.documentaryMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		VBox vbox = new VBox(text, hbox1, hbox2, hbox3, hbox4, hbox5, hbox6, hbox7, hbox8, hbox9, hbox0);
	
		vbox.setSpacing(15);
		vbox.setMargin(hbox1,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox2,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox3,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox4,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox5,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox6,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox7,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox8,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox9,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox0,  new Insets(0, 0, 0, 170));
		vbox.setAlignment(Pos.CENTER);
		
		Scene documentaryCreateScene = new Scene(vbox, 600, 600);
		
		
		return documentaryCreateScene;
	}
	
	private static void showSubmittedAlert(boolean createdDocumentary, String title) {
		if(createdDocumentary)
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Documentary Added!");
			alert.setContentText(title + " is added into the system!");
			alert.showAndWait();
		}
		else
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Error!");
			alert.setContentText("There was a problem with adding the documentary into the system.");
			alert.showAndWait();
		}
	}
}
