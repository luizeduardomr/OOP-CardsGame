package pucrs.ep.poo.cartas.gui;

import java.util.*;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.event.*;
import pucrs.ep.poo.cartas.modelo.Game;


public class GameWindow extends Application implements Observer{
   
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Game.getInstance().addObserver(this);
        
        primaryStage.setTitle("Batalha de Cartas");

        Group root = new Group();

        TabPane tabPane = new TabPane();

        Tab tab1 = new Tab("Planes", new Label("Show all planes available"));
        Tab tab2 = new Tab("Cars"  , new Label("Show all cars available"));
        Tab tab3 = new Tab("Boats" , new Label("Show all boats available"));

        tabPane.getTabs().add(tab1);
        tabPane.getTabs().add(tab2);
        tabPane.getTabs().add(tab3);


        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));


        DeckView deckJ1 = new DeckView(1);
        ScrollPane sd1 = new ScrollPane();
        sd1.setPrefSize(1200, 400);
        sd1.setContent(deckJ1);
        grid.add(sd1,0,0);


        PlacarView placar = new PlacarView();
        grid.add(placar,0,1);


        Button butClean = new Button("Clean");
        grid.add(butClean,1,1);
        butClean.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Game.getInstance().removeSelected();
            }
        });

        DeckView deckJ2 = new DeckView(2);
        ScrollPane sd2 = new ScrollPane();
        sd2.setPrefSize(1200, 400);
        sd2.setContent(deckJ2);
        grid.add(sd2,0,2);

        tab1.setContent(grid);

        ObservableList list = root.getChildren();
        //list.add(grid);
        list.add(tabPane);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void update(Observable o,Object arg){
        Alert alert;
        
        if (arg == null){
            return;
        }
        GameEvent eg = (GameEvent)arg;
        if (eg.getTarget() == GameEvent.Target.GWIN){
            switch(eg.getAction()){
                case INVPLAY:
                    alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Atenção !!");
                    alert.setHeaderText("Jogada inválida!!");
                    alert.setContentText("Era a vez do jogador "+eg.getArg());
                    alert.showAndWait();
                    break;                    
                case MUSTCLEAN:
                    alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Atenção !!");
                    alert.setHeaderText(null);
                    alert.setContentText("Utilize o botao \"Clean\"");
                    alert.showAndWait();
                    break;                    
                case ENDGAME:
                    alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Atenção !!");
                    alert.setHeaderText(null);
                    alert.setContentText("Fim de Jogo !!");
                    alert.showAndWait();
                    break;                    
            }
        }
    }
    
}
