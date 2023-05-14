package presentation.loan;

import java.util.List;

import domain.Loan;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import persistence.LoanDataAccess;

public class UpdateLoan {
	static Scene updateLoanScene(Stage primaryStage) {
		Text text = new Text("Update Loan");
		
		Label loanIdLbl = new Label("Enter loan id: ");
		Label updatedDueDateLbl = new Label("Enter updated due date : ");
		Label updatedLoanDateLbl = new Label("Enter the loan date: ");
		
		TextField loanIdTxtField = new TextField();
		TextField updatedDueDateTxtField = new TextField();
		TextField updatedLoanDateTxtField = new TextField();
		
		HBox hbox1 = new HBox(loanIdLbl, loanIdTxtField); 
		HBox hbox2 = new HBox(updatedDueDateLbl, updatedDueDateTxtField);
		HBox hbox3 = new HBox(updatedLoanDateLbl, updatedLoanDateTxtField);
				
		hbox1.setSpacing(15);
		hbox2.setSpacing(15);
		hbox3.setSpacing(15);
		
		Button btnUpdateLoan = new Button("Update Loan");
		Button btnBack = new Button("Back");
		
		HBox hbox5 = new HBox(btnBack, btnUpdateLoan);
		hbox5.setSpacing(50);
		
		text.setFont(new Font(30));
		
		btnUpdateLoan.setMinWidth(100);
		btnUpdateLoan.setMinHeight(40);
		
		btnBack.setMinWidth(100);
		btnBack.setMinHeight(40);
		
		btnUpdateLoan.setOnAction(e->{
			int loanId = Integer.valueOf(loanIdTxtField.getText());
			String updatedDueDate = updatedDueDateTxtField.getText();
			String updatedLoanDate = updatedLoanDateTxtField.getText();
			boolean loanUpdated = LoanDataAccess.updateLoan(loanId, updatedDueDate, updatedLoanDate);
			showLoanUpdatedAlert(loanUpdated);
			// List<Loan> overDueLoans = LoanDataAccess.getLoans();
		});
		
		btnBack.setOnAction(e -> {
			Scene scene = LoanMenu.loanMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		VBox vbox = new VBox(text, hbox1, hbox2, hbox3, hbox5);
		
		vbox.setSpacing(50);
		vbox.setMargin(hbox1, new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox2, new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox3, new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox5, new Insets(0, 0, 0, 170));
		vbox.setAlignment(Pos.CENTER);
		
		Scene studentUpdateLoanScene = new Scene(vbox, 600, 600);
		
		return studentUpdateLoanScene;
	}
	
	private static void showLoanUpdatedAlert(boolean loanUpdated) {
		if(loanUpdated == true)
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Loan has been updated!");
			alert.setContentText("Loan has been updated into the system!");
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

