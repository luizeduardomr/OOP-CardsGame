package pucrs.ep.poo.cartas.modelo;

import pucrs.ep.poo.cartas.gui.GameEvent;

import java.util.*;


// Esta classe tem de ser um container de cartas observavel ...
public class Hand extends Observable {
    public static final int NCARDS = 10;
    private List<Card> cartas;
    private Card selected;
    private Card buyedCard;

    public Hand(int jogador, Deck grimorio) {
        cartas = new ArrayList<Card>(NCARDS);
        selected = null;

        for (int i = 0; i < NCARDS; i++) {
            Card c = grimorio.buyACard();
            cartas.add(c);
        }
    }

    public void buyOneCard(Deck baralho){
        Card c = baralho.buyACard();
        cartas.add(c);
        buyedCard = c;
        GameEvent gameEvent = new GameEvent(GameEvent.Target.DECK,GameEvent.Action.ADDTOHAND,"");
        setChanged();
        notifyObservers(gameEvent);
    }

    public Card getBuyedCard() {
        return buyedCard;
    }

    public List<Card> getCards() {
        return (cartas);
    }

    public int getNumberOfCards() {
        return (cartas.size());
    }

    public void removeSel() {
        if (selected == null) {
            return;
        }
        cartas.remove(selected);
        selected = null;
        GameEvent gameEvent = new GameEvent(GameEvent.Target.DECK, GameEvent.Action.REMOVESEL, "");
        setChanged();
        notifyObservers(gameEvent);
    }

    public void setSelectedCard(Card card) {
        selected = card;
    }

    public Card getSelectedCard() {
        return (selected);
    }
}

