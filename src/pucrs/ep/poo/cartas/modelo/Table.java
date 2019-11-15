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

    public void addToTable(Card umaCarta){
        cartas.add(umaCarta);
        selected = umaCarta;
        GameEvent gameEvent = new GameEvent(GameEvent.Target.TABLE,GameEvent.Action.ADDTOTABLE,"");
        setChanged();
        notifyObservers(gameEvent);
        selected = null;
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

    public int getNumberOfMana(){
        int manaReserve = 0;

        for (Card c : cartas){
            if (c instanceof TerrainCard) manaReserve++;
        }

        return manaReserve;
    }

    public void setSelectedCard(Card card){
        selected = card;
    }

    public Card getSelectedCard(){
        return(selected);
    }
}

