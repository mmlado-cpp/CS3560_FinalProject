package presentation.loan;
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
import presentation.mainMenu.MainMenu;
//
//- create loan
//- update loan
//- delete loan
//- search loan
//- check overdue loans
//- generate financial report
import presentation.student.StudentRegistration;

public class LoanMenu {
	public static Scene loanMenuScene(Stage primaryStage)
	{
		Text text = new Text("Loan Menu");
		
		
		Button btnCreateLoan = new Button("Create Loan");
		Button btnUpdateLoan = new Button("Update Loan");
		Button btnSearchLoan = new Button("Search Loan");
		Button btnDeleteLoan = new Button("Delete Loan");
		Button btnCheckOverdue = new Button("Check Overdue Loans");
		Button btnGFR = new Button("Generate Financial Report");
		Button btnBack = new Button("Back");
		
		text.setFont(new Font(30));
		
		btnCreateLoan.setMinWidth(150);
		btnCreateLoan.setMinHeight(50);
		
		btnUpdateLoan.setMinWidth(150);
		btnUpdateLoan.setMinHeight(50);
		
		btnSearchLoan.setMinWidth(150);
		btnSearchLoan.setMinHeight(50);
		
		btnDeleteLoan.setMinWidth(150);
		btnDeleteLoan.setMinHeight(50);
		
		btnCheckOverdue.setMinWidth(150);
		btnCheckOverdue.setMinHeight(50);
		
		btnGFR.setMinWidth(150);
		btnGFR.setMinHeight(50);
		
		btnBack.setMinWidth(150);
		btnBack.setMinHeight(50);
		
		btnBack.setOnAction(e ->{
			Scene scene = MainMenu.mainMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		btnCreateLoan.setOnAction(e ->{
			//Scene scene = StudentRegistration.studentRegistrationScene(primaryStage);
			//primaryStage.setScene(scene);
		});
		btnUpdateLoan.setOnAction(e ->{
			//Scene scene = StudentRegistration.studentRegistrationScene(primaryStage);
			//primaryStage.setScene(scene);
		});
		btnSearchLoan.setOnAction(e ->{
			//Scene scene = StudentRegistration.studentRegistrationScene(primaryStage);
			//primaryStage.setScene(scene);
		});
		btnDeleteLoan.setOnAction(e ->{
			//Scene scene = StudentRegistration.studentRegistrationScene(primaryStage);
			//primaryStage.setScene(scene);
		});
		btnCheckOverdue.setOnAction(e ->{
			//Scene scene = StudentRegistration.studentRegistrationScene(primaryStage);
			//primaryStage.setScene(scene);
		});
		
		btnGFR.setOnAction(e ->{
			Scene scene = GenerateFinancialReport.gfrScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		
		
		
		
		VBox vbox = new VBox(text, btnCreateLoan, btnUpdateLoan, btnSearchLoan, btnDeleteLoan, btnCheckOverdue, btnGFR, btnBack);
	
		vbox.setSpacing(50);
		
		vbox.setAlignment(Pos.CENTER);
		
		Scene loanMenuScene = new Scene(vbox, 600, 600);
		
		
		return loanMenuScene;
	
	}

}
