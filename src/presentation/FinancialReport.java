package presentation;

import javafx.scene.Scene;

import domain.Student;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.stage.Stage;
import persistence.DocumentaryAccess;
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
import presentation.StudentMenu;
import presentation.DocumentaryMenu;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class FinancialReport {
	
	static Scene financialReportScene(Stage primaryStage)
	{

		Label label = new Label("Financial Report For ");
		String name = "Temp Name";
		Text studentName = new Text(name);
		HBox hbox = new HBox(label, studentName); //creates a Horizontal box, now lab and student name are on the same line
		label.setFont(new Font(30));
		studentName.setFont(new Font(30));
		
		int numberOfLoans = 1;
		Label label1 = new Label ("Number of Loans: ");
		Text numLoans = new Text(String.valueOf(numberOfLoans));
		
		HBox hbox1 = new HBox(label1, numLoans);
		
		label1.setFont(new Font (15));
		numLoans.setFont(new Font (15));
		
		
		int loanID = 3986765;

		TableView table = new TableView();
		
		table.setEditable(true);
		
		TableColumn loanid = new TableColumn("Loan ID");
		TableColumn bookTitle = new TableColumn("Book Name");
		TableColumn loanStart = new TableColumn("Loan Start Date");
		TableColumn dueDate   = new TableColumn("Due Date");
		TableColumn amountDue = new TableColumn("Amount Due");
		
		
		table.getColumns().addAll(bookTitle, loanStart, dueDate, amountDue, loanid);
//		
//		ObservableList<>
		
	
		VBox vbox = new VBox(hbox, hbox1, table);

		
		
		
		
//		
//		btnSearch.setOnAction(e -> {
////			int code = Integer.valueOf(textField.getText());
////			String documentary = String.valueOf(DocumentaryAccess.getDocumentary(code));
////			textDocumentaryDetails.setText(documentary);
//		});
//		
//		btnBack.setOnAction(e ->{
//			Scene scene = DocumentaryMenu.documentaryMenuScene(primaryStage);
//			primaryStage.setScene(scene);
//		});
		
//		HBox hbox1 = new HBox(lbl, textField);
//		
//		HBox hbox2 = new HBox(btnBack, btnSearch);
//		hbox2.setSpacing(50);
//		
//		VBox vbox = new VBox(title, hbox1, hbox2, textDocumentaryDetails);
		
//		vbox.setMargin(hbox1,  new Insets(0, 0, 0, 170));
//		vbox.setMargin(hbox2,  new Insets(0, 0, 0, 170));
//		
		vbox.setAlignment(Pos.CENTER);
		
		vbox.setSpacing(30);
//		
		Scene scene = new Scene(vbox, 600, 600);
		
		return scene;
		
	
	}
	
	private static void createTable(int loanID) {
		TableView table = new TableView();
		
		table.setEditable(true);
		
		TableColumn loanid = new TableColumn("Loan ID: " + String.valueOf(loanID));
		TableColumn bookTitle = new TableColumn("Book Name");
		TableColumn loanStart = new TableColumn("Loan Start Date");
		TableColumn dueDate   = new TableColumn("Due Date");
		TableColumn amountDue = new TableColumn("Amount Due");
		
		table.getColumns().addAll(bookTitle, loanStart, dueDate, amountDue, loanid);
		
	}
	
	private static double calculateIndPrice() {
		double objectPrice = 0.0;
		return objectPrice;
	}
	private static double calcTotalPrice() {
		double totalPrice = 0.0;
		return totalPrice;
		
	}
	
	

}
