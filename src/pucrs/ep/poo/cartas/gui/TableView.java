package pucrs.ep.poo.cartas.gui;

import java.util.*;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import pucrs.ep.poo.cartas.modelo.*;

public class TableView extends HBox implements CardObserver, Observer {
    private int jogador;
    private CardDeck cDeck;
    private Card selectedCard;
    private Table table;


    public TableView(int nroJog) {
        super(4);
        this.setAlignment(Pos.CENTER);

        jogador = nroJog;
        selectedCard = null;

        cDeck = null;
        table=null;
        if (jogador == 1) {
            cDeck = Game.getInstance().getDeckJ1();
            table = Game.getInstance().getTableJ1();
        } else {
            cDeck = Game.getInstance().getDeckJ2();
            table = Game.getInstance().getTableJ2();
        }
        cDeck.addObserver(this);
        table.addObserver(this);

        //se mudar de cdeck para table caga tudo
        /*
        for (Card card : cDeck.getCards()) {
            CardView cv = new CardView(card);
            cv.setCardObserver(this);
            this.getChildren().add(cv);
        }

         */
    }

    @Override
    public void cardSelected(CardView cv) {
        cDeck.setSelectedCard(cv.getCard());
        selectedCard = cv.getCard();
        Game.getInstance().play(cDeck);
    }

    private void addSel() {
        List cards = table.getCards();
        selectedCard = table.getSelectedCard();
        CardView cv = new CardView(selectedCard);
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i) == selectedCard) {
                getChildren().add(cv);
                selectedCard = null;
            }
        }
    }

    private void removeSel() {
        List cards = getChildren();
        for (int i = 0; i < cards.size(); i++) {
            CardView cv = (CardView) cards.get(i);
            if (cv.getCard() == selectedCard) {
                getChildren().remove(cv);
                selectedCard = null;
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {

        if (arg == null) {
            return;
        }
        GameEvent ge = (GameEvent) arg;
        if (ge.getTarget() != GameEvent.Target.TABLE) {
            return;
        }
        if (ge.getAction() == GameEvent.Action.ADDTOTABLE) {
            addSel();
        }
    }
}

