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

public class DeleteLoan {
	static Scene deleteLoanScene(Stage primaryStage){
		Text text = new Text("Delete Loan");
		
		Label loanIdLbl = new Label("Enter id of the loan: ");
		
		TextField loanIdTxtField= new TextField();
		
		HBox hbox = new HBox(loanIdLbl, loanIdTxtField);
		
		hbox.setSpacing(65);
		
		Button btnCreateLoan = new Button("Delete Loan");
		Button btnBack = new Button("Back");
		
		HBox hbox1 = new HBox(btnBack, btnCreateLoan);
		hbox1.setSpacing(50);
		hbox1.setAlignment(Pos.CENTER);  // Add this line
	
		text.setFont(new Font(30));
		
		btnCreateLoan.setMinWidth(100);
		btnCreateLoan.setMinHeight(40);
		
		btnBack.setMinWidth(100);
		btnBack.setMinHeight(40);
		
		btnCreateLoan.setOnAction(e ->{
				int loanId = Integer.valueOf(loanIdTxtField.getText());
				boolean loanDeleted = LoanDataAccess.deleteLoan(loanId);
				showLoanCreatedAlert(loanDeleted);
		});
		
		btnBack.setOnAction(e ->{
			Scene scene = LoanMenu.loanMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		VBox vbox = new VBox(text, hbox, hbox1);
		
		vbox.setSpacing(50);
		vbox.setMargin(hbox,  new Insets(0, 0, 0, 170));
		vbox.setAlignment(Pos.CENTER);
		
		Scene studentRegistrationScene = new Scene(vbox, 600, 600);
		
		return studentRegistrationScene;
	}
	
	private static void showLoanCreatedAlert(boolean loanDeleted) {
		if(loanDeleted == true)
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Loan Deleted!");
			alert.setContentText("Loan was deleted from the system!");
			alert.showAndWait();
		}
		else if(loanDeleted == false)
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("ERROR!");
			alert.setContentText("The Loan was not deleted.");
			alert.showAndWait();
		}
	}
}