package presentation.loan;
import javafx.scene.control.ListView;
import javafx.scene.Scene;

import java.util.List;
import java.util.ArrayList;

import domain.Loan;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button; 
import javafx.stage.Stage;
import persistence.LoanDataAccess;
import persistence.StudentDataAccess;
import presentation.student.StudentMenu;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class SearchLoan {
	
	public static Scene searchLoanScene(Stage primaryStage)
	{
		Text title= new Text("View Loan");
		title.setFont(new Font(30));
		
		Label lbl = new Label("Enter Bronco Id: ");
		
		TextField textField = new TextField();
		
		Button btnBack = new Button("Back");
		btnBack.setMinWidth(100);
		btnBack.setMinHeight(40);
		
		Button btnSearch = new Button("Search");
		btnSearch.setMinWidth(100);
		btnSearch.setMinHeight(40);
		
		Text textStudentDetails = new Text();
		textStudentDetails.setFont(new Font(15));
		
		ListView listView = new ListView();
		
		btnSearch.setOnAction(e -> {
			int broncoId = Integer.valueOf(textField.getText());
			List<Loan> loans = LoanDataAccess.getLoans(broncoId);
			List<String> loansString = new ArrayList<String>();
			
			int i = 0;
			for(Loan loan : loans)
			{
				loansString.add(loan.getStudent().getName() + "        " + loan.getItem().getTitle() + "        $"  + loan.getItem().getDailyPrice() + "        " +loan.getLoanDate() + "        " + loan.getDuedate());
				listView.getItems().add(loansString.get(i));
				i++;
			}
			
		});
		
		btnBack.setOnAction(e ->{
			Scene scene = LoanMenu.loanMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		HBox hbox1 = new HBox(lbl, textField);
		
		HBox hbox2 = new HBox(btnBack, btnSearch);
		hbox2.setSpacing(50);
		
		VBox vbox = new VBox(title, hbox1,  hbox2, listView);
		
		vbox.setMargin(hbox1,  new Insets(0, 0, 0, 170));
		vbox.setMargin(hbox2,  new Insets(0, 0, 0, 170));
		
		vbox.setAlignment(Pos.CENTER);
		
		vbox.setSpacing(30);
		
		Scene scene = new Scene(vbox, 600, 600);
		
		return scene;
		
	
	}
	

}