package estimatecosts;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EstimateCosts extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("Managers tool");
        GridPane grid = new GridPane();                                 //GridPane object and assigns it to the variable named grid
        grid.setAlignment(Pos.BOTTOM_LEFT);                             //Alignment property changes the default position of the grid from the top left of the scene to the center
        grid.setHgap(7);                                       
        grid.setVgap(7);                                                //gap properties manage the spacing between the rows and columns
        grid.setPadding(new Insets(35, 35, 35, 35));                    //padding property manages the space around the edges of the grid pane. In here each side has 25 pixels padding
        Text scenetitle = new Text("Enter projects dates");             //text object which cannot be edited
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20)); //setFont sets font. THIS IS AN INLINE STYLING
        grid.add(scenetitle, 0, 0, 2, 1);                               //add the object scenetitle to the gridlayout at row 0 and column 0, and spans accross 2 columns and 1 row

        Label startDate = new Label("Start date");                      //Label object before editable text field
        grid.add(startDate, 0, 1);                                      //Adding it to the first column and second row, doesn't span
        TextField startTextField = new TextField();                     //Object for editable text where we enter start date of the project
        grid.add(startTextField, 1, 1);                                 //Adding this editable textfield to the gridlayout

        Label endDate = new Label("End date");                          //New object for end date label
        grid.add(endDate, 0, 2);                                        //Adding it to the gridlaout at column 0 and row third row
        TextField endTextField = new TextField();                       //Text field for entering the end date 
        grid.add(endTextField, 1, 2);                                   //Adding it to the column one and row tree
        
        Button nextButton = new Button("Next");                         //Create an object button with a text Next
        HBox hbBtn = new HBox(10);                                      //Horizintal pane window for button 
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);                           //positioning the horizontal layout pane to the right
        hbBtn.getChildren().add(nextButton);                            //
        grid.add(hbBtn, 1, 4);

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
