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
import javafx.stage.Stage;
import pucrs.ep.poo.cartas.modelo.Game;


public class GameWindow extends Application implements Observer {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Game.getInstance().addObserver(this);

        primaryStage.setTitle("Magic dus guri");

        Group root = new Group();

        //Cria as tabs
        TabPane tabPane = new TabPane();

        Tab tab1 = new Tab("Mão Jogador 1");
        Tab tab2 = new Tab("Mão Jogador 2");
        Tab tab3 = new Tab("Mesa");
        //Tab tab4 = new Tab("Mesa Jogador 2");

        tabPane.getTabs().add(tab1);
        tabPane.getTabs().add(tab2);
        tabPane.getTabs().add(tab3);
        //tabPane.getTabs().add(tab4);

        //Cria o objeto placar
        PlacarView placar = new PlacarView();
        PlacarView placar2 = new PlacarView();

        //Cria botões de passar turno
        Button butNextPlayer1 = new Button("Passar turno");
        butNextPlayer1.setOnAction(e -> Game.getInstance().nextPlayer());
        Button butNextPlayer2 = new Button("Passar turno");
        butNextPlayer2.setOnAction(e -> Game.getInstance().nextPlayer());
        Button butNextPlayerMesa = new Button("Passar turno");
        butNextPlayerMesa.setOnAction(e -> Game.getInstance().nextPlayer());

        //Cria os botões para comprar carta
        Button butBuyOneCardJ1 = new Button("Comprar");
        butBuyOneCardJ1.setOnAction(e-> Game.getInstance().buyoneCard());
        Button butBuyOneCardJ2 = new Button("Comprar");
        butBuyOneCardJ2.setOnAction(e-> Game.getInstance().buyoneCard());

        //Cria o botão de ataque
        Button butAttack = new Button("Atacar");
        butAttack.setOnAction(e-> Game.getInstance().attack());

        // Mão Jogador 1
        GridPane grid1 = new GridPane();
        grid1.setAlignment(Pos.CENTER);
        grid1.setHgap(10);
        grid1.setVgap(10);
        grid1.setPadding(new Insets(25, 25, 25, 25));

        HandView handJ1 = new HandView(1);
        ScrollPane sd1 = new ScrollPane();
        sd1.setPrefSize(1500, 310);
        sd1.setContent(handJ1);
        grid1.add(sd1, 0, 0);

        grid1.add(placar, 0, 1);
        grid1.add(butNextPlayer1, 0, 2);
        grid1.add(butBuyOneCardJ1,0,3);

        //Mão Jogador 2
        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(25, 25, 25, 25));

        HandView handJ2 = new HandView(2);
        ScrollPane sd2 = new ScrollPane();
        sd2.setPrefSize(1500, 310);
        sd2.setContent(handJ2);
        grid2.add(sd2, 0, 0);

        grid2.add(placar2, 0, 1);
        grid2.add(butNextPlayer2, 0, 2);
        grid2.add(butBuyOneCardJ2,0,3);

        // Mesa
        GridPane grid3 = new GridPane();
        grid3.setAlignment(Pos.CENTER);
        grid3.setHgap(10);
        grid3.setVgap(10);
        grid3.setPadding(new Insets(25, 25, 25, 25));

        //Mesa jogador 1
        TableView tableJ1 = new TableView(1);
        ScrollPane sd3 = new ScrollPane();
        sd3.setPrefSize(1500, 310);
        sd3.setContent(tableJ1);
        grid3.add(sd3, 0, 0);

        //Mesa jogador 2
        TableView tableJ2 = new TableView(2);
        ScrollPane sd4 = new ScrollPane();
        sd4.setPrefSize(1500, 310);
        sd4.setContent(tableJ2);
        grid3.add(sd4, 0, 1);

        //Botão "Atacar" e "Passar turno" na mesa
        grid3.add(butAttack,0,2);
        grid3.add(butNextPlayerMesa,0,3);

        //Coloca o conteúdo nas tabs adequadas
        tab1.setContent(grid1);
        tab2.setContent(grid2);
        tab3.setContent(grid3);

        //Cria a lista de observadores
        ObservableList list = root.getChildren();
        list.add(tabPane);

        //Coloca o root na scene
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
                case INVCARD:
                    alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Atenção !!");
                    alert.setHeaderText(null);
                    alert.setContentText("Carta inválida, meu querido!!");
                    alert.showAndWait();
                    break;
            }
        }
    }

}
