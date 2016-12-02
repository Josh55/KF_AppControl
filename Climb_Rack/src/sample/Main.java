package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    Scene sceneMenu, sceneRack;
    ImageView value;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setOnCloseRequest(event -> {
            event.consume();
            closeProgram();
        });

        //Label Main Menu
        Label labelMenu = new Label("Main Menu");
        labelMenu.setFont(new Font(50.0));
        //Button Start
        Button buttonStart = new Button("START");
        buttonStart.setOnAction(event -> window.setScene(sceneRack));
        buttonStart.setMinSize(200, 100);
        //Button Quit
        Button buttonQuit = new Button("Quit");
        buttonQuit.setOnAction(event -> closeProgram());
        buttonQuit.setMinSize(200, 100);
        //Layout Menu
        VBox layoutMenu = new VBox(30);
        layoutMenu.getChildren().addAll(labelMenu,buttonStart,buttonQuit);
        layoutMenu.setAlignment(Pos.CENTER);
        sceneMenu = new Scene(layoutMenu, 700, 500);


        HBox topMenu = new HBox();
        VBox center = new VBox();

        //Label Rack
        Label labelRack = new Label("Which one?  ");

        ChoiceBox<String> choiceBox = new ChoiceBox<>();

        //getItems return ObservableList object which you can add items to
        choiceBox.getItems().add("Harness");
        choiceBox.getItems().add("Helmet");
        choiceBox.getItems().add("Rope");
        //default value
        choiceBox.setValue("Harness");

        //Listen for selection changes
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue)->{
            switch (newValue){
                case "Harness":

                    Image image = new Image("harness.png", 375, 375, true, false);
                    ImageView iv1 = new ImageView();
                    iv1.setImage(image);
                    iv1 = value;

                case "Helmet":

                    Image image1 = new Image("Helmet.png", 375, 375, true, false);
                    ImageView iv2 = new ImageView();
                    iv2.setImage(image1);
                    iv2 = value;

                case "Rope":

                    Image image2 = new Image("rope.png", 375, 375, true, false);
                    ImageView iv3 = new ImageView();
                    iv3.setImage(image2);
                    iv3 = value;
            }
        });

        //just temporary due to problem with visibility of proper images
        Image image = new Image("harness.png", 375, 375, true, false);    // preserve ratio, smoothing
        ImageView iv1 = new ImageView();
        iv1.setImage(image);





        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        topMenu.getChildren().addAll(labelRack, choiceBox);
        topMenu.setAlignment(Pos.CENTER);


        borderPane.setCenter(center);
        center.getChildren().addAll(iv1);
        center.setAlignment(Pos.CENTER);


        sceneRack = new Scene(borderPane, 400, 400);

        window.setScene(sceneMenu);
        window.setTitle("Climb Trad Rack Repository");
        window.show();


    }

    //closing method
    private void closeProgram() {
        Boolean answer = ExitConfirmation.display("Program is about to exit", "sure?");
        if (answer)
            window.close();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
