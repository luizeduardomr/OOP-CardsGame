package pucrs.ep.poo.cartas.gui;

import java.util.*;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import pucrs.ep.poo.cartas.modelo.*;

public class HandView extends HBox implements CardObserver,Observer{
    private int jogador;
    private Hand hand;
    private Card selectedCard;


    public HandView(int nroJog){
        super(4);
        this.setAlignment(Pos.CENTER);
        
        jogador = nroJog;
        selectedCard = null;
        
        hand = null;
        if (jogador == 1){
            hand = Game.getInstance().getHandJ1();
        }else{
            hand = Game.getInstance().getHandJ2();
        }
        hand.addObserver(this);
        
        for(Card card: hand.getCards()){
            CardView cv = new CardView(card);
            cv.setCardObserver(this);
            this.getChildren().add(cv);
        }
    }
    
    @Override
    public void cardSelected(CardView cv){
        hand.setSelectedCard(cv.getCard());
        selectedCard = cv.getCard();
        Game.getInstance().play(hand);
    }
        
    private void removeSel(){
        List cards = getChildren();
        for(int i=0;i<cards.size();i++){
            CardView cv = (CardView)cards.get(i);
            if (cv.getCard() == selectedCard){
                getChildren().remove(cv);
                selectedCard = null;
            }
        }      
    }

    private void addToHand() {
        List cards = getChildren();
        CardView cv = new CardView(hand.getBuyedCard());
        cv.setCardObserver(this);
        cards.add(cv);
    }


    @Override
    public void update(Observable o,Object arg){
        if (arg == null){
            return;
        }
        GameEvent ge = (GameEvent)arg;
        if (ge.getTarget() != GameEvent.Target.DECK){
            return;
        }
        if (ge.getAction() == GameEvent.Action.REMOVESEL){
            removeSel();
        }
        if (ge.getAction() == GameEvent.Action.ADDTOHAND) {
            addToHand();
        }
    }
}



