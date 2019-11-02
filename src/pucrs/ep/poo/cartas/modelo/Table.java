package pucrs.ep.poo.cartas.modelo;

import pucrs.ep.poo.cartas.gui.GameEvent;

import java.util.*;


// Esta classe tem de ser um container de cartas observavel ...
public class Table extends Observable{

    private List<Card> cartas;
    private Card selected;

    public Table(int jogador){
        cartas = new ArrayList<Card>();
        selected = null;
    }

    public List<Card> getCards(){
        return(cartas);
    }

    public int getNumberOfCards(){
        return(cartas.size());
    }

    public void addSel(){
        if (selected == null){
            return;
        }
        cartas.add(selected);
        selected = null;
        GameEvent gameEvent = new GameEvent(GameEvent.Target.DECK,GameEvent.Action.ADDSEL,"");
        setChanged();
        notifyObservers(gameEvent);
    }

    public void removeSel(){
        if (selected == null){
            return;
        }
        cartas.remove(selected);
        selected = null;
        GameEvent gameEvent = new GameEvent(GameEvent.Target.DECK,GameEvent.Action.REMOVESEL,"");
        setChanged();
        notifyObservers(gameEvent);
    }

    public void setSelectedCard(Card card){
        selected = card;
    }

    public Card getSelectedCard(){
        return(selected);
    }
}

