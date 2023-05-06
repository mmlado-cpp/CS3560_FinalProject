package presentation;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import presentation.StudentMenu;
import presentation.DocumentaryCreate;
public class MainMenu extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Scene mainMenu = mainMenuScene(primaryStage);
			primaryStage.setScene(mainMenu);
			/*
			Scene testing = DocumentaryCreate.documentaryCreateScene(primaryStage);
			primaryStage.setScene(testing);
			*/
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Scene mainMenuScene(Stage primaryStage) {
		Text text = new Text("CPP Library Management System");
		Button btnManageLoans = new Button("Manage Loans");
		Button btnManageItems = new Button("Manage Items");
		Button btnManageStudents = new Button("Manage Students");
		
		text.setFont(new Font(30));
		
		btnManageLoans.setMinWidth(150);
		btnManageLoans.setMinHeight(50);
		
		btnManageItems.setMinWidth(150);
		btnManageItems.setMinHeight(50);
		
		btnManageItems.setOnAction(e ->{
			Scene scene = ItemMenu.itemMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		btnManageStudents.setMinWidth(150);
		btnManageStudents.setMinHeight(50);
		
		btnManageStudents.setOnAction(e ->{
			Scene scene = StudentMenu.studentMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		btnManageLoans.setOnAction(e ->{
			Scene scene = LoanMenu.loanMenuScene(primaryStage);
			primaryStage.setScene(scene);
		});
		
		
		VBox vbox = new VBox(text, btnManageLoans, btnManageItems, btnManageStudents);
		
		vbox.setSpacing(50);
		
		vbox.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(vbox, 600,600);
		return scene;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}