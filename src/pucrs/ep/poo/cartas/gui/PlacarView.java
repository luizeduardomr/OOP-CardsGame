package pucrs.ep.poo.cartas.gui;

import java.util.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import pucrs.ep.poo.cartas.modelo.Game;

public class PlacarView extends GridPane implements Observer{
    private TextField ptsJ1,ptsJ2;
    private TextField manaJ1, manaJ2;
    
    public PlacarView(){
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));
        
        Game.getInstance().addObserver(this);
        
        ptsJ1 = new TextField();
        ptsJ2 = new TextField();
        manaJ1 = new TextField();
        manaJ2 = new TextField();
      
        ptsJ1.setText(""+Game.getInstance().getLifeJ1());
        ptsJ2.setText(""+Game.getInstance().getLifeJ2());
        manaJ1.setText(""+Game.getInstance().getManaReserveJ1());
        manaJ2.setText(""+Game.getInstance().getManaReserveJ2());

        this.add(new Label("Jogador 1 - Vida:"),0,0);
        this.add(ptsJ1,1,0);
        this.add(new Label("Mana:"),2,0);
        this.add(manaJ1,3,0);

        this.add(new Label("Jogador 2 - Vida:"),0,1);
        this.add(ptsJ2,1,1);
        this.add(new Label("Mana:"),2,1);
        this.add(manaJ2,3,1);
    }
    
    @Override
    public void update(Observable o,Object arg){
        ptsJ1.setText(""+Game.getInstance().getLifeJ1());
        ptsJ2.setText(""+Game.getInstance().getLifeJ2());
        manaJ1.setText(""+Game.getInstance().getManaReserveJ1());
        manaJ2.setText(""+Game.getInstance().getManaReserveJ2());
    }    
}

