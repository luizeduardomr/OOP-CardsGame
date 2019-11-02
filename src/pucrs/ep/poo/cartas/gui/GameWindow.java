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


public class GameWindow extends Application implements Observer {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Game.getInstance().addObserver(this);

        primaryStage.setTitle("Batalha de Cartas");

        Group root = new Group();

        //Cria as tabs
        TabPane tabPane = new TabPane();

        Tab tab1 = new Tab("Mão Jogador 1");
        Tab tab2 = new Tab("Mão Jogador 2");
        Tab tab3 = new Tab("Mesa Jogador 1");
        Tab tab4 = new Tab("Mesa Jogador 2");

        tabPane.getTabs().add(tab1);
        tabPane.getTabs().add(tab2);
        tabPane.getTabs().add(tab3);
        tabPane.getTabs().add(tab4);

        //Cria o objeto placar
        PlacarView placar = new PlacarView();

        //Cria o botão
        Button butClean = new Button("Clean");
        butClean.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Game.getInstance().removeSelected();
            }
        });

        // Jogador 1
        GridPane grid1 = new GridPane();
        grid1.setAlignment(Pos.CENTER);
        grid1.setHgap(10);
        grid1.setVgap(10);
        grid1.setPadding(new Insets(25, 25, 25, 25));

        DeckView deckJ1 = new DeckView(1);
        ScrollPane sd1 = new ScrollPane();
        sd1.setPrefSize(1500, 395);
        sd1.setContent(deckJ1);
        grid1.add(sd1, 0, 0);

        grid1.add(placar, 0, 1);
        grid1.add(butClean, 1, 1);

        //Jogador 2
        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(25, 25, 25, 25));

        DeckView deckJ2 = new DeckView(2);
        ScrollPane sd2 = new ScrollPane();
        sd2.setPrefSize(1500, 395);
        sd2.setContent(deckJ2);
        grid2.add(sd2, 0, 0);

        grid2.add(placar, 0, 1);
        grid2.add(butClean, 1, 1);

        tab1.setContent(grid1);
        tab2.setContent(grid2);

        ObservableList list = root.getChildren();
        list.add(tabPane);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void update(Observable o, Object arg) {
        Alert alert;

        if (arg == null) {
            return;
        }
        GameEvent eg = (GameEvent) arg;
        if (eg.getTarget() == GameEvent.Target.GWIN) {
            switch (eg.getAction()) {
                case INVPLAY:
                    alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Atenção !!");
                    alert.setHeaderText("Jogada inválida!!");
                    alert.setContentText("Era a vez do jogador " + eg.getArg());
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
