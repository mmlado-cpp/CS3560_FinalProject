package presentation.loan;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.stage.Stage;
import persistence.LoanDataAccess;
import persistence.StudentDataAccess;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
//import presentation.StudentMenu;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import domain.Student;
import domain.Item;
import domain.Loan;

public class CreateLoan {
	static Scene createLoanScene(Stage primaryStage){
		Text text = new Text("Create Loan");
		
		Label broncoIdLbl = new Label("Enter BroncoID of student: ");
		Label itemIdLbl = new Label("Enter id of item: ");
		Label loanDueDateLbl = new Label("Enter Loan Due Date: ");
		
		
		TextField broncoIdTxtField = new TextField();
		TextField itemIdTxtField = new TextField();
		TextField loanDueDateTxtField= new TextField();
		
		
		
		HBox hbox1 = new HBox(broncoIdLbl, broncoIdTxtField);
		HBox hbox2 = new HBox(itemIdLbl, itemIdTxtField);
		HBox hbox3 = new HBox(loanDueDateLbl, loanDueDateTxtField);
		
		hbox1.setSpacing(35);
		hbox2.setSpacing(90);
		hbox3.setSpacing(65);
		
		Button btnCreateLoan = new Button("Create Loan");
		Button btnBack = new Button("Back");
		
		HBox hbox5 = new HBox(btnBack, btnCreateLoan);
		hbox5.setSpacing(50);
	
		text.setFont(new Font(30));
		
		btnCreateLoan.setMinWidth(100);
		btnCreateLoan.setMinHeight(40);
		
		btnBack.setMinWidth(100);
		btnBack.setMinHeight(40);
		
		btnCreateLoan.setOnAction(e ->{
				int broncoId = Integer.valueOf(broncoIdTxtField.getText());
				int itemId = Integer.valueOf(itemIdTxtField.getText());
				String loanDueDate = loanDueDateTxtField.getText();
				String loanCreated = LoanDataAccess.createLoan(broncoId, itemId, loanDueDate);
				showLoanCreatedAlert(loanCreated);
				List<Loan> overDueLoans = LoanDataAccess.getLoans(broncoId);
				
		});
		
		btnBack.setOnAction(e ->{
			Scene scene = LoanMenu.loanMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		VBox vbox = new VBox(text, hbox1, hbox2, hbox3, hbox5);
	
		vbox.setSpacing(50);
		vbox.setMargin(hbox1,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox2,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox3,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox5,  new Insets(0, 0, 0, 170));
		vbox.setAlignment(Pos.CENTER);
		
		Scene studentRegistrationScene = new Scene(vbox, 600, 600);
		
		
		return studentRegistrationScene;
	}
	
	private static void showLoanCreatedAlert(String loanCreated) {
		if(loanCreated.equals("created"))
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Loan Added!");
			alert.setContentText("Loan is added into the system!");
			alert.showAndWait();
		}
		else if(loanCreated.equals("itemNotAvailable"))
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Item Availability");
			alert.setContentText("Item is not available for loaning");
			alert.showAndWait();
		}
		else
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Error!");
			alert.setContentText("There was a problem with adding the loan into the system.");
			alert.showAndWait();
		}
	}
}