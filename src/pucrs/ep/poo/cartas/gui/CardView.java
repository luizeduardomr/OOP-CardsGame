package pucrs.ep.poo.cartas.gui;

import javafx.scene.control.Button;

import java.util.*;
import javafx.event.*;
import pucrs.ep.poo.cartas.modelo.*;

public class CardView extends Button implements Observer{
    private Card card;
    private CardView thisCard;
    private CardObserver observer;
    
    public CardView(Card aCard){
        card = aCard;
        card.addObserver(this);
        thisCard = this;
        this.setCorrectImage();

        this.setOnAction(e -> {
            if (observer != null){
                observer.cardSelected(thisCard);
            }
        });
    }

    private void setCorrectImage() {
        this.setGraphic(ImageFactory.getInstance().createImage(card.getImageId()));
    }

    @Override
    public void update(Observable o,Object args){
            this.setGraphic(ImageFactory.getInstance().createImage(card.getImageId()));
    }
    
    public void setCardObserver(CardObserver obs){
        observer = obs;
    }
    
    public Card getCard(){
        return(card);
    }
}

